package productorConsumidor;

public class Armario {

	private int cantidadHamburguesas = 0, cantidadPizzas = 0;
	private final int MAX_HAMBURGUESAS = 3, MAX_PIZZAS = 2;
	private int finalTurnoRepartidores = 0;
	private final int MAX_REPARTIDORES = 4;
	// hamburguesas = 0 pizzas = 1
	// hamburguesas = 0 pizzas = 1 todo =2
	
	public void terminaRepartidor() {	
		finalTurnoRepartidores++;
	}
	
	public int getCantidadHamburguesas() {
		return cantidadHamburguesas;
	}

	public void setCantidadHamburguesas(int cantidadHamburguesas) {
		this.cantidadHamburguesas = cantidadHamburguesas;
	}

	public int getCantidadPizzas() {
		return cantidadPizzas;
	}

	public void setCantidadPizzas(int cantidadPizzas) {
		this.cantidadPizzas = cantidadPizzas;
	}

	public boolean cerrarCocina() {
		if(finalTurnoRepartidores==MAX_REPARTIDORES)
			return true;
		return false;
	}

	public synchronized int repartir(int tipoRepartidor, String nombre) {
		// hamburguesas = 0 pizzas = 1

		if (tipoRepartidor == 0) {

			while (cantidadHamburguesas == 0) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			notifyAll();
			cantidadHamburguesas--;
			return 0;

		} else if (tipoRepartidor == 1) {

			while (cantidadPizzas == 0) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			notifyAll();
			cantidadPizzas--;
			return 1;

		} else if (tipoRepartidor == 2) {

			while (cantidadHamburguesas == 0 && cantidadPizzas == 0) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			notifyAll();

			if (cantidadHamburguesas == 0) {
				System.out.println(nombre+ " va a repartir una Pizza."
						+ " Quedan: "+(getCantidadPizzas()));
				cantidadPizzas--;
				return 1;
			} else {
				System.out.println(nombre+ " va a repartir una Hamburguesa."
						+ " Quedan: "+(getCantidadHamburguesas()));
				cantidadHamburguesas--;
				return 0;
			}

		}
		return 2;
	}

	public synchronized void crearHamburgesa() {
		
		while(cantidadHamburguesas == MAX_HAMBURGUESAS) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		notifyAll();
		cantidadHamburguesas++;
		
	}

	public synchronized void crearPizza() {
		
		while(cantidadPizzas == MAX_PIZZAS) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		notifyAll();
		cantidadPizzas++;
		
	}

}
