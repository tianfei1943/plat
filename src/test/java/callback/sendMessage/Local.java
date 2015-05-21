package callback.sendMessage;

public class Local implements CallBack {

	private String message;
	
	private Remote remote;
	
	public Local(String message, Remote remote) {
		super();
		this.message = message;
		this.remote = remote;
	}
	
	public void sendMessage(){
		System.out.println("local 向 remote 发送的消息是："+message);
		remote.handleMessage(message,this);
	}


	@Override
	public void execute(Object...paras) {
		System.out.println("回调方法执行,执行结果是："+paras[0]);
	}
	
}
