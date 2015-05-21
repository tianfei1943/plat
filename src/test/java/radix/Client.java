package radix;
/**
 * 进制转换
 * @author Administrator
 *
 */
public class Client {

	public static void main(String[] args) {
		//String binary = Integer.toBinaryString(3);
		//System.out.println(binary);
		
		double x = 34473932.749999999;
		
		double x1 = x*100;
		System.out.println(x1);
		
		float y = (float)x1;
		System.out.println(y/100);
		
		
	}

}
