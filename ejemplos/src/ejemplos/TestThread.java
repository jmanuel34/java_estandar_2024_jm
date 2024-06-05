package ejemplos;

import java.util.concurrent.atomic.AtomicInteger;

class Test2 {
	volatile int x=1;
	AtomicInteger xObj = new AtomicInteger(1);
}
public class TestThread  {
	public static void main(String[] args) {
		Test2 t = new Test2();
		Runnable r1 = ()-> {
			Thread trd = Thread.currentThread();
			while (t.x < 3) {
				System.out.println(trd.getName()+" + "+t.x+" :");
				t.x++;
			}
		};
		Runnable r2= ()-> {
			Thread trd = Thread.currentThread();
			while (t.xObj.get() < 3) {
				System.out.println(trd.getName()+" + "+t.xObj.get()+" :");
				t.xObj.getAndIncrement();
			}
		};
		Thread t1 = new Thread(r1, "t1");
		Thread t2 = new Thread(r2, "t2");
		t1.start();
		t2.start();
		
	}

}
}