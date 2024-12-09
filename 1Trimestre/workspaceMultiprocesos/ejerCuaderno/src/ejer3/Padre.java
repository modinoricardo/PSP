package ejer3;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class Padre {

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Escribe un texto: ");
		String texto = sc.nextLine();
		
		File directorio = new File(
				"D:\\DAM+DAW2º\\workspace\\ProyectoHijo\\bin");
		ProcessBuilder pb = new ProcessBuilder("java","paquetesHijos.HijoEjer3");
		pb.directory(directorio);
		
		Process p = pb.start();
		
		OutputStream os = p.getOutputStream();
		
		os.write(texto.getBytes());
		os.flush();
		os.close();
		
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
