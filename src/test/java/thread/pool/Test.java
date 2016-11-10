package thread.pool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

	public static void main(String[] args) {
		
		ExecutorService es = Executors.newFixedThreadPool(1);
//		es.
		Executors.newCachedThreadPool();
		Executors.newSingleThreadExecutor();
		
	}

}
