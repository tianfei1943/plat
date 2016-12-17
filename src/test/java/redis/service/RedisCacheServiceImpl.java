package redis.service;

import java.util.Map;
import java.util.Set;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.req.AddData2CacheRequest;
import redis.req.GetData4CacheRequest;
import redis.req.RemoveData4CacheRequest;
import redis.res.AddData2CacheResponse;
import redis.res.GetData4CacheResponse;
import redis.res.RemoveData4CacheResponse;
import redis.util.RedisClusterUtil;


@Slf4j
@Service(value = "redisCacheService")
public class RedisCacheServiceImpl implements RedisCacheService {

	
	@Autowired
	RedisClusterUtil  redisClusterUtil;

	@Override
	public AddData2CacheResponse setData2Cache(AddData2CacheRequest request) {
		 
		AddData2CacheResponse response=new AddData2CacheResponse();
		
		try {
			
			Map<String,Object> valueMap =request.getValueMap();
			
			 if(request.getValue()!=null){
				redisClusterUtil.setObj2Cache(request.getKey(), request.getValue(),request.getTimeOut());
				
			}else if(!valueMap.isEmpty()){
				
				Set<String> keys=valueMap.keySet();
				for(String name: keys){
					redisClusterUtil.setObj2MapCache(request.getKey(), name, valueMap.get(name),request.getTimeOut());
				}
			}else{
				throw new IllegalArgumentException("The cache data cannot be empty");
			}
			
			response.setRespCode("0000");
			response.setRespMsg("success");
			
			} catch (Exception e) {
				log.error(request.getKey()+"加入缓存出现异常："+e.getMessage(), e);
				response.setRespCode("1111");
				response.setRespMsg("fail");
			}
		
		return response;
	}

	

	@Override
	public  GetData4CacheResponse getData4Cache(GetData4CacheRequest  request) {
	GetData4CacheResponse  response=new GetData4CacheResponse();
		
		try {
		
			if(StringUtils.isNotBlank(request.getName())){
				String josnObj=redisClusterUtil.getObj4MapCache(request.getKey(),request.getName());
				response.setJsonObj(josnObj);
			}else{
				String josnObj=redisClusterUtil.getObj4Cache(request.getKey());
				response.setJsonObj(josnObj);
			}
		
			response.setRespCode("0000");
			response.setRespMsg("success");
		
		} catch (Exception e) {
			log.error("获取缓存"+request.getKey()+"出现异常："+e.getMessage(), e);
			response.setRespCode("1111");
			response.setRespMsg("fail");
		}
		
		return response;
	}
	

	@Override
	public RemoveData4CacheResponse removeData4Cache(RemoveData4CacheRequest request) {
		
		RemoveData4CacheResponse response=new RemoveData4CacheResponse();
		try {
			
			if(request.getFileds() !=null && request.getFileds().length>0){
				redisClusterUtil.removeValues(request.getKey(),request.getFileds());
				
			}else{
				redisClusterUtil.removeValue(request.getKey());
			}
			
			response.setRespCode("0000");
			response.setRespMsg("success");
			
		} catch (Exception e) {
			
			log.error("删除"+request.getKey()+"缓存出现异常："+e.getMessage(), e);
			response.setRespCode("1111");
			response.setRespMsg("fail");
		}
			
		return response;
	}

	/**
	 * 设置缓存数据
	 * @param key
	 * @param value
	 * @param timeOut
	 * @return
	 */
	public String setCachesData(String key, String value,int timeOut){
		return this.redisClusterUtil.setCachesData(key, value, timeOut);
	}
	
	/**
	 * 获取缓存数据
	 * @param key
	 * @return
	 */
	public String getValue(String key){
		return this.redisClusterUtil.getValue(key);
	}
	/**
	 * 删除缓存
	 * @param key
	 * @return
	 */
	public long removeValue(String key){
		return this.redisClusterUtil.removeValue(key);
	}


}
