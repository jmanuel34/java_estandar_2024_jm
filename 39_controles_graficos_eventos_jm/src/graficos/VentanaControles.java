package graficos;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class VentanaControles extends JFrame {
	
	public VentanaControles() {
		super.setTitle("Ventana Controles2");
		this.setBounds(100,100, 800, 800);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		initComponents();
		this.setVisible(true);
	}
	
	private void initComponents() {
		this.setLayout(null);		// Desactivar el gestor de organización
		JButton jbt1 = new JButton("Pulsar aqui");
		jbt1.setBounds(50,50,150,50);
		
 		JButton jbt2 = new JButton("Colorear");
		jbt2.setBounds(50,100,150,50);
		
		this.add(jbt1); 
		this.add(jbt2);
	
// Gestion de eventos
		ActionListener listenerJbt1 = e->jbt1.setText("Ha pulsado");
		jbt1.addActionListener(listenerJbt1);
		ActionListener listenerJbt2 = e->VentanaControles.this.getContentPane().setBackground(Color.CYAN);
		jbt2.addActionListener(listenerJbt2);
		
		
	}

}
