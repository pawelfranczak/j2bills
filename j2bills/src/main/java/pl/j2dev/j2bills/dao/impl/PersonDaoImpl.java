package pl.j2dev.j2bills.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.j2dev.j2bills.dao.DaoAbstractImpl;
import pl.j2dev.j2bills.pojo.Account;
import pl.j2dev.j2bills.pojo.Person;
import pl.j2dev.j2bills.pojo.Users;
import pl.j2dev.j2bills.pojo.mappers.PersonRowMapper;

@Repository
public class PersonDaoImpl extends DaoAbstractImpl<Person> {

	@Autowired
	PersonRowMapper mapper;
	
	@Override
	public Person getOjectById(int id) {
		final String sql = "SELECT * FROM person where id = ?";
		Person person = jdbc.queryForObject(sql, mapper, id);
		return person;
	}

	@Override
	public List<Person> getOjects() {
		String user = username();
		if (user == null)
			return new ArrayList<Person>();

		final String sql = "SELECT * FROM person WHERE username = ?";
		List<Person> list = jdbc.query(sql, mapper, user);
		
		return list;
	}

	@Override
	public int save(Person object) {
		Users user = getLoggedUser();
		if (user == null)
			return 0;
		
		return (int) 0;
	}

	@Override
	public boolean update(Person object) {
		// TODO Auto-generated method stub
		return false;
	}

}
