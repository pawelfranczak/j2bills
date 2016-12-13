package pl.j2dev.j2bills.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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

		KeyHolder key = new GeneratedKeyHolder();

		final String sql = "INSERT INTO account (username, accountname, description, balance) values (?, ?, ?, ?)";
		jdbc.update(

				new PreparedStatementCreator() {

					@Override
					public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
						PreparedStatement ps = con.prepareStatement(sql, new String[] {"id"});
						ps.setString(1, user);
						ps.setString(2, object.getAccountName());
						ps.setString(3, object.getDescription());
						ps.setBigDecimal(4, BigDecimal.ZERO);
						return ps;
					}
				},
			key
		);
		
		System.out.println("Dodane konto ma id " + key.getKey().intValue());

		return key.getKey().intValue();
	}

	@Override
	public boolean update(Account object) {
		final String sql = "UPDATE account SET accountname = ?, description = ?, balance = ? where id = ?";
		jdbc.update(sql, object.getAccountName(), object.getDescription(), object.getBalance(), object.getId());
		return true;
	}

}
