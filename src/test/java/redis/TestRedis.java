package redis;

import lombok.extern.slf4j.Slf4j;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import redis.service.RedisCacheService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/redis/config/spring-redis.xml"})
@Slf4j
public class TestRedis {

	@Autowired
	private RedisCacheService redisCacheService;
	
	@Test
	public void test() {
		redisCacheService.setCachesData("key", "val1", 120);
		String val = redisCacheService.getValue("key");
		if(val.equals("val1")){
			log.info("获取缓存success");
		}
	}

}
