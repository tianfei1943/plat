package redis.req;



import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import redis.excetion.RuleException;


/**
 * 添加数据到缓存的请求，其中key为必须，value/valueMap为二选一
 *
 */

@Getter
@Setter
public class AddData2CacheRequest extends BaseRequest{

	private static final long serialVersionUID = 987613125067397604L;

	//缓存的标示
	private String key; //(必填)
	
	//单个数据对象加入缓存
	private Object value; //(选填)
	
	
	//map格式的数据加入缓存
	private Map<String,Object> valueMap =new HashMap<String,Object>(); //(选填)
	
	private int timeOut=-1; //缓存时效(默认永久)

	@Override
	public void check() throws RuleException {
		
	}
	
}
