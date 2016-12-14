package pl.j2dev.j2bills.config.converters;

import org.springframework.core.convert.converter.Converter;

import pl.j2dev.j2bills.pojo.Currency;

public class StringToCurrency implements Converter<String, Currency> {

	@Override
	public Currency convert(String source) {
		Currency c = new Currency();
		c.setId(Integer.parseInt(source));
		return c;
	}

}
