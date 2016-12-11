package pl.j2dev.j2bills.web.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
}
