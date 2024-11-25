package principal;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	public static void main(String[] args) {
		
		final int NUMERO_PUERTO = 5000;
		ServerSocket server = null;
		Socket sk = null;

		DataOutputStream out;
		DataInputStream in;
		
		try {
			
			server = new ServerSocket(NUMERO_PUERTO);
			System.out.println("Servidor iniciado");
			System.out.println("Numeros recibidos: ");
			
			while(true) {
				
				sk = server.accept();
				
				in = new DataInputStream(sk.getInputStream());
				out = new DataOutputStream(sk.getOutputStream());
				
				int numero = in.readInt();
				System.out.println(numero);
				
				numero = (int) Math.pow(numero, 2);
				
				out.writeInt(numero);
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}
}
