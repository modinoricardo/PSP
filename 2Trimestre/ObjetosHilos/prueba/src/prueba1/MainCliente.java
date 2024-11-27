package prueba1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import servidor.A;

public class MainCliente {

	public static void main(String[] args) {
		A a = new A();
System.out.println("Cliente ");
		try(Socket cliente = new Socket("localhost",12345);
				ObjectOutputStream oOs = new ObjectOutputStream(cliente.getOutputStream())){
			
			System.out.println(a);
			oOs.writeObject(a);
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
