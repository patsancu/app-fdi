package es.ucm.fdi.tutorias.business.boundary;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

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
		enviarEmail(tutoria.getDestinatario().getEmail(), tutoria, mensaje, asunto);
	}
	
	public void enviarEmailConfirmacionTutoria(Tutoria tutoria){
		String mensaje = generarMensajeConfirmacionTutoria(tutoria); 
		String asunto = generarAsuntoConfirmacionTutoria(tutoria);
		enviarEmail(tutoria.getDestinatario().getEmail(), tutoria, mensaje, asunto);
	}
	
	private void crearArchivoCSV(String nombreArchivo, Tutoria tutoria){
		PrintWriter writer;
		try {
			writer = new PrintWriter(nombreArchivo, "UTF-8");
			String contenidoCSV = "Subject,Start Date,Start Time,End Date,End Time,All Day Event,Description,Location,Private";
			contenidoCSV += "\nFinal Exam,05/12/20,07:10:00 PM,05/12/20,10:00:00 PM,False,Two essay questions that will cover topics covered throughout the semester,\"Columbia, Schermerhorn 614\",True";
			//writer.println("The first line");
			//writer.println("The second line");
			writer.print(contenidoCSV);
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void enviarEmail(String to, Tutoria tutoria, String mensaje, String asunto){
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
			message.setContent(mensaje, "text/html");
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
