package principal;

import jakarta.mail.*;
import jakarta.mail.internet.*;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class GestorCorreo {

	private Properties misPropiedades;
	private Session miSesion;
	private MiAutorizacion miAutorizacion;

	public void setPropiedadesServidorSMTP(String usuario, String password) {
		misPropiedades = new Properties();
		misPropiedades.put("mail.smtp.auth", "true");
		misPropiedades.put("mail.smtp.starttls.enable", "true");
		misPropiedades.put("mail.smtp.host", "smtp.gmail.com");
		misPropiedades.put("mail.smtp.port", "587");
		miAutorizacion = new MiAutorizacion(usuario, password);
		miSesion = Session.getInstance(misPropiedades, miAutorizacion);
	}

	public void enviarMensajeTexto(String emisor, String destinatario, String asunto, String texto) {
		try {
			Message mensaje = crearMensajeTexto(emisor, destinatario, asunto, texto);
			Transport transport = conectarServidorSMTP();
			transport.sendMessage(mensaje, mensaje.getAllRecipients());
			transport.close();
			System.out.println("Mensaje enviado correctamente.");
		} catch (MessagingException e) {
			System.err.println("Error al enviar el mensaje: " + e.getMessage());
		}
	}

	public void enviarMensajeTextoConAdjunto(String emisor, String destinatario, String asunto, String texto,
			File archivo) {
		try {
			Message mensaje = crearMensajeTextoConAdjunto(emisor, destinatario, asunto, texto, archivo);
			Transport transport = conectarServidorSMTP();
			transport.sendMessage(mensaje, mensaje.getAllRecipients());
			transport.close();
			System.out.println("Mensaje con adjunto enviado correctamente.");
		} catch (MessagingException e) {
			System.err.println("Error al enviar el mensaje con adjunto: " + e.getMessage());
		}
	}

	private Transport conectarServidorSMTP() throws MessagingException {
		Transport transport = miSesion.getTransport("smtp");
		transport.connect();
		return transport;
	}

	private Message crearNucleoMensaje(String emisor, String destinatario, String asunto)
			throws AddressException, MessagingException {
		Message mensaje = new MimeMessage(miSesion);
		mensaje.setFrom(new InternetAddress(emisor));
		mensaje.setRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
		mensaje.setSubject(asunto);
		return mensaje;
	}

	private Message crearMensajeTexto(String emisor, String destinatario, String asunto, String texto)
			throws AddressException, MessagingException {
		Message mensaje = crearNucleoMensaje(emisor, destinatario, asunto);
		mensaje.setText(texto);
		return mensaje;
	}

	private Message crearMensajeTextoConAdjunto(String emisor, String destinatario, String asunto, String texto,
			File archivo) throws MessagingException {
		Message mensaje = crearNucleoMensaje(emisor, destinatario, asunto);

		MimeBodyPart textoParte = new MimeBodyPart();
		textoParte.setText(texto);

		MimeBodyPart archivoParte = new MimeBodyPart();
		try {
			archivoParte.attachFile(archivo);
		} catch (IOException e) {
			throw new MessagingException("Error al adjuntar el archivo", e);
		}

		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(textoParte);
		multipart.addBodyPart(archivoParte);

		mensaje.setContent(multipart);
		return mensaje;
	}
}
