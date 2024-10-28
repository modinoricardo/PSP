package ejer;

import java.util.Arrays;
import java.util.Scanner;

public class OrdenaNum {

	public static void main(String[] args) {
		int[] num = new int[10];

		try (Scanner sc = new Scanner(System.in);){
			for (int i = 0; i < num.length; i++) {
				num[i] = Integer.parseInt(sc.nextLine());
			}
			
			//ordenamos los numeros
			Arrays.sort(num);
			
			for (int i : num) {
				System.out.println(i);
			}
			System.exit(0);
		} catch (Exception e) {
			// TODO: handle exception
			System.exit(-1);
		}

	}

}
