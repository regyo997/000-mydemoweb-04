package com.mydemoweb.simpleweb.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mydemoweb.simpleweb.model.Cart;
import com.mydemoweb.simpleweb.model.CartItem;


@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private Cart cart;
	
	@Override
	public Cart addCartItemQuantityById(int theId) {
		Map<Integer,CartItem> cartList=cart.getCartList();
		CartItem theCartItem;
		if(cartList.get(theId)==null){
			theCartItem = new CartItem(productService.findById(theId),1);
		}else {
			theCartItem = cartList.get(theId);
			int oldQuantity = theCartItem.getQuantity();
			theCartItem.setQuantity(oldQuantity + 1);
		}
		cartList.put(theId, theCartItem);
		cart.setCartList(cartList);
		cart.setNumInCart(cart.getNumInCart()+1);
		return cart;
	}

	@Override
	public Cart subCartItemQuantityById(int theId) {
		Map<Integer,CartItem> cartList=cart.getCartList();
		CartItem theCartItem;
		if(cartList.get(theId)!=null&&cartList.get(theId).getQuantity()>0){
			theCartItem = cartList.get(theId);
			int oldQuantity = theCartItem.getQuantity();
			if(oldQuantity==1) {//再減就沒有了
				cartList.remove(theId);
			}else {
				theCartItem.setQuantity(oldQuantity - 1);
				cartList.put(theId, theCartItem);
			}
			cart.setCartList(cartList);
			cart.setNumInCart(cart.getNumInCart()-1);
		}
		return cart;
	}

	@Override
	public Cart setCartItemQuantityById(int theId, int newQuantity) {
		Map<Integer,CartItem> cartList=cart.getCartList();
		CartItem theCartItem;
		if(cartList.get(theId)!=null&&cartList.get(theId).getQuantity()>0&&newQuantity>0){
			theCartItem = cartList.get(theId);
			theCartItem.setQuantity(newQuantity);
			cartList.put(theId, theCartItem);
			cart.setCartList(cartList);
			cart.setNumInCart(cart.getNumInCart()-1);
		}else if(newQuantity==0) {
			cartList.remove(theId);
		}
		return cart;
	}

}
