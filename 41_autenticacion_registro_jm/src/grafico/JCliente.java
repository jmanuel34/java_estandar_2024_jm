package grafico;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import service.ClientesService;
import service.ClientesServiceFactory;

public class JCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel registroPane;
	
	private JTextField txtNombre;
	private JPasswordField passwordField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCliente frame = new JCliente();
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
	public JCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(41, 29, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(41, 60, 46, 14);
		contentPane.add(lblPassword);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(112, 26, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(112, 57, 86, 20);
		contentPane.add(passwordField);
		
		JButton btnSubmit = new JButton("Aceptar");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ClientesService serviceC = ClientesServiceFactory.getClientesService();				
				String nombre = txtNombre.getText();
				String password= passwordField.toString();
				
			}
		});
		btnSubmit.setBounds(109, 102, 89, 23);
		contentPane.add(btnSubmit);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
/*				
				registroPane = new JPanel();	
				registroPane = new JPanel();
				registroPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				registroPane.setLayout(null);
				
				registroPane.setVisible(false);
				registroPane.add(contentPane);
//*/
			}
		});
		btnRegistrar.setBounds(21, 227, 89, 23);
		contentPane.add(btnRegistrar);
	}
}
