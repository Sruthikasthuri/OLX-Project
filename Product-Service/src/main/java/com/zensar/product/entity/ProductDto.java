package com.zensar.product.entity;

import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

	private int productId;
	private String productName;
	private String discription;
	private double price;
	@Transient
	private String code;
	public Object getDescription() {
		// TODO Auto-generated method stub
		return null;
	}
}
