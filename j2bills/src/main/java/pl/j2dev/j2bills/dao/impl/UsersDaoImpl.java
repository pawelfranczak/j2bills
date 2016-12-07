package pl.j2dev.j2bills.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcOperations;

import pl.j2dev.j2bills.dao.DaoAbstractImpl;
import pl.j2dev.j2bills.pojo.Users;
import pl.j2dev.j2bills.pojo.mappers.UserRowMapper;

public class UsersDaoImpl extends DaoAbstractImpl<Users> {
	
	@Override
	@Deprecated
	//"For USERS use this method with String parameter"
	public Users getOjectById(int id) {
		return null;
	}
	
	public Users getOjectById(String id) {
		final String sql = "SELECT * FROM users where username = ?";
		Users user = jdbc.queryForObject(sql, new UserRowMapper(), id);
		return user;
	}

	@Override
	public List<Users> getOjects() {
		final String sql = "SELECT * FROM users";
		List<Users> list = jdbc.query(sql, new UserRowMapper());
		return list;
	}

	@Override
	public int save(Users object) {
		final String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
		jdbc.update(sql, object.getUsername(), object.getPassword());
		return 0;
	}

	@Override
	public boolean update(Users object) {
		final String sql = "UPDATE users SET password = ?, enabled = ? where username = ?";
		jdbc.update(sql, object.getPassword(), object.isEnabled(), object.getUsername());
		return true;
	}

}
