package redis.req;



import lombok.Getter;
import lombok.Setter;
import redis.excetion.RuleException;


@Getter
@Setter
public class RemoveData4CacheRequest extends BaseRequest{

	private static final long serialVersionUID = 987613125067397604L;

	private String key;
	
	private String [] fileds;
	
	@Override
	public void check() throws RuleException {
		
	}
	
}
