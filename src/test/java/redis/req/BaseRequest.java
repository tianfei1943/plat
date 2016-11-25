package redis.req;

import java.io.Serializable;

import redis.excetion.RuleException;

public abstract class BaseRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4157088554961038236L;
	
	/**
	 * 校验参数
	 * @throws ServiceException
	 */
	public abstract void check() throws RuleException;
	
}
