package thread.p1;

public class MultiThread implements Runnable {

	private SignInfo signInfo;
	
	public MultiThread(SignInfo signInfo){
		this.signInfo = signInfo;
	}
	
	@Override
	public void run() {
		synchronized (signInfo) {
			String name = this.signInfo.getName();
			String id = this.signInfo.getLocationId();
			if(!name.equals(id)){
				System.out.println("产生错误了------");
				System.out.println(name);
				System.out.println(id);
			}
		}
		
		
	}

}
