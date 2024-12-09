package ejerThread;

public class ArtificieroBomba_artifiero extends Thread{
	
	public void run() {
		//int tiempoDesactivacion = (int) (Math.random() * (10500 - 9500 + 1)) + 9500;
		int tiempoDesactivacion = 5;
		System.out.println("El artificiero empieza a desactivar la bomba");
		System.out.println("El tiempo que va a tardar en desactivarla es de " + tiempoDesactivacion);

		try {
			sleep(tiempoDesactivacion);

		} catch (InterruptedException e) {
			System.out.println("PUUUUMMMMMMM");
			System.out.println("El artificiero a muerto");
		}
	}
}
