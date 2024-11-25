package principal;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente2 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		final String HOST = "127.0.0.1";
		final int PUERTO = 5000;
		
		DataInputStream in;
		DataOutputStream out;
		
		try {
			Socket sc = new Socket(HOST, PUERTO);
			
			in = new DataInputStream(sc.getInputStream());
			out = new DataOutputStream(sc.getOutputStream());
			
			System.out.println("Texto a volver a minuscula: ");
			String mensaje= scanner.nextLine();
			
			out.writeUTF(mensaje);
			
			String mensajeRecibido = in.readUTF();
			
			System.out.println(mensajeRecibido);
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
