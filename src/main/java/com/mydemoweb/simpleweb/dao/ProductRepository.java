package com.mydemoweb.simpleweb.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mydemoweb.simpleweb.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	//什麼都不用打　只要填好<T, ID>
	
}
