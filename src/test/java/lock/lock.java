package lock;

import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class lock {
	
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
	
	
}
