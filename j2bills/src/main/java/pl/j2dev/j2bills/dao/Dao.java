package pl.j2dev.j2bills.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;



/**
 * This interface is root inerface for dao class in basic package.
 * Every other (unless otherwise stated) should implements this interface.
 * 
 * @author Pawe³ Franczak
 *
 * @param <T> pojo class for which DAO will be parametrized.
 */
public interface Dao<T> {

	/**
	 * Search in database for object of {@link T} type using field id.
	 * @param id number of object in database which could be returned<BR>can't be null
	 * @return filled object {@link T} if found, else null
	 */

	public T getOjectById(int id);
	
	/**
	 * Search in database for object of {@link T} type using field key.
	 * @param key of object in database which could be returned<BR>can't be null
	 * @return filled object {@link T} if found, else null
	 */
	T getObjectByKey(String key);
	
	/**
	 * @return every object of {@link T} type from database
	 */
	List<T> getOjects();
	
	/**
	 * Save object in database
	 * @param product filled object of {@link T} type<BR>can't be null
	 * @return id of created record, 0 if error
	 */
	int save(T object);
	
	/**
	 * Update object in database
	 * @param product object with fields to update<BR>can't be null
	 * @return true if updating success, false if failed
	 */
	boolean update(T object);
	
	/**
	 * @return current hibernate session
	 */
	Session currentSession();
	
}
