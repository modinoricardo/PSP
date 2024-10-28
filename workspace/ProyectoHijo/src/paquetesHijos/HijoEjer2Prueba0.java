package paquetesHijos;

import java.util.Scanner;

public class HijoEjer2Prueba0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String numeroEntrada;
        int suma = 0;
        
        while (sc.hasNext()) {
            numeroEntrada = sc.nextLine();
         
            if (numeroEntrada.equals("*")) {
                System.out.println(suma);
                System.exit(1);
            }

            try {
                int trueNumber = Integer.parseInt(numeroEntrada);
                suma += trueNumber;
                
            } catch (NumberFormatException e) {
                System.exit(-1);
            }
        }
        
        sc.close();
    }
}

