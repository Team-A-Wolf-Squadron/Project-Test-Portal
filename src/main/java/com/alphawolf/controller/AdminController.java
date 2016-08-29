package com.alphawolf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/admin/")
public class AdminController {

	@GetMapping("/")
	public String adminPage(ModelMap map) {
		return "admin/admin";
	}

	@GetMapping("/admin")
	public String adminPage2(ModelMap map) {
		return "admin/admin";
	}
}
