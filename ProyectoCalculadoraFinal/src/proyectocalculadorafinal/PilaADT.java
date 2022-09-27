package proyectocalculadorafinal;

/**
 * 
 * Clase PilaADT como se vio en clase 
 * @param <T> 
 */
public interface PilaADT <T> {
    
    public void push(T dato);
    public T pop();
    public boolean isEmpty();
    public T peek();
    
}
