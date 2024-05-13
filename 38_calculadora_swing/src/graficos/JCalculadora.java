package graficos;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JCalculadora extends JFrame {
	
	public JCalculadora() {
		super.setTitle("Ventana Controles2");
		this.setBounds(100,100, 800, 800);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		initComponents();
		this.setVisible(true);
	}
	private void initComponents() {
		 this.setLayout(null);		// Desactivar el gestor de organización
		 JLabel jLabel1 = new  JLabel("Numero 1");
		 JLabel jLabel2 = new JLabel("Numero 2");
		 JLabel jLabel3 = new JLabel("Resultado");
		 
		 jLabel1.setBounds(50,50,100,30);
		 jLabel2.setBounds(50,100,100,30);
		 jLabel3.setBounds(300,100,100,30);
		 	 
		 
		 JTextField jText1 = new JTextField();
		 JTextField jText2 = new JTextField();

		 jText1.setBounds(150,50,100,30);
		 jText2.setBounds(150,100,100,30);

		 JButton jBtSumar = new JButton("Sumar");
		 JButton jBtMultiplicar = new JButton("Multiplicar");
		 jBtSumar.setBounds(150,200,100,50);
		 jBtMultiplicar.setBounds(250,200,100,50);
		 	
		 this.add(jLabel1); 
		 this.add(jLabel2);
		 this.add(jLabel3);
		 
		 this.add( jText1); this.add( jText2); 
		 this.add(jBtSumar); this.add(jBtMultiplicar);
		 
		 ActionListener listenerJText1 = e->jText1.getText();
		 jText1.addActionListener(listenerJText1);
			
		 ActionListener listenerJText2 = e->jText2.getText();
		 jText2.addActionListener(listenerJText2);
		
		 ActionListener listenerJBtSumar = e->jText2.getText();
		 jBtSumar.addActionListener(listenerJBtSumar);
		
		 ActionListener listenerJBtMultiplicar = e-> jBtMultiplicar.getText();
		 jBtMultiplicar.addActionListener(listenerJBtMultiplicar);
		
		
	
		

	}
}
