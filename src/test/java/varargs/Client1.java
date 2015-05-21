package varargs;

public class Client1 {

	public static void sum(int... values){
		int sum = 0;
		for(int x : values){
			sum += x;
		}
		System.out.println(sum);
	}
	
	
	public static void main(String[] args) {
		Client1.sum(1,2,3,4);
	}

}
