package cloneable;

import java.util.ArrayList;

/**
 * 邮件实体类
 * @author Administrator
 *
 */
public class Mail implements Cloneable {
	
	private String receiver;//收件人
	
	private String subject;//主题
	
	private String appellation;//称谓
	
	private String context;//邮件内容
	
	private String tail;//邮件末尾
	
	//测试深拷贝
	private ArrayList<String> list = new ArrayList<String>(10);
	
	public Mail(){
		this.list.add("java1");
		this.list.add("java2");
		System.out.println("========");
	}
	
	public Mail(AdvTemplate template){
		this();
		this.subject = template.getAdvSubject();
		this.context = template.getAdvContext();
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getAppellation() {
		return appellation;
	}

	public void setAppellation(String appellation) {
		this.appellation = appellation;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getTail() {
		return tail;
	}

	public void setTail(String tail) {
		this.tail = tail;
	}

	public void addValue(String value){
		this.list.add(value);
	}



	@Override
	public String toString() {
		return "Mail [receiver=" + receiver + ", subject=" + subject
				+ ", appellation=" + appellation + ", context=" + context
				+ ", tail=" + tail + ", list=" + list + "]";
	}

	@SuppressWarnings("unchecked")
	@Override
	protected Mail clone() {
		Mail mail = null;
		try{
			mail = (Mail)super.clone();
			mail.list =  (ArrayList<String>)this.list.clone();
		}catch(CloneNotSupportedException ex){
			ex.printStackTrace();
		}
		return mail;
	}
	
	
}
