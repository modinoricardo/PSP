package productorConsumidor;

import java.util.Random;

public class Repartidor extends Thread {

	private int numeroTotalRepartos = 0;
	private final int MAX_REPARTOS = 15;
	private int tipo;
	private String nombre;
	private Armario armario;
	private Random numRandom;
	private int hamburguesasRepartidas = 0;
	private int pizzasRepartidas = 0;
	// hamburguesas = 0 pizzas = 1
	// hamburguesas = 0 pizzas = 1 todo =2

	public Repartidor(int tipo, String nombre, Armario armario) {
		super();
		this.tipo = tipo;
		this.nombre = nombre;
		this.armario = armario;
		this.numRandom = new Random();
	}

	@Override
	public void run() {

		while (numeroTotalRepartos < MAX_REPARTOS) {
			int tiempoEspera = numRandom.nextInt(601);
			try {

				switch (tipo) {
				case 0:
					
					System.out.println(nombre + " va a repartir una Hamburguesa."
							+ " Quedan "+(armario.getCantidadHamburguesas()));

					break;

				case 1:
					System.out.println(nombre + " va a repartir una Pizza."
							+ " Quedan "+(armario.getCantidadPizzas()));
					break;
				}

				sleep(tiempoEspera);
				
				switch (armario.repartir(tipo, nombre)) {
				case 0:
					hamburguesasRepartidas++;
					break;

				case 1:
					pizzasRepartidas++;
					break;
				
				case 2:
					break;
				}
				
				numeroTotalRepartos++;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		armario.terminaRepartidor();

		mensajeFinal();		
	}

	public void mensajeFinal() {
		System.out.println();
		System.out.println("El repartidor "+nombre+" ha repartido "+hamburguesasRepartidas+" hamburguesas");
		System.out.println("El repartidor "+nombre+" ha repartido "+pizzasRepartidas+" pizzas");
		System.out.println();
	}

}
