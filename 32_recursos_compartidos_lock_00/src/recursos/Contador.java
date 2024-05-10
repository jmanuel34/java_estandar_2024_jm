package recursos;

import java.util.concurrent.locks.Lock;

public class Contador {
	private int valor;
	private Lock lock;
	
	
	public Contador() {
		super();
		this.valor = valor;
		this.lock = lock;
	}
	
	public synchronized void incrementar() {
		//synchronized (this) {
			int temp=valor;
			temp=temp+1;
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			valor=temp;
		//}
		
	}
	public int getValor() {
		return valor;
	}
}
