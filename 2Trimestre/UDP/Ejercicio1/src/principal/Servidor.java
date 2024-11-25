package principal;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Servidor {
	public static void main(String[] args) {
		byte[] bufer = new byte[1024];
		
		final int NUMPUERTO = 5000;
		try {
			DatagramSocket socket = new DatagramSocket(NUMPUERTO);
			
			System.out.println("Esperando datagrama...");
			DatagramPacket paquete = new DatagramPacket(bufer, bufer.length);
			socket.receive(paquete);
			
			String respuesta = new String(paquete.getData());
			
			System.out.println(respuesta);
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
