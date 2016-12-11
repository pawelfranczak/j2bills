package pl.j2dev.j2bills.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.j2dev.j2bills.dao.DaoAbstractImpl;
import pl.j2dev.j2bills.pojo.Journal;
import pl.j2dev.j2bills.pojo.mappers.JournalRowMapper;

@Repository
public class JournalDaoImpl extends DaoAbstractImpl<Journal> {

	@Autowired
	JournalRowMapper mapper;
	
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean update(Journal object) {
		// TODO Auto-generated method stub
		return false;
	}

}
