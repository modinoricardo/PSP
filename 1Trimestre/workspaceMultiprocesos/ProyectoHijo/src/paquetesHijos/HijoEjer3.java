package paquetesHijos;

import java.util.Scanner;

public class HijoEjer3 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String palabra = sc.nextLine();
		
		if(palabra.equals(reversa(palabra))) {
			System.out.println("Es palindromo");
			System.exit(0);
		}else {
			System.out.println("No es palindromo");
			System.exit(-1);
		}
	}
	
	private static String reversa(String arbalap) {
		
		String reverseString = "";
		
		for(int i = arbalap.length() - 1 ; i>=0 ; i--) {
			reverseString = reverseString + arbalap.charAt(i);
		}
		return reverseString;
	}
	
}
