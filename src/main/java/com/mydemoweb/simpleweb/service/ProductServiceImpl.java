package com.mydemoweb.simpleweb.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mydemoweb.simpleweb.dao.ProductRepository;
import com.mydemoweb.simpleweb.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public Product findById(int theId) {
		Product theProduct=null;
		Optional<Product> result = productRepository.findById(theId);
		if(result.isPresent())
			theProduct=result.get();
		else
			throw new RuntimeException("Did not foun product id - "+theId);
		return theProduct;
		
	}

	@Override
	public void save(Product theProduct,MultipartFile imgFile) throws IOException {
		saveFileIO(imgFile);
		productRepository.save(theProduct);
	}

	@Override
	public void deleteById(int theId) {
		productRepository.deleteById(theId);
	}

	
	// IO方法 
	private void saveFileIO(MultipartFile imgFile) throws IOException {
		InputStream inputStream = imgFile.getInputStream();
		OutputStream outputStream = new FileOutputStream("./src/main/resources/static/img/"+imgFile.getOriginalFilename());
		OutputStream outputStream_temp = new FileOutputStream("./target/classes/static/img/"+imgFile.getOriginalFilename());
		
		byte[] bytes = new byte[(int) imgFile.getSize()];
		inputStream.read(bytes);
		outputStream.write(bytes);
		
		inputStream.close();
		outputStream.close();
		
		outputStream_temp.write(bytes);
		outputStream_temp.close();
	}
}
