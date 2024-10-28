package ejerThread;

public class ArtificieroBomba_bomba extends Thread{
	
	public void run() {
		
		for(int i = 9; i>=0 ;i--) {
			
			System.out.println(i);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("El artificiero ha desactivado la bomba");
				System.out.println("La bomba ha sido desactivada");
			}
			
		}

	}
}
