package hilos;

import java.io.*;
import java.util.Scanner;

public class Principal {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		System.out.println("Dime la ruta donde lo guardo: ");
		String path = sc.nextLine();
		System.out.println("Dime el nombre del fichero a generar: ");
		String nomFichero = sc.nextLine();
		System.out.println("Dime el numero de transferencias a generar: ");
		String numTransferencias = sc.nextLine();

		sc.close();
		File dirEjerI = new File("/media/richi/USBR/DAM+DAW2º/PSP/UT2PRACTICA_MULTIHILO_(Copiar)/proyectoI/bin");
		ProcessBuilder pb = new ProcessBuilder("java", "generaDirTrans.CreaDir");
		pb.directory(dirEjerI);

		Process p = pb.start();

		try (BufferedOutputStream bos = new BufferedOutputStream(p.getOutputStream())) {

			bos.write((path + "\n" + nomFichero + "\n" + numTransferencias + "\n").getBytes());

			bos.flush();

			try {
				int exitval = p.waitFor();

				System.out.println("Valor de Salida " + exitval);

				switch (exitval) {
				case 0:
					BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

					System.out.println("El importe total de las transferencias es: " + reader.readLine());

					procesarFichero(path, nomFichero, Integer.parseInt(numTransferencias));
					break;

				case -1:
					System.out.println("Error al generar el fichero");
					break;

				case -2:
					System.out.println("No ha llegado el fichero de transferencias");
					break;
				}

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	private static void procesarFichero(String path, String nomFichero, int numTransferencias) {
		// Banca rota (pruebas)
//		double importePromedio = 1500 + (Math.random() * 1500);
//		double saldoCuenta = importePromedio * numTransferencias * 0.75;
//		saldoCuenta = Math.round(saldoCuenta * 100.0) / 100.0;

		double saldoCuenta = (2000 + (Math.random() * (3000 - 2000)));
		saldoCuenta *= numTransferencias;
		saldoCuenta = Math.round(saldoCuenta * 100.0) / 100.0;

		Saldo saldo = new Saldo(saldoCuenta); // Saldo inicial
		ListaTransferencias listaTransfer = new ListaTransferencias(path, nomFichero);

		System.out.println("El saldo de la cuenta es: " + saldo.getSaldo());

		Transferencias hilo0 = new Transferencias(path, nomFichero, saldo, listaTransfer);
		Transferencias hilo1 = new Transferencias(path, nomFichero, saldo, listaTransfer);
		Transferencias hilo2 = new Transferencias(path, nomFichero, saldo, listaTransfer);

		// Inicia los hilos
		hilo0.start();
		hilo1.start();
		hilo2.start();

		do {
		} while (hilo0.isAlive() || hilo1.isAlive() || hilo2.isAlive());

		System.out.println("Hilo 0 ha hecho transferencias por valor de: " + hilo0.getSumaTotalTrans());
		System.out.println("Hilo 1 ha hecho transferencias por valor de: " + hilo1.getSumaTotalTrans());
		System.out.println("Hilo 2 ha hecho transferencias por valor de: " + hilo2.getSumaTotalTrans());

		System.out.println("Quedan " + Math.round(saldo.getSaldo() * 100.0) / 100.0 + "€ en la cuenta");

		System.out.println("Fin del proceso");

	}

}
