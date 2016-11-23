package pl.j2dev.j2bills.web.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.j2dev.j2bills.pojo.Person;
import pl.j2dev.j2bills.web.DefaultController;

@Controller
@RequestMapping(value = "/person")
public class PersonController extends DefaultController<Person> {

	@Override
	public String getPojoName() {
		return "person";
	}

	@Override
	public Person getNewObject() {
		return new Person();
	}

}
