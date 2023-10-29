/**En la clase main se encarga de ejecutar el juego ejecutando todas las clases
 y la interfaz grafica para que se muestre el juego**/
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        Tablero tablero = new Tablero();
        Jugador jugador1 = new Jugador("Jugador 1", "X");
        Jugador jugador2 = new Jugador("Máquina", "O");

        TicTacToe juego = new TicTacToe(tablero, jugador1, jugador2);

       
        SwingUtilities.invokeLater(() -> {
            GameUI gameUI = new GameUI(juego);
        });
    }
}