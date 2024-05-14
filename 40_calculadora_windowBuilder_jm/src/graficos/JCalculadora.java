package graficos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JCalculadora extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jtf1;
	private JTextField jtf2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCalculadora frame = new JCalculadora();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JCalculadora() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Numero 1");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(31, 34, 69, 14);
		contentPane.add(lblNewLabel);
		JLabel lblResultado = new JLabel("");
		lblResultado.setBounds(251, 59, 69, 14);
		contentPane.add(lblResultado);
		
		JLabel lblNewLabel_1 = new JLabel("Numero 2");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(31, 59, 69, 14);
		contentPane.add(lblNewLabel_1);
		
		jtf1 = new JTextField();
		jtf1.setBounds(110, 31, 86, 20);
		contentPane.add(jtf1);
		jtf1.setColumns(10);
		
		jtf2 = new JTextField();
		jtf2.setBounds(110, 56, 86, 20);
		contentPane.add(jtf2);
		jtf2.setColumns(10);
		
		JButton btnSumar = new JButton("Sumar");
		btnSumar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int suma = Integer.parseInt(jtf1.getText())+Integer.parseInt(jtf2.getText());
				lblResultado.setText("Suma: "+suma);
				
			}
		});
		btnSumar.setBounds(49, 124, 89, 23);
		contentPane.add(btnSumar);
		
		JButton btnMultiplicar = new JButton("Multiplicar");
		btnMultiplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int mult = Integer.parseInt(jtf1.getText())*Integer.parseInt(jtf2.getText());
				lblResultado.setText("Suma: "+mult);
			}
		});
		btnMultiplicar.setBounds(149, 124, 89, 23);
		contentPane.add(btnMultiplicar);
		
		JButton btnNewButton = new JButton("Salir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				System.exit(EXIT_ON_CLOSE);
				JCalculadora.this.dispose();
			}
		});
		btnNewButton.setBounds(110, 181, 89, 23);
		contentPane.add(btnNewButton);
/*		
		JLabel lblResultado = new JLabel("");
		lblResultado.setBounds(251, 59, 69, 14);
		contentPane.add(lblResultado);
//*/
	}
}
