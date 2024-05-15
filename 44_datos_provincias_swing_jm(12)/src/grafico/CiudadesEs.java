package grafico;

import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import adaptadores.ComboBoxModelComunidadesImpl;

public class CiudadesEs extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CiudadesEs frame = new CiudadesEs();
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
	public CiudadesEs() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblComunidad = new JLabel("Seleccionar Comunidad");
		lblComunidad.setBounds(151, 11, 153, 14);
		contentPane.add(lblComunidad);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 43, 377, 38);
		contentPane.add(scrollPane);
		
		JComboBox comboComunidades = new JComboBox();
		comboComunidades.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if (e.getStateChange() == ItemEvent.SELECTED) {
					String seleccionado=(String)comboComunidades.getSelectedItem();
					//creamos adaptador con los datos de los paises
					//y lo volcamos en JTable
					var adaptador=new ComboBoxModelComunidadesImpl();
					comboComunidades.setModel(adaptador);
				}		
				
				
			}
		});
		comboComunidades.setModel(new ComboBoxModelComunidadesImpl());
		scrollPane.setViewportView(comboComunidades);
		
	}
}
