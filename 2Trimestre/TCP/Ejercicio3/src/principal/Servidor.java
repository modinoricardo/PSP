package principal;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	public static void main(String[] args) {

		final int NUMPUERTO = 5000;
		ServerSocket servidor = null;

		try {
			servidor = new ServerSocket(NUMPUERTO);

			System.out.println("Servidor iniciado...Esperando conexiones...");

			while (true) {
				System.out.println("Esperando a cliente 1...");
				Socket cliente1 = servidor.accept();
				procesarCliente(cliente1, true);

				System.out.println("Esperando a cliente 2...");
				Socket cliente2 = servidor.accept();
				procesarCliente(cliente2, false);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void procesarCliente(Socket cliente, boolean esMayuscula) throws IOException {

		DataInputStream in = new DataInputStream(cliente.getInputStream());
		DataOutputStream out = new DataOutputStream(cliente.getOutputStream());

		String mensaje = in.readUTF();
		mensaje = esMayuscula ? mensaje.toUpperCase() : mensaje.toLowerCase();

		out.writeUTF(mensaje);

	}

}
