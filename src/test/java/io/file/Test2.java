package io.file;

import org.apache.commons.codec.binary.Hex;

public class Test2 {
	
	public static void toHex(char[] src){
		StringBuffer sb = new StringBuffer();
		for(char c : src){
			sb.append(Integer.toHexString((int)c)+" ");
		}
		System.out.println(sb.toString());
	} 
	
	public static String toHex(byte[] src){   
		String str = Hex.encodeHexString(src);
		System.out.println(str);
	    return str;   
	} 

	public static void main(String[] args) {
		
		
		String name = "I am 君山"; 
		
        toHex(name.toCharArray()); 
        try { 
            byte[] iso8859 = name.getBytes("ISO-8859-1"); 
            toHex(iso8859); 
            byte[] gb2312 = name.getBytes("GB2312"); 
            toHex(gb2312); 
            byte[] gbk = name.getBytes("GBK"); 
            toHex(gbk); 
            byte[] utf16 = name.getBytes("UTF-16"); 
            toHex(utf16); 
            byte[] utf8 = name.getBytes("UTF-8"); 
            toHex(utf8); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
	}

}
