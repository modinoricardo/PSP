package principal;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import juego.Juego;

public class Server {
	public static void main(String[] args) {
		final int PUERTO = 5100;
		boolean turno = true;

		try (ServerSocket servidor = new ServerSocket(PUERTO)) {
			
			Socket puenteCliente1, puenteCliente2;
			
			puenteCliente1 = servidor.accept();
			puenteCliente2 = servidor.accept();
			
			ObjectInputStream inObject1 = new ObjectInputStream(puenteCliente1.getInputStream());
			ObjectInputStream inObject2 = new ObjectInputStream(puenteCliente2.getInputStream());
			ObjectOutputStream outObject1 = new ObjectOutputStream(puenteCliente1.getOutputStream());
			ObjectOutputStream outObject2 = new ObjectOutputStream(puenteCliente2.getOutputStream());
			
			DataInputStream inData1 = new DataInputStream(puenteCliente1.getInputStream());
			DataInputStream inData2 = new DataInputStream(puenteCliente2.getInputStream());
			DataOutputStream outData1 = new DataOutputStream(puenteCliente1.getOutputStream());
			DataOutputStream outData2 = new DataOutputStream(puenteCliente2.getOutputStream());
						
//			String mensajeParesONones = "¿Quieres Jugar PARES o NONES?";
//			String mensajePedirNumero = "¿Dime un número?";
			String mensajeConfirEleccion = "El otro Jugador ya ha elegido";
//			String mensajeJuegoNones = "Yo juego NONES";
//			String mensajeJuegoPares = "Yo juago PARES";

			while (true) {
				
				if (turno) {
					
					Juego juegoC1 = (Juego) inObject1.readObject();
					
					outData2.writeUTF(mensajeConfirEleccion);
					outData2.writeBoolean(!juegoC1.isEsPar());
					
					Juego juegoC2 = (Juego) inObject2.readObject();
					int numJugador1 = juegoC2.getNum();
					
				} else {

				}
				
				turno = !turno; //cambiamos el turno
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
