package pl.j2dev.j2bills.dao.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Repository;

import pl.j2dev.j2bills.dao.DaoAbstractImpl;
import pl.j2dev.j2bills.pojo.Account;
import pl.j2dev.j2bills.pojo.Users;

@Repository
public class AccountDaoImpl extends DaoAbstractImpl<Account> {

	public AccountDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
		// TODO Auto-generated constructor stub
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
		if (securityContext() == null)
			return new ArrayList<Account>();
		
		Authentication authentication = securityContext().getAuthentication();
		String user = authentication.getName();

		Criteria criterion = currentSession().createCriteria(Account.class);
		criterion.add(Restrictions.eq("users.username", user));
		
		@SuppressWarnings("unchecked")
		List<Account> list = criterion.list();
		
		return list;
	}

	@Override
	public int save(Account object) {
		if (securityContext() == null)
			return 0;
		Authentication authentication = securityContext().getAuthentication();
		String user = authentication.getName();
		
		object.setBalance(BigDecimal.ZERO);
		object.setUsers( (Users)currentSession().load(Users.class, user));
		
		System.out.println("NEW USER " + object);
		
		Serializable id = currentSession().save(object);
		return (int) id;
	}

	@Override
	public boolean update(Account object) {
		// TODO Auto-generated method stub
		return false;
	}

}
