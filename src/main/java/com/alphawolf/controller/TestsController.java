package com.alphawolf.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.alphawolf.model.Center;
import com.alphawolf.model.Provider;
import com.alphawolf.model.StudentTest;
import com.alphawolf.model.Test;
import com.alphawolf.model.User;
import com.alphawolf.service.CenterService;
import com.alphawolf.service.ProviderService;
import com.alphawolf.service.StudentTestService;
import com.alphawolf.service.TestService;
import com.alphawolf.service.UserService;

@Controller
public class TestsController {

	@Autowired
	private ProviderService providerService;
	@Autowired
	private TestService testService;
	@Autowired
	private UserService userService;
	@Autowired
	private CenterService centerService;
	@Autowired
	private StudentTestService studentTestService;
	
	
	@RequestMapping(value="/testsList", method = RequestMethod.GET)
	public String GetTestList(Model model, HttpSession session) {
		model.addAttribute("providers", providerService.findAllProviders());
		model.addAttribute("centers", centerService.findAllCenters());
		return "testsList";
	}
	
	@RequestMapping(value="/tests*", method = RequestMethod.GET)
	public @ResponseBody List<Test> findAllProviderTests(@RequestParam(value = "provider") String providerId) {
		Provider provider = providerService.findById( Long.parseLong(providerId));
		if(provider != null) {
			return provider.getTests();
		}
		return null;
	}
	
	@RequestMapping(value="/testsList", method = RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.OK)
	public String BookTest(Model model, HttpSession session, 
				@RequestParam(value = "test") String testId,
				@RequestParam(value = "center") String centerId,
				@RequestParam(value = "testDate") String testDate) {

		SecurityContextImpl sci = (SecurityContextImpl)session.getAttribute("SPRING_SECURITY_CONTEXT");
		String username = sci.getAuthentication().getName();
		User user = userService.findByUsername(username);

		Test test = testService.findById( Long.parseLong(testId) );
		Center center = centerService.findById(Long.parseLong(centerId));

		StudentTest studentTest = new StudentTest();
		studentTest.setStudent(user);
		studentTest.setTest(test);
		studentTest.setCenter(center);
		
		studentTest.setTestDate( parseDate(testDate) );
		studentTest.setBookingDate( new Date() );
		
		studentTestService.save(studentTest);
		userService.update(user, studentTest);

		return "testBooked";
	}
	
	private Date parseDate(String date){
		Date parsed = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			parsed = format.parse(date);
		} catch(ParseException pe) {
			pe.printStackTrace();
			return null;
		}
		
		return parsed;
	}
	
}
