package juego;

import java.io.Serializable;

public class Juego implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private boolean esPar;
	private int num;
	
	public Juego(boolean esPar, int num) {
		super();
		this.esPar = esPar;
		this.num = num;
	}
	
	public Juego(int num) {
		super();
		this.num = num;
	}

	public boolean isEsPar() {
		return esPar;
	}

	public void setEsPar(boolean esPar) {
		this.esPar = esPar;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	
	
}
