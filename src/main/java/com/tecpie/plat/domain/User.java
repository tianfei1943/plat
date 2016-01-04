package com.tecpie.plat.domain;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 2154355482042975723L;
	
	private String username;
	
	private int age;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", age=" + age + "]";
	}
	
	
	
}
