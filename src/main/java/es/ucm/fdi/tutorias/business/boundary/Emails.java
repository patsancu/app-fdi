package es.ucm.fdi.tutorias.business.boundary;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import net.fortuna.ical4j.data.CalendarOutputter;
import net.fortuna.ical4j.model.Dur;
import net.fortuna.ical4j.model.Property;
import net.fortuna.ical4j.model.ValidationException;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.property.CalScale;
import net.fortuna.ical4j.model.property.Description;
import net.fortuna.ical4j.model.property.Location;
import net.fortuna.ical4j.model.property.Organizer;
import net.fortuna.ical4j.model.property.ProdId;
import net.fortuna.ical4j.model.property.Version;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import es.ucm.fdi.tutorias.business.entity.Tutoria;
import es.ucm.fdi.util.Constants;

@Service
public class Emails {

	@Value("#{gmailData[username]}")
	private String username;	

	@Value("#{gmailData[password]}")
	private String password;

	@Value("#{gmailData[port]}")
	private String port;

	@Value("#{gmailData[host]}")
	private String host;

	@Value("#{gmailData[starttls]}")
	private String starttls;

	@Value("#{gmailData[auth]}")
	private String auth;
	
	@Autowired
	private MessageSource messageSource;


	private static final Logger logger = LoggerFactory.getLogger("Emails");	
	

	private String generarMensajeConfirmacionTutoria(Tutoria tutoria){
		String mensaje = "<p><b>" + tutoria.getDestinatario().getUserGivenName() + tutoria.getDestinatario().getUserSurname() + "</b>";
		mensaje += " ha confirmado la tutoría con usted, ";
		mensaje += tutoria.getEmisor().getUserGivenName() + " " + tutoria.getEmisor().getUserSurname();
		DateTimeFormatter dtfOut = DateTimeFormat.forPattern("MM/dd/yyyy hh:mm");
		mensaje += " sobre su asignatura <b>" + tutoria.getAsignatura() + "</b></p> de " + "<b>" + dtfOut.print(tutoria.getComienzoTutoria()) + "</b>";
		mensaje += " hasta " + "<b>" + dtfOut.print(tutoria.getFinTutoria()) + "</b></p>";		
		return mensaje;		
	}

	private String generarAsuntoConfirmacionTutoria(Tutoria tutoria){
		String asunto = "Confirmada tutoría para la asignatura: " + tutoria.getAsignatura();
		return asunto;
	}

	private String generarMensajeSolicitudTutoria(Tutoria tutoria, String contextPath){
		String mensaje = "<p> <b>" + tutoria.getEmisor().getUserGivenName() + " " + tutoria.getEmisor().getUserSurname() + "</b>";
		mensaje += " ha solicitado una tutoría con usted, ";
		mensaje += tutoria.getDestinatario().getUserGivenName() + " " + tutoria.getDestinatario().getUserSurname();
		DateTimeFormatter dtfOut = DateTimeFormat.forPattern("MM/dd/yyyy hh:mm");
		mensaje += ", sobre su asignatura: <b>" + tutoria.getAsignatura() + "</b>, de " + "<b>" + dtfOut.print(tutoria.getComienzoTutoria()) + "</b>";
		mensaje += " hasta " + "<b>" + dtfOut.print(tutoria.getFinTutoria()) + "</b></p>";
		mensaje += "El motivo por el que se solicita la tutoría es: <p><i>" + tutoria.getResumenDudas() + "</i></p>";	
		mensaje += "<a bgcolor='#70bbd9' color='green' href='http://localhost:8088" + contextPath + Constants.URL_CONFIRMAR_TUTORIA + "?id=" + tutoria.getId() + "'>Confirmar tutoría</a>";
		return mensaje;		
	}

	private String generarAsuntoSolicitudTutoria(Tutoria tutoria){
		String asunto = "Solicitud de tutoría para la asignatura: " + tutoria.getAsignatura();
		return asunto;
	}
	
	public void enviarEmailSolicitudTutoria(Tutoria tutoria, String contextPath){
		String mensaje = generarMensajeSolicitudTutoria(tutoria, contextPath); 
		String asunto = generarAsuntoSolicitudTutoria(tutoria);
		String nombreArchivo = tutoria.getEmisor().getUsername() + tutoria.getId(); 
		if (crearArchivoCSV( nombreArchivo + ".csv",tutoria) && crearArchivoCal(nombreArchivo  + ".ics", tutoria)){
//		if (crearArchivoCSV( nombreArchivo + ".csv",tutoria) ){
			enviarEmail(tutoria.getDestinatario().getEmail(), tutoria, mensaje, asunto, nombreArchivo + ".csv", nombreArchivo  + ".ics");
		}
		
	}
	
	public void enviarEmailConfirmacionTutoria(Tutoria tutoria){
		String mensaje = generarMensajeConfirmacionTutoria(tutoria); 
		String asunto = generarAsuntoConfirmacionTutoria(tutoria);
		enviarEmail(tutoria.getDestinatario().getEmail(), tutoria, mensaje, asunto,"","");
	}
	
	private boolean crearArchivoCSV(String nombreArchivo, Tutoria tutoria){
		PrintWriter writer;
		try {
			writer = new PrintWriter(nombreArchivo, "UTF-8");
			String contenidoCSV = "Subject,Start Date,Start Time,End Date,End Time,All Day Event,Description,Location,Private\n";
			contenidoCSV += "Tutoria," + tutoria.getComienzoTutoria(); 
			contenidoCSV +=	"," + tutoria.getFinTutoria(); 
			contenidoCSV +=",False";
			contenidoCSV += ","  + tutoria.getResumenDudas();
			contenidoCSV += ",\"Facultad de Informática - UCM\"";
			contenidoCSV +=",True";
			writer.print(contenidoCSV);
			writer.close();
			return true;
		} catch (FileNotFoundException e) {
			logger.error("NO se ha podido crear archivo CSV" + e);
			e.printStackTrace();
			return false;
		} catch (UnsupportedEncodingException e) {
			logger.error("NO se ha podido crear archivo CSV" + e);
			e.printStackTrace();
			return false;
		}

	}
	
	private boolean crearArchivoCal(String nombreCalendario, Tutoria tutoria){
		String hostEmail = username;
				
		//Initialize values
		String calFile = nombreCalendario;;

		//start time
		DateTime comienzo = tutoria.getComienzoTutoria();
		java.util.Calendar startCal = java.util.Calendar.getInstance();
		startCal.set(comienzo.getYear(), comienzo.getMonthOfYear(), comienzo.getDayOfMonth(), comienzo.getHourOfDay(), comienzo.getMinuteOfHour());

		//end time
		java.util.Calendar endCal = java.util.Calendar.getInstance();
		DateTime fin = tutoria.getFinTutoria();
		endCal.set(fin.getYear(), fin.getMonthOfYear(), fin.getDayOfMonth(), fin.getHourOfDay(), fin.getMinuteOfHour());

		String subject = "Tutoría";
		String location = "Location - \"Facultad de Informática-UCM\"";
		String description = tutoria.getResumenDudas();

		net.fortuna.ical4j.model.Calendar calendar = new net.fortuna.ical4j.model.Calendar();
		calendar.getProperties().add(new ProdId("-//ProyectoSI-FdiUcm//iCal4j 1.0//EN"));
		calendar.getProperties().add(Version.VERSION_2_0);
		calendar.getProperties().add(CalScale.GREGORIAN);


		SimpleDateFormat sdFormat =  new SimpleDateFormat("yyyyMMdd'T'hhmmss'Z'");
		String strDate = sdFormat.format(startCal.getTime());

		net.fortuna.ical4j.model.Date startDt = null;
		try {
			startDt = new net.fortuna.ical4j.model.Date(strDate,"yyyyMMdd'T'hhmmss'Z'");
		} catch (ParseException e) {
			e.printStackTrace();
			return false;
		}

		long diff = endCal.getTimeInMillis() - startCal.getTimeInMillis();
		int min = (int)(diff / (1000 * 60));

		Dur dur = new Dur(0,0,min,0);

		//Creating a meeting event
		VEvent meeting = new VEvent(startDt,dur,subject);

		meeting.getProperties().add(new Location(location));
		meeting.getProperties().add(new Description());

		try {
			meeting.getProperties().getProperty(Property.DESCRIPTION).setValue(description);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return false;
		} catch (ParseException e) {
			e.printStackTrace();
			return false;
		}

		try {
			meeting.getProperties().add(new Organizer("MAILTO:"+hostEmail));
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return false;
		}

		calendar.getComponents().add(meeting);

		FileOutputStream fout = null;

		try {
			fout = new FileOutputStream(calFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}

		CalendarOutputter outputter = new CalendarOutputter();
		outputter.setValidating(false);

		try {
			outputter.output(calendar, fout);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} catch (ValidationException e) {
			e.printStackTrace();
			return false;
		}
	}

	private void enviarEmail(String to, Tutoria tutoria, String mensaje, String asunto, String nombreCSV, String nombreCal){
		Properties props = new Properties();

		Session session = Session.getDefaultInstance(props);
		MimeMessage message = new MimeMessage(session);

		props.put("mail.smtp.starttls.enable", starttls);
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.user", username);
		props.put("mail.smtp.password", password);
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.auth", auth);



		try {
			message.setFrom(new InternetAddress(username));
			InternetAddress[] toAddress = new InternetAddress[1];
			toAddress[0] = new InternetAddress(to);
			message.addRecipient(Message.RecipientType.TO, toAddress[0]);
			message.setContent(mensaje, "text/calendar");
			
			// Se rellena el texto de la primera parte del email
			MimeBodyPart mbp1 = new MimeBodyPart();
			mbp1.setText(mensaje);
			mbp1.setContent(mensaje, "text/html");
			
			// Creación de segunda parte 
			MimeBodyPart mbp2 = new MimeBodyPart();			
			// Se adjunta el archivo csv
			FileDataSource fds = new FileDataSource(nombreCSV);
			mbp2.setDataHandler(new DataHandler(fds));
			mbp2.setFileName(fds.getName());
			
			
			// Creación de tercera parte 
			MimeBodyPart mbp3 = new MimeBodyPart();			
			// Se adjunta el archivo ical
			FileDataSource fds2 = new FileDataSource(nombreCal);
			mbp3.setDataHandler(new DataHandler(fds2));
			mbp3.setFileName(fds2.getName());
			
			// Se crea el Multipart y se añaden sus partes
			Multipart mp = new MimeMultipart();
			mp.addBodyPart(mbp1);
			mp.addBodyPart(mbp2);
			mp.addBodyPart(mbp3);
			
			// Se añade el Multipart to the message
			message.setContent(mp);
			
			message.setSentDate(new Date());
			
			message.setSubject(asunto);
			Transport transport = session.getTransport("smtp");
			transport.connect(host, username, password);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		}
		catch (AddressException ae) {
			ae.printStackTrace();
		}
		catch (MessagingException me) {
			me.printStackTrace();
		}
	}
}
