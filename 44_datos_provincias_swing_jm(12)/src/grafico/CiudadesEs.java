package grafico;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
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
		setBounds(100, 100, 501, 400);
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
		scrollMunicipios.setBounds(40, 177, 377, 150);
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
		
		JComboBox<String> comboComunidades = new JComboBox<>();
		comboComunidades.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {			
				if (e.getStateChange() == ItemEvent.SELECTED) {
					String seleccionado=(String)comboComunidades.getSelectedItem();
					//creamos adaptador con los datos de los paises
					//y lo volcamos en JTable
					var adaptador=new TableModelProvinciasImpl(seleccionado);
					tableProvincias.setModel((TableModel) adaptador);
					// Para borrar la table municipios de selecciones previas
					tableMunicipios.setModel(new DefaultTableModel());
				}				
			}
		});
		
		
		comboComunidades.setModel(new ComboBoxModelComunidadesImpl());
		scrollPane.setViewportView(comboComunidades);
		
		JLabel lblReloj = new JLabel("");
		lblReloj.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblReloj.setBounds(371, 11, 104, 20);
		contentPane.add(lblReloj);
		
		// Hilo reloj
/*		ExecutorService service= new Executors.newCachedThreadPool();
				service.submit(()->{
					LocalTime hora = LocalTime.now();
					lblReloj.setText(hora.toString());
					Thread.sleep(500);
		});
		service.shutdown();
//*/		
	}
}
