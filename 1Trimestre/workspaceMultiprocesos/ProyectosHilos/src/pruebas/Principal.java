package pruebas;

public class Principal extends Thread{
	private final int tiempo=2;
	
	public Principal() {
		super();
	}
	public void escribir() {
		try {
			Tic tic= new Tic();
			Tac tac= new Tac();
			while (true) {
				System.out.println(tic);
				Thread.sleep(tiempo*250);
				System.out.println(tac);
				Thread.sleep(tiempo*250);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void run() {
		this.escribir();
	}
	public static void main(String[] args) {
		
		Principal reloj= new Principal();
		reloj.start();
		
	}
}
