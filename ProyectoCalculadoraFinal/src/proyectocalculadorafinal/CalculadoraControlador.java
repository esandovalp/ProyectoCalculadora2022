package proyectocalculadorafinal;

/*
Creado por: Valeria Maqueda, Regina Rodriguez Emiliano Sandoval, Abraham Martinez, Lars Johansson
Fecha: Septiembre del 2022
Proposito: tener clases estaticas necesarias para calculadora
 */
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class CalculadoraControlador extends VistaCalculadora {
	
	public CalculadoraControlador(String nombre) {
		super(nombre);
		
		cero.addActionListener(new ClaseEscuchadorNum());
		uno.addActionListener(new ClaseEscuchadorNum());
		dos.addActionListener(new ClaseEscuchadorNum());
		tres.addActionListener(new ClaseEscuchadorNum());
		cuatro.addActionListener(new ClaseEscuchadorNum());
		cinco.addActionListener(new ClaseEscuchadorNum());
		seis.addActionListener(new ClaseEscuchadorNum());
		siete.addActionListener(new ClaseEscuchadorNum());
		ocho.addActionListener(new ClaseEscuchadorNum());
		nueve.addActionListener(new ClaseEscuchadorNum());
                //empiezan operandos y otros botones
		mult.addActionListener(new ClaseEscuchadorOperador());
		div.addActionListener(new ClaseEscuchadorOperador());
                mas.addActionListener(new ClaseEscuchadorOperador());
		menos.addActionListener(new ClaseEscuchadorOperador());	
                exp.addActionListener(new ClaseEscuchadorOperador());
                punto.addActionListener(new ClaseEscuchadorOperador());
                
                
                
                //parentesis
                pareAbre.addActionListener(new ClaseEscuchadorOtros());
                pareCierra.addActionListener(new ClaseEscuchadorOtros());
                
                
                //en estos tengo que checar el action Listener
                reiniciar.addActionListener(new ClaseEscuchadorOtros());
                borrar.addActionListener(new ClaseEscuchadorOtros());
                
		res.addActionListener(new ClaseEscuchadorOtros());
		
	}
        
        /*
        Realiza las operaciones de los numeros
        
        */	
	private class ClaseEscuchadorNum implements ActionListener{

		public void actionPerformed(ActionEvent ae) {    
                        updateOperation(ae.getActionCommand());
		}
		
	}
	
	private class ClaseEscuchadorOperador implements ActionListener{
		public void actionPerformed(ActionEvent ae) {
                    boolean notPermit =isOperando(operation.charAt(cantChars));
                    
                    if(!notPermit)
                        updateOperation(ae.getActionCommand());
                    else
                        errorReStart("Error con operando! Intenta de nuevo :(");	
		}
	
	}
	
	private class ClaseEscuchadorOtros implements ActionListener{
		
		public void actionPerformed(ActionEvent ae) {	
                    Character inQuestion = ae.getActionCommand().charAt(0);
                    
                    switch(inQuestion){
                        case '(':
                            parentesisManager(inQuestion);
                            break;
                        case ')':
                            parentesisManager(inQuestion);
                            break;  
                            
                            
                            
                        case '=':
                            if(revisorParentesis.balanceados() && cantChars != 0){
                            
                                aux = UsefulManager.infijaPostFija(operation);
                                operation = Double.toString(UsefulManager.evaluacionPostfija(aux));
                                cantChars = operation.length();
                                jLabelOperacion.setText(operation);
                                //se recicla este metodo
                                errorReStart("Gracias por calcular :)");
                            }
                            else
                                errorReStart("Error! problemas con parentesis o no hay ningun caracter");
                            break; 
                            //este reinicia la operacion
                        case 'R':
                            operation = " ";
                            cantChars = 0;
                            jLabelOperacion.setText(operation);
                            break;
                        //este es de borrar  
                        case 'B':
                            if(cantChars != 0){
                                operation = operation.substring(0, cantChars);
                                jLabelOperacion.setText(operation); 
                                cantChars--;  
                            }
                            break;   
                    }








		}

	}
        
        
        
        
        //terminan los actionListener
        private void updateOperation(String toAdd){
            operation = operation+toAdd+"";
            jLabelOperacion.setText(operation);
            cantChars++;
    }
        /*
        Reinicia todo en caso de un error
        
        */
        private void errorReStart(String messageReStart){
            JFrame popUp = new JFrame();

            JOptionPane.showMessageDialog(popUp, messageReStart);
            operation = " ";
            cantChars = 0;
            jLabelOperacion.setText(operation);
    }
        
        
        
    //se asegura que sea valido el input del nuevo operando

    
    //checa cada potencial problema para el uso de parentesis
    private void parentesisManager(Character toCheck){
        
        switch(toCheck){
            case ')':
                if(!isOperando(operation.charAt(cantChars)) && operation.charAt(cantChars) != '(')
                    updateOperation(toCheck.toString());
                else
                    errorReStart("Error! intenta de nuevo :(");
                break;
            case '(':
                if(isOperando(operation.charAt(cantChars)) && operation.charAt(cantChars) != '.')
                    updateOperation(toCheck.toString());
                else
                    //el mensaje particular queda pendiente
                    errorReStart("Error! intenta de nuevo :(");
                break;    
        }   
    }
        
    //revisa si el caracter en cuestion es un operando
    private boolean isOperando(Character toAnalize){
        boolean isOper = false;
        
        if(toAnalize.equals('+')||toAnalize.equals('-')||toAnalize.equals('*')||toAnalize.equals('/')||toAnalize.equals('^') ||toAnalize.equals('.') ||  cantChars == 0 ||toAnalize.equals('^') ||toAnalize.equals('(') )
            isOper = true; 
        return isOper;  
    }
	public static void main(String[]args) {
		//Main final para calculadora
		CalculadoraControlador pruebaB = new CalculadoraControlador("CALCULADORA");
		
	}
        
    


}
