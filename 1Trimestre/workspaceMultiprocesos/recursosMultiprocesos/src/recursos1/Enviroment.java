/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package recursos1;

/**
 *
 * @author jhorn
 */

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Enviroment {
    
public static void main(String[] args) throws IOException, InterruptedException
	{
		ProcessBuilder pb = new ProcessBuilder("C:\\windows\\notepad.exe");
		
                java.util.Map<String, String> env = pb.environment();
                System.out.println("N� procesadores: " + env.get("NUMBER_OF_PROCESSORS"));
	}

}