package papelTijera;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Sevidor {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int puerto=6000;
		ServerSocket servidor = new ServerSocket(puerto);
		Socket cliente=null;
		System.out.println("Servidor Conectado");
		cliente = servidor.accept();
		int clienteG=0;
		int servidorG=0;
		int jugadaS=0;
		int jugadaC=0;
		InputStream entrada=null;
		entrada =cliente.getInputStream();
		DataInputStream recibir = new DataInputStream(entrada);
		OutputStream salida=null;
		salida=cliente.getOutputStream();
		DataOutputStream salir = new DataOutputStream(salida);
		while(clienteG<3 && servidorG<3) {
			jugadaS =(int) ((Math.random()*(1-4+1))+4);
			jugadaC=recibir.readInt();
			
			if(jugadaC ==jugadaS) {
				salir.writeInt(0);
				System.out.println("EMPATE");
			}else if(jugadaC==1 && jugadaS==3) {
				clienteG++;
				salir.writeInt(1);
			}else if(jugadaC==3 && jugadaS==1) {
				servidorG++;
				salir.writeInt(2);
			}else if(jugadaC==2 && jugadaS==3) {
				servidorG++;
				salir.writeInt(2);
			}else if(jugadaC==3 && jugadaS==2) {
				clienteG++;
				salir.writeInt(1);
			}else if(jugadaC==1 && jugadaS==2) {
				servidorG++;
				salir.writeInt(2);
			}else if(jugadaC==2 && jugadaS==1) {
				clienteG++;
				salir.writeInt(1);
			}
			
			System.out.println("El servidor a sacado " + jugadaS);
			System.out.println("CLiente- " + clienteG + " Servidor-" + servidorG);
				
			if(clienteG==3) {
				System.out.println("Ha gando el cliente!!!!");
				salir.writeInt(1);
			}else if(servidorG==3) {
				System.out.println("Ha gando el servidor!!!!");
				salir.writeInt(1);
			}else if(servidorG!=3 && clienteG!=3){
				salir.writeInt(0);
			}
		
		}
		
		
		
		salir.close();
		recibir.close();
		salida.close();
		entrada.close();
		cliente.close();
		servidor.close();
	}

}
