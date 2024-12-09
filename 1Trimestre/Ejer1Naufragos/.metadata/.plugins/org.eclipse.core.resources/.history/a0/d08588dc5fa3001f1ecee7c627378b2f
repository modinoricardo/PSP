package principal;

public class Barca extends Thread {

	private Isla isla;
	private int capacidad;
	private int naufragosSalvados = 0;
	private int tiempoTardado = 0;

	public Barca(Isla isla, int maxCapacidad, int minCapacidad) {

		this.isla = isla;
		this.capacidad = (int) (Math.random() * (maxCapacidad - minCapacidad + 1)) + minCapacidad;
	}

	public void imprimeTotalSalvaciones() {
		System.out.println("La barca " + this.getName() + " salvo a " + naufragosSalvados + " naufragos");
	}

	public void imprimeTotalTiempoTardado() {
		System.out.println("La barca " + this.getName() + " tardo un total de " + tiempoTardado + " segundos");
	}

	@Override
	public void run() {
		System.out.println("La barca actual es " + this.getName() + " y tiene " + capacidad + " plazas");
		while (!isla.estaVacia()) {

			naufragosSalvados += isla.rescate(capacidad, this.getName());

			try {
				sleep(1);
				tiempoTardado += 3000;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		System.out.println("Barco " + this.getName() + " ha terminado");

		imprimeTotalSalvaciones();
		imprimeTotalTiempoTardado();

	}

}
