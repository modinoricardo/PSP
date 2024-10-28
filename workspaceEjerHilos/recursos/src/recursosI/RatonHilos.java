package recursosI;

public class RatonHilos extends Thread{
	
	private String nombre;

	private int tiempoAlimentacion;

	public RatonHilos(String nombre, int tiempoAlimentacion) {
	
		super ();
		this.nombre = nombre;
		this.tiempoAlimentacion = tiempoAlimentacion;
		}
		
	public void comer() {
		try {
			System.out.printf ("El ratón " +this.nombre+" ha comenzado a alimentarse%n",nombre) ;
			this.sleep(tiempoAlimentacion * 1000);
			System.out.printf ("El ratón " +this.nombre+" ha terminado de alimentarse%n",nombre) ;
		}catch (InterruptedException e) {
			e.printStackTrace () ;
		}														
	}
	
	@Override
	public void run() {
		this.comer();
	}

	public static void main(String[] args) {
		RatonHilos fievel = new RatonHilos("Fievel", 4);
		RatonHilos jerry = new RatonHilos("Jerry", 5);
		RatonHilos pinky = new RatonHilos("Pinky", 3);
		RatonHilos mickey = new RatonHilos("Mickey", 6);
		
		fievel.start();
		jerry.start();
		pinky.start();
		mickey.start();
	}
		
		
}
		