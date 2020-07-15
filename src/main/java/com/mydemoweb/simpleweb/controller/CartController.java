package com.mydemoweb.simpleweb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mydemoweb.simpleweb.model.Cart;
import com.mydemoweb.simpleweb.service.CartService;
import com.mydemoweb.simpleweb.service.ProductService;

@Controller
@RequestMapping("/cart")
@Scope("session")
public class CartController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private Cart cart;
	
	@GetMapping("/list")
	public String listCart(Model theModel,HttpSession session) {
		theModel.addAttribute("products",productService.findAll());
		theModel.addAttribute("cart",cart);
		return "cart/list-product-cart";
	}
	
	@GetMapping("/addToCart")
	public String addToCart(@RequestParam("productId") int theId,Model theModel,HttpSession session) {
		theModel.addAttribute("products",productService.findAll());
		cart=(Cart) theModel.getAttribute("cart");
		cart=cartService.addCartItemQuantityById(theId);
		theModel.addAttribute("cart",cart);
		return "cart/list-product-cart";
	}
	
	@GetMapping("/subFromCart")
	public String subFromCart(@RequestParam("productId") int theId,Model theModel,HttpSession session) {
		theModel.addAttribute("products",productService.findAll());
		cart=(Cart) theModel.getAttribute("cart");
		cart=cartService.subCartItemQuantityById(theId);
		theModel.addAttribute("cart",cart);
		return "cart/list-product-cart";
	}
	

	
	@GetMapping("/inCart")
	public String inCart(Model theModel,HttpSession session) {
		theModel.addAttribute("cart",cart);
		theModel.addAttribute("isConfirm",false);
		return "/cart/in-cart";
	}
	
	@GetMapping("/setCartItemQuantity")
	public String setCartItemQuantity(@RequestParam("productId") int theId,@RequestParam("newQuantity") int newQuantity,Model theModel,HttpSession session) {
		cart=(Cart) theModel.getAttribute("cart");
		cart=cartService.setCartItemQuantityById(theId,newQuantity);
		theModel.addAttribute("cart",cart);
		theModel.addAttribute("isConfirm",false);
		return "cart/in-cart";
	}
	
	@GetMapping("/confirm")
	public String confirm(Model theModel,HttpSession session) {
		theModel.addAttribute("cart",cart);
		theModel.addAttribute("isConfirm",true);
		return "/cart/in-cart";
	}
	
	@PostMapping("/checkout")
	public String checkout(@ModelAttribute("cart") Cart theCart,Model theModel,HttpSession session) {
		cart=theCart;
//		cartService.checkout(cart);
		return "/cart/in-cart";
	}
	
}
