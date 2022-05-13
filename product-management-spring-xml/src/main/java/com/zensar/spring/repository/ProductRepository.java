package com.zensar.spring.repository;

import org.springframework.jdbc.core.RowMapper;

import com.zensar.spring.beans.Product;

public interface ProductRepository {

	public int insertProduct(Product product);

	public boolean deleteProduct(int productId);
	
	public int updateProduct(Product product);
}
