package base64;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64Util {
	
	public static String decode(String str){
		String decode = null;
		BASE64Decoder base64 = new BASE64Decoder();
        try {
			byte[] b = base64.decodeBuffer(new ByteArrayInputStream(str.getBytes("UTF-8")));
			decode = new String(b);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        System.out.println("加密:"+str+" -->  原窜："+decode);
        return decode;
	}
	
	public static String encode(String str){
		BASE64Encoder encoder = new BASE64Encoder();
 	 	String encode = encoder.encode(str.getBytes());
        System.out.println("原字符窜:"+str+" -->  加密："+encode);
        return encode;
	}
	
}
