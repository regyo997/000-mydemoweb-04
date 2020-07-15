package com.mydemoweb.simpleweb.model;

import java.util.Map;

public class Cart {
	private Map<Integer,CartItem> cartList;
	
	private int numInCart;
	
	//getter / setter
	public Map<Integer, CartItem> getCartList() {
		return cartList;
	}

	public void setCartList(Map<Integer, CartItem> cartList) {
		this.cartList = cartList;
	}

	public int getNumInCart() {
		return numInCart;
	}

	public void setNumInCart(int numInCart) {
		this.numInCart = numInCart;
	}


	
}