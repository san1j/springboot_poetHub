package com.poethub.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
 
import com.poethub.demo.model.userModel;

@Controller
public class SignUpController {
	@Autowired
	private userRepo userRepo;
	
	@GetMapping("/SignUp")
 	public String home(Model model) {
		model.addAttribute("userModel", new userModel());
		return "signup";
	}
	
	@PostMapping("/SignUp")
	public String signup(@Valid userModel userModel, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
            return "signup";
        }
	    return "tempObject";
	}
		
}
