package principal;

import java.util.concurrent.Semaphore;

public class Isla {

	private int totalNaufragos;
	private Semaphore miSemaforo;

	public Isla(Semaphore miSemaforo) {
		this.totalNaufragos = (int) (Math.random() * 201) + 800;
		this.miSemaforo = miSemaforo;
	}
	
	public int getTotalNaufragos() {
		return totalNaufragos;
	}

	public int rescate(int numRescate, String nombre) {
		
		int numeroRescatados = 0;
		
		try {
			miSemaforo.acquire();

			 numeroRescatados = naufragosSalvados(numRescate, nombre);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		miSemaforo.release();
		return numeroRescatados;
	}

	private synchronized int naufragosSalvados(int naufragosSalvados, String nombre) {
		
		int totalNaufragosSalvados = 0;
		
		if (totalNaufragos > 0) {

			if(naufragosSalvados>totalNaufragos) {
				
				System.out.println("La balsa actual es "+nombre+" y rescatamos a "+totalNaufragos);
				totalNaufragosSalvados = totalNaufragos;
				totalNaufragos = 0;
						
			}else {
				
				totalNaufragos -= naufragosSalvados;
				System.out.println("La balsa actual es "+nombre+" y rescatamos a "+naufragosSalvados);
				totalNaufragosSalvados = naufragosSalvados;
				
			}				
		}
		System.out.println("Quedan "+totalNaufragos+" náufragos");
		return totalNaufragosSalvados;

	}
	
	public boolean estaVacia() {
		return totalNaufragos == 0;
	}

}
