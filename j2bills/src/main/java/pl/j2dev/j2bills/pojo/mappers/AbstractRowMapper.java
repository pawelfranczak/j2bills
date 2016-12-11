package pl.j2dev.j2bills.pojo.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

public abstract class AbstractRowMapper<T> implements RowMapper<T> {

	@Autowired 
	protected ApplicationContext context;
	
	@Override
	abstract public T mapRow(ResultSet rs, int rowNum) throws SQLException;

}
