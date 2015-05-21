package callback.template;

public class HibernateTemplate {

	private void execute(ICallBack callBack){
		this.getConnection();
		callBack.doCurd();
		this.releaseConnection();
	}
	
	public void save(){
		this.execute(new ICallBack() {
			
			@Override
			public void doCurd() {
				System.out.println("保存操作-----");
			}
		});
	}
	
	public void delete(){
		this.execute(new ICallBack() {
			
			@Override
			public void doCurd() {
				System.out.println("删除操作-----");
			}
		});
	}
	
	
	private void getConnection(){
		System.out.println("获取连接----");
	}
	
	private void releaseConnection(){
		System.out.println("释放连接----");
	}
	
}
