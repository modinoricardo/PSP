package cliente;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		final String HOST = "127.0.0.1";
		final int PUERTO = 5000;

		boolean error = true;
		boolean esPares;
		do {
			System.out.println("¿Quieres Jugar PARES o NONES?");
			String paresNones = sc.nextLine();
			
			if(paresNones.equalsIgnoreCase("pares") || paresNones.equalsIgnoreCase("nones")) {
				esPares = (paresNones.equalsIgnoreCase("pares"));
				error = false;
			}else {
				System.out.println("El valor debe ser PARES O NONES");
			}
			
		} while (error);

		System.out.println("¿Dime un numero?");
		int num = Integer.parseInt(sc.nextLine());
		
		try(ServerSocket server = new ServerSocket(PUERTO)){
			
			Socket cliente = server.accept();
			ObjectInputStream in = new ObjectInputStream(cliente.getInputStream());
			Juego juego = (Juego) in.readObject();
			
			
			
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
