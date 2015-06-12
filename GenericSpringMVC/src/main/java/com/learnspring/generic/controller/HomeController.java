package com.learnspring.generic.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.learnspring.generic.comon.MailMail;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController extends BaseController {
	
	private MailMail mailMail;
	
	@Autowired(required=true)
	@Qualifier(value="mailMail")		
	public void setMailMail(MailMail mailMail) {
		this.mailMail = mailMail;
	}	
		
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.error("Welcome home! The client locale is {}.");
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		mailMail.sendMail("dear", "hello");
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}	
}
