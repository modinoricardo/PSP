package paquetesHijos;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class HijoMPIIIEjer4 {
	public static void main(String[] args) throws IOException {
		DataInputStream dIS = new DataInputStream(System.in);
		
		String nomAsignatura = dIS.readUTF();
		String nomFichero = dIS.readUTF();
				
		File ficheroNotas = new File("../"+nomFichero);
		
		//Ver ruta absoluta donde se guarda el archivo
		//System.out.println(ficheroNotas.getAbsolutePath());
		
		try (Scanner ficheroLectura = new Scanner(ficheroNotas)){
			
			double nota;
			double sumaNotas = 0;
			int contadorNotas = 0;
			int numAprobado = 0;
			
			while(ficheroLectura.hasNextLine()) {
				String linea = ficheroLectura.nextLine();
				
				nota = Double.parseDouble(linea);
				
				if(nota>=5) {
					numAprobado++;
				}
				
				sumaNotas += nota;
				
				contadorNotas++;
			}
			
			double mediaNotas = sumaNotas / contadorNotas;
			
			System.out.println("En la aignatura de "+nomAsignatura);
			System.out.println("Han aprobado "+numAprobado+" alumnos");
			System.out.println("La media es "+mediaNotas);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
