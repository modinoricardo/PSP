package clientes;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import juego.Juego;

public class Cliente1 {
	
	private static int partidasGanadas = 0;
	private static int partidasPerdidas = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		final String HOST = "127.0.0.1";
		final int PUERTO = 5000;

		boolean error = true;
		boolean esPar = false;
		
		while(partidasGanadas<3 && partidasPerdidas<3) {
			do {
				System.out.println("¿Quieres Jugar PARES o NONES?");
				String paresNones = sc.nextLine();
				
				if(paresNones.equalsIgnoreCase("pares") || paresNones.equalsIgnoreCase("nones")) {
					esPar = (paresNones.equalsIgnoreCase("pares"));
					error = false;
				}else {
					System.out.println("El valor debe ser PARES O NONES");
				}
				
			} while (error);

			System.out.println("¿Dime un numero?");
			int numJugado = Integer.parseInt(sc.nextLine());
			
			try(Socket puenteAlServidor = new Socket(HOST, PUERTO);
				ObjectOutputStream out = new ObjectOutputStream(puenteAlServidor.getOutputStream());
					ObjectInputStream in = new ObjectInputStream(puenteAlServidor.getInputStream())){
				
				Juego jugadaEnviada = new Juego(esPar, numJugado);
				out.writeObject(jugadaEnviada);
				//out.flush();
				
				Juego jugadaRecibida = (Juego) in.readObject();
				int resultado = jugadaRecibida.getNumJugado() + numJugado;
				
				System.out.println("El juega el: "+jugadaRecibida.getNumJugado());
				
				if(esPar) {
					if(resultado%2==0) {
						partidasGanadas++;
						System.out.print("He ganado. ");
					}else {
						partidasPerdidas++;
						System.out.print("He perdido. ");
					}
				}else {
					if(resultado%2!=0) {
						partidasGanadas++;
						System.out.print("He ganado. ");
					}else {
						partidasPerdidas++;
						System.out.print("He perdido. ");
					}
				}
				System.out.println("Vamos Cliente: "+partidasGanadas+" Servidor: "+partidasPerdidas);
				
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Final del juego");
		sc.close();
	}
}
