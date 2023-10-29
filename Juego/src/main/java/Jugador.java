/**En la clase jugador se guardan los simbolos que este puede utilizar y 
 tambien en nombre de este mismo ya sea el jugador 1 el usuario o el jugador 2
 la maquina**/

public class Jugador {
    private final String simbolo; 
    private final String nombre;

    public Jugador(String nombre, String simbolo) {
        this.nombre = nombre;
        this.simbolo = simbolo;
    }

    public void realizarMovimiento(Tablero tablero, int fila, int columna) {
    Casilla.Enumeracion simboloEnum = (this.simbolo.equals("X")) ?
            Casilla.Enumeracion.X : Casilla.Enumeracion.O;
    
    if (tablero.comprobarCasillaVacia(fila, columna)) {
        tablero.marcarCasilla(fila, columna, simboloEnum);
    } else {
        System.out.println("La casilla seleccionada no está vacía. "
                + "Elija otra casilla.");
    }
}

    public String getNombre() {
        return nombre;
    }

    public String getSimbolo() {
        return simbolo;
    }
}
