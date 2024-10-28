package ejerciciosIII;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class Ejer3 {

	public static void main(String[] args) throws IOException {
		
		File directorio = new File(
				"C:\\Users\\Ricardo Marica\\Desktop\\workspace\\ProyectoHijo\\bin");
		ProcessBuilder pb = new ProcessBuilder("java", "paquetesHijos.HijoEjer3");
		pb.directory(directorio);
		
		File fBat = new File(
				"C:\\Users\\Ricardo Marica\\Desktop\\temporal\\dato.txt");
		pb.redirectInput(fBat);
		File fOut = new File(
				"C:\\Users\\Ricardo Marica\\Desktop\\temporal\\palindromo.txt");
		pb.redirectOutput(fOut);
		File fErr = new File(
				"C:\\Users\\Ricardo Marica\\Desktop\\temporal\\error.txt");
		pb.redirectError();
		
		Process p = pb.start();

		try {

			int exitVal = p.waitFor();

			switch (exitVal) {
			case -1:
				System.out.println("No es palíndormo");
				break;

			case 0:
				System.out.println("Es palíndromo");
				break;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
