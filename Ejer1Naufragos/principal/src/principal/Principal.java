package principal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Principal {
	public static void main(String[] args) {
		
		Semaphore miSemaforo = new Semaphore(2);
		
		Isla isla = new Isla(miSemaforo);
		
		ExecutorService miExecutor = Executors.newFixedThreadPool(4);
		
		Barca barca1 = new Barca(isla,((int)Math.random()*201) + 800);
		Barca barca2 = new Barca(isla,((int)Math.random()*201) + 800);
		Barca barca3 = new Barca(isla,((int)Math.random()*201) + 800);
		
		miExecutor.submit(barca1);
		miExecutor.submit(barca2);
		miExecutor.submit(null)
		
	}
}
