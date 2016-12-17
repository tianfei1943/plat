package mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
public class Client {

	public static void main(String[] args) {

		ApplicationContext factory = new ClassPathXmlApplicationContext("mybatis/dataSource.xml");
		
		UserMapper mapper = (UserMapper) factory.getBean("userMapper");
		//add
		User user = new User();
		user.setUserAddress("上海");
		user.setUserName("tianfei");
		int p= mapper.insert(user);
		
		//update
		User user2 = new User();
		user2.setUserAddress("上海t");
		user2.setUserName("tianfeit");
		user2.setUserId(p);
		mapper.updateByPrimaryKeySelective(user2);
		
	}
	

}
