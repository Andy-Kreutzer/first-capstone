package com.techelevator.products;

public class Gum extends Product {
	
	public Gum(String productName, double productPrice, String productType) {
		super (productName, productPrice, productType);
	}

	public String makeNoise() {
		return "\n Chew, Chew, Yum!";
	}

}
