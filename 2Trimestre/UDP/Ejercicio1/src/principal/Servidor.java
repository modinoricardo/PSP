package principal;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.SocketException;

public class Servidor {
	public static void main(String[] args) {
		byte[] buffer = new byte[1024];
		
		final int NUMPUERTO = 5000;
		try {
			DatagramSocket socket = new DatagramSocket(NUMPUERTO);
			
			System.out.println("Esperando datagrama...");
			
			while(true) {				
				DatagramPacket paquete = new DatagramPacket(buffer, buffer.length);
				socket.receive(paquete);
				
				String respuesta = new String(paquete.getData(),0,paquete.getLength());
				respuesta = respuesta.toUpperCase();
				
				byte[] arregloRespuesta = respuesta.getBytes();
				InetAddress direccionCliente = paquete.getAddress();
				int puertoCliente = paquete.getPort();
				
				DatagramPacket paqueteEnvioCliente = new DatagramPacket(
						arregloRespuesta, 
						arregloRespuesta.length,
						direccionCliente, 
						puertoCliente);
				
				socket.send(paqueteEnvioCliente);
			}
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
