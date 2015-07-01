package thread.join;

public class JoinTest2 {
	
	public static void main(String[] args) throws InterruptedException {
//		Thread t = new Thread(new JoinTest());
//		t.start();
//		t.join();//等等该线程执行完毕后再继续执行
//		System.out.println(a);
		Source s = new Source ();
		Thread t1 = new Thread(new Thread0(s));
		Thread t2 = new Thread(new Thread00(s));
		t2.start();
		//t2.join();
		t1.start();
		//t1.join();
		//System.out.println("main-end");
	}

}

class Thread0 implements Runnable{
	
	Source s;
	
	Thread0(Source t){
		this.s = t;
	}
	
	@Override
	public void run() {
		synchronized (s) {
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

class Thread00 implements Runnable{
	
	Source s;
	
	Thread00(Source t){
		this.s = t;
	}
	
	@Override
	public void run() {
		synchronized (s) {
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

class Source{
	private int x = 1;
}
