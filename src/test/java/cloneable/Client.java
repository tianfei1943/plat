package cloneable;

import java.util.Random;

import org.apache.commons.beanutils.BeanUtils;


public class Client {

	private static final int MAX_SEND_COUNT = 2; 
	
	public static void main(String[] args) {
		//邮件模板
		Mail mail = new Mail(new AdvTemplate());
		mail.setTail("交通银行版权所有");
		int i = 0;
		while(i<MAX_SEND_COUNT){
			Mail cloneMail = mail.clone();
			cloneMail.setAppellation(getRandString(5)+"先生(女士)");
			cloneMail.setReceiver(getRandString(5)+"@"+getRandString(8)+".com");
			cloneMail.addValue("java3");
			send(cloneMail);
			i++;
		}
		//
		System.out.println("源头："+mail);
	}
	
	public static void send(Mail mail){
		System.out.println(mail+" succ");
	}
	
	public static String getRandString(int maxLength){
		String source = "abcdefghijklmnopqrstuvwxyz";
		StringBuffer sb = new StringBuffer();
		Random rand = new Random();
		for(int i=0;i<maxLength;i++){
			sb.append(source.charAt(rand.nextInt(source.length())));
		}
		return sb.toString();
	}

}
