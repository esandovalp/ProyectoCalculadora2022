/**
 * <pre>
 * Clase ExcepcionColeccionVacia
 * 
 * Contiene la excepcion
 * </pre>
 */

public class ExcepcionColeccionVacia extends RuntimeException {

    public ExcepcionColeccionVacia() {
        super();
    }
    
    /**
     * 
     * @param mensaje: mensaje que aparecerá al lanzar la excepcion
     */
    public ExcepcionColeccionVacia(String mensaje) {
        super(mensaje);
    }
    
}
