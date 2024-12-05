package servidores;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import juego.Jugada;

public class Servidor {

	public static void main(String[] args) {

		boolean partidaTerminada = false;
		int victoriasCliente1 = 0;
		int victoriasCliente2 = 0;

		try (ServerSocket servidor = new ServerSocket(5000)) {

			System.out.println("Servidor iniciado...");

			Socket cliente1 = servidor.accept();
			Socket cliente2 = servidor.accept();
			
			ObjectInputStream oISC1 = new ObjectInputStream(cliente1.getInputStream());
			ObjectInputStream oISC2 = new ObjectInputStream(cliente2.getInputStream());
			
			DataOutputStream dOSC1 = new DataOutputStream(cliente1.getOutputStream());
			DataOutputStream dOSC2 = new DataOutputStream(cliente2.getOutputStream());
			
			while (true) {


				Jugada jugadaCliente1 = (Jugada) oISC1.readObject();
				Jugada jugadaCliente2 = (Jugada) oISC2.readObject();

				// 1piedra 2papel 3tijera

				int resultado = determinarGanador(jugadaCliente1.getPiedraPapelTijera(),
						jugadaCliente2.getPiedraPapelTijera());

				switch (resultado) {
				case 0:
					System.out.println("Es un empate");
					break;
				case 1:
					System.out.println("Gano el jugador 1");
					if (victoriasCliente1 >= 3) {
						System.out.println("Final del juego");
					} else {
						victoriasCliente1++;
					}
					break;
				case 2:
					System.out.println("Gano el jugador 2");
					if (victoriasCliente2 >= 3) {
						System.out.println("Final del juego");
					} else {
						victoriasCliente2++;
					}
					break;
				}

				System.out.println("Cliente-1: "+victoriasCliente1+" Cliente-2: "+victoriasCliente2);
				
				if(victoriasCliente1>=3 || victoriasCliente2>=3)
					partidaTerminada = true;
				
				dOSC1.writeBoolean(partidaTerminada);
				dOSC2.writeBoolean(partidaTerminada);
			}

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static int determinarGanador(int jugada1, int jugada2) {
		if (jugada1 == jugada2)
			return 0;
		if ((jugada1 == 1 && jugada2 == 3) || (jugada1 == 2 && jugada2 == 1) || (jugada1 == 3 && jugada2 == 2)) {
			return 1;
		}
		return 2;
	}

}
