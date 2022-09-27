package proyectocalculadorafinal;

/*
Creado por: Valeria Maqueda, Regina Rodriguez Emiliano Sandoval, Abraham Martinez, Lars Johansson
Fecha: Septiembre del 2022
Proposito: tener clases estaticas necesarias para calculadora
 */
public class RevisorParentesis {
    
    private String toAnalize;
    
    public RevisorParentesis(String toAnalize){
        this.toAnalize = toAnalize;
        
    }
    
    public void actualizaPalabra(String newWord){
        this.toAnalize = newWord;
    }
    
    /**
     * 
     * @return <ul>
     *      <li> true: si los parentesis estan balanceados 
     *      <li> false: si los parentesis no estan balanceados 
     *      </ul>
     */
    public boolean balanceados(){
        boolean exito = false;
        PilaADT <Character> aux = new PilaA();
        Character temp;
        int i = 0;
        
        while(i<toAnalize.length()){
            temp = toAnalize.charAt(i);
            
            if(temp == '(')
                aux.push(temp);
            else
                if(temp == ')')
                    i = checaMiBalanceGen(i,aux,temp);
            i++; 
        }
        
        if(i == toAnalize.length() && aux.isEmpty())
            exito = true; 
        return exito;
    }
    
    
    /**
     * Revisa si estan balanceados '(', ')', '{', '}', '[', ']'  
     * @param i: indicador
     * @param aux: pila auxiliar
     * @param compare: 
     * @return 
     */
    private int checaMiBalanceGen(int i, PilaADT aux, Character compare){
        
        if(!aux.isEmpty())
            switch(compare){
                case ')':
                    
                    if(aux.peek().equals('('))
                        aux.pop();
                    else
                        i = toAnalize.length()+1;
                    break;
                case ']':
                    if(aux.peek().equals(']'))
                        aux.pop();
                    else
                        i = toAnalize.length()+1;
                    break;
                case '}':
                    if(aux.peek().equals('}'))
                        aux.pop();
                    else
                        i = toAnalize.length()+1;
                    break;    
            }
        else
            // puede ser que el problema este en este else
            i = toAnalize.length() +1;
     return i;   
    }
    
}
