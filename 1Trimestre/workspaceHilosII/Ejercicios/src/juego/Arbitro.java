package juego;

public class Arbitro extends Thread {
    private int numeroJugadores;
    private int turno;
    private int numeroAdivinar;
    private boolean juegoAcabado;

    public Arbitro(int numeroJugadores) {
        this.numeroJugadores = numeroJugadores;
        this.turno = 1; // Empieza con el jugador 1
        this.numeroAdivinar = (int) (Math.random() * 10) + 1; // Número aleatorio entre 1 y 10
        this.juegoAcabado = false;
    }

    public int getNumeroAdivinar() {
        return numeroAdivinar;
    }

    public synchronized int getTurno() {
        return turno;
    }

    public synchronized void siguienteTurno() {
        turno = (turno % numeroJugadores) + 1; // Cambia al siguiente jugador
    }

    public synchronized boolean numeroCorrecto(int numeroJugada) {
        if (numeroJugada == numeroAdivinar) {
            juegoAcabado = true;
            return true;
        }
        return false;
    }

    public synchronized boolean isJuegoAcabado() {
        return juegoAcabado;
    }

    @Override
    public void run() {
        while (!juegoAcabado) {
            // El árbitro solo supervisa, no hace nada más
            // El juego acaba cuando un jugador adivina el número
            try {
                Thread.sleep(100); // Evita sobrecargar el CPU
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
