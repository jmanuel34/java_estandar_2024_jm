package tareas;

import recursos.Recurso;

public class HiloProductor implements Runnable {
	private Recurso recurso;

	public HiloProductor(Recurso r) {
		this.recurso = r;
	}

	@Override
	public void run() {
		while (true) {
			int num = (int) (Math.random()*100+1);
			synchronized (recurso) {
				if (recurso.isLleno()) {
					System.out.println("Recurso lleno");
					try {
						recurso.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				recurso.guardar(num);
				System.out.println("Se ha guardado el num: " + num);
				recurso.notify();
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
