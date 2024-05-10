package tarea;

public class Multiplicar implements Runnable{
	private int numero;
	
	public Multiplicar(int numero) {
		this.numero = numero;
	}

	@Override
	public void run() {
		for (int i=0; i<10; i++) {
			System.out.println("Resultado de " +numero+ " x "+ i+ " = " +numero*i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}

}
