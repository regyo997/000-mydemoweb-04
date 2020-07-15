package com.mydemoweb.simpleweb.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.mydemoweb.simpleweb.entity.Product;
import com.mydemoweb.simpleweb.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/list")
	public String listProduct(Model theModel,HttpSession session) {
		theModel.addAttribute("products",productService.findAll());
		return "product/list-product";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel,HttpSession session) {
		theModel.addAttribute("theProduct",new Product());
		return "product/product-form";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("productId") int theId,Model theModel,HttpSession session) {
		Product theProduct=productService.findById(theId);
		theModel.addAttribute("theProduct",theProduct);
		return "product/product-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute Product theProduct, @RequestPart("imgFile") MultipartFile imgFile,Model theModel,HttpSession session) {
		theProduct.setImgPath("/img/"+imgFile.getOriginalFilename());
		try {
			productService.save(theProduct,imgFile);
		} catch (IOException e) {
			System.out.println("檔案IO出錯");
			e.printStackTrace();
		}
		return "redirect:/product/list";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("productId") int theId,Model theModel,HttpSession session) {
		productService.deleteById(theId);
		return "redirect:/product/list";
	}
}
