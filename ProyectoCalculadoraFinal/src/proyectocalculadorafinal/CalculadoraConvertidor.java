package proyectocalculadorafinal;

/*
 * Creado por: Lars Daniel Johansson Nino
 * Fecha: 5/20/22
 * Proposito: Crear calculadora
 */
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.GridLayout;
/*



*/
public class CalculadoraConvertidor extends JFrame {
	
	protected JTextField input;
	protected JButton cero,uno,dos,tres,cuatro,cinco,seis,siete,ocho,nueve,mult,div,res, mas,menos,exp,punto;
        protected String operation;
        protected Integer cantChars;
        protected PilaADT <String>aux;
        //private RevisorParentesis parentesis;
        //private InfijaPostfija infijaPostFija;
        
        
	
	public CalculadoraConvertidor(String nombre) {
		super(nombre);
		
		cantChars = 0;
                operation = " ";
		cero = new JButton("0");
		uno = new JButton("1");
		dos = new JButton("2");
		tres = new JButton("3");
		cuatro = new JButton("4");
		cinco = new JButton("5");
		seis = new JButton("6");
		siete = new JButton("7");
		ocho = new JButton("8");
		nueve = new JButton("9");
		mult = new JButton("*");
		div = new JButton("/");
		mas = new JButton("+");
		menos = new JButton("-");
                exp = new JButton("^");
		res = new JButton("=");
		input = new JTextField();
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4,4));
		Border gap = BorderFactory.createEmptyBorder(2,2,2,2);
		panel.setBorder(gap);
		
		panel.add(cero);
		panel.add(uno);
		panel.add(dos);
		panel.add(input);
		panel.add(tres);
		panel.add(cuatro);
		panel.add(cinco);
		panel.add(seis);
		panel.add(siete);
		panel.add(ocho);
		panel.add(nueve);
		panel.add(mas);
		panel.add(menos);
		panel.add(mult);
		panel.add(div);
                panel.add(exp);
                panel.add(punto);
		panel.add(res);
                
                
		
		
		this.add(panel);
		this.setVisible(true);
		this.setBounds(200,200,400,400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);	
	}
	
	

}
