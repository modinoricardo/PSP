package principal;

import java.io.File;

public class Main {
	public static void main(String[] args) {
		GestorCorreo gestor = new GestorCorreo();
		String usuario = "da2d1e.2024@gmail.com";
		String password = "nuzw uevk dwym pxbu";
		
		String destinatario = "natalia55012436@gmail.com";
		String asunto = "Prueba";
		String mensaje = "HOLA MUNDO";

		gestor.setPropiedadesServidorSMTP(usuario, password);

		gestor.enviarMensajeTexto(usuario, destinatario, asunto, mensaje);

		// Enviar mensaje con adjunto
		File archivo = new File("/home/ricardo/Escritorio/prueba.txt");
		gestor.enviarMensajeTextoConAdjunto(usuario, destinatario, asunto,
		mensaje, archivo);
	}
}
