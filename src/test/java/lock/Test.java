package lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

	public static void main(String[] args) {
		final lock k = new lock();
		ExecutorService pool = Executors.newFixedThreadPool(5);
		pool.submit(new Runnable() {
			
			@Override
			public void run() {
				k.message1();
			}
		});
		
		final lock k2 = new lock();
		pool.submit(new Runnable() {
			@Override
			public void run() {
				k2.message1();
			}
		});
	}
	
}
