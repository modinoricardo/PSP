package clientes;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import juego.Jugada;

public class Cliente2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		boolean jugadaInvalida = true;
		int jugadaInt = 0;
		boolean juegoTerminado;

		final String SERVER_IP = "127.0.0.1";
		final int SERVER_PORT = 5000;
				
		try (Socket sk = new Socket(SERVER_IP, SERVER_PORT);
				ObjectOutputStream oOS = new ObjectOutputStream(sk.getOutputStream());
				DataInputStream in = new DataInputStream(sk.getInputStream())) {

			do {
				do {
					jugadaInvalida = true;
					System.out.println("Que opcion quiere jugar: ");
					String jugada = sc.nextLine();

					if (jugada.matches("[1-3]") || jugada.equalsIgnoreCase("PIEDRA") || jugada.equalsIgnoreCase("PAPEL")
							|| jugada.equalsIgnoreCase("TIJERA")) {

						jugadaInvalida = false;

						switch (jugada.toUpperCase()) {
						case "PIEDRA", "1" -> jugadaInt = 1;
						case "PAPEL", "2" -> jugadaInt = 2;
						case "TIJERA", "3" -> jugadaInt = 3;
						}

					} else {
						System.out.println(
								"Las opciones disponibles son: " + "\n\t1.Piedra" + "\n\t2.Papel" + "\n\t3.Tijera");
					}

				} while (jugadaInvalida);
				
				oOS.writeObject(new Jugada(jugadaInt));
				
				System.out.println(in.readBoolean() ? "Ronda ganada" : "Ronda no ganada");
				juegoTerminado = in.readBoolean();
			} while (!juegoTerminado);
			
			System.out.println(in.readBoolean() ? "HEMOS GANADO EL JUEGO" : "HEMOS PERDIDO EL JUEGO");
			
			System.out.println("El juego ha terminado. Gracias por Jugar");
			sc.close();
		
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
