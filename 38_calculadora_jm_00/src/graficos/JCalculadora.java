package graficos;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JCalculadora extends JFrame {
	public JCalculadora() {
		super("Ventana controles");
		this.setBounds(100,80,800,400);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//creación y configuración de controles
		initComponents();
		this.setVisible(true);
	}
	private void initComponents() {
		this.setLayout(null);
		JLabel jl1=new JLabel("Número 1: ");
		JLabel jl2=new JLabel("Número 2: ");
		JLabel jlResultado=new JLabel("");
		JTextField jtf1=new JTextField();
		JTextField jtf2=new JTextField();
		JButton jbtSumar=new JButton("Sumar");
		JButton jbtMultiplicar=new JButton("Multiplicar");
		jl1.setBounds(150, 50, 130, 40);
		jtf1.setBounds(280,50,100,40);
		jl2.setBounds(150, 130, 130, 40);
		jtf2.setBounds(280,130,100,40);
		jbtSumar.setBounds(120, 220, 150, 50);
		jbtMultiplicar.setBounds(360, 220, 150, 50);
		jlResultado.setBounds(150, 270, 150, 30);
		//añadir control al contenedor
		this.add(jl1);this.add(jl2);this.add(jtf1);
		this.add(jtf2);this.add(jbtSumar);this.add(jbtMultiplicar); 
		this.add(jlResultado);
		
		//eventos
		jbtSumar.addActionListener(e->{
			int suma=Integer.parseInt(jtf1.getText())+Integer.parseInt(jtf2.getText());
			jlResultado.setText("Suma: "+suma);
		});
		jbtMultiplicar.addActionListener(e->{
			int multi=Integer.parseInt(jtf1.getText())*Integer.parseInt(jtf2.getText());
			jlResultado.setText("Producto: "+multi);
		});
		
		FocusListener listener1=new FocusListener(); {
	
			@Override
			public void focusLost(FocusEvent e) {
				// cuando la caja pierda el foco, cmpruba si el valor introducido no es numérico
				// en cuyo caso debe mantener el foco
				JTextField jtf=(JTextField)e.getSource(); //obtiene una referencia a la caja 
															// en la que se ha proiducido el evento
				
				try {
					Integer.parseInt( jtf.getText());
					
				} catch (NumberFormatException ex) {
					jtf.requestFocus();
					jtf.selectAll();
				}
				jtf1.addFocusListener(listener1);
				jtf2.addFocusListener(listener1);
				
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		};
	}
}
