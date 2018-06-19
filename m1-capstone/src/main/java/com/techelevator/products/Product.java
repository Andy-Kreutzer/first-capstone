package com.techelevator.products;

import com.techelevator.Slot;

public abstract class Product {
	

	Slot slot;
	
	private String productType;
	private String productName;
	private String productSlot;
	private double productPrice;

	public Product(String productName, double productPrice, String productType) {
		this.productName = productName;
		this.productPrice = productPrice;
		this.productType = productType;
	}
	
	public String getProductType() {
		return this.productType;
	}

	public String getProductName() {
		return this.productName;
	}
	
	public double getProductPrice() {
		return this.productPrice;
	}
	
	public String getProductSlot() {
		return this.productSlot;
	}

	public abstract String makeNoise(); 
	

	
}
