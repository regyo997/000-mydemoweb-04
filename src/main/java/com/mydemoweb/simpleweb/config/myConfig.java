package com.mydemoweb.simpleweb.config;

import java.util.HashMap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.mydemoweb.simpleweb.model.Cart;
import com.mydemoweb.simpleweb.model.CartItem;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.mydemoweb.simpleweb")
public class myConfig {

	@Bean
	public Cart cart() {
		Cart cart =new Cart();
		cart.setCartList(new HashMap<Integer,CartItem>());
		return cart;
	}
	
}
