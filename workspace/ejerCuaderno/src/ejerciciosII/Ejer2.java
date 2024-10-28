package ejerciciosII;

import java.io.*;
import java.util.Scanner;

public class Ejer2 {
	public static void main(String[] args) throws IOException {
		
		//Directorio del proceso que quiero llamar
		File directorioHijo = new File("D:\\DAM+DAW2º\\workspace\\ProyectoHijo\\bin");
		//Tipo de proceso y archivo
		ProcessBuilder pb = new ProcessBuilder("java","paquetesHijos.HijoEjer2");
		//agrego donde esta el programa
		pb.directory(directorioHijo);
		
		File salidaDatoTxt = new File("D:\\DAM+DAW2º\\temporales\\dato.txt");
		
		pb.redirectInput(salidaDatoTxt);
		
		Process p = pb.start();
		
		Scanner sc = new Scanner(salidaDatoTxt);
		
		InputStream is = p.getInputStream();
		
		try {
			
			int exitVal = p.waitFor();
			
			switch (exitVal) {
			case -1:
				System.out.println("Error de ejecucion, el valor no es un numero");
				break;
				
			case 0:
				
				Scanner sc2 = new Scanner(is);
				OutputStream os = p.getOutputStream();
				File escribirFichero = new File("D:\\DAM+DAW2º\\temporales\\suma.txt");
				
				while(sc2.hasNext()) {
					String salida = sc2.nextLine();

					os.write(salida);
					
				}
				is.close();
				sc.close();
				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
