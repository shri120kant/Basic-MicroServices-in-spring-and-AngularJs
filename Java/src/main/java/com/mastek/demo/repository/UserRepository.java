package com.mastek.demo.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mastek.demo.model.User;

@Repository
public class UserRepository {

	private static final List<User> USER_LIST=
			Arrays.asList(
				new User("shri120kant.g@gmail.com","123456"),
				 new User("shri.g@gmail.com","123456"),
				  new User("shrikant.g@gmail.com","123456"));
						 
	
	public User findById(String userName) {
		return USER_LIST.stream()
				.filter(user->user.getUser_name().equals(userName))
				.findFirst()
				.get();
	}
	public List<User> findAll(){
		return USER_LIST;
	}
}
