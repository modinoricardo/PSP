package ejerThread;

public class Relevos extends Thread{

	private int RECORRIDO = 100;
	
	int velocidad;
	String pais,nombre;

	public Relevos(String nombre) {
		int min = 950, max = 1050;
		this.velocidad = (int) (Math.random()*(max-min+1)) +min;
		
		this.pais = "España";
		this.nombre = nombre;
	}

	public void correr() {
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
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//super.run();
		correr();
	}
	
	public static void main(String[] args) {
		
		Relevos pepe = new Relevos("Pepe");
		Relevos maria = new Relevos("Pepe");
		Relevos juan = new Relevos("juan");
		Relevos marta = new Relevos("Marta");
		
		try {
			pepe.start();
			pepe.join();
			
			maria.start();
			maria.join();
			
			juan.start();
			juan.join();
			
			marta.start();
			marta.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("FINAL DEL PROGRAMA");
		//LLamar al metodo, hacer el run, mensaje al final de Fin del programa
		
	}
	
}
//Crea una clase java con un método que simule que un corredor está corriendo 100 metros.
//La velocidad con la que corre 10 metros será un número aleatorio entre 950 y 1.050
//milisegundos.
//El método nos indicará cuando un corredor empieza el relevo y cuando lo acaba, además
//de al equipo al que pertenece.