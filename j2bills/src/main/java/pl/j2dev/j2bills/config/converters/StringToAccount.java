package pl.j2dev.j2bills.config.converters;

import org.springframework.core.convert.converter.Converter;

import pl.j2dev.j2bills.pojo.Account;
import pl.j2dev.j2bills.pojo.Currency;

public class StringToAccount  implements Converter<String, Account> {

	@Override
	public Account convert(String source) {
		Account a = new Account();
		a.setId(Integer.parseInt(source));
		return a;
	}

}