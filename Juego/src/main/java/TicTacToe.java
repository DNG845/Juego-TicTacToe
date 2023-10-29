/**En TicTacToe se encuentra la logica de la maquina y todas las funciones para
 que el usuario pueda interactuar tanto con el tablero y para que la maquina
 tambien pueda.**/

import java.util.ArrayList;
import java.util.Scanner;

public class TicTacToe {
    private final Tablero tablero;
    private final Jugador jugador1;
    private final Jugador jugador2;
    private boolean turnoJugador1; 

    public TicTacToe(Tablero tablero, Jugador jugador1, Jugador jugador2) {
        this.tablero = tablero;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.turnoJugador1 = true; 
    }
    /**Aqui se muestra el tablero y las opciones que tiene el usuario con este**/

    private void mostrarTablero() {
        System.out.println("Tablero actual:");
        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 3; columna++) {
                Casilla casilla = tablero.obtenerCasilla(fila, columna);
                if (null == casilla.obtenerContenido()) {
                    System.out.print("   "); 
                } else {
                    switch (casilla.obtenerContenido()) {
                        case X -> System.out.print(" X ");
                        case O -> System.out.print(" O ");
                        default -> System.out.print("   "); 
                    }
                }
                if (columna < 2) {
                    System.out.print("|"); 
                }
            }
            System.out.println(); 
            if (fila < 2) {
                System.out.println("-----------"); 
            }
        }
        System.out.println(); 
    }
    /**Aqui se inicia el juego y se le da el turno al usuario y a la maquina
     y se guardan los movimientos que realizan cada uno. Y en iniciar juego se
     encuentra la logica de la maquina la logica de la maquina se basa en
     encontrar una casilla de forma aleatoria despues del movimiento del
     usuario**/

    public void iniciarJuego() {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean esTurnoJugador1 = (Math.random() < 0.5); 

            while (tablero.hayCasillasVacias() && comprobarGanador() == null) {
                mostrarTablero();

                if (esTurnoJugador1) {
                    
                    System.out.println("Turno de " + jugador1.getNombre() + " "
                            + "(X)");
                    System.out.print("Ingrese la fila y"
                            + " la columna (ejemplo: 1 2): ");
                    int fila = scanner.nextInt() - 1;
                    int columna = scanner.nextInt() - 1;

                    if (realizarMovimiento(fila, columna)) {
                        esTurnoJugador1 = false; 
                    } else {
                        System.out.println("La casilla seleccionada no"
                                + " está vacía. Elija otra casilla.");
                    }
                } else {
                  
                    System.out.println("Turno de " + jugador2.getNombre() + " "
                            + "(O)");

                    int[] movimientoMaquina = seleccionarMovimientoMaquina();
                    int filaMaquina = movimientoMaquina[0];
                    int columnaMaquina = movimientoMaquina[1];

                    if (realizarMovimiento
        (filaMaquina, columnaMaquina)) {
                        esTurnoJugador1 = true;
                    }
                }
            }
        }
    }

    private int[] seleccionarMovimientoMaquina() {
        ArrayList<int[]> movimientosDisponibles = new ArrayList<>();
        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 3; columna++) {
                if (tablero.comprobarCasillaVacia(fila, columna)) {
                    movimientosDisponibles.add(new int[]{fila, columna});
                }
            }
        }

        if (!movimientosDisponibles.isEmpty()) {
            int indiceMovimiento = (int) (Math.random() * 
                    movimientosDisponibles.size());
            return movimientosDisponibles.get(indiceMovimiento);
        }

        return new int[]{-1, -1};
    }

    public boolean realizarMovimiento(int fila, int columna) {
        
        Jugador jugadorActual = (turnoJugador1) ? jugador1 : jugador2;
        if (tablero.comprobarCasillaVacia(fila, columna)) {
            Casilla.Enumeracion simboloEnum = (jugadorActual.getSimbolo()
                    .equals("X")) ? Casilla.Enumeracion.X : 
                    Casilla.Enumeracion.O;
            tablero.marcarCasilla(fila, columna, simboloEnum);
            turnoJugador1 = !turnoJugador1; 
            return true; 
        }
        return false; 
    }
    /**Aqui se realiza la comprobacion de las casillas para comprobar si hay 
     un ganador sea el jugador 1 el usuario o el jugador2 la maquina**/
    


    public Jugador comprobarGanador() {

        for (int fila = 0; fila < 3; fila++) {
        if (tablero.obtenerCasilla(fila, 0).obtenerContenido()
                == Enumeracion.X &&
            tablero.obtenerCasilla(fila, 1).obtenerContenido()
                == Enumeracion.X &&
            tablero.obtenerCasilla(fila, 2).obtenerContenido()
                == Enumeracion.X) {
            return jugador1; 
        }
        if (tablero.obtenerCasilla(fila, 0).obtenerContenido()
                == Enumeracion.O &&
            tablero.obtenerCasilla(fila, 1).obtenerContenido()
                == Enumeracion.O &&
            tablero.obtenerCasilla(fila, 2).obtenerContenido()
                == Enumeracion.O) {
            return jugador2; 
        }
    }

   
    for (int columna = 0; columna < 3; columna++) {
        if (tablero.obtenerCasilla(0, columna).obtenerContenido()
                == Enumeracion.X &&
            tablero.obtenerCasilla(1, columna).obtenerContenido()
                == Enumeracion.X &&
            tablero.obtenerCasilla(2, columna).obtenerContenido()
                == Enumeracion.X) {
            return jugador1; 
        }
        if (tablero.obtenerCasilla(0, columna).obtenerContenido()
                == Enumeracion.O &&
            tablero.obtenerCasilla(1, columna).obtenerContenido()
                == Enumeracion.O &&
            tablero.obtenerCasilla(2, columna).obtenerContenido()
                == Enumeracion.O) {
            return jugador2; 
        }
    }

    
    if (tablero.obtenerCasilla(0, 0).obtenerContenido()
            == Enumeracion.X &&
        tablero.obtenerCasilla(1, 1).obtenerContenido()
            == Enumeracion.X &&
        tablero.obtenerCasilla(2, 2).obtenerContenido()
            == Enumeracion.X) {
        return jugador1; 
    }
    if (tablero.obtenerCasilla(0, 2).obtenerContenido()
            == Enumeracion.X &&
        tablero.obtenerCasilla(1, 1).obtenerContenido()
            == Enumeracion.X &&
        tablero.obtenerCasilla(2, 0).obtenerContenido()
            == Enumeracion.X) {
        return jugador1; 
    }
    
    
    if (tableroEstaLleno()) {
        return null; 
    }

    
    return null;
}

  

    private boolean tableroEstaLleno() {
       
        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 3; columna++) {
                if (tablero.comprobarCasillaVacia(fila, columna)) {
                    return false; 
                }
            }
        }
        return true; 
    }
    /**La opcion del tablero esta lleno se utiliza para comprobar empate si
     el tablero esta lleno entonces es un empate ya que no hay posibilidad de 
     que ninguno de los 2 gane**/

    boolean comprobarEmpate() {
        for (int fila = 0; fila < 3; fila++) {
        for (int columna = 0; columna < 3; columna++) {
            if (tablero.comprobarCasillaVacia(fila, columna)) {
                return false; 
            }
        }
    }
    return true; 
}

    public String getCurrentPlayerSymbol() {
        return turnoJugador1 ? jugador1.getSimbolo() : jugador2.getSimbolo();
    }

    public void reset() {
        
        tablero.reset(); 
        turnoJugador1 = true;  
        
    }
    private static class Enumeracion {

        private static Casilla.Enumeracion X;
        private static Casilla.Enumeracion O;

        public Enumeracion() {
        }
    }

}