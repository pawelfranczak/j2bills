package pl.j2dev.j2bills.web.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.j2dev.j2bills.pojo.Currency;

import pl.j2dev.j2bills.web.DefaultController;

@Controller
@RequestMapping(value = "/currency")
public class CurrencyController extends DefaultController<Currency> {

	@Override
	public String getPojoName() {
		return "currency";
	}

	@Override
	public Currency getNewObject() {
		return new Currency();
	}

}
