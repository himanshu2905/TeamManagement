package com.team.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//In spring mvc we can define a url mapping for a method inside a controller
@Controller
//M = Domain Objects
//V = JSP, Free marker templates, theam leaf, velocity templates
//C = Dispatcherservlet(web.xml) - Front controller
//It creates request handler mappings(url to method mapping)
public class HomeController {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String loadHomePage(){
		return "home";//name of the jsp
	}
	
//	@RequestMapping(value="/hi", method=RequestMethod.GET)
//	public String loadHiPage(){
//		return "hi";//name of the jsp
//	}
	
	
}
