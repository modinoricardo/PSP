package ejer1;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class EnteroPadre {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		//File ficheroHijo = new File("G:\\eclipse-workspace\\ProyectoHijo\\bin");
		File ficheroHijo = new File("D:\\DAM+DAW2º\\workspace\\ProyectoHijo\\bin");
		
		ProcessBuilder pb = new ProcessBuilder("java", "paquetesHijos.HijoEnteros");
		pb.directory(ficheroHijo);
		
		Process p = pb.start();
		
		System.out.println("Escribeme un numero");
		String num = sc.nextLine();
		num = num+"\n";
		
		OutputStream os = p.getOutputStream();
		os.write(num.getBytes());
		os.close();
		//os.flush();
		
		try {
			int exitVal = p.waitFor();
			
			switch (exitVal) {
			case 0:
				System.out.println("entero negativo");
				break;
			case -1:
				System.out.println("vacio");
				break;
			case -2:
				System.out.println("no entero");
				break;
			case -3:
				System.out.println("entero");
				break;
			}
			
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
