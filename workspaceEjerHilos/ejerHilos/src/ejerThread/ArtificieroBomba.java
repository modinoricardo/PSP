package ejerThread;

public class ArtificieroBomba extends Thread {

	public static void main(String[] args) {

		ArtificieroBomba_bomba littleBoy = new ArtificieroBomba_bomba();
		ArtificieroBomba_artifiero pablo = new ArtificieroBomba_artifiero();

		littleBoy.start();
		pablo.start();

//		do  {
//			
//		}while((littleBoy.isAlive() && pablo.isAlive()));
		
		while((littleBoy.isAlive() && pablo.isAlive())) {
		}
		
		if(!littleBoy.isAlive()) {
			pablo.interrupt();			
		}else if(!pablo.isAlive()) {
			littleBoy.interrupt();
		}
	}

}
