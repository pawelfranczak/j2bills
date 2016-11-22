package pl.j2dev.j2bills.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import pl.j2dev.j2bills.dao.DaoAbstractImpl;
import pl.j2dev.j2bills.pojo.Account;

@Repository
public class AccountDaoImpl extends DaoAbstractImpl<Account> {

	public AccountDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Account getOjectById(int id) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean update(Account object) {
		// TODO Auto-generated method stub
		return false;
	}

}
