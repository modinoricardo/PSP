package pruebas;

public class Tic extends Thread{
	
	private final String palabra="Tic";

	public Tic() {
		super();
	}

	@Override
	public String toString() {
		return palabra;
	}
	
	
}
