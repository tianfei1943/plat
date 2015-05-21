package cloneable;

/**
 * 广告模板（一般是从数据库获取）
 * @author Administrator
 *
 */
public class AdvTemplate {
	//主题
	private String advSubject = "交通银行国庆信用卡活动开始了";
	//广告内容
	private String advContext = "只要抽奖就送100万。。。。。。";
	
	public String getAdvSubject() {
		return advSubject;
	}
	public void setAdvSubject(String advSubject) {
		this.advSubject = advSubject;
	}
	public String getAdvContext() {
		return advContext;
	}
	public void setAdvContext(String advContext) {
		this.advContext = advContext;
	}
	
}
