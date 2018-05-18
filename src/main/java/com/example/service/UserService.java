package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserRepo;
import com.example.model.User;

@Service
public class UserService {
	@Autowired
	private UserRepo userRepo;

	public void create(User user) {
		userRepo.save(user);
	}

	public List<User> getUsers() {
		List<User> list = new ArrayList<User>();
		userRepo.findAll().forEach(list::add);
		return list;
	}
}
