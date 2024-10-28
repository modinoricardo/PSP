package paquetesHijos;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HijoEjer2 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);	
		double num, suma = 0;
		
		try {
			while(sc.hasNext()) {
				num = sc.nextDouble();
				suma += num;
				System.out.println("Escrito "+ num);
			}
		} catch (InputMismatchException e) {
			if(sc.next().equals("*")) {
				System.out.println("Escrito *" + "\nSuma: " + suma);
				System.exit(0);
			}
			
			System.exit(-1);
			
		}
		
	}
	
}
