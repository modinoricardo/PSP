package productorConsumidor;

public class Restaurante {
	public static void main(String[] args) {
		// hamburguesas = 0 pizzas = 1
		// hamburguesas = 0 pizzas = 1 todo =2

		Armario armario = new Armario();

		Cocinero cocinero1 = new Cocinero(0, armario);
		Cocinero cocinero2 = new Cocinero(1, armario);

		Repartidor pepe = new Repartidor(0, "Pepe", armario);
		Repartidor maria = new Repartidor(1, "Maria", armario);
		Repartidor juan = new Repartidor(2, "Juan", armario);
		Repartidor ricardo = new Repartidor(2, "Ricardo", armario);

		cocinero1.start();
		cocinero2.start();

		pepe.start();
		maria.start();
		juan.start();
		ricardo.start();
		
	}
}
