package principal;

public class Restaurante {
	public static void main(String[] args) {
		// producto 0 = hamburguesa Y producto 1 = pizza
		// tipo 1 = pizzas & tipo 2 = hamburguesas & tipo 3 todo

		Armario armario = new Armario();
		
		Cocinero c1 = new Cocinero(0, armario);
		Cocinero c2 = new Cocinero(1, armario);
		
		Repartidor r1 = new Repartidor(1, "Maria", armario);
		Repartidor r2 = new Repartidor(2, "Pedro", armario);
		Repartidor r3 = new Repartidor(3, "Ana", armario);
		Repartidor r4 = new Repartidor(3, "Juan", armario);
		
		c1.start();
		c2.start();
		
		r1.start();
		r2.start();
		r3.start();
		r4.start();
				
	}
}
