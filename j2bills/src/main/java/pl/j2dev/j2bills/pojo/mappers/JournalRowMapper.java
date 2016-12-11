package pl.j2dev.j2bills.pojo.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import pl.j2dev.j2bills.dao.impl.AccountDaoImpl;
import pl.j2dev.j2bills.dao.impl.CurrencyDaoImpl;
import pl.j2dev.j2bills.dao.impl.PersonDaoImpl;
import pl.j2dev.j2bills.dao.impl.UsersDaoImpl;
import pl.j2dev.j2bills.pojo.Account;
import pl.j2dev.j2bills.pojo.Currency;
import pl.j2dev.j2bills.pojo.Journal;
import pl.j2dev.j2bills.pojo.Person;
import pl.j2dev.j2bills.pojo.Users;

@Component
public class JournalRowMapper extends AbstractRowMapper<Journal> {

	@Override
	public Journal mapRow(ResultSet rs, int rowNum) throws SQLException {
		Journal journal = new Journal();
		journal.setId(rs.getInt("id"));
		journal.setDescription(rs.getString("description"));
		journal.setValue(rs.getBigDecimal("value"));
		journal.setTimestamp(rs.getTimestamp("timestamp"));
		
		String username = rs.getString("username");
		UsersDaoImpl usersDaoImpl = context.getBean(UsersDaoImpl.class);
		Users user = usersDaoImpl.getOjectById(username);
		journal.setUsers(user);
		
		int personID = rs.getInt("person_id");
		int accountID = rs.getInt("account_id");
		int currencyID = rs.getInt("currency_id");
		
		CurrencyDaoImpl currencyDaoImpl = context.getBean(CurrencyDaoImpl.class);
		Currency currency = currencyDaoImpl.getOjectById(currencyID);
		
		AccountDaoImpl accountDaoImpl = context.getBean(AccountDaoImpl.class);
		Account account = accountDaoImpl.getOjectById(accountID);
		
		PersonDaoImpl personDaoImpl = context.getBean(PersonDaoImpl.class);
		Person person = personDaoImpl.getOjectById(personID);
		
		journal.setCurrency(currency);
		journal.setAccount(account);
		journal.setPerson(person);
		
		return journal;
	}

	
	
}
