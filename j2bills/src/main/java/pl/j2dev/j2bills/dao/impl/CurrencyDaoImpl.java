package pl.j2dev.j2bills.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import pl.j2dev.j2bills.dao.DaoAbstractImpl;
import pl.j2dev.j2bills.pojo.Account;
import pl.j2dev.j2bills.pojo.Currency;
import pl.j2dev.j2bills.pojo.mappers.CurrencyRowMapper;


@Repository
public class CurrencyDaoImpl extends DaoAbstractImpl<Currency> {

	@Autowired
	CurrencyRowMapper mapper;
	
	@Override
	public Currency getOjectById(int id) {
		final String sql = "SELECT * FROM currency where id = ?";
		Currency currency = jdbc.queryForObject(sql, mapper, id);
		return currency;
	}


	@Override
	public List<Currency> getOjects() {
		final String sql = "SELECT * FROM currency";
		List<Currency> list = jdbc.query(sql, mapper);
		return list;
	}

	@Override
	public int save(Currency object) {
		final String sql = "INSERT INTO currency (iso4217) values (?)";
		
		KeyHolder key = new GeneratedKeyHolder();
		
		jdbc.update(
		
			new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement ps = con.prepareStatement(sql, new String[] {"id"});
					ps.setString(1, object.getIso4217());
					return ps;
				}
			},
			
			key
				
		);
		
		System.out.println("Dodana waluta ma klucz " + key.getKey().intValue());
		
		return key.getKey().intValue();
	}

	@Override
	public boolean update(Currency object) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
