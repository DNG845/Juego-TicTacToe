/**En la clase Tablero se encuentra la distribucion de las casillas y el
 contenido que contiene cada una de estas asi tambien en esta se comprueba
 si la casilla se encuentra vacia o si esta se encuentra llena para que el 
 usuario o la maquina puedan interactuar con esta o no**/

public class Tablero {
    private final Casilla[][] casillas;
    
    public Tablero() {
        casillas = new Casilla[3][3];
        // Inicializa cada casilla en el tablero
        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 3; columna++) {
                casillas[fila][columna] = new Casilla();
            }
        }
    }

    public Casilla obtenerCasilla(int fila, int columna) {
        return casillas[fila][columna];
    }

    public boolean comprobarCasillaVacia(int fila, int columna) {
    return casillas[fila][columna].obtenerContenido() == null;
    }

    public void marcarCasilla(int fila, int columna,
            Casilla.Enumeracion contenido) {
        casillas[fila][columna].marcarContenido(contenido);
    }
    
    public void reset() {
   
    for (int fila = 0; fila < 3; fila++) {
        for (int columna = 0; columna < 3; columna++) {
            casillas[fila][columna] = new Casilla();
        }
    }
}

    public boolean hayCasillasVacias() {
    for (int fila = 0; fila < 3; fila++) {
        for (int columna = 0; columna < 3; columna++) {
            if (comprobarCasillaVacia(fila, columna)) {
                return true; 
                
            }
        }
    }
    return false; 
    
}

}
