package pl.j2dev.j2bills.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import pl.j2dev.j2bills.pojo.Users;

public abstract class DaoAbstractImpl<T> implements Dao<T> {

	@Autowired
	public JdbcOperations jdbc;
	
	@Autowired 
	protected ApplicationContext context;
	
	@Override
	public abstract T getOjectById(int id);

	@Override
	public abstract List<T> getOjects();

	@Override
	public abstract int save(T object);

	@Override
	public abstract boolean update(T object);

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
			return (Users) null;
		}
		return null;
	}

}
