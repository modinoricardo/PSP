package ejer1;

import java.io.IOException;
import java.util.Scanner;

public class Prueba {
	
	static Scanner sc = new Scanner(System.in);
	static int tiempo = 0;
	static int cancelar = 0; 
	
	public static void main(String[] args) {
		
		System.out.println("Que quiere hacer hoy: \n"
				+ "1. Apagar \n"
				+ "2. Reinicia \n"
				+ "3. Suspender \n");
		
		int opcion = Integer.parseInt(sc.nextLine());

				
	switch (opcion) {
	case 1:
		
		System.out.println("¿Cuanto tiempo quiere esperar?");
 		
		tiempo = Integer.parseInt(sc.nextLine());
		
		apagarEquipo(tiempo);
		
		System.out.println("Pulsa 1 para cancelar la accion");
		cancelar = Integer.parseInt(sc.nextLine());
		
		if(cancelar==1) {
			cancelarAccion();
			System.out.println("Accion cancelada");
		}

		break;
	case 2:
		
		System.out.println("¿Cuanto tiempo quiere esperar?");
 		
		tiempo = Integer.parseInt(sc.nextLine());
		
		reiniciarEquipo(tiempo);
		
		System.out.println("Pulsa 1 para cancelar la accion");
		cancelar = Integer.parseInt(sc.nextLine());
		
		if(cancelar==1) {
			cancelarAccion();
			System.out.println("Accion cancelada");
		}

		break;
	case 3:
		suspenderEquipo();
		break;
	default:
		break;
	}
			
	}
	
	private static void apagarEquipo(int tiempo) {
		
		Runtime entorno = Runtime.getRuntime();
		
		try {
			entorno.exec("cmd /c start cmd.exe /k shutdown -s -t "+tiempo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void reiniciarEquipo(int tiempo) {
		
		Runtime entorno = Runtime.getRuntime();
		
		try {
			entorno.exec("cmd /c start cmd.exe /k shutdown -r -t "+tiempo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void suspenderEquipo() {
		Runtime entorno = Runtime.getRuntime();
		
		try {
			entorno.exec("cmd /c start cmd.exe /k shutdown -h");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void cancelarAccion() {
		Runtime entorno = Runtime.getRuntime();
		
		try {
			entorno.exec("cmd /c start cmd.exe /k shutdown -a");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	}
	
}
