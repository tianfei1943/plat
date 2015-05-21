package callback.sendMessage;

public interface CallBack {
	/**
	 *  回调方法
	 * @param paras 将处理后的结果作为参数返回给回调方法
	 */
	public void execute(Object... paras);
	
}
