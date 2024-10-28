package ejer2;

import java.io.*;
import java.util.Scanner;

public class Padre {
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		String datoRecibido, respuesta = "0";
		boolean primeraVez = false;
		
		do {	
			System.out.println("Escribe un número entero positivo:");
			datoRecibido = sc.nextLine();
			
			if(!primeraVez) {
				respuesta  = datoRecibido;
				primeraVez = true;
			}else {
				respuesta = respuesta + "\n" + datoRecibido;
			}
			
		}while(!datoRecibido.equals("*"));
		
		//Directorio del proceso que quiero llamar
		File directorio = new File("D:\\DAM+DAW2º\\workspace\\ProyectoHijo\\bin");
		//Tipo de proceso y archivo
		ProcessBuilder pb = new ProcessBuilder("java","paquetesHijos.HijoEjer2");
		//agrego donde esta el programa
		pb.directory(directorio);
		
		Process p = pb.start();
		
		//mandamos el proceso al hijo
		OutputStream os = p.getOutputStream();
		
		os.write(respuesta.getBytes());
		os.flush();
		os.close();
		
		try {
			
			int exitVal = p.waitFor();
			
			switch (exitVal) {
			case -1:
				System.out.println("Error de ejecucion, el valor no es un numero");
				break;
				
			case 0:
				
				InputStream is = p.getInputStream();
				Scanner sc2 = new Scanner(is);
				
				while(sc2.hasNext()) {
					String salida = sc2.nextLine();
					System.out.println(salida);
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
