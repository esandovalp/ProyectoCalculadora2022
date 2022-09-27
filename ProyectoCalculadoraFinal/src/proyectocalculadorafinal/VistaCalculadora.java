package proyectocalculadorafinal;

/*
Creado por: Valeria Maqueda, Regina Rodriguez Emiliano Sandoval, Abraham Martinez, Lars Johansson
Fecha: Septiembre del 2022
Proposito: Crear calculadora para estructuras
 */
import java.awt.Color;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.GridLayout;

public class VistaCalculadora extends JFrame {
	
	protected JLabel jLabelOperacion;
	protected JButton cero,uno,dos,tres,cuatro,cinco,seis,siete,ocho,nueve,mult,div,res,
                          mas,menos,exp,punto,reiniciar,borrar,pareAbre, pareCierra;
        protected String operation;
        protected Integer cantChars;
        protected RevisorParentesis revisorParentesis;
        protected PilaADT <String> aux;
	
	public VistaCalculadora(String nombre) {
		super(nombre);
                
                //panel principal de la calculadora
                JPanel principal = new JPanel();
                principal.setLayout(new GridLayout(2,1));
                Border gap = BorderFactory.createEmptyBorder(2,2,2,2);
                principal.setBorder(gap);
                
		
                operation = " ";
		cantChars = 0;
                revisorParentesis = new RevisorParentesis(operation);
		cero = new JButton("0");
                cero.setBackground(new Color(897474));
		uno = new JButton("1");
                uno.setBackground(new Color(897474));
		dos = new JButton("2");
                dos.setBackground(new Color(897474));
		tres = new JButton("3");
                tres.setBackground(new Color(897474));
		cuatro = new JButton("4");
                cuatro.setBackground(new Color(897474));
		cinco = new JButton("5");
                cinco.setBackground(new Color(897474));
		seis = new JButton("6");
                seis.setBackground(new Color(897474));
		siete = new JButton("7");
                siete.setBackground(new Color(897474));
		ocho = new JButton("8");
                ocho.setBackground(new Color(897474));
		nueve = new JButton("9");
                nueve.setBackground(new Color(897474));
		mult = new JButton("*");
                mult.setBackground(new Color(2227474));
		div = new JButton("/");
                div.setBackground(new Color(2227474));
		mas = new JButton("+");
                mas.setBackground(new Color(2227474));
		menos = new JButton("-");
                menos.setBackground(new Color(2227474));
                exp = new JButton("^");
                exp.setBackground(new Color(2227474));
                punto = new JButton(".");
                punto.setBackground(new Color(2227474));
                pareAbre = new JButton("(");
                pareAbre.setBackground(new Color(2227474));
                pareCierra = new JButton(")");
                pareCierra.setBackground(new Color(2227474));
                res = new JButton("=");
                res.setBackground(new Color(8945));
                reiniciar = new JButton("R");
                reiniciar.setBackground(new Color(27474));
                borrar = new JButton("B");
                borrar.setBackground(new Color(27474));
		jLabelOperacion = new JLabel(operation);
		
		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(5,6));
		buttons.setBorder(gap);
                buttons.setBounds(100,100,200,200);
		buttons.add(cero);
		buttons.add(uno);
		buttons.add(dos);
		buttons.add(tres);
		buttons.add(cuatro);
		buttons.add(cinco);
		buttons.add(seis);
		buttons.add(siete);
		buttons.add(ocho);
		buttons.add(nueve);
		buttons.add(mas);
		buttons.add(menos);
		buttons.add(mult);
		buttons.add(div);
                buttons.add(div);
                buttons.add(exp);
                buttons.add(punto);
                buttons.add(pareAbre);
                buttons.add(pareCierra);
                buttons.add(borrar);
                buttons.add(reiniciar);
                buttons.add(res);
		
                principal.add(jLabelOperacion);
		principal.add(buttons);
                this.add(principal);
		this.setVisible(true);
		this.setBounds(200,200,400,400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);       
	}
}
