package productorConsumidor;

import java.util.Random;

public class Cocinero extends Thread{
	private int tipo;
	private Random ram;
	private Armario armario;
	//hamburguesas = 0 pizzas = 1
	//hamburguesas = 0 pizzas = 1 todo =2 

	public Cocinero(int tipo, Armario armario) {
		super();
		this.tipo = tipo;
		this.ram = new Random();
		this.armario = armario;
	}
	
	@Override
	public void run() {
		
		while(!armario.cerrarCocina()) {
			switch (tipo) {
			case 0:
				//hamburguesas
				int tipoEsperaHam = ram.nextInt(201);
//				System.out.println(tipoEsperaHam);
				try {
						System.out.println("Preparando una hamburguesa...");
						sleep(tipoEsperaHam);
						armario.crearHamburgesa();
						System.out.println("Hamburguesas preparada para reparto. "
								+ " Hamburguesas pendientes de entrega: "+(armario.getCantidadHamburguesas()));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;

			case 1:
				//pizzas
				int tipoEsperaPizza = ram.nextInt(301);
//				System.out.println(tipoEsperaPizza);
				try {
					System.out.println("Preparando una pizza...");
					sleep(tipoEsperaPizza);
					armario.crearPizza();
					System.out.println("Pizza preparada para reparto. "
							+ "Pizzas pendientes de entrega: "+(armario.getCantidadPizzas()));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		}
		
	}
	
}
