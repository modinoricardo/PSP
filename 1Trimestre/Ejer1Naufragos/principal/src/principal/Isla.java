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
			Thread.sleep(3000);
			numeroRescatados = rescatarNaufragos(numRescate, nombre);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		miSemaforo.release();
		return numeroRescatados;
	}

	private synchronized int rescatarNaufragos(int rescate, String nombre) {
		int rescatados = 0;

		if (totalNaufragos > 0) {
			if (rescate > totalNaufragos) {
				rescatados = totalNaufragos;
				totalNaufragos = 0;
			} else {
				totalNaufragos -= rescate;
				rescatados = rescate;

			}
			System.out.println("La balsa actual es " + nombre + " y rescatamos a " + rescatados);
			System.out.println("Quedan " + totalNaufragos + " náufragos");
		}
		return rescatados;

	}

	public boolean estaVacia() {
		return totalNaufragos == 0;
	}

}
