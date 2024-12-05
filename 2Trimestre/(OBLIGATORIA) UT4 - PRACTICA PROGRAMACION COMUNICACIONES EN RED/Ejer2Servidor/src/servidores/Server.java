package servidores;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		
		final int NUM_PUERTO = 5000;
		
		try(ServerSocket server = new ServerSocket(NUM_PUERTO)){
			Socket cliente;
			
			while(true) {
				cliente = server.accept();
				Partida partida = new Partida(cliente);
				partida.start();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
