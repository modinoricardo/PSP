package ejerRunnable;

public class IronMan implements Runnable{
	
	private int BICI = 180, MARATHON = 42, NADAR = 4;
	
	String nombreParticipante;
	int velocidadCorres,velocidadBici, velocidadNadando;
	
	public IronMan(String nombreParticipante, int velocidadCorres, int velocidadBici, int velocidadNadando) {
		this.nombreParticipante = nombreParticipante;
		this.velocidadCorres = velocidadCorres;
		this.velocidadBici = velocidadBici;
		this.velocidadNadando = velocidadNadando;
	}
	
	public void bici() {
		System.out.println(nombreParticipante+" comienza la prueba en bici");
		
		try {
			Thread.sleep(BICI / velocidadBici * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(nombreParticipante+" ha acabado la prueba en bici");
	}
	public void marathon() {
		System.out.println(nombreParticipante+" comienza la prueba en marathon");
		
		try {
			Thread.sleep(MARATHON / velocidadCorres * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(nombreParticipante+" ha acabado la prueba en marathon");
	}
	public void nadar() {
		System.out.println(nombreParticipante+" comienza la prueba en nadar");
		
		try {
			Thread.sleep(NADAR / velocidadNadando * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(nombreParticipante+" ha acabado la prueba en nadar");
	}
	
	@Override
	public void run() {
		bici();
		marathon();
		nadar();
		
		System.out.println("El concursante "+nombreParticipante+" ha TERMINADO");
	}
	
	public static void main(String[] args) {
		IronMan pedro = new IronMan("Pedro", 6, 20, 1);
		IronMan juan = new IronMan("Juan", 7, 18, 2);
		IronMan vicente = new IronMan("Vicente",6,30,1);
		
		new Thread(pedro).start();
		new Thread(juan).start();
		new Thread(vicente).start();
	}
	
}
