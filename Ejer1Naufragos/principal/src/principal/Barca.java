package principal;

public class Barca extends Thread {

	private Isla isla;
	private int capacidad;
	private int naufragosSalvados = 0;
	private int tiempoTardado = 0;

	public Barca(Isla isla,int maxCapacidad, int minCapacidad) {
		
		this.isla = isla;
		this.capacidad = (int)(Math.random()*(maxCapacidad-minCapacidad+1))+minCapacidad;
	}

	@Override
	public void run() {
		System.out.println("La barca actual es "+this.getName()+" y tiene "+capacidad+" plazas");
		while(!isla.estaVacia()) {
			
			isla.rescate(capacidad, this.getName());
			naufragosSalvados += Math.min(capacidad, isla.getTotalNaufragos());  // Aumentar el contador	
			
			try {
				sleep(3000);
				tiempoTardado += 3000;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
						
		}
	}

}