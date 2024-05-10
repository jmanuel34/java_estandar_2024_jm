package principal;

import recursos.Contador;

public class LanzarCliente {

	public static void main(String[] args) {
		Contador cont = new Contador();
		for (int i=1; i<=100; i++) {
			new Thread(()->cont.incrementar()).start();
			
		}
		// Ponemos retardo para esperar a que terminen todas las tareas
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Cuanto debería valor el contador?
		System.out.println(cont.getValor());
	}

}
