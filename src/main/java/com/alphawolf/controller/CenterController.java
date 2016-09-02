package com.alphawolf.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alphawolf.model.Center;
import com.alphawolf.model.User;
import com.alphawolf.service.CenterService;
import com.alphawolf.service.UserService;

@Controller
public class CenterController {
	@Autowired
	private CenterService centerService;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/centers*", method = RequestMethod.GET)
	public @ResponseBody List<Center> findAllCenters() {
		List<Center> asd = centerService.findAllCenters();
		return asd; 
	}
	@RequestMapping(value="/center/{id}", method = RequestMethod.GET)
	public @ResponseBody Center findCenter(@PathVariable("id") Long centerId) {
		return centerService.findById(centerId);
	}
	
	@RequestMapping(value = "/admin/addCenter", method = RequestMethod.GET)
	public String addCenter(Model model, HttpSession session) {
		model.addAttribute("admins", userService.findByRole("ROLE_ADMIN"));
		model.addAttribute("center", new Center());
		return "admin/addCenter";
	}
	
	@RequestMapping(value = "/admin/addCenter", method = RequestMethod.POST)
	public String addCenter(@ModelAttribute("center") Center center,
					@RequestParam(value = "admin_id") Long adminId,
					Model model, HttpSession session, 
					BindingResult result) {
		if(result.hasErrors()) {
			return "admin/addCenter";
		} else {
			User admin = userService.findById(adminId);
			center.setAdmin(admin);
			admin.addCenter(center);
			centerService.save(center);
		}
		return "admin/centerAdded";
	}
	@RequestMapping(value = "/admin/centerList", method = RequestMethod.GET)
	public String centerList(Model model, HttpSession session) {
		model.addAttribute("centers", centerService.findAllCenters());
		return "admin/centerList";
	}
}
