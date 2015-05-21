package spring.chapter6.aop;

public class HelloAspect {

	public void before(){
		System.out.println("---before");
	}
	
	public void after(){
		System.out.println("---after");
	}
	
}
