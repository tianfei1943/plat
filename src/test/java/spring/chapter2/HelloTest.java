package spring.chapter2;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloTest {

	private static ApplicationContext context;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("spring/chapter2/helloWord.xml");
	}

	@Test
	public void test() {
		IHelloWord helloword = context.getBean("helloWord",IHelloWord.class);
		helloword.say();
		
	}
}
