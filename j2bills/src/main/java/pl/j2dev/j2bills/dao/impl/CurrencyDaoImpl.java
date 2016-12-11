package pl.j2dev.j2bills.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
		return (int) 0;
	}

	@Override
	public boolean update(Currency object) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
