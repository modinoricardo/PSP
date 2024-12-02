package principal;

import jakarta.mail.Session;

import java.io.File;
import java.util.Properties;

import jakarta.mail.BodyPart;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Transport;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

public class GestorCorreo {

	private Properties misPropiedades;
	private Session miSesion;
	private MiAutorizacion miAutorizacion;

	private void setPropiedadesServidorSMTP(String usuario, String password) {
		misPropiedades = new Properties();
		misPropiedades.put("mail.smtp.auth", "true");
		misPropiedades.put("mail.smtp.starttls.enable", "true");
		misPropiedades.put("mail.smtp.host", "smtp.gmail.com");
		misPropiedades.put("mail.smtp.port", "587");

		miAutorizacion = new MiAutorizacion(usuario, password);
		miSesion = Session.getInstance(misPropiedades, miAutorizacion);
	}

	private Transport conectarServidorSMTP() throws MessagingException {
		Transport transport = miSesion.getTransport("smtp");
		transport.connect();
		return transport;
	}

	private Message crearNucleoMensaje(String emisor, String destinatario, String asunto) throws AddressException, MessagingException {
		Message mensaje = new MimeMessage(miSesion);
		mensaje.setFrom(new InternetAddress(emisor));
		mensaje.setRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
		mensaje.setSubject(asunto);
		return mensaje;
	}

	private Message crearMensajeTexto(String emisor, String destinatario, String asunto, String texto) throws AddressException, MessagingException {
	    Message mensaje = crearNucleoMensaje(emisor, destinatario, asunto);
	    mensaje.setText(texto);
	    return mensaje;
	}

	private Message crearMensajeTextoConAdjunto(String emisor, String destinatario, String asunto, File archivo) {
		return null;

	}

	private void enviarMensajeTexto(String emisor, String destinatario, String asunto, String texto) {

	}

}
