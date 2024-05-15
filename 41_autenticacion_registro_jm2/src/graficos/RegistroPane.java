package graficos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dao.ClientesDao;
import model.Cliente;
import service.ClientesService;
import service.ClientesServiceFactory;

public class RegistroPane extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textUsuario;
	private JTextField textPasword;
	private JTextField textEmail;
	private JTextField textTelefono;
	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroPane frame = new RegistroPane();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
//*/
	/**
	 * Create the frame.
	 */
	public RegistroPane() {

		ClientesService service = ClientesServiceFactory.getClientesService();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(37, 27, 46, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(37, 52, 46, 14);
		contentPane.add(lblPassword);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(37, 77, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(37, 100, 46, 14);
		contentPane.add(lblTelefono);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(148, 21, 86, 20);
		contentPane.add(textUsuario);
		textUsuario.setColumns(10);
		
		textPasword = new JTextField();
		textPasword.setColumns(10);
		textPasword.setBounds(148, 46, 86, 20);
		contentPane.add(textPasword);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(148, 71, 86, 20);
		contentPane.add(textEmail);
		
		textTelefono = new JTextField();
		textTelefono.setColumns(10);
		textTelefono.setBounds(148, 94, 86, 20);
		contentPane.add(textTelefono);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente cliente = new Cliente(0,
						textUsuario.getText(),
						textPasword.getText(),
						textEmail.getText(),
						Integer.parseInt( textTelefono.getText()));
				if (service.registrar(cliente))
				JOptionPane.showMessageDialog(null, "Usuario registrado con éxito");
				else JOptionPane.showMessageDialog(null, "Fallo en el registro del usuario");

			}
		});
		btnRegistrar.setBounds(52, 208, 89, 23);
		contentPane.add(btnRegistrar);
		
	}

}
