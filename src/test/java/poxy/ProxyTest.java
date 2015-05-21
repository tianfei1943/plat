package poxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.junit.Test;

public class ProxyTest {

	@Test
	public void test() {
		IHelloWrod helloWord = new HelloWord();
		InvocationHandler h = new HelloWordHandle(helloWord);
		//创建动态代理对象
		IHelloWrod proxy = (IHelloWrod)Proxy.newProxyInstance(helloWord.getClass().getClassLoader(), helloWord.getClass().getInterfaces(), h);
		int x = proxy.sayHelloWord("tian");
		System.out.println(x);
		
	}

}
