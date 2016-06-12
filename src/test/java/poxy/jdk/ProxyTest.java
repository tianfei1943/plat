package poxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.junit.Test;

public class ProxyTest {

	@Test
	public void test() {
		HelloWordHandle h = new HelloWordHandle();
		//创建动态代理对象
		IHelloWrod proxy = (IHelloWrod)h.getProxyObject(new HelloWord());
		int x = proxy.sayHelloWord("tian");
		System.out.println(x);
		
	}

}
