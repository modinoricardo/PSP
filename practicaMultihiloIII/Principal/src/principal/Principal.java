package principal;

public class Principal extends Thread{
	public static void main(String[] args) {

		Cadena lista = new Cadena();
		
		Colocador colocador = new Colocador(lista);
		
		Empaquetador empaquetador1 = new Empaquetador(1, lista);
		Empaquetador empaquetador2 = new Empaquetador(2, lista);
		Empaquetador empaquetador3 = new Empaquetador(3, lista);
		
		colocador.start();
		
		empaquetador1.start();
		empaquetador2.start();
		empaquetador3.start();
		
		try {
			sleep(10000);
			
			colocador.interrupt();
			
			empaquetador1.interrupt();
			empaquetador2.interrupt();
			empaquetador3.interrupt();
			
			empaquetador1.join();
			empaquetador2.join();
			empaquetador3.join();
			
			System.out.print("Quedan en la cinta "); //nunca llega aqui
			lista.imprimirLista();
			
		} catch (InterruptedException e) {
			
		}

	}
}
