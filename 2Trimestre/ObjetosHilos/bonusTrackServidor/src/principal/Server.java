package principal;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import juego.Juego;

public class Server {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		final int PUERTO = 5100;
		boolean turno = true;

		try (ServerSocket servidor = new ServerSocket(PUERTO)) {
			
			Socket puenteCliente1, puenteCliente2;
			ObjectInputStream inCliente1, inCliente2;
			ObjectOutputStream outCliente1, outCliente2;
			
			puenteCliente1 = servidor.accept();
			puenteCliente2 = servidor.accept();

			while (true) {
				
				if (turno) {
					//tiene que enviar el mensaje al cliente1
					inCliente1 = new ObjectInputStream(puenteCliente1.getInputStream());
					outCliente1 = new ObjectOutputStream(puenteCliente1.getOutputStream());
					
					Juego juego = (Juego) inCliente1.readObject();
					
					
				} else {

				}
				
				turno = !turno; //cambiamos el turno
			}

		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}