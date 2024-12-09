package principal;

public class Cadena extends Thread {

	private int[] miLista = { 0, 0, 0 };
	
    public synchronized int comprobarProducto(int tipoProducto) {
        for (int i = 0; i < miLista.length; i++) {
            if (miLista[i] == tipoProducto) {
                return i; // Producto encontrado
            }
        }
        return -1; // Producto no encontrado
    }

	public synchronized void colocarProducto(int tipoProducto) {
		boolean productoColocado = false;

		if (miLista[miLista.length - 1] == 0) { // comprobar si la ultima posicion es 0
			System.out.println("Produciendo tipo " + tipoProducto);

			for (int i = 0; i < miLista.length; i++) {
				if (miLista[i] == 0 && !productoColocado) { // colocar en la primera posicion el tipo de Producto
					System.out.println("Coloco un producto " + tipoProducto + " en la posicion " + i);
					miLista[i] = tipoProducto;
					imprimirLista();
					notifyAll();
					productoColocado = true; // terminamos el programa cuando introducimos el numero
				}
			}

		} else {//la lista esta llena
			try {
				wait();
				System.out.println("Hilo del producto " + tipoProducto + " dormido");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
			}
		}
	}

	public void imprimirLista() {
		System.out.print("[");
		
		for (int i = 0; i < miLista.length; i++) {
			if (i == 2) {
				System.out.print(miLista[i]);				
			}else {
			System.out.print(miLista[i] + ", ");
			}
		}
		
		System.out.print("]");
		System.out.println();
	}

	public synchronized void retirarProducto(int tipoProducto) {

		int posicionRetirar = comprobarProducto(tipoProducto);// recogemos la posicion a retirar
		miLista[posicionRetirar] = 0;// cambiamos la posicion por 0

		if (posicionRetirar != (miLista.length - 1))
			colocarLista();
		try {
			int tiempoEspera = (int) (Math.random() * 501);
			sleep(tiempoEspera);
			notifyAll();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}

	}

	private void colocarLista() {
		int[] listaAuxiliar = { 0, 0, 0 };
		int contador = 0;

		for (int i = 0; i < miLista.length; i++) {
			if (miLista[i] != 0) {
				listaAuxiliar[contador] = miLista[i];
				contador++;
			}
		}

		for (int i = 0; i < listaAuxiliar.length; i++) {
			miLista[i] = listaAuxiliar[i];
		}

	}

}
