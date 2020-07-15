package com.mydemoweb.simpleweb.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.mydemoweb.simpleweb.entity.Product;

public interface ProductService {
	public List<Product> findAll();
	public Product findById(int theId);
	public void save(Product theProduct,MultipartFile imgFile) throws IOException;
	public void deleteById(int theId);
}
