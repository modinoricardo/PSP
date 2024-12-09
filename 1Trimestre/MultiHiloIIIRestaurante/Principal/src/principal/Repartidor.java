package principal;

public class Repartidor extends Thread{
	// tipo 1 = pizzas & tipo 2 = hamburguesas & tipo 3 todo
	private int tipoRepartidor, totalRepartos;
	private String nombre;
	private Armario armario;

	private final int MAX_REPARTOS = 15;

	public Repartidor(int tipoRepartidor, String nombre, Armario armario) {
		super();
		this.tipoRepartidor = tipoRepartidor;
		this.nombre = nombre;
		this.armario = armario;
		this.totalRepartos = 0;
	}

	@Override
	public void run() {

		while (totalRepartos <= MAX_REPARTOS) {
			int tiempoReparto = (int) (Math.random() * 601);
			try {
				sleep(tiempoReparto);
				empezarRepartir();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		armario.puertasCerradas();
	}

	public synchronized void empezarRepartir() {

		switch (tipoRepartidor) {
		case 1:// repartidor de pizzas

			while (armario.getTotalpizzas() == 0) {

				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			totalRepartos++;
			int totalPizzas = armario.getTotalpizzas();
			armario.setTotalpizzas(totalPizzas - 1);
			notifyAll();

			System.out.println(nombre+" va a repartir una Pizza. \n"
					+ "Quedan "+armario.getTotalpizzas());
			
			System.out.println(nombre+" realizo "+totalRepartos+" repartos");
			
			break;

		case 2:// repartidor de hamburguesas

			while (armario.getTotalHamburguesas() == 0) {

				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			totalRepartos++;
			int totalHamburguesas = armario.getTotalHamburguesas();
			armario.setTotalHamburguesas(totalHamburguesas - 1);
			
			System.out.println(nombre+" va a repartir una hamburguesa. \n"
					+ "Quedan "+armario.getTotalHamburguesas());
			
			notifyAll();

			System.out.println(nombre+" realizo "+totalRepartos+" repartos");
			
			break;
		case 3:// reparte ambos

			boolean salida = true;

			while (salida) {
				if (armario.getTotalHamburguesas() != 0) {

					totalRepartos++;
					armario.setTotalHamburguesas(armario.getTotalHamburguesas() - 1);
					
					System.out.println(nombre+" va a repartir una hamburguesa. \n"
							+ "Quedan "+armario.getTotalHamburguesas());
					
					notifyAll();

					salida = false;
				} else if (armario.getTotalpizzas() != 0) {

					totalRepartos++;
					armario.setTotalpizzas(armario.getTotalpizzas() - 1);
					
					System.out.println(nombre+" va a repartir una Pizza. \n"
							+ "Quedan "+armario.getTotalpizzas());
					
					notifyAll();

					salida = false;
				}
			}
			
			System.out.println(nombre+" realizo "+totalRepartos+" repartos");
			
			break;
		}
	}

}
