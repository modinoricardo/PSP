package juego;

public class Principal {
    public static void main(String[] args) {
        Arbitro arbitro = new Arbitro(3);
        arbitro.start();

        // Imprimir el número secreto para depuración
        System.out.println("Número a adivinar (secreto): " + arbitro.getNumeroAdivinar());
        
        Jugador jugador0 = new Jugador(1, arbitro);
        Jugador jugador1 = new Jugador(2, arbitro);
        Jugador jugador2 = new Jugador(3, arbitro);
        
        // Iniciamos los jugadores
        jugador0.start();
        jugador1.start();
        jugador2.start();

        // Esperamos a que termine el árbitro (el juego)
        try {
            arbitro.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("¡El juego ha terminado!");
    }
}
