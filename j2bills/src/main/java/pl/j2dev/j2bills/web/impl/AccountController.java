package pl.j2dev.j2bills.web.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.j2dev.j2bills.pojo.Account;
import pl.j2dev.j2bills.web.DefaultController;

@Controller
@RequestMapping(value = "/account")
public class AccountController extends DefaultController<Account> {

	@Override
	public String getPojoName() {
		return "account";
	}

	@Override
	public Account getNewObject() {
		return new Account();
	}

}
