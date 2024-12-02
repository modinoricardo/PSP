package juego;

import java.io.Serializable;

public class Juego implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private boolean parImpar;
	private int num;
	
	//true = PAR : false = IMPAR
	public Juego(boolean parImpar, int num) {
		super();
		this.parImpar = parImpar;
		this.num = num;
	}
	
	public Juego(int num) {
		super();
		this.num = num;
	}

	public boolean isParImpar() {
		return parImpar;
	}

	public void setParImpar(boolean parImpar) {
		this.parImpar = parImpar;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
}
