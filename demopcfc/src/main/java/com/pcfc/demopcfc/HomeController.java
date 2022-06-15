package com.pcfc.demopcfc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pcfc.service.EmployeeService;

/**
 * Handles requests for the application home page.
 * Create Date : 2022-06-14
 * @author Nadeem
 * 
 */
@Controller
public class HomeController {
	
	@Autowired
	EmployeeService employeeService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Home Page
	 */
	
	@RequestMapping(value = {"/","/home"}, method = RequestMethod.GET)
	public String home(Locale locale, Model model,@RequestParam(required = false) String smessage) {
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		model.addAttribute("employees", employeeService.getEmployees());
		model.addAttribute("smessage", smessage);
		
		logger.info("PCFC Dashboard Running : "+formattedDate);
		
		return "user.home";
	}
	
}
