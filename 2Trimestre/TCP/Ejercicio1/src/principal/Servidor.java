package principal;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	public static void main(String[] args) throws IOException {
		
		final int NUMPUERTO = 5000;
		ServerSocket servidor = null;
		Socket cliente = null;
		
		DataInputStream in;
		DataOutputStream out;
		
		
		servidor = new ServerSocket(NUMPUERTO);
		System.out.println("Servidor iniciado");
		System.out.println("Palabras recibidas: ");
		
		while(true) {
			
			cliente = servidor.accept();
			
			in = new DataInputStream(cliente.getInputStream());
			out = new DataOutputStream(cliente.getOutputStream());
			
			String mensaje = in.readUTF();
			
			System.out.println(mensaje);
			
			String mensajeMayuscula = mensaje.toUpperCase();
			
			out.writeUTF(mensajeMayuscula);
			
		}
		
	}
}
