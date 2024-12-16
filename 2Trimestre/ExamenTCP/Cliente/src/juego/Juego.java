package juego;

import java.io.Serializable;

public class Juego implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int numJugado;
	private boolean esMayor;
	private boolean acierto;
	
	public Juego(boolean esMayor, boolean acierto) {
		this.esMayor = esMayor;
		this.acierto = acierto;
	}
	
	public Juego(int numJugado) {
		this.numJugado = numJugado;
	}

	public boolean isEsMayor() {
		return esMayor;
	}

	public void setEsMayor(boolean esMayor) {
		this.esMayor = esMayor;
	}

	public int getNumJugado() {
		return numJugado;
	}

	public void setNumJugado(int numJugado) {
		this.numJugado = numJugado;
	}

	public boolean isAcierto() {
		return acierto;
	}

	public void setAcierto(boolean acierto) {
		this.acierto = acierto;
	}

}
