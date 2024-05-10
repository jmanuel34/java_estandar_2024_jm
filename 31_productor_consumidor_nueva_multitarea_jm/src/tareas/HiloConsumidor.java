package tareas;

import recursos.Recurso;

public class HiloConsumidor implements Runnable {
	private Recurso recurso;
	public HiloConsumidor(Recurso r) {
		this.recurso= r;
	}

		@Override
		public void run() {
			while (true) {
				synchronized (recurso) {
					if (recurso.isVacio()  ) {
						System.out.println("Recurso vacio");
						try {
							recurso.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println("Consumiento: "+recurso.sacar());
					recurso.notify();	
				}
				
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

}
