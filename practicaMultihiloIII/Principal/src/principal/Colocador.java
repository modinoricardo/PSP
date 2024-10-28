package principal;

public class Colocador extends Thread {// mete el producto
	private Cadena lista;
	private int sumaTotal = 0;

	public Colocador(Cadena lista) {
		super();
		this.lista = lista;
	}

	@Override
	public void run() {
		try {
			while (!isInterrupted()) {

				int tiempoEspera = (int) (Math.random() * 251);
				int tipoProducto = (int) (Math.random() * 3) + 1;
				//int tiempoEspera = 1;//pruebas
				
				sumaTotal += tipoProducto;
				
				lista.colocarProducto(tipoProducto);
				sleep(tiempoEspera);

			}
		} catch (InterruptedException e) {
			System.out.println("Puestos en total: " + sumaTotal);
		}

	}

}
