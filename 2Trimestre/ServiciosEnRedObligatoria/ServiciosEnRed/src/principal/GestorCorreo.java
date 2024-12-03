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

	}

	private Transport conectarServidorSMTP() throws MessagingException {

	}

	private Message crearNucleoMensaje(String emisor, String destinatario, String asunto) throws AddressException, MessagingException {

	}

	private Message crearMensajeTexto(String emisor, String destinatario, String asunto, String texto) throws AddressException, MessagingException {

	}

	private Message crearMensajeTextoConAdjunto(String emisor, String destinatario, String asunto, File archivo) {

	}

	private void enviarMensajeTexto(String emisor, String destinatario, String asunto, String texto) {

	}

}
