package principal;

import java.util.concurrent.Semaphore;

public class Isla {
	
	private int totalNaufragos;
	private Semaphore miSemaforo;

	public Isla(Semaphore miSemaforo) {
		this.totalNaufragos = (int)(Math.random()*201) + 800;
		this.miSemaforo = miSemaforo;
	}

}
