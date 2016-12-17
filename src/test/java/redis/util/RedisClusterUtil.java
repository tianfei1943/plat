package redis.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import redis.clients.jedis.Connection;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import com.google.common.base.Throwables;
import com.google.common.collect.Sets;
import com.google.gson.Gson;

/**
 * redis 工具类
 * @author uatft90931
 *
 */
public class RedisClusterUtil {
    private static Logger log = Logger.getLogger(RedisClusterUtil.class);
    private int timeout = 10000;
    private JedisCluster jedisCluster;
    private Set<HostAndPort> clusterNodes ;

    public RedisClusterUtil (String redisUris, JedisPoolConfig jedisPoolConfig) throws  Exception{
        init(redisUris);
        checkHostAndPost();
        jedisCluster = new JedisCluster(clusterNodes,timeout,jedisPoolConfig);
    }
    /**
     * reids 链接节点地址
     */
    public void init(String redisUris) {
        log.info("redisUris:" + redisUris);
        // ## 注册redis连接节点
        clusterNodes = Sets.newHashSet();
        if(StringUtils.isNotBlank(redisUris)){
            // 以“；”分割成"ip:post"
            String [] ipAndPostes = redisUris.split(";");
            // 以“：”分割成 “ip”，“post”
            if(ipAndPostes != null){
                for (String ipAndPost : ipAndPostes){
                    //ipAndPost 值：(ip：端口)
                    String [] ipAndPostArray = ipAndPost.split(":");
                    clusterNodes.add(new HostAndPort(ipAndPostArray[0], Integer.parseInt(ipAndPostArray[1])));
                }
            }
        }
        log.info("redis链接节点个数(clusterNodes)：" + clusterNodes.size());
    }

    /**
     * 检查节点的ip和端口是否开通
     */
    public void checkHostAndPost() throws  Exception{
        //Set<HostAndPort> clusterNodes
        for(HostAndPort hostAndPort : clusterNodes){
            try {
                Connection connection = new Connection();
                connection.setPort(hostAndPort.getPort());
                connection.setHost(hostAndPort.getHost());
                connection.connect();
                connection.close();
            }catch (Exception e){
                //log.error("redis cluster[" + hostAndPort.getHost() + ":" + hostAndPort.getPort() + "],Exception is " + e.getMessage());
                throw new Exception("redis cluster[" + hostAndPort.getHost() + ":" + hostAndPort.getPort() + "],Exception is " + e.getMessage());
            }
        }

    }

    /**
     *  设值并设置失效时间
     * @param key       需保存的key
     * @param value     需保存的值
     * @return
     */
    public String setCachesData(String key, String value){
        return jedisCluster.set(key,value);
    }
    
    
    /**
     *  设值并设置失效时间
     * @param key       需保存的key
     * @param value     需保存的值
     * @param timeOut   失效时间
     * @return
     */
    public String setCachesData(String key, String value,int timeOut){
        String values = jedisCluster.set(key,value);
        setxpireData(key,timeOut);
        return values;
    }

    /**
     *  key是否存在
     * @param key   需验证的key
     * @return      是否
     */
    public Boolean isExistsKey(String key){
        return jedisCluster.exists(key);
    }

    /**
     * 失效
     *
     * @param key   保存的key
     * @param seconds 秒
     */
    public long setxpireData(String key, int seconds){
        return jedisCluster.expire(key, seconds);
    }

    /**
     * 从缓存中获取数据
     * @param key
     * @return
     */
    public String getValue(String key) {
        return jedisCluster.get(key);
       
    }
    

    
 
    
    
    /**
     * 将对象保存到缓存
     * @param key 缓存的key
     * @param object 缓存的对象
     * @param timeOut 缓存过期时间
     */
    public void setObj2Cache(String key,Object value,int timeOut){
    
    	String jsonObj=new Gson().toJson(value);
    	jedisCluster.set(key, jsonObj);
    	
    	if(timeOut !=-1){  //-1表示不过期
    		jedisCluster.expire(key, timeOut);
    	}
    	
    	
    }
    
    
    /**
     * 从缓存中获取对象
     * @param key 缓存的key
     * @param clazz 对象的类型
     * @return
     */
    public String getObj4Cache(String key){
    	String jsonObj=jedisCluster.get(key);
    	return jsonObj;
    	
    }
    
    
    /**
     * 将对象保存到缓存
     * @param key 缓存的key
     * @param object 缓存的对象
     * @param timeOut 缓存过期时间
     */
    public void setObj2MapCache(String key,String name,Object value,int timeOut){
    	String jsonObj=new Gson().toJson(value);
    	Map<String,String> exitsMap=jedisCluster.hgetAll(key);
    	if(exitsMap ==null){
    		exitsMap=new HashMap<String,String>();
    	}
		exitsMap.put(name, jsonObj);
    	jedisCluster.hmset(key, exitsMap);
    	if(timeOut!=-1){  //-1表示不过期
    		jedisCluster.expire(key, timeOut);
    	}
    	
    }
    
    /**
     * 通过key和name从缓存的map中获取的对象json字符串
     * @param key  redis缓存map的缓存标志
     * @param name 缓存map中对象对应的key
     * @return 返回的jons字符串
     */
    public String getObj4MapCache(String key,String name){
    	String jsonObj=jedisCluster.hget(key, name);
    	return jsonObj;
    }
    
  
    

 
    

    /**
     * 从缓存中删除数据
     * @param key
     * @return
     */
    public long removeValue(String key) {
         return jedisCluster.del(key);
    }
    
    
    /**
     * 从缓存map中中删除删除对应filed的值
     * @param key  
     * @return fileds
     */
    public long removeValues(String key,String [] fileds) {
         return jedisCluster.hdel(key,fileds);
    }
    // psvm
    public static void main(String[] args) {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // 最大连接数
        jedisPoolConfig.setMaxTotal(500);
        // 最大空闲连接数
        jedisPoolConfig.setMaxIdle(15);
        // 最小空闲连接数
        jedisPoolConfig.setMinIdle(5);
        // 获取连接最大等待时间 ms
        jedisPoolConfig.setMaxWaitMillis(1000);
        // 指明是否在从池中取出连接前进行检验，如果检验失败，则从池中去除连接并尝试去除另一个
        jedisPoolConfig.setTestOnBorrow(true);
        try{
            // redis连接节点 ;172.30.114.141:7002;172.30.114.141:7003;172.30.114.141:7004;172.30.114.141:7005;172.30.114.141:7006
            String redisUris = "172.30.114.141:7001";
            

            
            
            //FtpInfo fi2=new FtpInfo();
           // fi2.setHost("122.134.11.33");
            //fi2.setPassword("password111");
           // fis.add(fi2);
            
            //FtpInfo fi3=new FtpInfo();
            //fi3.setHost("122.134.11.33");
            //fi3.setPassword("password111");
            //fis.add(fi3);
            
            
            
           // Map<String,FtpInfo> fMap=new HashMap<String,FtpInfo>();
            
            
            RedisClusterUtil redisClusterUtil = new RedisClusterUtil(redisUris,jedisPoolConfig);
            
            
            Long num=11111L;
            String name="zhangsan";
            String pwd="dddddd";
            
            
            redisClusterUtil.setObj2MapCache("111111", "num", num,20);
            redisClusterUtil.setObj2MapCache("111111", "name", name,10);
            
            
            String num1=redisClusterUtil.getObj4MapCache("111111","num");
            System.out.println("开始获取的值为num=="+num1);
  
            name=redisClusterUtil.getObj4MapCache("111111","name");
            System.out.println("开始获取的值为name=="+name);
  
            
            Thread.sleep(1000*15);
            
            System.out.println("休眠15秒后。。。。。");
            
            String num2=redisClusterUtil.getObj4MapCache("111111","num");
            System.out.println("开始获取的值为num=="+num2);
  
            name=redisClusterUtil.getObj4MapCache("111111","name");
            System.out.println("开始获取的值为name=="+name);

          
            
       
        }catch (Exception e){
            System.out.println("异常：" + Throwables.getStackTraceAsString(e));
        }

    }
}
