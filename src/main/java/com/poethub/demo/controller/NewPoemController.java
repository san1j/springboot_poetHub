package com.poethub.demo.controller;

import java.security.Principal;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.poethub.demo.model.PoemModel;
import com.poethub.demo.model.UserModel;
import com.poethub.demo.service.PoemService;
import com.poethub.demo.service.UserService;

@Controller

public class NewPoemController {
	@Autowired
	PoemService poemService;
	@Autowired
	UserService userService;
	
	@GetMapping("/newPoem")
	public String newPoem(Principal principal, Model model) {
		List<UserModel> users = userService.findByUsername(principal.getName());
		PoemModel poemModel = new PoemModel();
		poemModel.setUserModel(users.get(0));
		model.addAttribute("poemModel", poemModel);
		return "newPoem";
	}
	
	@PostMapping("/newPoem")
	public String submitPoem(PoemModel poemModel,BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
            return "newPoem";
        }
		poemService.savePoem(poemModel);
		return "redirect:userPage/"+ poemModel.getUserModel().getUsername();
	}
}
