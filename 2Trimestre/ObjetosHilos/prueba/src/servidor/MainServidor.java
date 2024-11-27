package servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServidor {
	public static void main(String[] args) {
		System.out.println("Servidor ");

		try(ServerSocket server = new ServerSocket(12345);
				Socket cliente = server.accept();
				ObjectInputStream oIS = new ObjectInputStream(cliente.getInputStream())){
			
			A a = (A) oIS.readObject();
			
			System.out.println(a);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
