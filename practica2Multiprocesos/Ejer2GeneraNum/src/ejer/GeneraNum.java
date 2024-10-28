package ejer;

import java.io.*;

public class GeneraNum {

	public static void main(String[] args) {
		final int totalNum = 10;
		int contador = 0;

		//File ficheroEscritura = new File("D:\\DAM+DAW2º\\temporales\\impares.txt");
		File ficheroEscritura = new File("/home/richi/Escritorio/impares.txt");

		if (!ficheroEscritura.getParentFile().exists()) {
			System.out.println("La carpeta no existe \nCreandola...");
			ficheroEscritura.getParentFile().mkdirs();// crea la carpeta si no existe
		}

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(ficheroEscritura))) {

			do {
				int numRandom = (int) (Math.random() * 100) + 1;

				if (!esPar(numRandom)) {
					// System.out.println(numRandom);
					writer.write(numRandom+"\n");
					writer.flush();
					contador++;
				}

			} while (contador < totalNum);
			//System.out.println("Se han escrito " + contador + " numeros impares");
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	private static boolean esPar(int num) {
		return num % 2 == 0;
	}
}