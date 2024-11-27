package servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private static int partidasGanadas = 0;
	private static int partidasPerdidas = 0;

	public static void main(String[] args) {

		final int NUMPUERTO = 5000;

		try (ServerSocket server = new ServerSocket(NUMPUERTO)){
			
			while (true) {
		
		try (Socket puenteAlCliente = server.accept();
				ObjectOutputStream out = new ObjectOutputStream(puenteAlCliente.getOutputStream());
				ObjectInputStream in = new ObjectInputStream(puenteAlCliente.getInputStream())) {

				out.flush();

				int numeroJugado = (int) (Math.random() * 100 + 1);// 1 al 100
				// int numeroJugado = (int) (Math.random() * 101);//0 al 100
				// int numeroJugado = (int) (Math.random() * 101 + 100);//100 al 200
				// int numeroJugado = 100 + (int) (Math.random() * (200 - 100 + 1));//100 al 200

				Juego jugadaRecibida = (Juego) in.readObject();

				String mensaje = (jugadaRecibida.isEsPar()) ? "El juega PARES" : "El juega NONES";
				System.out.println(mensaje);
				System.out.println("Nº: " + jugadaRecibida.getNumJugado());

				System.out.println("Se ha generado un numero aleatorio: " + numeroJugado);

				boolean esPar = !jugadaRecibida.isEsPar();

				Juego jugadaEnviada = new Juego(!jugadaRecibida.isEsPar(), numeroJugado);
				out.writeObject(jugadaEnviada);
				out.flush();

				int resultado = jugadaRecibida.getNumJugado() + numeroJugado;

				if (esPar) {
					if (resultado % 2 == 0) {
						partidasGanadas++;
						System.out.print("He ganado. ");
					} else {
						partidasPerdidas++;
						System.out.print("He perdido. ");
					}
				} else {
					if (resultado % 2 != 0) {
						partidasGanadas++;
						System.out.print("He ganado. ");
					} else {
						partidasPerdidas++;
						System.out.print("He perdido. ");
					}
				}

				System.out.println("Vamos Servidor: " + partidasGanadas + " Cliente: " + partidasPerdidas);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
