package pl.j2dev.j2bills.web.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.j2dev.j2bills.dao.impl.AccountDaoImpl;
import pl.j2dev.j2bills.dao.impl.CurrencyDaoImpl;
import pl.j2dev.j2bills.dao.impl.JournalDaoImpl;
import pl.j2dev.j2bills.dao.impl.PersonDaoImpl;
import pl.j2dev.j2bills.dao.impl.UsersDaoImpl;
import pl.j2dev.j2bills.pojo.Journal;
import pl.j2dev.j2bills.web.DefaultController;

@Controller
@RequestMapping(value = "/journal")
public class JournalController extends DefaultController<Journal> {

	@Override
	public String getPojoName() {
		return "journal";
	}

	@Override
	public Journal getNewObject() {
		return new Journal();
	}
	
	@Autowired
	UsersDaoImpl userDao;
	
	@Autowired
	AccountDaoImpl accountDao;
	
	@Autowired
	PersonDaoImpl personDao;
	
	@Autowired
	CurrencyDaoImpl currencyDao;
	
	@Override
	@RequestMapping(value = "/addForm", method = RequestMethod.GET)
	public String addForm(Model model) {
		model.addAttribute(getPojoName(), getNewObject());
		
		model.addAttribute(userDao.getOjects());
		model.addAttribute(accountDao.getOjects());
		model.addAttribute(personDao.getOjects());
		model.addAttribute(currencyDao.getOjects());
		
		return getPojoName().toLowerCase() + "/addForm";
	}
	
}
