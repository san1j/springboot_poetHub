package com.poethub.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/SignUp")
public class SignUpController {
	@Autowired
	private userRepo userRepo;
	
	@RequestMapping(method = RequestMethod.GET)
 	public String home() {
		return "signup";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String signup() {
		return 
	}
}
