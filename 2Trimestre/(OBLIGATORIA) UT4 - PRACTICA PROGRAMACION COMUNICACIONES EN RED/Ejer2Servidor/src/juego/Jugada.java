package juego;

import java.io.Serializable;

public class Jugada implements Serializable{
	private static final long serialVersionUID = 1L;
	//1Piedra 2papel 3Tijera
	private int PiedraPapelTijera;

	public Jugada(int piedraPapelTijera) {
		super();
		PiedraPapelTijera = piedraPapelTijera;
	}

	public int getPiedraPapelTijera() {
		return PiedraPapelTijera;
	}

	public void setPiedraPapelTijera(int piedraPapelTijera) {
		PiedraPapelTijera = piedraPapelTijera;
	}
	
}
