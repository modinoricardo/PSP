package principal;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Cliente {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		InetAddress destino = InetAddress.getLocalHost();
		final int NUMPUERTO = 5000;
		byte[] buffer = new byte[1024];
		
		System.out.println("Numero a elevar al cuadrado: ");
		String mensaje = sc.nextLine();
		buffer = mensaje.getBytes();
		
		DatagramSocket socket = new DatagramSocket();
		
		DatagramPacket paqueteEnviado = new DatagramPacket(buffer, buffer.length, destino, NUMPUERTO);
		socket.send(paqueteEnviado);
		
		DatagramPacket paqueteRecibido = new DatagramPacket(buffer, buffer.length);
		socket.receive(paqueteRecibido);
		
		String respuesta = new String(paqueteRecibido.getData(), 0 ,paqueteRecibido.getLength());
		System.out.println(respuesta);
		
		socket.close();
		sc.close();
		
	}
}
