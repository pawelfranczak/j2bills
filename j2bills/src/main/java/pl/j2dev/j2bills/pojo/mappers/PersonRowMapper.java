package pl.j2dev.j2bills.pojo.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import pl.j2dev.j2bills.dao.impl.UsersDaoImpl;
import pl.j2dev.j2bills.pojo.Person;
import pl.j2dev.j2bills.pojo.Users;

@Component
public class PersonRowMapper extends AbstractRowMapper<Person> {

	@Override
	public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
		Person person = new Person();
		person.setId(rs.getInt("id"));
		person.setFirstName(rs.getString("firstname"));
		person.setLastName(rs.getString("lastname"));
		
		String username = rs.getString("username");
		UsersDaoImpl usersDaoImpl = context.getBean(UsersDaoImpl.class);
		Users user = usersDaoImpl.getOjectById(username);
		person.setUsers(user);
		
		return person;
	}
	
}
