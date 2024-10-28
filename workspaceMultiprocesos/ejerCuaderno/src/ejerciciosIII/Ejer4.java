package ejerciciosIII;

import java.io.*;
import java.util.Scanner;

public class Ejer4 {

	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner sc = new Scanner(System.in);

		File direcAsigMedia = new File("D:\\DAM+DAW2º\\workspace\\ProyectoHijo\\bin");

		String asignatura;
		String fichero;

		do {
			System.out.println("Escribe la asignatura: ");
			asignatura = sc.nextLine();
			System.out.println("Escribe el nombre del fichero");
			fichero = sc.nextLine();

			if (!asignatura.equals("*") && !fichero.equals("*")) {

				ProcessBuilder pb = new ProcessBuilder("java", "paquetesHijos.HijoMPIIIEjer4");
				pb.directory(direcAsigMedia);

				Process p = pb.start();

				OutputStream os = p.getOutputStream();
				try (DataOutputStream dOs = new DataOutputStream(p.getOutputStream());
						Scanner sc1 = new Scanner(p.getInputStream())) {

					dOs.writeUTF(asignatura);
					dOs.writeUTF(fichero);
					dOs.flush();

					while (sc1.hasNextLine()) {
						System.out.println(sc1.nextLine());
					}
				}
			}

			System.out.println();
		} while (!asignatura.equals("*") && !fichero.equals("*"));

		sc.close();

	}

}
