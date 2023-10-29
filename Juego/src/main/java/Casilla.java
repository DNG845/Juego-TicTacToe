/**la funcion de la clase Casilla es marcar los espacios correspondientes 
 * de cada lugar con los simbolos que pueden tener los usuarios o la maquina**/

public class Casilla {
    private Enumeracion contenido;

    void marcarContenido(Enumeracion simbolo) {
        contenido = simbolo;
    }
    
    public enum simbolo {
        X, 
        O, 
    }

    public enum Enumeracion {
        X, 
        O, 
        VACIO 
    }

    public Casilla() {
        contenido = Enumeracion.VACIO; 
    }

    public Enumeracion obtenerContenido() {
        return contenido;
    }
}
