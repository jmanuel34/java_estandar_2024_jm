package graficos;

import java.awt.Color;

import javax.swing.JFrame;

public class MiVentana extends JFrame {
		public MiVentana() {
			super("Primera Ventana Swing");
			this.setBounds(100,100, 700,300);
			this.getContentPane().setBackground(Color.BLUE);
			this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			this.setVisible(true);
			
		}

}
