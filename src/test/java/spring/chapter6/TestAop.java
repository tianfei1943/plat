package spring.chapter6;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.chapter6.service.IHelloWordService;

public class TestAop {

private static ApplicationContext context;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("spring/chapter6/helloWord.xml");
	}

	@Test
	public void test() {
		IHelloWordService helloword = context.getBean("helloWordService",IHelloWordService.class);
		helloword.sayAop();
		
	}
	
	@Test
	public void test2() {
		IHelloWordService helloword = context.getBean("helloWordService",IHelloWordService.class);
		helloword.sayAop2();
	}
}
