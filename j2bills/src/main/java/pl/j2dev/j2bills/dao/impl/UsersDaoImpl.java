package pl.j2dev.j2bills.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import pl.j2dev.j2bills.dao.DaoAbstractImpl;
import pl.j2dev.j2bills.pojo.Users;

public class UsersDaoImpl extends DaoAbstractImpl<Users> {
	
	public UsersDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@Override
	public Users getOjectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users getObjectByKey(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Users> getOjects() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(Users object) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean update(Users object) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
