package servidores;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import juego.Jugada;

public class Partida extends Thread {

	private int victoriasCliente = 0;
	private int victoriasServidor = 0;
	ObjectOutputStream oOS;
	ObjectInputStream oIS;

	public Partida(Socket sk) {
		try {
			oOS = new ObjectOutputStream(sk.getOutputStream());
			oIS = new ObjectInputStream(sk.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 1Piedra 2papel 3Tijera

	@Override
	public void run() {
		while (victoriasCliente < 3 && victoriasServidor < 3) {
			empezarJugar();
		}
	}

	private void empezarJugar() {

		try {
			int jugadaServidor = (int) (Math.random() * 3 + 1);
			Jugada jugadacliente = (Jugada) oIS.readObject();

			oOS.writeObject(new Jugada(jugadaServidor));

			switch (jugadaServidor) {
			case 1:
				System.out.println("El servidor juega Piedra");
				break;
			case 2:
				System.out.println("El servidor juega Papel");
				break;
			case 3:
				System.out.println("El servidor juega Tijera");
				break;
			}

			switch (jugadacliente.getPiedraPapelTijera()) {
			case 1:
				System.out.println("El cliente juega Piedra");
				break;
			case 2:
				System.out.println("El cliente juega Papel");
				break;
			case 3:
				System.out.println("El cliente juega Tijera");
				break;
			}

			if (jugadaServidor == jugadacliente.getPiedraPapelTijera()) {
				System.out.println("Hay un empate");
			} else if (jugadaServidor == 1 && jugadacliente.getPiedraPapelTijera() == 3
					|| jugadaServidor == 2 && jugadacliente.getPiedraPapelTijera() == 1
					|| jugadaServidor == 3 && jugadacliente.getPiedraPapelTijera() == 2) {

				System.out.println("El servidor gana");
				victoriasServidor++;

			} else {
				System.out.println("El cliente gana");
				victoriasCliente++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
