package proyectocalculadorafinal;

/**
 * 
 * Clase PilaA como se implemento en clase 
 * @param <T> 
 */
public class PilaA  <T> implements PilaADT<T> {
    private int tope;
    private T[] pila;
    private final int MAX = 20;


    public PilaA() {
        pila = (T[]) new Object[MAX];
        tope = -1;                  // esto nos indica que la pila esta vacia 
    }

    public PilaA(int max) {
        pila = (T[]) new Object[max];
        tope = -1;                  
    }
    
    @Override
    public void push(T dato) {
        if (tope == pila.length - 1)    // Pila llena 
            expande();
        tope++;
        pila[tope] = dato;
    }

    private void expande() {
        T masGrande[] = (T[]) new Object[pila.length * 2];
        
        for(int i = 0; i <= tope; i++)
            masGrande[i] = pila[i];
        pila = masGrande;
        
    }
    
    @Override
    public T pop() {
        
        if(this.isEmpty())
            throw new ExcepcionColeccionVacia("Error: la pila esta vacia");
        T resultado;
        
        resultado = pila[tope];
        pila[tope] = null;
        tope--;
        
        return resultado;
    }

    @Override
    public boolean isEmpty() {
        return tope == -1;
    }

    @Override
    public T peek() {
        
        if(this.isEmpty())
            throw new ExcepcionColeccionVacia("Error: la pila esta vacia");
        
        return pila[tope];
    }

    @Override
    public String toString() {
        StringBuilder sB = new StringBuilder();
        int i;
                
        for (i = 0; i <= tope ; i++){
            sB.append(pila[i]);
        }
                
       
        
        return sB.toString();
    }
    
}
