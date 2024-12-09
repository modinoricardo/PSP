package ejerciciosIII;

import java.io.*;

public class Ejer2 {
	public static void main(String[] args) throws IOException {
		
		//Directorio del proceso que quiero llamar
		File directorioHijo = new File(
				"C:\\Users\\Ricardo Marica\\Desktop\\workspace\\ProyectoHijo\\bin");
		//Tipo de proceso y archivo
		ProcessBuilder pb = new ProcessBuilder("java","paquetesHijos.HijoEjer2");
		//agrego donde esta el programa
		pb.directory(directorioHijo);
		
		File entradaDatoTxt = new File
				("C:\\Users\\Ricardo Marica\\Desktop\\temporal\\dato.txt");
		pb.redirectInput(entradaDatoTxt);
		
		Process p = pb.start();
		
        // Capturo el InputStream del proceso (la salida que genera el hijo)
		InputStream is = p.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		
		//Fichero donde se va a escribit la salida
		File escribirFichero = new File("C:\\Users\\Ricardo Marica\\Desktop\\temporal\\suma.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(escribirFichero));
		
		try {
			
			int exitVal = p.waitFor();
			
			switch (exitVal) {
			case -1:
				System.out.println("Error de ejecucion, el valor no es un numero");
				break;
				
			case 0:
				
				String linea;
				
				while((linea = reader.readLine()) != null) {
					writer.write(linea);
					writer.newLine();
				}
				
				writer.close();
				reader.close();
				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
