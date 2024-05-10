package recursos;

public class Contador {
	private int valor;

	public void incrementar() {
		synchronized (this) {
			int temp = valor;
			temp = temp + 1;
			valor = temp;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public int getValor() {
		return valor;
	}
}
