package grafico;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import adaptadores.ListModelContinentesImpl;
import graficos.VentanaPaises;
import service.DatosServiceFactory;

public class Municipio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Municipio frame = new Municipio();
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
	public Municipio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(107, 26, 213, 58);
		contentPane.add(scrollPane);
		
		JList<String> listComunidad = new JList();
		scrollPane.setViewportView(listComunidad);
		
		JLabel lblComunidad = new JLabel("Seleccionar Comunidad");
		lblComunidad.setBounds(151, 11, 110, 14);
		contentPane.add(lblComunidad);
		
		listComunidad.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				String seleccionado=listComunidad.getSelectedValue();
				var service=DatosServiceFactory.getDatosProvincias().comunidades();
				JOptionPane.showMessageDialog(VentanaPaises.this, "Paises de "+seleccionado+" :"+service.getPaisesFiltradosPor(seleccionado).size());
			}
		});
		listContinentes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(listContinentes);
		//asociamos adaptador a la lista
		listContinentes.setModel(new ListModelContinentesImpl());
	}

}
