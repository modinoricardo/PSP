package juego;

public class Jugador extends Thread {
    private Arbitro arbitro;
    private int idJugador;

    public Jugador(int idJugador, Arbitro arbitro) {
        this.idJugador = idJugador;
        this.arbitro = arbitro;
    }

    @Override
    public void run() {
        while (!arbitro.isJuegoAcabado()) {
            synchronized (arbitro) {
                // Solo juega si es su turno
                if (arbitro.getTurno() == idJugador && !arbitro.isJuegoAcabado()) {
                    int numeroJugado = (int) (Math.random() * 10) + 1;
                    System.out.println("Jugador " + idJugador + " dice: " + numeroJugado);
                    try {
						sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

                    if (arbitro.numeroCorrecto(numeroJugado)) {
                        System.out.println("Jugador " + idJugador + " ha adivinado el número y gana!");
                        arbitro.notifyAll(); // Notificamos a todos para que se detengan
                        return;
                    } else {
                        System.out.println("Jugador " + idJugador + " falla. Siguiente turno.");
                        arbitro.siguienteTurno();
                        arbitro.notifyAll(); // Notificar al siguiente jugador
                    }

                    try {
                        arbitro.wait(); // Esperar hasta el próximo turno
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        arbitro.wait(); // Espera si no es su turno
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
