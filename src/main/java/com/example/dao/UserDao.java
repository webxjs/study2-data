package com.example.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.model.User;

@Repository
@Qualifier("userDao")
public class UserDao {
	@Autowired
    JdbcTemplate jdbcTemplate;
	
	public void addUser(User user) {
        jdbcTemplate.update("INSERT INTO t_user (id, name) VALUES (?, ?)", user.getId(), user.getName());
    }
	
	public void addHistory(String id, String action) {
		jdbcTemplate.update("INSERT INTO t_history (id, action) VALUES (?, ?)", id, action);
	}
}
