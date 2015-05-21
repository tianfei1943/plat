package spring.chapter6.service.impl;

import spring.chapter6.service.IHelloWordService;

public class HelloWordService implements IHelloWordService {

	@Override
	public void sayAop() {
		System.out.println("aop");
	}
	
	@Override
	public void sayAop2() {
		System.out.println("aop2");
	}

}
