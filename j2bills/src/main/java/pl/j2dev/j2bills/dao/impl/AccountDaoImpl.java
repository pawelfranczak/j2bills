package pl.j2dev.j2bills.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.j2dev.j2bills.dao.DaoAbstractImpl;
import pl.j2dev.j2bills.pojo.Account;
import pl.j2dev.j2bills.pojo.mappers.AccountRowMapper;

@Repository
public class AccountDaoImpl extends DaoAbstractImpl<Account> {

	@Autowired
	AccountRowMapper mapper;
	
	@Override
	public Account getOjectById(int id) {
		final String sql = "SELECT * FROM account where id = ?";
		Account account = jdbc.queryForObject(sql, mapper, id);
		return account;
	}

	@Override
	public List<Account> getOjects() {
		String user = username();
		if (user == null)
			return new ArrayList<Account>();

		final String sql = "SELECT * FROM account WHERE username = ?";
		List<Account> list = jdbc.query(sql, mapper, user);
		
		return list;
	}

	@Override
	public int save(Account object) {
		String user = username();
		if (user == null)
			return 0;
		
		final String sql = "INSERT INTO account (username, accountname, description, balance) values (?, ?, ?, ?)";
		jdbc.update(sql, user, object.getAccountName(), object.getDescription(), BigDecimal.ZERO);
		
		return 0;
	}

	@Override
	public boolean update(Account object) {
		final String sql = "UPDATE account SET accountname = ?, description = ?, balance = ? where id = ?";
		jdbc.update(sql, object.getAccountName(), object.getDescription(), object.getBalance(), object.getId());
		return true;
	}


}
