package principal;

import tarea.Multiplicar;

public class Lanzador {

	public static void main(String[] args) {
		Multiplicar t1 = new Multiplicar(3);
		Multiplicar t2 = new Multiplicar(5);
		Multiplicar t3 = new Multiplicar(7);
		
		Thread ta =new Thread(t1);
		Thread td =new Thread(t2);
		Thread te =new Thread(t3);
		

		ta.start();
		td.start();
		te.start();
	}

}
