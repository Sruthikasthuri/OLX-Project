package com.zensar.spring.service;

import com.zensar.spring.beans.Product;

public interface ProductService {

	public int insertProduct(Product product);
	
	
	public boolean deleteProduct(int productId);
	
	
	public int updateProduct(Product product);
}
