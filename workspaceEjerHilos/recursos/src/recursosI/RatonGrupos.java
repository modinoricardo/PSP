package recursosI;

public class RatonGrupos extends Thread{
	


	private String nombre;

	private int tiempoAlimentacion;

	public RatonGrupos(String nombre, int tiempoAlimentacion) {
	
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
		 
		RatonGrupos fievel = new RatonGrupos("Fievel", 4);
		Thread r1 = new Thread(grupo,fievel);
		RatonGrupos jerry = new RatonGrupos("Jerry", 5);
		RatonGrupos pinky = new RatonGrupos("Pinky", 3);
		Thread r3 = new Thread(grupo,pinky);
		RatonGrupos mickey = new RatonGrupos("Mickey", 6);
		
		r1.start();
		jerry.start();
		r3.start();
		mickey.start();
		
		grupo.interrupt();
	}
		
		
}
		