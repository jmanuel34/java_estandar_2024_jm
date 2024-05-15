package graficos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import adaptadores.ListModelContinentesImpl;
import service.PaisesServiceFactory;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class Paises extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Paises frame = new Paises();
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
	public Paises() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblContinentes = new JLabel("Continentes");
		lblContinentes.setBounds(31, 22, 46, 14);
		contentPane.add(lblContinentes);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(205, 10, -36, 5);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(124, 20, 81, 85);
		contentPane.add(scrollPane);
		
		JList<String> listContinentes = new JList<>();
		listContinentes.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				String continente = listContinentes.getSelectedValue();
				var service =PaisesServiceFactory.getPaisesService();
				JOptionPane.showMessageDialog(VentanaPaises.this,  "Paises de "+ );
			}
		});
		scrollPane.setViewportView(listContinentes);
		// asociamos adaptador a la lista
		listContinentes.setModel(new ListModelContinentesImpl());
	
	}
}
