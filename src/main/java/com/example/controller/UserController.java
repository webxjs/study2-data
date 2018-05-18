package com.example.controller;


import java.util.List;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public void create(@RequestBody User user) {
		userService.create(user);
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<User> getUsers() {
		return userService.getUsers();
	}
	
	@RequestMapping("/hello")
	public String hello() {
		return "123";
	}
	
	@Scheduled(fixedDelay=500)
	public void doSomething() {
	  System.out.println("schedule.........................");
	}
}
