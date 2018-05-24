package com.poethub.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.poethub.demo.service.userService;

import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
 
import com.poethub.demo.model.userModel;

@Controller
public class SignUpController {
	@Autowired
	private userService userService;
	
	@GetMapping("/SignUp")
 	public String home(Model model) {
		model.addAttribute("userModel", new userModel());
		return "signup";
	}
	
	@PostMapping("/SignUp")
	public String signup(@Valid userModel userModel,BindingResult bindingResult, Model model) {
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
		userService.saveUser(userModel);
		model.addAttribute("username", userModel.getUsername());
	    return "userPage";
	}
		
}
