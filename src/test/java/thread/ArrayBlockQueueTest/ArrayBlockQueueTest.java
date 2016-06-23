package thread.ArrayBlockQueueTest;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;


/**
 * 生产
 * put :如果BlockQueue没有空间,则调用此方法的线程被阻塞，直到BlockingQueue里面有空间再继续
 * offer：即如果BlockingQueue可以容纳,则返回true,否则返回false.（本方法不阻塞当前执行方法的线程）
 * 
 * 消费：
 * take:  若BlockingQueue为空,阻塞进入等待状态直到BlockingQueue有新的数据被加入; -->对应put
 * poll： 若不能立即取出,则可以等time参数规定的时间,取不到时返回null;
 * 
 * @author fei
 *
 */
public class ArrayBlockQueueTest {

	public static void main(String[] args) {
		ArrayBlockingQueue<String> abq = new ArrayBlockingQueue<String>(2);
		new Thread(new Producer(abq,"红星厂")).start();
		//new Thread(new Consumer(abq,"消费者A")).start(); 
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
				//System.out.println(this.abq.put(product));
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

