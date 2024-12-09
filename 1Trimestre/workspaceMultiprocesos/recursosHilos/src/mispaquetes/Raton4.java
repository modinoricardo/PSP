package mispaquetes;

public class Raton4 {
	


	private String nombre;

	private int tiempoAlimentacion;

	public Raton4(String nombre, int tiempoAlimentacion) {
	
		super ();
		this.nombre = nombre;
		this.tiempoAlimentacion = tiempoAlimentacion;
		}
		
	public void comer() {
		try {
			System.out.printf ("El ratón " +this.nombre+" ha comenzado a alimentarse%n",nombre) ;
			Thread. sleep(tiempoAlimentacion * 1000);
			System.out.printf ("El ratón " +this.nombre+" ha terminado de alimentarse%n",nombre) ;				}catch (InterruptedException e) {
			e.printStackTrace () ;
		}														
	}

	public static void main(String[] args) {
		Raton fievel = new Raton("Fievel", 4);
		Raton jerry = new Raton("Jerry", 5);
		Raton pinky = new Raton("Pinky", 3);
		Raton mickey = new Raton("Mickey", 6);
		
		fievel.comer();
		jerry.comer();
		pinky.comer();
		mickey.comer();
	}
		
		
}
		