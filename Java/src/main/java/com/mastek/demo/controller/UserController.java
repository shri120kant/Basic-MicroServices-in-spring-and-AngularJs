package com.mastek.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mastek.demo.model.User;
import com.mastek.demo.repository.UserRepository;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class UserController {
	
	@Autowired(required=true)
	UserRepository repository;
	
//	@GetMapping("/")
//	public User home() {
//		return new User("User1","*****");
//	}
//	
//	@GetMapping("/user/{user_name}")
//	public User findById(@PathVariable String user_name) {
//		return repository.findById(user_name);
//	}
	
	@GetMapping(path="/users", produces="application/json")
	public List<User> findAll(){
		return repository.findAll();
	}
}
