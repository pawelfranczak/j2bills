package pl.j2dev.j2bills.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import pl.j2dev.j2bills.dao.DaoAbstractImpl;
import pl.j2dev.j2bills.pojo.Currency;


@Repository
public class CurrencyDaoImpl extends DaoAbstractImpl<Currency> {

	public CurrencyDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@Override
	public Currency getOjectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Currency getObjectByKey(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Currency> getOjects() {
		@SuppressWarnings("unchecked")
	
		List<Currency> list = currentSession().createCriteria(Currency.class)
			.add( Restrictions.eq("active", true))
			.list();
		
		return list;
	}

	@Override
	public int save(Currency object) {
		System.out.println("try to save account " + object);

		object.setActive(true);
		
		Serializable id = currentSession().save(object);
		
		return (int) id;
	}

	@Override
	public boolean update(Currency object) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
