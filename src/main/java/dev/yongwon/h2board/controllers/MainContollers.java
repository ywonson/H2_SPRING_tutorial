package dev.yongwon.h2board.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainContollers {
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/main")
	public String test() {
		return "main";
	}
}
