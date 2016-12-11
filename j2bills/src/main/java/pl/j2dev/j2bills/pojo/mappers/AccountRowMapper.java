package pl.j2dev.j2bills.pojo.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import pl.j2dev.j2bills.dao.impl.UsersDaoImpl;
import pl.j2dev.j2bills.pojo.Account;
import pl.j2dev.j2bills.pojo.Users;

@Component
public class AccountRowMapper extends AbstractRowMapper<Account> {
	
	@Override
	public Account mapRow(ResultSet set, int arg1) throws SQLException {
		Account account = new Account();
		account.setId(set.getInt("id"));
		account.setAccountName(set.getString("accountname"));
		account.setDescription(set.getString("description"));
		account.setBalance(set.getBigDecimal("balance"));
		
		String username = set.getString("username");
		UsersDaoImpl usersDaoImpl = context.getBean(UsersDaoImpl.class);
		Users user = usersDaoImpl.getOjectById(username);
		account.setUsers(user);
		
		return account;
	}
	
}
