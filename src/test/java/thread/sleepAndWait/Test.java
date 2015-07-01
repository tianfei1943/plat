package thread.sleepAndWait;

/*
所以sleep()和wait()方法的最大区别是：
sleep()睡眠时，保持对象锁，仍然占有该锁；
而wait()睡眠时，释放对象锁
*/
public class Test implements Runnable {

	public int num = 0;
	
	public synchronized void firstMethod(){
		num = 100;
		String name = Thread.currentThread().getName();
		System.out.println("first ==="+name + " "+num);
	}
	
	public synchronized void secondMethod(){
		try {
			String name = Thread.currentThread().getName();
			//Thread.sleep(2000);
			System.out.println("second pre==="+name + " "+num);
			wait(2000);
			num = 200;
			System.out.println("second after ==="+name + " "+num);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		firstMethod();
	}
	
	
	public static void main(String[] args) throws Exception {
		Test threadTest = new Test();
        Thread thread = new Thread(threadTest);
        thread.start();
        threadTest.secondMethod();
    }


}
