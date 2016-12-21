package mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import mybatis.mapper.UserMapper;
import mybatis.model.User;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
public class Client {

	public static void main(String[] args) {

		ApplicationContext factory = new ClassPathXmlApplicationContext("mybatis/spring-mybatis.xml");
		
		UserMapper mapper = (UserMapper) factory.getBean("userMapper");
		log.info("userMapper:"+mapper.toString());
		//add
		User user = new User();
		user.setUserAddress("张三");
		user.setUserName("tianfei");
		int x = mapper.insert(user);
		log.info("insert-return:{}",x);
		
		//update
		User user2 = new User();
		user2.setUserAddress("222");
		user2.setUserName("省");
		user2.setUserId(1);
		int y = mapper.updateByPrimaryKeySelective(user2);
		log.info("update-return:{}",y);
		
	}
	

}
