package com.mydemoweb.simpleweb.controller;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	@GetMapping("/")
	public String path(Model theModel,HttpSession session) {
		return "index";
	}
	
	@GetMapping("/hello")
	public String satHello(Model theModel) {
		theModel.addAttribute("theDate",new java.util.Date());
		return "helloworld";
	}
	
	@GetMapping("/temppath")
	public String path(Model theModel) {
		System.out.println(new File(".").getAbsolutePath());
		return "helloworld";
	}
	
}
