package callback.sendMessage;

public class Remote {
	
	public void handleMessage(String message,CallBack callBack){
		System.out.println("remote 的接收消息是："+message);
		callBack.execute("2");
	}
	
}
