package principal;

public class Armario extends Thread {
	// producto 0 = hamburguesa Y producto 1 = pizza
	private boolean quedaSitioHamburgesas, quedaSitioPizzas;
	private int totalHamburguesas, totalpizzas;

	private boolean armarioAbierto;
	private int totalRepartidoresTerminado;

	public Armario() {
		super();

		this.quedaSitioHamburgesas = true;
		this.quedaSitioPizzas = true;
		this.totalHamburguesas = 0;
		this.totalpizzas = 0;
		this.armarioAbierto = true;
	}

	public synchronized boolean isArmarioAbierto() {
		return armarioAbierto;
	}

	public synchronized int getTotalpizzas() {
		return totalpizzas;
	}

	public synchronized void setTotalpizzas(int totalpizzas) {
		this.totalpizzas = totalpizzas;
	}

	public synchronized int getTotalHamburguesas() {
		return totalHamburguesas;
	}

	public synchronized void setTotalHamburguesas(int totalHamburguesas) {
		this.totalHamburguesas = totalHamburguesas;
	}

	public synchronized boolean isQuedaSitioHamburgesas() {
		return quedaSitioHamburgesas;
	}

	public synchronized boolean isQuedaSitioPizzas() {
		return quedaSitioPizzas;
	}

	public synchronized void colocarNuevoProducto(int producto) {
		// producto 0 = hamburguesa Y producto 1 = pizza

		switch (producto) {
		case 0:
			colocarHamburguesa();
			break;
		case 1:
			colocarPizza();
			break;
		}

	}

	public synchronized void colocarHamburguesa() {

		while (!quedaSitioHamburgesas) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.totalHamburguesas++;
		notifyAll();
	}

	public synchronized void compruebaEspacioHambur() {
		if (totalHamburguesas != 0) {
			quedaSitioHamburgesas = true;
		} else {
			quedaSitioHamburgesas = false;
		}
	}

	public synchronized void colocarPizza() {
		while (!quedaSitioPizzas) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.totalpizzas++;
		notifyAll();
	}

	public synchronized void compruebaEspacioPizzas() {
		if (totalpizzas != 0) {
			quedaSitioPizzas = true;
		} else {
			quedaSitioPizzas = false;
		}
	}

	public synchronized void puertasCerradas() {
		totalRepartidoresTerminado++;
		if(totalRepartidoresTerminado >= 4) {
			System.out.println();
			armarioAbierto = false;			
		}
	}

}
