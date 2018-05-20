package com.example.jdbc.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.jdbc.model.User;

@Repository
@Qualifier("userDao")
public class UserDao {
	@Autowired
    JdbcTemplate jdbcTemplate;
	
	public void addUser(User user) {
        jdbcTemplate.update("INSERT INTO t_user (id, name) VALUES (?, ?)", user.getId(), user.getName());
    }
	
	public List<User> getUsers() {
		String sql = "SELECT * FROM t_user";
		 
		List<User> users = new ArrayList<User>();
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		for (Map row : rows) {
			User user = new User();
			user.setId(row.get("id").toString());
			user.setName(row.get("name").toString());
			users.add(user);
		}
		return users;
	}
}
