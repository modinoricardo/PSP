package servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import juego.Juego;

public class Server {

	public static void main(String[] args) {

		final int NUMPUERTO = 5000;

		try (ServerSocket server = new ServerSocket(NUMPUERTO)){
			
			while (true) {
				Socket puenteAlCliente = server.accept();
				Hilo cliente = new Hilo(puenteAlCliente);
				cliente.start();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
