package innerClass;

public class Template {
	
	public void connect(){
		System.out.println("connect------");
	}
	
	public void disConnect(){
		System.out.println("disconnect---------");
	}
	
	public void execute(Executor executor){
		this.connect();
		executor.execute();
		this.disConnect();
	}
	
}
