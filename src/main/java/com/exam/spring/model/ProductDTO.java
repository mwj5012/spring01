package com.exam.spring.model;

import lombok.Data;

@Data
public class ProductDTO {
	
	private String name;
	private int price;
	
	public ProductDTO() {
	}
	
	public ProductDTO(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	
	
}
