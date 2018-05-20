package com.example.jdbc.controller;


import java.util.List;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jdbc.model.User;
import com.example.jdbc.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/jdbc/user", method = RequestMethod.POST)
	public void create(@RequestBody User user) {
		userService.create(user);
	}
	
	@RequestMapping(value = "/jdbc/users", method = RequestMethod.GET)
	public List<User> getUsers() {
		return userService.getUsers();
	}
	
	@RequestMapping("/jdbc/hello")
	public String hello() {
		return "123";
	}
}
