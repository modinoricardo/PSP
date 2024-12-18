package principal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Principal {
	public static void main(String[] args) {
		
		Semaphore miSemaforo = new Semaphore(2);
		
		Isla isla = new Isla(miSemaforo);
		
		System.out.println("La isla empieza con "+isla.getTotalNaufragos()+" naufragos");
		
		ExecutorService miExecutor = Executors.newFixedThreadPool(4);
		
		Barca barca1 = new Barca(isla,40,20);
		Barca barca2 = new Barca(isla,50,30);
		Barca barca3 = new Barca(isla,60,40);
		
		miExecutor.submit(barca1);
		miExecutor.submit(barca2);
		miExecutor.submit(barca3);
		
		miExecutor.shutdown();
				
	}
}
