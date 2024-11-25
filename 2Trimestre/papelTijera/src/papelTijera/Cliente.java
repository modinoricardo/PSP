package papelTijera;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		int puerto=6000;
		String host="localhost";
		Scanner nn = new Scanner(System.in);
		Socket cliente= new Socket(host,puerto);
		int terminar=0;
		int servidorG=0;
		int clienteG=0;
		int auxiliar=0;
		int numero=0;
		
		DataOutputStream enviar = new DataOutputStream(cliente.getOutputStream());
		DataInputStream recibir= new DataInputStream(cliente.getInputStream());
		while(terminar ==0) {
			System.out.println("Inserta un numero (1-piedra,2-papel,3-tijera)");
			numero = nn.nextInt();
			enviar.writeInt(numero);
			auxiliar=recibir.readInt();
			if(auxiliar==1) {
				clienteG++;
			}else if(auxiliar==2){
				servidorG++;
			}
			System.out.println("CLiente- " + clienteG + " Servidor-" + servidorG);
			terminar=recibir.readInt();
			
			if(clienteG==3) {
				System.out.println("Ha gando el cliente!!!!");
			}else if(servidorG==3) {
				System.out.println("Ha gando el servidor!!!!");
			}
		}
		
		recibir.close();
		enviar.close();
		nn.close();
		cliente.close();
	}

}
