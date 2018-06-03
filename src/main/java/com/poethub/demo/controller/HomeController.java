package com.poethub.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.poethub.demo.model.PoemModel;
import com.poethub.demo.model.UserModel;
import com.poethub.demo.service.PoemService;
import com.poethub.demo.service.UserService;
 
@Controller
@RequestMapping("/")
public class HomeController {
	@Autowired
	private PoemService poemService;
	@Autowired
	private UserService userService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(method = RequestMethod.GET)
	public String home(Model model,Authentication auth) {
		List<PoemModel> poems = poemService.findAllByOrderByPoemIdDesc();
		model.addAttribute("allpoems", poems);
		if(auth!=null && !(auth instanceof AnonymousAuthenticationToken) && !(auth instanceof UsernamePasswordAuthenticationToken)) {
			OAuth2Authentication oauth = (OAuth2Authentication) SecurityContextHolder.getContext().getAuthentication();
			Map<String, String> details =(Map<String, String>) oauth.getUserAuthentication().getDetails();
			if(userService.findByUsername(details.get("name")).isEmpty() && userService.findByUsername(details.get("email")).isEmpty())
			userService.saveUser(initializeUser(details,new UserModel()));
		    }
		return "home";
	}
	
	private UserModel initializeUser(Map<String,String> details,UserModel userModel) {
		userModel.setUsername(details.get("name"));
		userModel.setFirstName(details.get("name"));
		userModel.setLastName(details.get("family_name"));
		userModel.setEmail(details.get("email"));
		userModel.setEnabled(true);
		userModel.setRole("USER");
		userModel.setPassword(null);
		return userModel;
	}
}
