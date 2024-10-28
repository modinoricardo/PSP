package recursosI;

public class RatonVerInfo extends Thread{
	


	private String nombre;

	private int tiempoAlimentacion;

	public RatonVerInfo(String nombre, int tiempoAlimentacion) {
	
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
		RatonVerInfo fievel = new RatonVerInfo("Fievel", 4);
		RatonVerInfo jerry = new RatonVerInfo("Jerry", 5);
		RatonVerInfo pinky = new RatonVerInfo("Pinky", 3);
		RatonVerInfo mickey = new RatonVerInfo("Mickey", 6);
		
		fievel.start();
		jerry.start();
		pinky.start();
		mickey.start();
	}
		
		
}
		