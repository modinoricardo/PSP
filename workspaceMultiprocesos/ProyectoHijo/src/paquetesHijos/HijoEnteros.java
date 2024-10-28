package paquetesHijos;


import java.util.Scanner;

public class HijoEnteros {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double num;
		
		try {
			num=Double.parseDouble(sc.nextLine());
			
			if(num!=(int)num) {
				System.exit(-2);
			}else if(num<0){
				System.exit(0);
			}else if(num>0) {
				System.exit(-3);
			}
			
		} catch (NumberFormatException e) {
			System.exit(-1);
		}
		
	}
}
