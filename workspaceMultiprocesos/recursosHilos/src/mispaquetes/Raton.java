package mispaquetes;

public class Raton extends Thread{
	


	private String nombre;

	private int tiempoAlimentacion;

	public Raton(String nombre, int tiempoAlimentacion) {
	
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
			//e.printStackTrace () ;
			return;
		}														
	}
	
	@Override
	public void run() {
		System.out.println("Informacion del hilo: " + Thread.currentThread().toString());
		this.comer();		
	}

	public static void main(String[] args) throws InterruptedException {
		
		ThreadGroup grupo = new ThreadGroup("Grupo de hilos");
		
		
		Raton fievel = new Raton("Fievel", 4);
		Thread r1 = new Thread(grupo,fievel);
		Raton jerry = new Raton("Jerry", 5);
		Raton pinky = new Raton("Pinky", 3);
		Thread r3 = new Thread(grupo,pinky);
		Raton mickey = new Raton("Mickey", 6);
		
		r1.start();
		jerry.start();
		r3.start();
		mickey.start();
		
		grupo.interrupt();
	}
		
		
}
		