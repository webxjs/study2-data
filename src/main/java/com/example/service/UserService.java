package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.UserDao;
import com.example.dao.UserRepo;
import com.example.model.User;

@Service
public class UserService {
	@Autowired
	private UserRepo userRepo;
	
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
		userDao.addHistory(user.id, "create");
	}

	public List<User> getUsers() {
		List<User> list = new ArrayList<User>();
		userRepo.findAll().forEach(list::add);
		return list;
	}
}
