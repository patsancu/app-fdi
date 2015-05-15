package es.ucm.fdi.tutorias.business.boundary;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
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
	

	private static final Logger logger = LoggerFactory.getLogger("EmailUtils");

	public String generarMensajeConfirmacionTutoria(Tutoria tutoria){
		String mensaje = tutoria.getDestinatario().getUsername();
		mensaje += " ha confirmado la tutoría con usted, ";
		mensaje += tutoria.getEmisor().getUsername();
		mensaje += " sobre su asignatura: " + tutoria.getAsignatura() + ".\n";		
		return mensaje;		
	}

	public String generarAsuntoConfirmacionTutoria(Tutoria tutoria){
		String asunto = "Confirmada tutoría para la asignatura: " + tutoria.getAsignatura();
		return asunto;
	}

	public String generarMensajeSolicitudTutoria(Tutoria tutoria, String contextPath){
				String mensaje = tutoria.getEmisor().getUsername();
				mensaje += " ha solicitado una tutoría con usted, ";
				mensaje += tutoria.getDestinatario().getUsername();
				mensaje += " sobre su asignatura: " + tutoria.getAsignatura() + ".\n";
				mensaje += " El resumen del motivo de la tutoría es: " + tutoria.getResumenDudas() + "\n";
				mensaje += "Para confirmar dicha tutoría, haga click en el siguiente enlace: \n";		
//				mensaje += " http://localhost:8088/portal/tutorias/confirmar?id=" + tutoria.getId();
				mensaje += contextPath + Constants.URL_CONFIRMAR_TUTORIA + "?id=" + tutoria.getId();
				

//		String mensaje = "<html><head><script type='application/ld+json'> {'@context':     "
//				+ "        'http://schema.org', '@type':                 'EventReservation', "
//				+ "'reservationNumber':     'IO12345', 'underName': {'@type':        "
//				+ "       'Person', 'name':                'John Smith'}, 'reservationFor': {'@type':  "
//				+ "             'Event', 'name':                'Google I/O 2013', 'startDate':      "
//				+ "     '2013-05-15T08:30:00-08:00', 'location': {'@type':             'Place', 'name':  "
//				+ "            'Moscone Center', 'address': {'@type':           'PostalAddress', 'streetAddress':   "
//				+ "'800 Howard St.', 'addressLocality': 'San Francisco', 'addressRegion':   'CA', 'postalCode':    "
//				+ "  '94103', 'addressCountry':  'US'} } } }</script></head><body>PATA</body></html>";
		return mensaje;		
	}

	public String generarAsuntoSolicitudTutoria(Tutoria tutoria){
		String asunto = "Solicitud de tutoría para la asignatura: " + tutoria.getAsignatura();
		return asunto;
	}

	public void enviarEmail(String to, Tutoria tutoria, String mensaje, String asunto){
		Properties props = new Properties();
//		try{
//			ClassLoader loader = Thread.currentThread().getContextClassLoader();           
//			InputStream stream = loader.getResourceAsStream("gmail.properties");
//			props.load(stream);
//		}
//		catch(Exception e){
//			logger.error("No se ha podido leer el archivo gmail.properties" + e);
//		}

		Session session = Session.getDefaultInstance(props);
		MimeMessage message = new MimeMessage(session);

//		String starttls = props.getProperty("cfg.mail.starttls.enable");
//		String auth = props.getProperty("cfg.mail.auth");
//		String host = props.getProperty("cfg.mail.host");
//		String port = props.getProperty("cfg.mail.port");
//		String username = props.getProperty("cfg.mail.username");
//		String password = props.getProperty("cfg.mail.password");

//		props.put("mail.smtp.starttls.enable", ""+starttls);
//		props.put("mail.smtp.host", host);
//		props.put("mail.smtp.user", username);
//		props.put("mail.smtp.password", password);
//		props.put("mail.smtp.port", port);
//		props.put("mail.smtp.auth", ""+auth);
		
		props.put("mail.smtp.starttls.enable", ""+starttls);
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.user", username);
		props.put("mail.smtp.password", password);
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.auth", ""+auth);



		try {
			message.setFrom(new InternetAddress(username));
			InternetAddress[] toAddress = new InternetAddress[1];
			toAddress[0] = new InternetAddress(to);
			message.addRecipient(Message.RecipientType.TO, toAddress[0]);
			message.setContent(mensaje, "text/html");
			message.setSubject(asunto);
			//message.setText(mensaje);
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
