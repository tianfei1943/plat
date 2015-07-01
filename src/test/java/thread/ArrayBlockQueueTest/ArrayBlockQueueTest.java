package thread.ArrayBlockQueueTest;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockQueueTest {

	public static void main(String[] args) {
		ArrayBlockingQueue<String> abq = new ArrayBlockingQueue<String>(2);
		new Thread(new Producer(abq,"红星厂")).start();
		new Thread(new Consumer(abq,"消费者A")).start(); 
	}

}

class Producer implements Runnable{
	private ArrayBlockingQueue<String> abq;
	private String name;

	public Producer(ArrayBlockingQueue<String> abq,String name) {
		this.abq = abq;
		this.name = name;
	}

	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(2);
				String product = "产品"+new Random().nextInt(100);
				this.abq.put(product);
				System.out.println("生产者："+name+",生产产品："+product);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}

class Consumer implements Runnable{
	private ArrayBlockingQueue<String> abq;
	private String name;

	public Consumer(ArrayBlockingQueue<String> abq,String name) {
		this.abq = abq;
		this.name = name;
	}
	
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(10);
				System.out.println("消费者:"+name+"，消费掉产品:"+this.abq.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}

