package com.poethub.demo.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poethub.demo.model.PoemModel;
import com.poethub.demo.model.UserModel;
import com.poethub.demo.service.PoemService;
import com.poethub.demo.service.UserService;

@Controller
public class UserPageController {
	@Autowired
	private UserService userService;
	@Autowired
	private PoemService poemService;
	
	@RequestMapping("/userPage/{username}")
	public String userPage(Model model,@PathVariable String username) {
		List<UserModel> users = userService.findByUsername(username);
		UserModel userModel = users.get(0);
		List<PoemModel> poems = poemService.findAllByUserModelOrderByPoemIdDesc(userModel);
		model.addAttribute("poems", poems);
		model.addAttribute("userModel", userModel);
		return "userPage";
	}
	
	
	@RequestMapping("/editPoem/{id}")
	public String editPoem(Model model, @PathVariable int id, Principal principal) {
		PoemModel poemModel = poemService.findByPoemId(id);
		if(poemModel!=null && principal.getName().equals(poemModel.getUserModel().getUsername())) {
			model.addAttribute("poemModel", poemModel);
			return "newPoem";
		}
		return "error";
	}
	
	@RequestMapping("/deletePoem/{id}")
	public String deletePoem(@PathVariable int id, Principal principal) {
		PoemModel poemModel = poemService.findByPoemId(id);
		if(poemModel!=null && principal.getName().equals(poemModel.getUserModel().getUsername())) {
			poemService.deletePoem(poemModel);
			return "redirect:/userPage/"+poemModel.getUserModel().getUsername();
		}
		return "error";
	}
	
}
