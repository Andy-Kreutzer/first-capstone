package com.techelevator.products;

public class Drink extends Product {

	
	public Drink(String productName, double productPrice, String productType) {
		super (productName, productPrice, productType);
	}


	public String makeNoise() {
		return "\n Glug, Glug, Yum!";

	}

}
