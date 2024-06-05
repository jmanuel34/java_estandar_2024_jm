package graficos;

import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Cuenta;
import service.CajeroService;
import service.CajeroServiceFactory;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Banca extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Banca frame = new Banca();
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
	public Banca() {
		 CajeroService service = CajeroServiceFactory.getCajeroService();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 616, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer id = Integer.parseInt( textField.getText());
				 Cuenta cuenta =  service.obtenerCuenta(id);
				 System.out.println("He llegado");
				 new JFrameCuenta(cuenta);
				 
				 
				
			}
		});
/*
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				Integer id = Integer.parseInt( textField.getText());
				 if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					 Cuenta cuenta =  service.obtenerCuenta(id);
					 
					  
					  // Crear nueva ventana con datos de la cuenta
					  
					 
				 }
			}
		});
//*/
		textField.setBounds(167, 66, 161, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Número de Cuenta");
		btnNewButton.setBounds(167, 6, 161, 29);
		contentPane.add(btnNewButton);
	}

}
