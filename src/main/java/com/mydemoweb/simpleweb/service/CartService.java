package com.mydemoweb.simpleweb.service;

import com.mydemoweb.simpleweb.model.Cart;

public interface CartService {
	public Cart addCartItemQuantityById(int theId);
	public Cart subCartItemQuantityById(int theId);
	public Cart setCartItemQuantityById(int theId, int newQuantity);
}
