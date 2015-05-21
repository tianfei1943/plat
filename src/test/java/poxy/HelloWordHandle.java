package poxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 实现在方法调用前后向控制台输出两句字符串
 * @author Administrator
 *
 */
public class HelloWordHandle implements InvocationHandler {

	//要代理的原始对象
	private Object object;

	public HelloWordHandle(Object object) {
		super();
		this.object = object;
	}

	/**
	* 在代理实例上处理方法调用并返回结果
	* @param proxy 代理类
	* @param method 被代理的方法
	* @param args 该方法的参数数组
	*/
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object result;
		//调用之前
		this.before();
		//调用原始对象的方法
		result = method.invoke(object, args);
		//调用之后
		this.after();
		return result;
	}
	
	private void before(){
		System.out.println("----befor");
	}
	
	private void after(){
		System.out.println("----after");
	}

}
