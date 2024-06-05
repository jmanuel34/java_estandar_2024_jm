package graficos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import adaptadores.ListModelClientesImpl;
import model.Cliente;
import model.Cuenta;

public class JFrameCuenta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameCuenta frame = new JFrameCuenta();
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
	public JFrameCuenta(Cuenta cuenta) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 768);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuAcciones = new JMenu("Acciones");
		menuBar.add(menuAcciones);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(112, 58, 442, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		contentPane.add(scrollPane);
		JMenuItem menuItemTitulares = new JMenuItem("Titulares");
		menuItemTitulares.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JList<Cliente> listClientes = new JList<>();
				listClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				scrollPane.setViewportView(listClientes);
				//asociamos adaptador a la lista
				listClientes.setModel(new ListModelClientesImpl(cuenta.getNumeroCuenta()));
			}
		});
		menuAcciones.add(menuItemTitulares);
		
		JMenuItem menuItemIngreso = new JMenuItem("Ingreso");
		menuAcciones.add(menuItemIngreso);
		
		JMenuItem menuItemExtraccion = new JMenuItem("Extraccion");
		menuAcciones.add(menuItemExtraccion);
		
		JMenuItem menuItemMov = new JMenuItem("Saldo y Movimientos");
		menuAcciones.add(menuItemMov);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setVisible(true);
		
		
		
		
	}
}
