package mispaquetes;

import java.util.concurrent.Semaphore;

public class Hilo extends Thread {

	Cola  miCola;
	
	public Hilo(Cola  miCola) {
		super();
		this.miCola = miCola;
	}
	
	public void run() {
		miCola.pasar(this.getName());
	}
	

	

}
