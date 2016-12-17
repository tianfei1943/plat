package redis.res;


import lombok.Getter;
import lombok.Setter;


/**
 * 从缓存中获取对象josn字符串
 * @author uatts990105
 *
 */
@Getter
@Setter
public class GetData4CacheResponse extends BaseResponse {
	private static final long serialVersionUID = -3074135919071734826L;

	private String jsonObj;

	
	
}
