package pruebas;

public class Tac extends Thread{
	private final String palabra="Tac";

	public Tac() {
		super();
	}

	@Override
	public String toString() {
		return palabra;
	}
}
