package ejerThread;

import java.util.ArrayList;

public class CarreraRelevos_Equipos extends Thread{

	private ArrayList<CarreraRelevos_Participantes>participantes;
	private String nombre;

	public CarreraRelevos_Equipos(String nombre) {
		super();
		participantes = new ArrayList<CarreraRelevos_Participantes>();
		this.nombre = nombre;
	}
	
	public void add(String par) {
		participantes.add(new CarreraRelevos_Participantes(par, this.nombre));
	}
	
	@Override
	public void run() {
		for(CarreraRelevos_Participantes participante : participantes) {
			try {
				participante.start();
				participante.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("FINAL DEL PROGRAMA - "+nombre);
	}
	
}
