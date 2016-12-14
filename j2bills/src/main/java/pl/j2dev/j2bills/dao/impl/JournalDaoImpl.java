package pl.j2dev.j2bills.dao.impl;

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
import pl.j2dev.j2bills.pojo.Journal;
import pl.j2dev.j2bills.pojo.mappers.JournalRowMapper;

@Repository
public class JournalDaoImpl extends DaoAbstractImpl<Journal> {

	@Autowired
	JournalRowMapper mapper;
	
	@Autowired
	AccountDaoImpl accountDaoImpl;
	
	@Override
	public Journal getOjectById(int id) {
		final String sql = "SELECT * FROM journal WHERE id = ?";
		Journal journal = jdbc.queryForObject(sql, mapper, id);
		return journal;
	}

	@Override
	public List<Journal> getOjects() {
		String user = username();
		if (user == null)
			return new ArrayList<Journal>();
		final String sql = "SELECT * FROM journal WHERE username = ?";
		List<Journal> query = jdbc.query(sql, mapper, username());
		return query;
	}

	@Override
	public int save(Journal object) {
		System.out.println("Próbuje dodaæ wpis do dziennika");
		String user = username();
		if (user == null)
			return 0;
		
		final String sql = "INSERT INTO journal(username, person_id, account_id, currency_id, value, description, timestamp) " + 
		"values (?, ?, ?, ?, ?, ?, ?)";
		
		KeyHolder key = new GeneratedKeyHolder();
		
		jdbc.update(
		
				new PreparedStatementCreator() {
					
					@Override
					public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
						PreparedStatement ps = con.prepareStatement(sql);
						ps.setString(1, user);
						// those object are delivered only with id by mappers
						ps.setInt(2, object.getPerson().getId());
						ps.setInt(3, object.getAccount().getId());
						ps.setInt(4, object.getCurrency().getId());
						// end
						ps.setBigDecimal(5, object.getValue());
						ps.setString(6, object.getDescription());
						ps.setTimestamp(7, new java.sql.Timestamp(new java.util.Date().getTime()));
						System.out.println(ps.toString());
						return ps;
					}
				}, key
				
		);
		
		// update account balance
		Account account = accountDaoImpl.getOjectById(object.getAccount().getId());
		account.setBalance(account.getBalance().add(object.getValue()));
		accountDaoImpl.update(account);
		
		System.out.println("Dodany wpis do dziennika ma id " + key.getKey().intValue());
		
		return key.getKey().intValue();
	}

	@Override
	public boolean update(Journal object) {
		// TODO Auto-generated method stub
		return false;
	}

}
