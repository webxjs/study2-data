package com.example.jdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.example.jdbc.dao.UserDao;
import com.example.jdbc.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;


//	@Transactional(isolation=Isolation.READ_UNCOMMITTED)
//	could read uncommitted change on the row
	
//	@Transactional(isolation=Isolation.READ_COMMITTED)
//	lock the row	
	
	@Transactional(isolation=Isolation.REPEATABLE_READ) 
//	lock the row
	
//	@Transactional(isolation=Isolation.SERIALIZABLE) 
//	use it if it has to lock the whole table, such as doing sum, count
	public void create(User user) {
		userDao.addUser(user);
	}

	public List<User> getUsers() {
		return userDao.getUsers();
	}
}
