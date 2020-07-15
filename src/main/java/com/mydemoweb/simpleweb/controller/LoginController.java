package com.mydemoweb.simpleweb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.mydemoweb.simpleweb.entity.User;
import com.mydemoweb.simpleweb.service.LoginService;

@Controller
@RequestMapping("/login")
@SessionAttributes("currUser")
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@GetMapping("/showLoginForm")
	public String showLoginForm(Model theModel,HttpSession session){
		return "/login/login";
	}
	
	@PostMapping("/doLogin")
	public String doLogin(@RequestParam String email,@RequestParam String password,Model theModel,HttpSession session){
		User theUser = loginService.loginCheck(email, password);
		if (theUser == null) {
			theModel.addAttribute("error", true);
			return "/login/login";
		} else {
			theModel.addAttribute("currUser",theUser);
				return "redirect:/";
		}
	}
	
	@GetMapping("/doLogout")
	public String doLogout(SessionStatus status,Model theModel,HttpSession session){
		status.setComplete();
		return "redirect:/";
	}
	
}
