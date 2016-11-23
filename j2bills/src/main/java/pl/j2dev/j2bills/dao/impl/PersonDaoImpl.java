package pl.j2dev.j2bills.dao.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import pl.j2dev.j2bills.dao.DaoAbstractImpl;
import pl.j2dev.j2bills.pojo.Account;
import pl.j2dev.j2bills.pojo.Person;
import pl.j2dev.j2bills.pojo.Users;

@Repository
public class PersonDaoImpl extends DaoAbstractImpl<Person> {

	public PersonDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@Override
	public Person getOjectById(int id) {
		return (Person) currentSession().load(Person.class, id);
	}

	@Override
	public Person getObjectByKey(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> getOjects() {
		String user = username();
		if (user == null)
			return new ArrayList<Person>();
		
		Criteria criterion = currentSession().createCriteria(Person.class);
		criterion.add(Restrictions.eq("users.username", user));
		
		@SuppressWarnings("unchecked")
		List<Person> list = criterion.list();
		
		return list;
	}

	@Override
	public int save(Person object) {
		Users user = getLoggedUser();
		if (user == null)
			return 0;
		
		object.setUsers( user );
		
		Serializable id = currentSession().save(object);
		return (int) id;
	}

	@Override
	public boolean update(Person object) {
		// TODO Auto-generated method stub
		return false;
	}

}
