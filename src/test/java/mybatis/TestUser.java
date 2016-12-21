package mybatis;

import lombok.extern.slf4j.Slf4j;
import mybatis.mapper.UserMapper;
import mybatis.model.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration({"classpath:mybatis/spring-mybatis.xml"})  
public class TestUser {
	
	@Autowired
	UserMapper mapper;

	@Test
	public void test() {
		//ApplicationContext factory = new ClassPathXmlApplicationContext("mybatis/dataSource.xml");
		//UserMapper mapper = (UserMapper) factory.getBean("userMapper");
		log.info("userMapper:"+mapper.toString());
		//add
		User user = new User();
		user.setUserAddress("上海");
		user.setUserName("tianfei");
		int p= mapper.insert(user);
		log.info("insert-return:{}",p);
		
		//update
		User user2 = new User();
		user2.setUserAddress("上海t");
		user2.setUserName("tianfeit");
		user2.setUserId(1);
		int y = mapper.updateByPrimaryKeySelective(user2);
		log.info("update-return:{}",y);
	}

}
