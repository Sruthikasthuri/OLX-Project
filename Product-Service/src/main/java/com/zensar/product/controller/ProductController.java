package com.zensar.product.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.product.client.CouponClient;
import com.zensar.product.entity.CouponDto;
import com.zensar.product.entity.Product;
import com.zensar.product.entity.ProductDto;
import com.zensar.product.service.ProductService;

@RestController

public class ProductController {
	@Autowired
	private CouponClient client;

	@Autowired
	private ProductService productService;;

	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public ProductDto createProduct(@RequestBody ProductDto product, @RequestHeader("auth-token") String token) {

		CouponDto coupon = client.getCoupon(product.getCode());
		product.setPrice(product.getPrice() - (coupon.getDiscount()));

		return productService.createProduct(product, token);

	}

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public List<ProductDto> getAllProducts() {
		return productService.getAllProducts();
	}

	@RequestMapping(value = "/product/{productId}", method = RequestMethod.GET)
	public ProductDto getProduct(@PathVariable long productId) {

		return productService.getProduct(productId);

	}

	@DeleteMapping("/product/{productId}")
	public String deleteProduct(@PathVariable("productId") Integer id) {
		return productService.deleteProduct(id);
	}

	@PutMapping("/product/{productId}")
	public ProductDto updateProduct(@PathVariable Integer productId, @RequestBody ProductDto product) {
		return productService.updateProduct(productId, product);
	}

	@DeleteMapping
	public ResponseEntity<String> deleteAllProducts() {
		String returnResult = productService.deleteAllProducts();

		return new ResponseEntity<String>(returnResult, HttpStatus.OK);

	}

}
