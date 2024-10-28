package hilos;

import java.io.*;

public class Transferencias extends Thread {
	private Saldo saldo;
	private ListaTransferencias lista;
	private File ficheroInternas, ficheroExternas, ficheroSinSaldo;
	private double sumaTotalTrans = 0.0;

	public Transferencias(String path, String nomFichero, Saldo saldo, ListaTransferencias lista) {
		this.saldo = saldo;
		this.lista = lista;
		this.ficheroInternas = new File(path + "/transferenciasInt.txt");
		this.ficheroExternas = new File(path + "/transferenciasExterna.txt");
		this.ficheroSinSaldo = new File(path + "/transferenciasSinSaldo.txt");
	}

	public double getSumaTotalTrans() {
		return sumaTotalTrans;
	}

	@Override
	public void run() {
		catalogaTransfer();
	}

	public synchronized void catalogaTransfer() {
		while (!lista.finalFichero()) {
			String linea = lista.cogerTransOrdenada();

			// aqui siempre me da 50
			int tipoTrans = Character.getNumericValue(linea.charAt(0));

			String[] partes = linea.split(";");

			String cuenta = partes[0];
			double imporNomina = Double.parseDouble(partes[1]);

			switch (tipoTrans) {
			case 1:
				cuentaInterna(cuenta, imporNomina, linea);
				break;
			case 2:
				cuentaExterna(cuenta, imporNomina, linea);
				break;
			}
		}
	}

	private void cuentaExterna(String cuenta, double imporNomina, String linea) {

		synchronized (saldo) {
			if (saldo.saldoSuficienteTrans(imporNomina)) {
				saldo.setSaldo(saldo.getSaldo() - imporNomina);
				sumaTotalTrans += imporNomina;
				escribeTransferencia(ficheroExternas, linea);

					System.out.println("Cuenta: " + cuenta + " - Actualizamos el saldo de la cuenta con el importe: "
							+ imporNomina + " €\n" + "Grabamos transferencia externa. Cuenta " + cuenta);

			} else {
				escribeTransferencia(ficheroSinSaldo, linea);
				System.out.println("No hay saldo para la siguiente transferencia de: " + imporNomina + " €");
			}
		}

	}

	private void cuentaInterna(String cuenta, double imporNomina, String linea) {

		synchronized (saldo) {

			if (saldo.saldoSuficienteTrans(imporNomina)) {
				saldo.setSaldo(saldo.getSaldo() - imporNomina);
				sumaTotalTrans += imporNomina;
				escribeTransferencia(ficheroInternas, linea);

				try {
					sleep(1000); // simula validaciones

					System.out.println("Cuenta: " + cuenta + " - Actualizamos el saldo de la cuenta con el importe: "
							+ imporNomina + " €\n" + "Grabamos transferencia interna. Cuenta " + cuenta);

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {
				escribeTransferencia(ficheroSinSaldo, linea);
				System.out.println("No hay saldo para la siguiente transferencia de: " + imporNomina + " €");
			}
		}
	}

	private void escribeTransferencia(File fichero, String linea) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fichero, true))) {
			writer.write(linea + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
