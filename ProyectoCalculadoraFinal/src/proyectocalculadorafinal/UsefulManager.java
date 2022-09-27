package proyectocalculadorafinal;


import java.util.ArrayList;

/*
Creado por: Valeria Maqueda, Regina Rodriguez Emiliano Sandoval, Abraham Martinez, Lars Johansson
Fecha: Septiembre del 2022
Proposito: tener clases estaticas necesarias para calculadora

 */
public class UsefulManager {
    
        /**
         * 
         * @param <T>
         * @param pila 
         * Recibe una pila
         * MÃ©todo que invierte la pila
         */
        private static <T> void inviertePila(PilaADT<T> pila){
            ArrayList<T> c = new ArrayList();

            while(!pila.isEmpty()){
                c.add(pila.pop());
            }
            for(int i = 0; i < c.size(); i++){
                pila.push(c.get(i));
            }
        }
    
        /**
         * 
         * @param pila
         * Recibe una pila
         * @return double
         * Es el resultado de evaluar la expresion en notaciÃ³n postfija
         */
        public static double evaluacionPostfija(PilaADT<String> pila){
            double resultado = 0, num1, num2, res;
            char operador;
            String operator;

            PilaA<Double> aux = new PilaA();
            inviertePila(pila);
            while(!pila.isEmpty()){
                if(esNumero(pila.peek())){
                    aux.push(Double.parseDouble(pila.pop()));
                }
                else
                    if(esOperador(pila.peek())){
                        if(!aux.isEmpty()){
                            num2=aux.pop();
                            num1=aux.pop();
                            operator = pila.pop();
                            operador = operator.charAt(0);
                            switch (operador) {
                                case '+':
                                        res = num1 + num2;
                                        aux.push(res);
                                    break;
                                case '-':
                                        res = num1 - num2;
                                        aux.push(res);
                                    break;
                                case '*':
                                        res = num1 * num2;
                                        aux.push(res);
                                    break;
                                case '/':
                                    if(num2!=0){
                                        res = num1 / num2;
                                        aux.push(res);
                                    }
                                    break;
                                case '^':
                                        res = Math.pow(num1, num2);
                                        aux.push(res);
                                    break;
                                default:
                                    aux.push(Double.parseDouble(operator));
                                    break;
                        }
                    }
                }
            }
            if(!aux.isEmpty())
                resultado = aux.pop();
            return resultado;
        }

        /**
         * 
         * @param c
         * Recibe un String proveniente de un elemento de la pila
         * @return boolean
         * Intenta convertir el elemento de la pila a numero, regresa true si es un nÃºmero y false si no es
         */
        private static boolean esNumero(String c){
            try{
                double numero = (Double.parseDouble(c));
                return true;
            }
            catch(NumberFormatException e){
                return false;
            }
        }

        
        /**
         * 
         * @param c
         * Recibe un String proveniente de un elemento de la pila
         * @return boolean
         * Checa si es un operador, + - * / ^ y regresa true si es operador, false si no es
         */
        private static boolean esOperador(String c){
            char operador = c.charAt(0);
            return switch (operador) {
                case '+', '-', '*', '/', '^' -> true;
                default -> false;
            };
        }

    /**
     * 
     * @param expresion
     * Recibe una cadena, expresion, que se recibe de lo que captura el usuario en la calculadora y oprimiendo '='
     * @return PilaADT<String>
     * Regresa una pila con la expresiÃ³n convertida a notaciÃ³n postfija
     */
    public static PilaA<String> infijaPostFija(String expresion){
        PilaA<Character> pila= new PilaA();
        PilaA<String> postfija = new PilaA();
        String cad;
        Character caracter;
        
        for(int i=0; i < expresion.length();i++){
            caracter = expresion.charAt(i);
            //Primero checa si es un nÃºmero o un operador
            if(Character.isDigit(caracter)) { //Es un nÃºmero, lo agrega directo a la pila
                cad = genCad(expresion, i);
                postfija.push(cad);  
                i = i + cad.length()-1;
            }
            else {//Si no es un numero entonces son operadores, checa la jerarquÃ­a () ^ * / + - 
                //si es (
                if(caracter == '(') {
                    pila.push('(');
                }
                else { //si es )
                    if(caracter == ')') {
                        while(!pila.isEmpty() && pila.peek()!='(') {
                            postfija.push(pila.pop()+"");
                        }
                        if(pila.peek()=='(')
                            pila.pop();
                    }
                    else{ //si es potencia
                        if(caracter == '^'){
                            if(!pila.isEmpty())
                                while(!pila.isEmpty() && pila.peek()!='(' && pila.peek()!= '/' && pila.peek()!= '*' && pila.peek()!='+' && pila.peek()!='-')
                                        postfija.push(pila.pop()+"");
                            pila.push(caracter);
                        }
                        else { //si es multiplicaciÃ³n o divisiÃ³n
                            if(caracter == '/' || caracter == '*') {
                                if(!pila.isEmpty()) 
                                    while(!pila.isEmpty() && pila.peek()!='(' && pila.peek()!='+' && pila.peek()!='-')
                                        postfija.push(pila.pop()+"");
                                pila.push(caracter);
                            }
                            else { //si es suma o resta
                                if(caracter == '+' || caracter == '-') {
                                    if(!pila.isEmpty()) 
                                        while(!pila.isEmpty() && pila.peek()!='(')
                                            postfija.push(pila.pop()+"");
                                    pila.push(caracter);
                                }
                            }
                        }
                    }

                }
            }
            
        }
        while(!pila.isEmpty()) { //Por si quedaron elementos en la pila
            if(pila.peek()=='(')
                pila.pop();
            else 
                postfija.push(pila.pop()+""); 
        }
        return postfija;
    }
    
    /**
     * 
     * @param expresion
     * Recibe la cadena que capturÃ³ el usuario
     * @param i
     * El numero de caracter en el que se encuentra el anÃ¡lisis de la expresion
     * @return String
     * Regresa una cadena que puede ser nÃºmero u operador
     */
    private static String genCad(String expresion, int i){
        String cadena = expresion.charAt(i)+"";
        
        while(i < expresion.length()-1 && (expresion.charAt(i+1)=='.' || Character.isDigit(expresion.charAt(i+1))) ) {
                    cadena = cadena + expresion.charAt(i+1);
                    i++;
                }
        return cadena;
    }
            

    public static void main(String[] args) {
        
        String expresion = "(2+2)^2+5-(10*3)/3";
        String expresion2 = "(6-6)*(7-7)";
        PilaA<String> pila = infijaPostFija(expresion);
        PilaA<String> pila2 = infijaPostFija(expresion2);
        System.out.println("Postfija Expresion 1: \n" + pila.toString());
        System.out.println("Postfija Expresion 2: \n" + pila2.toString());
        double res = evaluacionPostfija(pila);
        System.out.println("EL resultado es " + res);
        double resultado = evaluacionPostfija(pila2);
        System.out.println("EL resultado es " + resultado);



    }
  
    
}