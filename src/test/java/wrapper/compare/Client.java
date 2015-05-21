package wrapper.compare;

import org.junit.Test;

public class Client {

	@Test
	public void test() {
		Integer x = new Integer(100);
		Integer y = new Integer(100);
		System.out.println(x==y);
		System.out.println(x>y);
		System.out.println(x<y);
		System.out.println(x.equals(y));
		System.out.println(x.compareTo(y));
	}

}
