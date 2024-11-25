package principal;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		final String HOST = "127.0.0.1";
		final int NUMPUERTO = 5000;
		
		DataInputStream in;
		DataOutputStream out;
		
		try {
			
			Socket sk = new Socket(HOST, NUMPUERTO);
			
			in = new DataInputStream(sk.getInputStream());
			out = new DataOutputStream(sk.getOutputStream());
			
			System.out.println("Calcular el cuadrado de: ");
			int numero = Integer.parseInt(sc.nextLine());
			
			out.writeInt(numero);
						
			System.out.println(in.readInt());
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
