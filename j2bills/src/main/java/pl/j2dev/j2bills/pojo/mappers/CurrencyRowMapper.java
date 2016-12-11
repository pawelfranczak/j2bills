package pl.j2dev.j2bills.pojo.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import pl.j2dev.j2bills.pojo.Currency;

@Component
public class CurrencyRowMapper extends AbstractRowMapper<Currency> {

	@Override
	public Currency mapRow(ResultSet rs, int rowNum) throws SQLException {
		Currency currency = new Currency();
		currency.setId(rs.getInt("id"));
		currency.setIso4217(rs.getString("iso4217"));
		currency.setActive(rs.getBoolean("active"));
		return currency;
	}

	
	
}
