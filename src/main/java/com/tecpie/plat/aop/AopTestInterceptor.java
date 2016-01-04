package com.tecpie.plat.aop;

import org.aspectj.lang.ProceedingJoinPoint;

import com.tecpie.plat.domain.User;

public class AopTestInterceptor {

	private int flag = 1;
	/**
	 * 配置aop 环绕
	 * @param pjp
	 * @return
	 * @throws Throwable 
	 */
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("进入兰解放");
		if(flag == 1){
			Object obj = pjp.proceed();
			return obj;
		}
		User user = new User();
		user.setUsername("susu");
		return user;
	}
	
	public void setFlag(int flag) {
		this.flag = flag;
	}
	
	
	
}
