package principal;

public class Empaquetador extends Thread { // quita el producto
	private int tipoProducto;
	private Cadena lista;
	private int sumaTotalProductos = 0;

	public Empaquetador(int tipoProducto, Cadena lista) {
		super();
		this.tipoProducto = tipoProducto;
		this.lista = lista;
	}

	@Override
	public void run() {
		while (!isInterrupted()) {
			try {
				if (lista.comprobarProducto(tipoProducto) != -1) {
					lista.retirarProducto(tipoProducto);
					sumaTotalProductos += tipoProducto;
					System.out.println("Recogido producto " + tipoProducto);
				}else {
					sleep(100);
				}
			} catch (InterruptedException e) {
			}
		}
	}

}
