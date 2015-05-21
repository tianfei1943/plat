package varargs;

public class Client2 {
	
	public static void main(String[] args) {
		Base base = new Sub();
		base.print(1,2,3);
		Sub sub = new Sub();
		int[] x = {2};
		//sub.print(1,2,3);编译失败

	}

}

class Base{
	void print(int... values){
		System.out.println("base");
	}
}

class Sub extends Base{
	@Override
	void print(int[] args){
		System.out.println("sub");
	}
}


