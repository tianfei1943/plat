package thread.join;

public class JoinTest implements Runnable {

	private static int a = 0;
	
	@Override
	public void run() {
		for(int i=0;i<5;i++){
			a = i;
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
//		Thread t = new Thread(new JoinTest());
//		t.start();
//		t.join();//等等该线程执行完毕后再继续执行
//		System.out.println(a);
		Thread t1 = new Thread(new Thread1());
		Thread t2 = new Thread2(t1);
		t2.start();
		t2.join();
		t1.start();
		t1.join();
		System.out.println("main-end");
	}

}

class Thread1 implements Runnable{
	@Override
	public void run() {
		synchronized (this) {
			System.out.println("Thread1--begin");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Thread1--end");
		}
	}
}

class Thread2 extends Thread{
	Thread thread;
	Thread2(Thread t){
		this.thread = t;
	}
	
	@Override
	public void run() {
		synchronized (thread) {
			System.out.println("Thread2--begin");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Thread2--end");
		}
	}
}

