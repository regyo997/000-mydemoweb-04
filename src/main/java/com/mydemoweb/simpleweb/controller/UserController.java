package com.mydemoweb.simpleweb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mydemoweb.simpleweb.entity.User;
import com.mydemoweb.simpleweb.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/list")
	public String listUser(Model theModel,HttpSession session) {
		theModel.addAttribute("users",userService.findAll());
		return "user/list-user";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel,HttpSession session) {
		theModel.addAttribute("theUser",new User());
		return "user/user-form";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("userId") int theId,Model theModel,HttpSession session) {
		User theUser=userService.findById(theId);
		theModel.addAttribute("theUser",theUser);
		return "user/user-form";
	}
	
	@PostMapping("/save")
	public String saveUser(@ModelAttribute User theUser, Model theModel,HttpSession session) {
		userService.save(theUser);
		return "redirect:/";
	}
		
	@GetMapping("/delete")
	public String delete(@RequestParam("userId") int theId, Model theModel,HttpSession session) {
		userService.deleteById(theId);
		return "redirect:/user/list";
	}
}
