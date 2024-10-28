package ejer;

import java.io.*;
import java.util.Scanner;

public class EjerPadre {
	public static void main(String[] args) throws IOException, InterruptedException {

		// directorio del programa que genera los numeros
		File dirGeneraNum = new File(
				"/home/richi/Escritorio/practica2Multiprocesos/Ejer2GeneraNum/bin");
		ProcessBuilder pb1 = new ProcessBuilder("java", "ejer.GeneraNum");
		pb1.directory(dirGeneraNum);

		Process p1 = pb1.start();
		InputStream iS = p1.getInputStream();
		Scanner sc1 = new Scanner(iS);

		StringBuilder cadecadenaNumeros = new StringBuilder();

		System.out.println("Valor de Salida programa 1: " + p1.waitFor());
		//System.out.println("Pintando la salida del programa de generación de impares");
		while (sc1.hasNextLine()) {
			// leo cada linea del programa 1 que genera los numeros
			String num = sc1.nextLine();

			System.out.println(num);

			// añado el numero a la cadena
			cadecadenaNumeros.append(num).append("\n");

		}
		sc1.close();
		//System.out.println("Fin la salida del programa de generacion de impares");

		File dirOrdenarNum = new File("/home/richi/Escritorio/practica2Multiprocesos/Ejer2OrdenaNum/bin");
		ProcessBuilder pb2 = new ProcessBuilder("java", "ejer.OrdenaNum");
		pb2.directory(dirOrdenarNum);

		Process p2 = pb2.start();

		// enviamos los datos recogidos del primer programa y se lo mandamos al segundo
		OutputStream oS = p2.getOutputStream();
		oS.write(cadecadenaNumeros.toString().getBytes());
		oS.flush();

		InputStream iS2 = p2.getInputStream();
		Scanner sc2 = new Scanner(iS2);

		System.out.println("Valor de Salida programa 2: " + p2.waitFor());
		//System.out.println("Salida Ordenada del Segundo programa");
		while (sc2.hasNext()) {
			String linea = sc2.nextLine();
			System.out.println(linea);
		}
		//System.out.println("Fin Ordenada del segundo programa");
		sc2.close();
	}
}
