package com.poethub.demo.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.poethub.demo.service.UserService;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
 
import com.poethub.demo.model.UserModel;

@Controller
public class SignUpController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/SignUp")
 	public String home(Model model) {
		model.addAttribute("userModel", new UserModel());
		return "signup";
	}
	
	@PostMapping("/SignUp")
	public String signup(@Valid UserModel userModel,BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "signup";
        }
		if(!userService.findByEmail(userModel.getEmail()).isEmpty()) {
			bindingResult.rejectValue("email", "error.userModel","This email is already registered with another user");
		}
		if(!userService.findByUsername(userModel.getUsername()).isEmpty()) {
			bindingResult.rejectValue("username", "error.username", "The username already exists");
			return "signup";
		}
		
		userModel.setEnabled(true);
		userService.saveUser(userModel);
		model.addAttribute("successMessage", "Registration Successful! Please login.");
        model.addAttribute("userModel", new UserModel());
	    return "signup";
	}
		
}
