package ejerThread;

public class CarreraRelevos_Participantes extends Thread{

	int velocidad;
	String pais,nombre;

//	public CarreraRelevos_Participantes(String nombre) {
//		int min = 950, max = 1050;
//		this.velocidad = (int) (Math.random()*(max-min+1)) +min;
//		
//		this.nombre = nombre;
//	}
	
	public CarreraRelevos_Participantes(String nombre, String pais) {
		int min = 950, max = 1050;
		this.velocidad = (int) (Math.random()*(max-min+1)) +min;
		
		this.pais = pais;
		this.nombre = nombre;
	}
	
	@Override
	public void run() {
		int tiempoTerminar;
		System.out.println(pais+":"+nombre+" comienza su relevo");
		
		tiempoTerminar = velocidad * 10;
		
		try {
			sleep(tiempoTerminar);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(pais+":"+nombre+" ha acabado su relevo - Ha tardado: "+(double)tiempoTerminar / 1000+" segundos");
	}
	
}
