package thread.stopThread;


public class T1{
	
	public static void main(String[] args) {
		T2 t = new T2();
		for(int i=0;i<3;i++){
			new Thread(t).start();
			new Thread(t).start();
			new Thread(t).start();
		}
		t.stop();
	}
	
}
/**
 * 实现Runable的好处
 * 资源共享，多继承
 * @author fei
 *
 */
class T2 implements Runnable {

	private int a = 0;
	
	//保证每次从主内存中获取最新的值
	private volatile boolean stop = false;
	
	@Override
	public void run() {
		while(!stop){
			synchronized (this) {
				a=a+1;
				String name = Thread.currentThread().getName();
				System.out.println(name+"   "+a);
			}
			
		}
	}

	public int getA() {
		return a;
	}

	public void stop() {
		this.stop = true;
	}
	
	
}
