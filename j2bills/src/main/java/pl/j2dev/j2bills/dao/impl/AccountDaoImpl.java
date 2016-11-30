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
import pl.j2dev.j2bills.pojo.Users;

@Repository
public class AccountDaoImpl extends DaoAbstractImpl<Account> {

	public AccountDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@Override
	public Account getOjectById(int id) {
		return (Account) currentSession().load(Account.class, id);
	}

	@Override
	public Account getObjectByKey(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> getOjects() {
		String user = username();
		if (user == null)
			return new ArrayList<Account>();
		
		Criteria criterion = currentSession().createCriteria(Account.class);
		criterion.add(Restrictions.eq("users.username", user));
		
		@SuppressWarnings("unchecked")
		List<Account> list = criterion.list();
		
		return list;
	}

	@Override
	public int save(Account object) {
		Users user = getLoggedUser();
		if (user == null)
			return 0;
		
		object.setBalance(BigDecimal.ZERO);
		object.setUsers( user );
		
		Serializable id = currentSession().save(object);
		return (int) id;
	}

	@Override
	public boolean update(Account object) {
		// TODO Auto-generated method stub
		return false;
	}

}
