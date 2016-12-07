package pl.j2dev.j2bills.pojo.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pl.j2dev.j2bills.pojo.Users;

public class UserRowMapper implements RowMapper<Users> {

	@Override
	public Users mapRow(ResultSet data, int arg1) throws SQLException {
		Users user = new Users();
		user.setUsername(data.getString("username"));
		user.setPassword(data.getString("password"));
		user.setEnabled(data.getBoolean("enabled"));
		return user;
	}
	
}
