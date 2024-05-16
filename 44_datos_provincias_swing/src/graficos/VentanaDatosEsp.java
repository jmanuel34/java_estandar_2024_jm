package graficos;

import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import adaptadores.ComboBoxModelComunidadesImpl;
import adaptadores.ComboBoxModelProvinciasImpl;
import adaptadores.TableModelMunicipiosImpl;
import model.Provincia;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaDatosEsp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableMunicipios;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaDatosEsp frame = new VentanaDatosEsp();
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
	public VentanaDatosEsp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Comunidad:");
		lblNewLabel.setBounds(49, 25, 83, 14);
		contentPane.add(lblNewLabel);
		JComboBox<Provincia> comboProvincias = new JComboBox<>();
		comboProvincias.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String codigoProv=((Provincia)comboProvincias.getSelectedItem()).getCodigoProvincia();
				if(e.getStateChange()==ItemEvent.SELECTED) {
					tableMunicipios.setModel(new TableModelMunicipiosImpl(codigoProv));
				}
			}
		});
		comboProvincias.setBounds(142, 64, 153, 22);
		contentPane.add(comboProvincias);
		
		JComboBox<String> comboComunidades = new JComboBox<>();
		comboComunidades.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String comunidad=(String)comboComunidades.getSelectedItem();
				comboProvincias.setModel(new ComboBoxModelProvinciasImpl(comunidad));
				//para borrar la tabla de municipios
				//de selecciones previas
				tableMunicipios.setModel(new DefaultTableModel());
			}
		});
		comboComunidades.setBounds(142, 21, 153, 22);
		contentPane.add(comboComunidades);
		
		JLabel lblNewLabel_1 = new JLabel("Provincia:");
		lblNewLabel_1.setBounds(49, 68, 64, 14);
		contentPane.add(lblNewLabel_1);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Municipios");
		lblNewLabel_2.setBounds(83, 111, 89, 14);
		contentPane.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 136, 399, 120);
		contentPane.add(scrollPane);
		
		tableMunicipios = new JTable();
		scrollPane.setViewportView(tableMunicipios);
		
		JButton jbtSalir = new JButton("Salir");
		jbtSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaDatosEsp.this.dispose();
			}
		});
		jbtSalir.setBounds(181, 267, 89, 23);
		contentPane.add(jbtSalir);
		
		//carga de comunidades
		comboComunidades.setModel(new ComboBoxModelComunidadesImpl());
	}
}
