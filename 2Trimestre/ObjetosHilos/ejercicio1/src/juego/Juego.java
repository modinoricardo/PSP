package juego;

import java.io.Serializable;

public class Juego implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5670356584956071216L;
	private boolean esPar;
	private int numJugado;
	
	public Juego(boolean esPar, int numJugado) {
		super();
		this.esPar = esPar;	
		this.numJugado = numJugado;
	}

	public boolean isEsPar() {
		return esPar;
	}

	public void setEsPar(boolean esPar) {
		this.esPar = esPar;
	}

	public int getNumJugado() {
		return numJugado;
	}

	public void setNumJugado(int numJugado) {
		this.numJugado = numJugado;
	}

}
