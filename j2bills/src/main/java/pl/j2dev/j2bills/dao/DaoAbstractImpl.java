package pl.j2dev.j2bills.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import pl.j2dev.j2bills.pojo.Users;

public abstract class DaoAbstractImpl<T> implements Dao<T> {

	protected SessionFactory sessionFactory;

	@Inject
	public DaoAbstractImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public abstract T getOjectById(int id);

	@Override
	public abstract T getObjectByKey(String key);

	@Override
	public abstract List<T> getOjects();

	@Override
	public abstract int save(T object);

	@Override
	public abstract boolean update(T object);

	@Override
	public Session currentSession() {
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
		return session;
	}

	@Override
	public SecurityContext securityContext() {
		return SecurityContextHolder.getContext();
	}

	@Override
	public Authentication authentication() {
		if (securityContext() != null)
			return securityContext().getAuthentication();
		return null;
	}

	@Override
	public String username() {
		Authentication authentication = authentication();
		if (authentication != null) {
			return authentication.getName();
		}
		return null;
	}

	@Override
	public Users getLoggedUser() {
		String username = username();
		if (username != null) {
			return (Users) currentSession().get(Users.class, username);
		}
		return null;
	}

}
