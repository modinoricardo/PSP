package cliente;

import java.io.Serializable;

public class Juego implements Serializable{
	private static final long serialVersionUID = 1L;	
	
	private boolean esPar;
	private int puntosCliente = 0;
	private int puntosServidor = 0;
	
	public Juego(boolean esPar) {
		super();
		this.esPar = esPar;	
	}
	
	public void jugar(int miNum, int suNum) {
		int resultado = miNum + suNum;
		
		System.out.println("El juega: "+suNum);
		String mensaje = mensaje(resultado);
		
		System.out.println(mensaje);
		
	}
	
	private String mensaje(int resultado){
		if(esPar) {
			if(resultado%2==0) {
				puntosCliente++;
				return "He ganado. Vamos Cliente: "+puntosCliente+" Servidor: "+puntosServidor;
			}else {
				puntosServidor++;
				return "He perdido. Vamos Cliente: "+puntosCliente+" Servidor: "+puntosServidor;
			}
		}else {
			if(resultado%2!=0) {
				puntosCliente++;
				return "He ganado. Vamos Cliente: "+puntosCliente+" Servidor: "+puntosServidor;
			}else {
				puntosServidor++;
				return "He perdido. Vamos Cliente: "+puntosCliente+" Servidor: "+puntosServidor;
			}
		}
			
	}
	
}
