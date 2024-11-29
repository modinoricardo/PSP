package servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import juego.Juego;

public class Hilo extends Thread{
	
	private Socket puenteAlCliente;
	private static int partidasGanadas = 0;
	private static int partidasPerdidas = 0;
	
	public Hilo(Socket puenteAlCliente) {
		super();
		this.puenteAlCliente = puenteAlCliente;
	}

	@Override
	public void run() {
		
		try {
		
		ObjectOutputStream out = new ObjectOutputStream(puenteAlCliente.getOutputStream());
		ObjectInputStream in = new ObjectInputStream(puenteAlCliente.getInputStream());
		
		int numeroJugado = (int) (Math.random() * 100 + 1);

		Juego jugadaRecibida = (Juego) in.readObject();

		String mensaje = (jugadaRecibida.isEsPar()) ? "El juega PARES" : "El juega NONES";
		System.out.println(mensaje);
		System.out.println("Nº: " + jugadaRecibida.getNumJugado());

		System.out.println("Se ha generado un numero aleatorio: " + numeroJugado);

		boolean esPar = !jugadaRecibida.isEsPar();

		Juego jugadaEnviada = new Juego(!jugadaRecibida.isEsPar(), numeroJugado);
		out.writeObject(jugadaEnviada);
		out.flush();

		int resultado = jugadaRecibida.getNumJugado() + numeroJugado;

		if (esPar) {
			if (resultado % 2 == 0) {
				partidasGanadas++;
				System.out.print("He ganado. ");
			} else {
				partidasPerdidas++;
				System.out.print("He perdido. ");
			}
		} else {
			if (resultado % 2 != 0) {
				partidasGanadas++;
				System.out.print("He ganado. ");
			} else {
				partidasPerdidas++;
				System.out.print("He perdido. ");
			}
		}

		System.out.println("Vamos Servidor: " + partidasGanadas + " Cliente: " + partidasPerdidas);
		
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
	
}
