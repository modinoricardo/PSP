package ejer;

import java.io.*;
import java.util.Arrays;

public class OrdenaNum {

	public static void main(String[] args) {
		int[] num = new int[10];
		int contador = 0;
		
		File ficheroLectura = new File(
				"/home/richi/Escritorio/impares.txt");
		File ficheroEscritura = new File(
				"/home/richi/Escritorio/orden.txt");
		
		if(!ficheroEscritura.getParentFile().exists()) {
			System.out.println("La carpeta no existe \nCreandola...");
			ficheroEscritura.getParentFile().mkdirs();
		}

		try (BufferedReader reader = new BufferedReader(new FileReader(ficheroLectura));
				BufferedWriter writer = new BufferedWriter(new FileWriter(ficheroEscritura))){
			
			String linea;
			
			while((linea = reader.readLine()) != null) {//Leo cada linea del archivo
				num[contador] = Integer.parseInt(linea);
				contador++;
			}
			
			//ordenamos los numeros
			Arrays.sort(num);
			
			for (int i : num) {
				//System.out.println(i);
				writer.write(i+"\n");
				writer.flush();
			}
			System.exit(0);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.exit(-1);
		}

	}

}
