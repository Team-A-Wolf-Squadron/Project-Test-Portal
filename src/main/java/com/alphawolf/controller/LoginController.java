package com.alphawolf.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(ModelMap model) {
		System.out.println("In the login method");
		
		return "login";
	}
	
	@RequestMapping(value="/loginFailed", method=RequestMethod.GET)
	public String loginFailed(ModelMap model) {
		System.out.println("Login failed");
		
		model.addAttribute("error","true");
		
		return "login";
		
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET) 
	public String logout(HttpServletRequest request, HttpServletResponse response){
		System.out.println("Logging out");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }

		return "logout";
	}
	
	@RequestMapping(value="/403", method=RequestMethod.GET) 
	public String error403(ModelMap model){
		System.out.println("Error 403");
		return "403";
	}
}
