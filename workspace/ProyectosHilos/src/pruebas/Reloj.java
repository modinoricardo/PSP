package pruebas;

public class Reloj extends Thread{

	String palabra;
	
	public Reloj(String palabra) {
		this.palabra = palabra;
	}
	
	public void imprimirPalabra() {
		boolean acabar = false;
		
		while(acabar) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(palabra);
		}
	}
	
	public void run() {
		this.imprimirPalabra();
	}
	
}














