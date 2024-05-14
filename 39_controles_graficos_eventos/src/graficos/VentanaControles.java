package graficos;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaControles extends JFrame {
	public VentanaControles() {
		super("Ventana controles");
		this.setBounds(100,80,800,400);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//creación y configuración de controles
		initComponents();
		this.setVisible(true);
	}
	private void initComponents() {
		this.setLayout(null);
		JButton jbt1=new JButton("Pulsar aquí");
		JLabel jlbl1=new JLabel();
		JButton jbt2=new JButton("Colorear");
		jbt2.setBounds(400, 50, 120, 50);
		jbt1.setBounds(50, 50, 300, 50);
		jlbl1.setBounds(100, 100, 150, 40);
		this.add(jbt1);
		this.add(jlbl1);
		this.add(jbt2);
		//gestión de eventos
	
		jbt1.addActionListener(e->jlbl1.setText("Ha pulsado"));
		

		jbt2.addActionListener(e->VentanaControles.this.getContentPane().setBackground(Color.yellow));
		
	}
}
