package servers;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import juego.Juego;

public class Server {

	public static void main(String[] args) {

		final int NUM_PUERTO = 2012;
		boolean partidaActiva = true;
		int numIntentos = 1;

		try (ServerSocket server = new ServerSocket(NUM_PUERTO);
				Socket cliente = server.accept();
				ObjectOutputStream oOS = new ObjectOutputStream(cliente.getOutputStream());
				ObjectInputStream oIS = new ObjectInputStream(cliente.getInputStream());) {

			int numAleatorio = (int) (Math.random() * 101);
			//System.out.println("El numero secreto es "+numAleatorio);
		
			//inicio del juego
			while (partidaActiva&&numIntentos<=5) {
				Juego numJugado = (Juego) oIS.readObject();

				if (numJugado.getNumJugado() < numAleatorio) {
					oOS.writeObject(new Juego(true, false));
					numIntentos++;
				} else if (numJugado.getNumJugado() > numAleatorio) {
					oOS.writeObject(new Juego(false, false));
				} else if (numJugado.getNumJugado() == numAleatorio) {
					numIntentos++;
					partidaActiva = false;
					oOS.writeObject(new Juego(false, true));
				}
			}
			
			//System.out.println("Cierre servidor");

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
