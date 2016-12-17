package redis.req;



import lombok.Getter;
import lombok.Setter;
import redis.excetion.RuleException;


@Getter
@Setter
public class GetData4CacheRequest extends BaseRequest{

	private static final long serialVersionUID = 7695061771765506911L;
	
	private String key;
	
	private String name;
	


	@Override
	public void check() throws RuleException {
		
	}
	
}
