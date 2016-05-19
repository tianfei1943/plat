package thread;

public class VolatileTest {

	public static void main(String[] args) throws InterruptedException {
		
		int value=10000;
		int loop=0;
		
		ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
		while(loop++ < value){
			
			T1 t = new T1();
			for(int i=0;i<10000;i++){
				new Thread(t).start();
			}
			do{
				Thread.sleep(15);
			}while(threadGroup.activeCount() != 1);
			
			if(t.getNum() != value){
				System.out.println("循环到"+loop+"时，开始出现线程不安全，Num:"+t.getNum());
			}else{
				System.exit(0);
			}
			
		}

	}

}

class T1 implements Runnable{

	//保证从主内存获取最新的值
	private volatile int num =0;
	
	@Override
	public void run() {
		for(int i=0;i<10000;i++){
			Math.hypot(Math.pow(99999999, i), Math.cos(99999999));
		}
		// 此处线程不安全
		num++;//num = num+1
	}
	
	public int getNum(){
		return num;
	}
	
}
