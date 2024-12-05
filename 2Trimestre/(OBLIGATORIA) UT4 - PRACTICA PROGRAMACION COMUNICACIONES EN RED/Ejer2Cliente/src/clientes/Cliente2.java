package clientes;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

import juego.Jugada;

public class Cliente2 {

	public static void main(String[] args) {
		
		final String SERVER_IP = "127.0.0.1"; 
		final int SERVER_PORT = 5000;
		
		int victoriaCliente = 0;
		int victoriaServer = 0;
		
		boolean jugadaInvalida;
		
		int jugadaCliente = 0;
		
		try (Socket sk = new Socket(SERVER_IP, SERVER_PORT);
				Scanner sc = new Scanner(System.in);){
			
			ObjectOutputStream oOS = new ObjectOutputStream(sk.getOutputStream());
			ObjectInputStream oIS = new ObjectInputStream(sk.getInputStream());
			
			while(victoriaCliente<3 && victoriaServer <3) {
				
				do {
					jugadaInvalida = true;
					System.out.println("Que opcion quiere jugar: ");
					String jugada = sc.nextLine();

					if (jugada.matches("[1-3]") || jugada.equalsIgnoreCase("PIEDRA") || jugada.equalsIgnoreCase("PAPEL")
							|| jugada.equalsIgnoreCase("TIJERA")) {

						jugadaInvalida = false;

						switch (jugada.toUpperCase()) {
						case "PIEDRA", "1" -> jugadaCliente = 1;
						case "PAPEL", "2" -> jugadaCliente = 2;
						case "TIJERA", "3" -> jugadaCliente = 3;
						}

					} else {
						System.out.println(
								"Las opciones disponibles son: " + "\n\t1.Piedra" + "\n\t2.Papel" + "\n\t3.Tijera");
					}

				} while (jugadaInvalida);
				
				oOS.writeObject(new Jugada(jugadaCliente));
				Jugada jugadaServidor = (Jugada) oIS.readObject();
				
				switch (jugadaServidor.getPiedraPapelTijera()) {
				case 1:
					System.out.println("El servidor juega Piedra");
					break;
				case 2:
					System.out.println("El servidor juega Papel");
					break;
				case 3:
					System.out.println("El servidor juega Tijera");
					break;
				}

				switch (jugadaCliente) {
				case 1:
					System.out.println("El cliente juega Piedra");
					break;
				case 2:
					System.out.println("El cliente juega Papel");
					break;
				case 3:
					System.out.println("El cliente juega Tijera");
					break;
				}

				if (jugadaServidor.getPiedraPapelTijera() == jugadaCliente) {
					System.out.println("Hay un empate");
				} else if (jugadaServidor.getPiedraPapelTijera() == 1 && jugadaCliente == 3
						|| jugadaServidor.getPiedraPapelTijera() == 2 && jugadaCliente == 1
						|| jugadaServidor.getPiedraPapelTijera() == 3 && jugadaCliente == 2) {

					System.out.println("El servidor gana");
					victoriaServer++;

				} else {
					System.out.println("El cliente gana");
					victoriaCliente++;
				}
				
				System.out.println();
				System.out.println("Cliente: "+victoriaCliente+" Servidor: "+victoriaServer);
				System.out.println();
				
			}
			
			if(victoriaCliente>=3) {
				System.out.println("HEMOS GANADO");
			}else {
				System.out.println("El servidor nos gano esta vez");
			}
			
			System.out.println("Gracias por jugar");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}
