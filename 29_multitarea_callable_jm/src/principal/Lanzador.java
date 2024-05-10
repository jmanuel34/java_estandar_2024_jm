package principal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 *Lanzar dos tareas que se ejecuten concurrentemente.
 * Una de ellas, calculará la suma de todos los numeros entre 1 y 100;
 * La otra calculara el factorial de un numero cualquiera.
 * Cuando finalicen las tareas, el programa principal mostrará los resultado
 * Mientras las tareas estén ejeccución, el programa principal estará haciendo otras cosas
 */

public class Lanzador {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		//ExecutorService executor = new Executors.newCachedThreadPool();
		// executor.submit(()->IntStream.rangeClosed(1.100).sum();
		Future<Integer> f1 =executor.submit(()-> {
			int suma=0;
			for (int i=1; i<=100; i++) {
				suma+=i;
				Thread.sleep(100);
			}
			return suma;
		});
	
	Future<Integer> f2 = executor.submit()-> {
		int p=1;
		for (int i=1; i<=6; i++) {
			p*=i;
			Thread.sleep(100);
		}
	});
		return p;


// el Main sigue haciendo algo hasta que las tareas terminen.
// momento en ql qu ese mostrarán los resultados

	while(!f1.isDone() || !f2.isDone()) {
		System.out.println ("haciendo cositas ...");
	}
	System.out.println("Suma de los numeros: "+f1.get());
	System.out.println("Factorial del numero: "+f2.get());
	executor.shutdown();
	
}
}
