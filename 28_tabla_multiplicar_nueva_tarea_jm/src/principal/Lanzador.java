package principal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import tarea.Multiplicar;

public class Lanzador {

	public static void main(String[] args) {
		ExecutorService executor=Executors.newCachedThreadPool();
//		Multiplicar t1 = new Multiplicar(3);
//		Multiplicar t2 = new Multiplicar(5);
//		Multiplicar t3 = new Multiplicar(7);
		
		/*
		 * Thread ta =new Thread(t1); Thread td =new Thread(t2); Thread te =new
		 * Thread(t3);
		 * 
		 * 
		 * ta.start(); td.start(); te.start();
		 */
	
	executor.submit(new Multiplicar(5));
	executor.submit(new Multiplicar(3));
	executor.submit(new Multiplicar(7));
	executor.shutdown();
	
	
	}

}
