package com.zensar.product.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.product.client.CouponClient;
import com.zensar.product.entity.CouponDto;
import com.zensar.product.entity.Product;
import com.zensar.product.entity.ProductDto;
import com.zensar.product.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CouponClient client;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<ProductDto> getAllProducts() {

		List<Product> findAll = productRepository.findAll();
		List<ProductDto> listProductResponse = new ArrayList<ProductDto>();
		for (Product product : findAll) {
			ProductDto map = modelMapper.map(product, ProductDto.class);
			listProductResponse.add(map);
		}
		return listProductResponse;
	}

	@Override
	public ProductDto getProduct(long productId) {
		Optional<Product> findByIdByOptional = productRepository.findById((int) productId);
		Product product = null;
		if (findByIdByOptional.isPresent()) {
			product = findByIdByOptional.get();
			return modelMapper.map(product, ProductDto.class);
		}

		else {
			return null;
		}
	}

	@Override
	public ProductDto createProduct(ProductDto product, String token) {
		ProductDto newProduct = modelMapper.map(product, ProductDto.class);
		if (token.equals("sk66631")) {
			Product map = modelMapper.map(product, Product.class);
			Product save = productRepository.save(map);
			return modelMapper.map(save, ProductDto.class);
		} else {
			return null;
		}

	}

	@Override
	public String deleteProduct(long id) {
		productRepository.deleteById((int) id);
		return "Deleted  " + id;
	}

	@Override
	public ProductDto updateProduct(long productId, ProductDto product) {
		Optional<Product> findById = productRepository.findById((int) productId);
		Product Product2 = findById.get();
		Product2.setDiscription(product.getDescription());
		Product2.setProductName(product.getProductName());
		Product2.setPrice(product.getPrice());
		return modelMapper.map(productRepository.save(Product2), ProductDto.class);
	}

	@Override
	public String deleteAllProducts() {
		productRepository.deleteAll();
		return "All Products Deleted";
	}
}
