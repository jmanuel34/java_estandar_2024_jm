package principal;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PruebaAgregar {

	public static void main(String[] args) {
		List<Integer> lista = new CopyOnWriteArrayList<>();
		ExecutorService executor=Executors.newFixedThreadPool(16);
		for (int i=0; i<500_000; i++) {
			executor.submit(()->lista.add((int)(Math.random()*500+1)));
		}
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Numeros en la lista: "+lista.size());
	}
}
