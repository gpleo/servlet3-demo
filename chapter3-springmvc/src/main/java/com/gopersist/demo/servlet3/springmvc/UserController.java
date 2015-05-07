package com.gopersist.demo.servlet3.springmvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/users")
public class UserController {
	static List<User> users = new ArrayList<User>();
	static {
		users.add(new User("user1", "password1", "user1@email.com"));
		users.add(new User("user2", "password2", "user2@email.com"));
	}
	
	@RequestMapping(value={"", "/"}, method=RequestMethod.GET)
	public String index(Map<String, List<User>> model) {
		model.put("users", users);
		return "user/index";
	}
	
	@RequestMapping(value={"", "/"}, method=RequestMethod.GET, params="new")
	public String createForm(Model model) {
		model.addAttribute("user", new User());
		return "user/edit";
	}
	
	@RequestMapping(value={"", "/"}, method=RequestMethod.POST)
	public String create(@Valid User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "user/edit";
		}
		
		user.setId(User.getNextId());
		users.add(user);
		
		return "redirect: /users";
	}
}