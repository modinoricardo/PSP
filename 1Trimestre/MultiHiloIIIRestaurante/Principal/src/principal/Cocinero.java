package principal;

public class Cocinero extends Thread {
	// producto 0 = hamburguesa Y producto 1 = pizza
	private Armario armario;
	private int producto;

	public Cocinero(int producto, Armario armario) {
		super();
		this.armario = armario;
		this.producto = producto;
	}

	@Override
	public void run() {
		while (armario.isArmarioAbierto()) {
			try {
				int timeDo;
				if (producto == 0) {
					System.out.println("Preparando una hamburguesa...");
					timeDo = (int) (Math.random() * 201);
					sleep(timeDo);
					
					armario.colocarNuevoProducto(producto);
					
					System.out.print("Hamburguesa preparada para reparto. "
							+ "Hamburguesas pendientes de entrega: "+armario.getTotalHamburguesas()+"\n");
					
				} else if (producto == 1) {
					System.out.println("Preparando una pizza...");
					timeDo = (int) (Math.random() * 301);
					sleep(timeDo);
					armario.colocarNuevoProducto(producto);
					System.out.print("Pizza preparada para reparto. "
							+ "Pizzas pendientes de entrega: "+armario.getTotalHamburguesas()+"\n");
				}
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}

}
