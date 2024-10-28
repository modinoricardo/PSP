package ejerciciosIII;

import java.io.File;
import java.io.IOException;

public class Ejer2Prueba {
	public static void main(String[] args) throws IOException {
		// Directorio del porceso que quiero llamar
		File directorio = new File(
				"C:\\Users\\Ricardo Marica\\Desktop\\workspace\\ProyectoHijo\\bin");
		// Tipo de proceso y archivo (depende del especificdo)
		ProcessBuilder pb = new ProcessBuilder("java","paquetesHijos.HijoEjer2");
		// Agrego donde esta el programa
		pb.directory(directorio);

		File fBat = new File("C:\\Users\\Ricardo Marica\\Desktop\\temporal\\dato.txt");
		pb.redirectInput(fBat);
		File fOut = new File("C:\\Users\\Ricardo Marica\\Desktop\\temporal\\suma.txt");
		pb.redirectOutput(fOut);
		File fErr = new File("C:\\Users\\Ricardo Marica\\Desktop\\temporal\\error.txt");
		pb.redirectError(fErr);

		Process p = pb.start();

		try {
			int exitVal = p.waitFor();

			switch (exitVal) {
			case -1:
				System.out.println("Error de ejecucion, un valor no es un numero");
				break;
			case 0:
				break;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
