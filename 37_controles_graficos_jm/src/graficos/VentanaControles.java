package graficos;

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
		jbt1.setBounds(50,50,300,50);
		
 		JButton jbt2 = new JButton("Otro");
		jbt2.setBounds(200,200,300,50);
		
		this.add(jbt1); 
		//this.add(jbt2);
	}

}
