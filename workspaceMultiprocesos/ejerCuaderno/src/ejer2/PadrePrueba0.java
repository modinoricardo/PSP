package ejer2;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class PadrePrueba0 {
	public static void main(String[] args) throws IOException, InterruptedException {
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<String> miLista = new ArrayList<>();
		
		File ficheroHijo = new File("D:\\DAM+DAW2º\\workspace\\ProyectoHijo\\bin");
		ProcessBuilder pb = new ProcessBuilder("java", "paquetesHijos.HijoEjer2");
		pb.directory(ficheroHijo);
		
		Process p = pb.start();
		OutputStream os = p.getOutputStream();
		InputStream is = p.getInputStream();
		Scanner hijoScanner = new Scanner(is);
		
		String numero;
		int suma = 0;
		
		do {
			
			System.out.println("Escribe un número: ");
			numero = sc.nextLine();
			
			os.write(numero.getBytes());
			os.flush();
			
			if(hijoScanner.hasNextLine()) {
				String respuestaHijo = hijoScanner.nextLine();
				
				int valorDevuelto = Integer.parseInt(respuestaHijo);
				
				suma += valorDevuelto;
			
			switch (valorDevuelto) {
			case 1:
				
				miLista.add(numero);
				
				break;

			case -1:
				
				System.out.println("Error al introducir los datos");
				
				break;
			}
			
			}
			
		}while(!numero.equals("*"));
		
		System.out.println("Valor de Salida 0");
		
		
		for (String i : miLista) {
			System.out.println("Escrito "+i);
			
		}
		
		System.out.println("Suma: "+suma);
		
	}
}
