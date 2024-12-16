package clientes;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

import juego.Juego;

public class Cliente {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		final String HOST = "localhost";
		final int NUM_PUERTO = 2012;
		
		int numIntentos = 1;
		boolean juegoActivo = true;
		
		try (Socket puenteServidor = new Socket(HOST, NUM_PUERTO);){
			
			ObjectOutputStream oOS = new ObjectOutputStream(puenteServidor.getOutputStream());
			ObjectInputStream oIS = new ObjectInputStream(puenteServidor.getInputStream());
			
			int numJugado;
			while(juegoActivo) {
				System.out.println("Introduce un numero: Intento nº "+numIntentos);
				numJugado = Integer.parseInt(sc.nextLine());
				
				oOS.writeObject(new Juego(numJugado));
				
				Juego resultado = (Juego) oIS.readObject();
				
				if(resultado.isAcierto()) {
					System.out.println("Acertaste");
					juegoActivo = false;
				}else if(numIntentos>=5) {
					System.out.println("Se acabaron los intentos. Perdiste");
					juegoActivo = false;
				}else {
					if(resultado.isEsMayor()) {
						System.out.println("El numero es mayor que el numero escrito");
					}else {
						System.out.println("El numero es menor que el numero escrito");
					}
					
					numIntentos++;
				}
				
			}
			
			//System.out.println("Cierre cliente");
			sc.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
