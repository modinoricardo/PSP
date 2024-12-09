package hilos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class ListaTransferencias {
	private String path, nomFichero;
	private BlockingQueue<String> transferencias;
	private static int posicionDeseada = 0;

	public ListaTransferencias(String path, String nomFichero) {
		this.path = path;
		this.nomFichero = nomFichero;
		this.transferencias = new LinkedBlockingDeque<String>();
		rellenaListTrans();
	}
	
	public boolean finalFichero() {
		return posicionDeseada == transferencias.size();
	}

	public static int getPosicionDeseada() {
		return posicionDeseada;
	}

	public synchronized String cogerTransOrdenada() {
		int contador = 0;
		String siguienteTransFerencia = "";

		for (String trans : transferencias) {
			if (contador == posicionDeseada) {
				siguienteTransFerencia = trans;
			}
			contador++;
		}
		posicionDeseada++;
		return siguienteTransFerencia;
	}

	public void rellenaListTrans() {
		// verificamos si es una cuenta externa o interna
		File ficheroTrans = new File(path + "/" + nomFichero);

		try (BufferedReader br = new BufferedReader(new FileReader(ficheroTrans))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				transferencias.add(linea);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
