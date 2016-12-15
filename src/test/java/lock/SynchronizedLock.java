package lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

/**
 * synchronized
 * 锁的是对象
 * 如果一个线程拿到了Synchronized锁，则其他线程对该对象的所有Synchronized操作都阻塞
 * @author uatft90931
 *
 */
@Slf4j
public class SynchronizedLock {
	
	public synchronized void message1(){
		try {
			log.info("------1--start");
			TimeUnit.SECONDS.sleep(2);
			log.info("------1--end");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void message2(){
		try {
			log.info("------2--start");
			TimeUnit.SECONDS.sleep(2);
			log.info("------2--end");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void message3(){
		log.info("-------3------s");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log.info("--------3-----e");
	}
	
	
	public static void main(String[] args) {
		final SynchronizedLock k = new SynchronizedLock();
		ExecutorService pool = Executors.newFixedThreadPool(5);
		for(int i=0;i<3;i++){
			pool.submit(new Runnable() {
				@Override
				public void run() {
					k.message1();
				}
			});
		}
		k.message3();
		final SynchronizedLock k2 = new SynchronizedLock();
		for(int i=0;i<3;i++){
			pool.submit(new Runnable() {
				@Override
				public void run() {
					k.message2();
				}
			});
		}
		pool.shutdown();
	}
	
	
}
