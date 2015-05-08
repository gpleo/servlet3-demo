package com.gopersist.demo.servlet3.springmvc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class UserController {
	static List<User> users = new ArrayList<User>();
	static {
		users.add(new User("user1", "password1", "user1@email.com"));
		users.add(new User("user2", "password2", "user2@email.com"));
	}
	
	@RequestMapping(value={""}, method=RequestMethod.GET)
	public String index(Map<String, List<User>> model) {
		model.put("users", users);
		return "user/index";
	}
	
	@RequestMapping(value={""}, method=RequestMethod.GET, params="new")
	public String createForm(Model model) {
		model.addAttribute("user", new User());
		return "user/edit";
	}
	
	@RequestMapping(value={""}, method=RequestMethod.POST)
	public String create(@Valid User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "user/edit";
		}
		user.setId(User.getNextId());
		users.add(user);
		
		return "redirect: /users";
	}
	
	@RequestMapping(value={"/{id}"}, method=RequestMethod.GET)
	public ModelAndView editForm(@PathVariable("id") Integer id, HttpServletResponse response) {
		if (id <=0 || id > users.size()) {
			response.setStatus(404);
			try {
				response.getWriter().print("id is not found.");
				response.getWriter().flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		
		ModelAndView modelAndView = new ModelAndView("user/edit");
		modelAndView.addObject("user", users.get(id-1));
		return modelAndView;
	}
	
	@RequestMapping(value={"/{id}"}, method=RequestMethod.POST)
	public ModelAndView update(@PathVariable("id") Integer id, HttpServletResponse response, @Valid User user, BindingResult bindingResult) {
		if (id <=0 || id > users.size()) {
			response.setStatus(404);
			try {
				response.getWriter().print("id is not found.");
				response.getWriter().flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}

		ModelAndView modelAndView = new ModelAndView();
		
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("user/edit");
			return modelAndView;
		}
		
		user.setId(id);
		users.set(id-1, user);
		
		modelAndView.setViewName("redirect:/users");
		return modelAndView;
	}
}