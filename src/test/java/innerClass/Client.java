package innerClass;

public class Client {

	public static void main(String[] args) {
		Template t = new Template();
		final String str = "source";
		t.execute(new Executor(){
			@Override
			public void execute() {
				System.out.println("start execute....."+str);
			}
		});
	}

}
