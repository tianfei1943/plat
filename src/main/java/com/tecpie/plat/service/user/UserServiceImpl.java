package com.tecpie.plat.service.user;

import org.springframework.stereotype.Service;

import com.tecpie.plat.domain.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Override
	public User getUser(String username){
		System.out.println("start getUser()---");
		User user = new User();
		user.setUsername("tian");
		user.setAge(22);
		return user;
	}
	
}
