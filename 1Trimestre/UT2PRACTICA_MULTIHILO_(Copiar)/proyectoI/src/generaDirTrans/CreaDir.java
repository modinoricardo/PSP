package generaDirTrans;

import java.io.*;
import java.util.Scanner;

public class CreaDir {
	public static void main(String[] args) throws IOException {
		
		int numAleatorio = (int) (Math.random() * 100) + 1;

		// System.out.println("Numero aleatorio: " + numAleatorio);

		if (numAleatorio < 30) {
			// no llega el fichero
			// System.out.println("Error");
			System.exit(2);
		} else {
			try (Scanner sc = new Scanner(System.in)) {

				String rutaFichero = sc.nextLine();
				String nombreFichero = sc.nextLine();
				int numeroTotalTransferencias = sc.nextInt();

				File ficheroEscritura = new File(rutaFichero + "/" + nombreFichero);

				try (BufferedWriter writer = new BufferedWriter(new FileWriter(ficheroEscritura))) {

					int transferenciasRealizadas = 0;
					double importeTotalTrasferencias = 0;

					while (transferenciasRealizadas < numeroTotalTransferencias) {
						int part1NumCuen = (int) (Math.random() * 2) + 1;
						int part2NumCuen = (int) (Math.random() * 90000000) + 10000000;
						String numCuenta = part1NumCuen + "" + part2NumCuen;

						double importeNomina = 1500 + (Math.random() * 1500);
						importeNomina = Math.round(importeNomina * 100.0) / 100.0;

						importeTotalTrasferencias += importeNomina;

						String linea = numCuenta + ";" + importeNomina + "\n";

						writer.write(linea);
						transferenciasRealizadas++;
					}

					System.out.println(importeTotalTrasferencias);

				} catch (FileNotFoundException e) {
					// e.printStackTrace();
					System.out.println("El fichero no existe");
					System.exit(-1);
				} catch (Exception e) {
					// TODO: handle exception
					// e.printStackTrace();
					System.out.println("Error general");
					System.exit(-2);

				}
			}
		}
	}
}
