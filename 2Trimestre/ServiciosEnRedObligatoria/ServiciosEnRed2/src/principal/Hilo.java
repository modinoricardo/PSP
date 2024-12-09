package principal;

import java.io.File;

public class Hilo extends Thread{

	@Override
	public void run() {
		GestorCorreo gestor = new GestorCorreo();
		String usuario = "da2d1e.2024@gmail.com";
		String password = "nuzw uevk dwym pxbu";
		
		String destinatario = "claraemprende@iesclaradelrey.es";
		String asunto = "Prueba";
		String mensaje = "HOLA MUNDO";

		gestor.setPropiedadesServidorSMTP(usuario, password);			

		for (int i = 0; i < 100; i++) {
			int numRandom = (int) (Math.random()*100+1);
			gestor.enviarMensajeTexto(usuario, destinatario, asunto+" "+numRandom, mensaje);
		}

		// Enviar mensaje con adjunto
		File archivo = new File("/home/ricardo/Escritorio/prueba.txt");
		gestor.enviarMensajeTextoConAdjunto(usuario, destinatario, asunto,
		mensaje, archivo);
	}
	
}
