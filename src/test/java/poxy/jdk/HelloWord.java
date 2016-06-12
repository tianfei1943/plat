package poxy.jdk;

public class HelloWord implements IHelloWrod {

	@Override
	public int sayHelloWord(String arg) {
		System.out.println(arg);
		return 100;
	}


}
