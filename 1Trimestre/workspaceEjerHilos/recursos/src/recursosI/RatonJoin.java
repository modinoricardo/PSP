package recursosI;

public class RatonJoin implements Runnable{
	
	private String nombre;

	private int tiempoAlimentacion;

	public RatonJoin(String nombre, int tiempoAlimentacion) {
	
		super ();
		this.nombre = nombre;
		this.tiempoAlimentacion = tiempoAlimentacion;
		}
		
	public void comer() {
		try {
			System.out.printf ("El ratón " +this.nombre+" ha comenzado a alimentarse%n",nombre) ;
			Thread.sleep(tiempoAlimentacion * 1000);
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
		
		RatonJoin fievel = new RatonJoin("Fievel", 4);		
		RatonJoin jerry = new RatonJoin("Jerry", 5);
		RatonJoin pinky = new RatonJoin("Pinky", 3);	
		RatonJoin mickey = new RatonJoin("Mickey", 6);
		
		new Thread(fievel).start();
		new Thread(jerry).start();
		Thread p = new Thread(pinky);
		p.start();						
		try {
		       p.join();
		   } catch (InterruptedException e) { }	
	
		new Thread(mickey).start();
		System.out.println("FINAL DE PROGRAMA");	   
	}
		
		
}
		