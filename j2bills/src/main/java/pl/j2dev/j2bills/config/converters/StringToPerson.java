package pl.j2dev.j2bills.config.converters;

import org.springframework.core.convert.converter.Converter;

import pl.j2dev.j2bills.pojo.Person;

public class StringToPerson implements Converter<String, Person> {

	@Override
	public Person convert(String source) {
		Person p = new Person();
		p.setId(Integer.parseInt(source));
		return p;
	}

}