package thread.p1;

public class Client {

	public static void main(String[] args) {
		for(int i=0;i<10;i++){
			String obj = "科目"+i;
			for(int j=0;j<10;j++){
				String title = "地点"+j;
				AbsFactory.getSignInfo(obj+title);
			}
		}
		
		SignInfo info = AbsFactory.getSignInfo("科目1地点2");
		while(true){
			info.setLocationId("tian");
			info.setName("tian");
			MultiThread t1 = new MultiThread(info);
			new Thread(t1).start();
			
			info.setLocationId("fei");
			info.setName("fei");
			MultiThread t2 = new MultiThread(info);
			new Thread(t2).start();
		}
	}

}
