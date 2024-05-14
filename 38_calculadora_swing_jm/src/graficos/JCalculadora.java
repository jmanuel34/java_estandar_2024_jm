package graficos;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JCalculadora extends JFrame {

	public JCalculadora() {
		super.setTitle("Ventana Controles2");
		this.setBounds(100, 100, 800, 800);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		initComponents();
		this.setVisible(true);
	}

	private void initComponents() {
		this.setLayout(null); // Desactivar el gestor de organización
		JLabel jLabel1 = new JLabel("Numero 1");
		JLabel jLabel2 = new JLabel("Numero 2");
		JLabel jLResultado = new JLabel("");

		jLabel1.setBounds(50, 50, 80, 30);
		jLabel2.setBounds(50, 80, 80, 30);
		jLResultado.setBounds(50, 110, 150, 30);

		JTextField jText1 = new JTextField();
		JTextField jText2 = new JTextField();

		jText1.setBounds(120, 50, 80, 30);
		jText2.setBounds(120, 80, 80, 30);

		JButton jBtSumar = new JButton("Sumar");
		JButton jBtMultiplicar = new JButton("Multiplicar");
		jBtSumar.setBounds(50, 150, 110, 30);
		jBtMultiplicar.setBounds(150, 150, 110, 30);

		this.add(jLabel1);
		this.add(jLabel2);
		this.add(jLResultado);

		this.add(jText1);
		this.add(jText2);
		this.add(jBtSumar);
		this.add(jBtMultiplicar);

		jBtSumar.addActionListener(e->{
			int suma=Integer.parseInt(jText1.getText())+Integer.parseInt(jText2.getText());
			jLResultado.setText("Resultado: "+suma);
		});
		jBtMultiplicar.addActionListener(e->{
			int multi=Integer.parseInt(jText1.getText())*Integer.parseInt(jText2.getText());
			jLResultado.setText("Resultado: "+multi);
		});
	}
}
