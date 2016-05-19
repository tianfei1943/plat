package mail;

import javax.mail.internet.InternetAddress;


public class MailUtils {
	
	
	public static boolean sendEmail(String mailTo,String subject,String content){
		InternetAddress mailfrom;
		InternetAddress mailto;
		try {
			mailfrom = new InternetAddress("admin@admin.com", "青岛大都邮件发送器");
			mailto = new InternetAddress(mailTo);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		
		boolean htmlContent = false;

		String username = "tianfei@tecpie.com";
		String password = "feitian321";
		String protocol = "smtp"; // default: smtp
		String smtpHost = "smtp.qq.com";
		int smtpPort = 25; // default: 25
		long timeoutInMills = 1000L; // default: 5000L
		ConnectionParams connectionParams = new ConnectionParams();
		connectionParams.setConnectTimeout(timeoutInMills)
		        .setSocketTimeout(timeoutInMills).setDebug(true)
		        .setProtocol(protocol).setHost(smtpHost).setPort(smtpPort)
		        .setNeedAuth(true).setEnvelopeFrom(username)
		        .setPassword(password);
		// if connection need keep alive after sent, you can set:
		// connectionParams.setKeepAlive(true);

		// if you need a connection pool, there present a class: ConnectionFactory,
		// which implements org.apache.commons.pool.PoolableObjectFactory

		SendJob job = new SendJob(new Connection(connectionParams));
		job.setSubject(subject).setMailFrom(mailfrom).addMailTo(mailto)
		        .setMailContent(content).setHtmlContent(htmlContent);

		boolean success = job.send();
		return success;
	}
	

	public static void main(String[] args) throws Exception {
		String subject = "请假审批需要处理";
		String content = "1. 有个单据需要您审核; \n"+ "2. 没有相关的文档供您参考。";
		String mailTo = "361681501@qq.com";
		MailUtils.sendEmail(mailTo, subject, content);

	}

}
