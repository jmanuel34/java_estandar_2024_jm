package grafico;

import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import adaptadores.ComboBoxModelComunidadesImpl;
import adaptadores.TableModelMunicipiosImpl;
import adaptadores.TableModelProvinciasImpl;

public class CiudadesEs extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableProvincias;
	private JTable tableMunicipios;

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
		lblComunidad.setBounds(40, 17, 153, 14);
		contentPane.add(lblComunidad);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 43, 377, 38);
		contentPane.add(scrollPane);
		
		
		
		JScrollPane scrollProvincias = new JScrollPane();
		tableProvincias = new JTable();
		tableProvincias.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String provinciaSelected = (String) tableProvincias.getValueAt(tableProvincias.getSelectedRow() , 0);
				var adaptadorMunicipios = new TableModelMunicipiosImpl(provinciaSelected);
				tableMunicipios.setModel(adaptadorMunicipios);
			}
		});
		scrollProvincias.setViewportView(tableProvincias);
		
		JScrollPane scrollMunicipios = new JScrollPane();
		scrollMunicipios.setBounds(40, 177, 377, 89);
		contentPane.add(scrollMunicipios);
		
		tableMunicipios = new JTable();
		tableMunicipios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		scrollMunicipios.setViewportView(tableMunicipios);

//*	
		
		
		scrollProvincias.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			
				String provinciaSelected = (String) tableProvincias.getValueAt(tableProvincias.getSelectedRow() , 0);
				var adaptadorMunicipios = new TableModelMunicipiosImpl(provinciaSelected);
				tableMunicipios.setModel(adaptadorMunicipios);
				//	            System.out.println(provinciaSelected);
				
			}
		});
//*/
		scrollProvincias.setBounds(40, 93, 377, 69);
		contentPane.add(scrollProvincias);
		
		
		scrollProvincias.setViewportView(tableProvincias);
		
		JComboBox comboComunidades = new JComboBox();
		comboComunidades.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {			
				if (e.getStateChange() == ItemEvent.SELECTED) {
					String seleccionado=(String)comboComunidades.getSelectedItem();
					//creamos adaptador con los datos de los paises
					//y lo volcamos en JTable
					var adaptador=new TableModelProvinciasImpl(seleccionado);
					tableProvincias.setModel((TableModel) adaptador);
				}				
			}
		});
		
		
		comboComunidades.setModel(new ComboBoxModelComunidadesImpl());
		scrollPane.setViewportView(comboComunidades);
		
		
		
		
		
	}
}
