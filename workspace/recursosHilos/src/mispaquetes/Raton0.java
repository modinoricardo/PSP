package mispaquetes;

public class Raton0 extends Thread{
	


	private String nombre;

	private int tiempoAlimentacion;

	public Raton0(String nombre, int tiempoAlimentacion) {
	
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
	    System.out.println(
	    	  	   "Dentro del Hilo  : " + Thread.currentThread().getName() + 
	    	 	   "\n\tPrioridad    : " + Thread.currentThread().getPriority() + 
	    	       "\n\tID           : " + Thread.currentThread().getId() +	  	  
	    	       "\n\tHilos activos: " + Thread.currentThread().activeCount());
		this.comer();
		
	}

	public static void main(String[] args) {
		Raton fievel = new Raton("Fievel", 4);
		Raton jerry = new Raton("Jerry", 5);
		Raton pinky = new Raton("Pinky", 3);
		Raton mickey = new Raton("Mickey", 6);
		
		fievel.start();
		jerry.start();
		pinky.start();
		mickey.start();
	}
		
		
}
		