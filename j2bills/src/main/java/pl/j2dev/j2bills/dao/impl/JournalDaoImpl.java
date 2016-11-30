package pl.j2dev.j2bills.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import pl.j2dev.j2bills.dao.DaoAbstractImpl;
import pl.j2dev.j2bills.pojo.Account;
import pl.j2dev.j2bills.pojo.Journal;

@Repository
public class JournalDaoImpl extends DaoAbstractImpl<Journal> {

	public JournalDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Journal getOjectById(int id) {
		return (Journal) currentSession().load(Journal.class, id);
	}

	@Override
	public Journal getObjectByKey(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Journal> getOjects() {
		String user = username();
		if (user == null)
			return new ArrayList<Journal>();
		
		Criteria criterion = currentSession().createCriteria(Journal.class);
		criterion.add(Restrictions.eq("users.username", user));
		
		@SuppressWarnings("unchecked")
		List<Journal> list = criterion.list();
		
		return list;
	}

	@Override
	public int save(Journal object) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean update(Journal object) {
		// TODO Auto-generated method stub
		return false;
	}

}
