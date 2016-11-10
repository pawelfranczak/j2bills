package pl.j2dev.j2bills.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.j2dev.j2bills.dao.Dao;

public abstract class DefaultController<T> {

	@Autowired
	Dao<T> dao;
	
	public abstract String getPojoName();
	public abstract T getNewObject();
	
	@RequestMapping(value = "/addForm", method = RequestMethod.GET)
	public String addForm(Model model) {
		model.addAttribute(getPojoName(), getNewObject());
		return getPojoName().toLowerCase() + "/addForm";
	}
	
	@RequestMapping(value = "/addForm", method = RequestMethod.POST)
	public String addFormPOST(T object) {
		long id = dao.save(object);
		return "redirect:/" + getPojoName().toLowerCase() + "/added/" + id;
	}
	
	@RequestMapping(value = "/added/{id}", method = RequestMethod.GET)
	public String addedObjectToDatabase(Model model, @PathVariable int id) {
		T object = dao.getOjectById(id);
		if (object != null)
			model.addAttribute(object);
		return getPojoName().toLowerCase() + "/added";
	}
	
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String show(Model model) {
		model.addAttribute(dao.getOjects());
		return getPojoName().toLowerCase() + "/show";
	}
	
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public String showOne(@PathVariable int id, Model model) {
		T object = dao.getOjectById(id);
		List<T> list = new ArrayList<T>();
		if (object != null)
			list.add(object);
		model.addAttribute(list);
		return getPojoName().toLowerCase() + "/show";
	}
	
	@RequestMapping(value = "/select", method = RequestMethod.GET)
	public String select(Model model) {
		model.addAttribute(getPojoName().toLowerCase(), getNewObject());
		model.addAttribute(dao.getOjects());
		return getPojoName().toLowerCase() + "/select";
	}
	
	@RequestMapping(value = "/select", method = RequestMethod.POST)
	public String selectPOST(String id) {
		return "redirect:/" + getPojoName().toLowerCase() + "/show/" + id;
	}
	
}
