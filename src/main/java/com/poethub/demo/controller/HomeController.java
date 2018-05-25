package com.poethub.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.poethub.demo.model.PoemModel;
import com.poethub.demo.service.PoemService;
 
@Controller
@RequestMapping("/")
public class HomeController {
	@Autowired
	private PoemService poemService;
	
	@RequestMapping(method = RequestMethod.GET)
 	public String home(Model model) {
		List<PoemModel> poems = poemService.findAllByOrderByPoemIdDesc();
		model.addAttribute("allpoems", poems);
		return "home";
	}
}
