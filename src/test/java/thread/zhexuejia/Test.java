package thread.zhexuejia;

public class Test {

	public static void main(String[] args) {
		Fork fork = new Fork();
		for(int i=0;i<5;i++){
			new Thread(new Customer(i,fork)).start();
		}
		
	}

}

class Customer implements Runnable{

	private int code;//客户编号
	
	private Fork fork;//筷子

	public Customer(int code, Fork fork) {
		super();
		this.code = code;
		this.fork = fork;
	}

	public void thinking(){
		try {
			Thread.sleep(2000);//思考两秒
			System.out.println("客户"+code+"思考，耗时两秒");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void eating(){
		try {
			Thread.sleep(2000);//吃两秒饭
			System.out.println("客户"+code+"吃饭，耗时两秒");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void run() {
		this.thinking();
		this.fork.takedFork(this.code);
		this.eating();
		this.fork.putFork(this.code);
	}
	
}

class Fork{
	/*初始化，默认都是未使用*/
	private boolean[] isUsed = {false,false,false,false,false};
	
	/*筷子被拿起*/
	public synchronized void takedFork(int customerCode){
		int leftForkCode = customerCode;
		int rightForkCode = (customerCode+1)%5;
		if(isUsed[leftForkCode] == false && isUsed[rightForkCode] == false){
			isUsed[leftForkCode] = true;
			isUsed[rightForkCode] = true;
			System.out.println("客户"+customerCode+"拿起筷子"+leftForkCode+ "和筷子"+rightForkCode);
		}else{
			try {
				//Thread.sleep(3);
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	//放下筷子，同时唤醒该对象线程池中的其他线程
	public synchronized void putFork(int customerCode){
		int leftForkCode = customerCode;
		int rightForkCode = (customerCode+1)%5;
		isUsed[leftForkCode] = false;
		isUsed[rightForkCode] = false;
		System.out.println("客户"+customerCode+"放下筷子"+leftForkCode+ "和筷子"+rightForkCode);
		notifyAll();
	}
	
}
