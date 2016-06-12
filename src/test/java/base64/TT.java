package base64;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.junit.Test;

public class TT {

	@Test
	public void test() {
		try {
			String str = URLEncoder.encode("测试", "GBK");
			System.out.println(str);
			String s2 = URLDecoder.decode(str, "ISO8859-1");
			String s34 = new String(s2.getBytes("ISO8859-1"),"GBK");
			System.out.println("-----"+s34);
			System.out.println(s2);
			String s3 = URLDecoder.decode(str, "GBK");
			System.out.println(s3);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
