package pl.j2dev.j2bills.web.impl;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class IndexController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String index() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("ZALOGOWANY JAKO " + authentication.getName());
		
		return "index";
	}
	
}
