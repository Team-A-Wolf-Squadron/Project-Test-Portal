package com.alphawolf.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alphawolf.model.StudentTest;
import com.alphawolf.model.User;
import com.alphawolf.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "addUser", method = RequestMethod.GET)
	public String addUserPage(Model model, HttpSession session) {
		System.out.println("In addUser (GET)");
		User user = (User)session.getAttribute("user");
		
		if( user == null) {
			user = new User();
		}
		
		model.addAttribute("user", user);
		
		return "addUser";
	}
	
	
	@RequestMapping(value = "addUser", method = RequestMethod.POST)
	public String addUser(@Valid @ModelAttribute("user") User user, HttpSession session, BindingResult result) {
		System.out.println("In addUser (post)");
		if(result.hasErrors()) {
			return "addUser";
		} else {
			userService.save(user);
		}

		
		return "userAdded";
	}
	
	@RequestMapping(value = "userAdded", method = RequestMethod.GET)
	public String userAdded() {
		
		return "userAdded";
	}
	
	@RequestMapping(value = "editUser", method = RequestMethod.GET)
	public String editUser(Model model, HttpSession session) {
		System.out.println("In editUser (get)");
		//TODO: check session if user object exists, else get user via the following
		SecurityContextImpl sci = (SecurityContextImpl)session.getAttribute("SPRING_SECURITY_CONTEXT");
		String username = sci.getAuthentication().getName();
		
		User user = userService.findByUsername(username);
		model.addAttribute("user", user);
					
		return "editUser";
	}
	@RequestMapping(value = "editUser", method = RequestMethod.POST)
	public String userEdited(@Valid @ModelAttribute("user") User newUserInfo, @RequestParam String newPassword,HttpSession session,  BindingResult result) {
		System.out.println("In editUser (post)");
		//TODO: check session if user object exists, else get user via the following
		SecurityContextImpl sci = (SecurityContextImpl)session.getAttribute("SPRING_SECURITY_CONTEXT");
		String username = sci.getAuthentication().getName();
		User user = userService.findByUsername(username);
		
		if(result.hasErrors()) {
			return "editUser";
		} else {
			userService.update(user, newUserInfo, newPassword);
		}

		return "userEdited";
	}
	
	@RequestMapping(value="myTests", method=RequestMethod.GET)
	public String myTestPage(Model model, HttpSession session) {
		//TODO: check session if user object exists, else get user via the following
		SecurityContextImpl sci = (SecurityContextImpl)session.getAttribute("SPRING_SECURITY_CONTEXT");
		String username = sci.getAuthentication().getName();
		User user = userService.findByUsername(username);
		
		List<StudentTest> tests = user.getStudentTests();
		model.addAttribute("tests", tests);
		
		return "myTests";
	}
	
}
