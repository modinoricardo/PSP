package principal;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Cliente {
	public static void main(String[] args) throws IOException {
		
		InetAddress destino = InetAddress.getLocalHost();
		
		final int NUMPUERTO = 5000;
		
		byte[] buffer = new byte[1024];
		
		String mensaje = "Hola mundo";
		buffer = mensaje.getBytes();
		
		DatagramSocket socket = new DatagramSocket();
		DatagramPacket paquete = new DatagramPacket(buffer, buffer.length, destino, NUMPUERTO);
		
		socket.send(paquete);
		
	}
}
