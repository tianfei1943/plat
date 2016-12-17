package redis.service;


import redis.req.AddData2CacheRequest;
import redis.req.GetData4CacheRequest;
import redis.req.RemoveData4CacheRequest;
import redis.res.AddData2CacheResponse;
import redis.res.GetData4CacheResponse;
import redis.res.RemoveData4CacheResponse;

public interface RedisCacheService {
	
	/**
	 * 添加数据到缓存
	 * @param request
	 * @return
	 */
	public AddData2CacheResponse  setData2Cache(AddData2CacheRequest request  );
	
	
	/**
	 * 从缓存中获取对象
	 * @param request
	 * @return
	 */
	public GetData4CacheResponse  getData4Cache(GetData4CacheRequest  request);
	
	
	/**
	 * 清除缓存
	 * @param request
	 * @return
	 */
	public RemoveData4CacheResponse removeData4Cache(RemoveData4CacheRequest request);

	/**
	 * 设置缓存数据
	 * @param key
	 * @param value
	 * @param timeOut
	 * @return
	 */
	public String setCachesData(String key, String value,int timeOut); 
	
	/**
	 * 获取缓存数据
	 * @param key
	 * @return
	 */
	public String getValue(String key); 
	/**
	 * 删除缓存
	 * @param key
	 * @return
	 */
	public long removeValue(String key);

}
