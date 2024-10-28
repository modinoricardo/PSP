package ejerThread;

public class Par_Impar extends Thread{
	int parOImpar;
	
	public Par_Impar(int num) {
		this.parOImpar = num;
	}

	public static void main(String[] args) {
		//Escribe una clase con un método que en función de un dato saque por consola los impares
		//entre 1 y 10 o los pares entre 1 y 10.
		Par_Impar Par = new Par_Impar(0);
		Par_Impar Impar = new Par_Impar(1);
		
		Par.start();
		Impar.start();
	}
	
	@Override
	public void run() {
		if(parOImpar % 2 == 0) {
			par();
		}else if(parOImpar % 2 != 0) {
			imPar();
		}
	}
	
	public void par() {
		for(int i = 2;i<=10;i+=2) {
			try {
				this.sleep(1);
				System.out.println(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void imPar() {
		for(int i = 1;i<=10;i+=2) {
			try {
				this.sleep(1);
				System.out.println(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
