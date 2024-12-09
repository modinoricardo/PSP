package ejerciciosIII;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Ejer1 {
	
	public static void main(String[] args) throws IOException {
		
		// Se crea un objeto File que representa el directorio donde está el proceso hijo
		File ficheroHijo = new File("D:\\DAM+DAW2º\\workspace\\ProyectoHijo\\bin");
		
		// Se construye un ProcessBuilder que ejecutará el proceso hijo en el paquete 'paquetesHijos' y clase 'HijoEnteros'	
		ProcessBuilder pb = new ProcessBuilder("java", "paquetesHijos.HijoEnteros");
		
		// Se establece el directorio donde se ejecutará el proceso hijo
		pb.directory(ficheroHijo);
		
		// Se crea un objeto File para representar el archivo "a.txt" que se utilizará como entrada del proceso hijo
		File entradaTxt = new File("D:\\DAM+DAW2º\\temporales\\a.txt");
		
		// El ProcessBuilder redirige la entrada del proceso hijo para que lea el archivo "a.txt" como entrada estándar
		pb.redirectInput(entradaTxt);
		
		// Se inicia el proceso hijo, esto lanza el proceso indicado por ProcessBuilder
		Process p = pb.start();
		
		// Se crea un Scanner para leer el archivo de entrada "a.txt"
		Scanner sc = new Scanner(entradaTxt);
		
		// Se obtiene el InputStream del proceso hijo para leer lo que imprime el proceso hijo
		InputStream is = p.getInputStream();
		
		try {
			// Espera a que el proceso hijo termine y devuelve el valor de salida del proceso hijo
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
			e.printStackTrace();
		}
		
	}
}

