package mispaquetes;

public class Cola {
	private int numero;
	private boolean disponible = false;// inicialmente cola vacia

	public synchronized int get() {
		if (!disponible) { // hay número en la cola
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		disponible = false; // se pone cola vacía
		this.notifyAll();
		return numero; // se devuelve
	}

	public synchronized void put(int valor) {
		if(disponible) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		numero = valor; // coloca valor en la cola
		disponible = true; // disponible para consumir, cola llena
		this.notifyAll();
	}
}