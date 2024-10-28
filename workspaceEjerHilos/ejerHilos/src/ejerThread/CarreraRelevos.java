package ejerThread;

public class CarreraRelevos extends Thread{
		
	public static void main(String[] args) {
		
		CarreraRelevos_Equipos españa = new CarreraRelevos_Equipos("España");
		CarreraRelevos_Equipos eeuu = new CarreraRelevos_Equipos("EEUU");
		
		españa.add("Pepe");
		españa.add("Maria");
		españa.add("Juan");
		españa.add("Marta");
		
		eeuu.add("Jhon");
		eeuu.add("Kim");
		eeuu.add("Mike");
		eeuu.add("Sarah");
		
		españa.start();
		eeuu.start();
		
		//System.out.println("FINAL DEL PROGRAMA");		
	}
	
}
//haz un proyecto y añade otra clase con la que los equipos de España y
//EEUU van a hacer una carrera de relevos: