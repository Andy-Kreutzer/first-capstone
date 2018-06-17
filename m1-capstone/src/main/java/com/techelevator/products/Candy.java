package com.techelevator.products;

public class Candy extends Product {

	
	public Candy(String productName, double productPrice, String productType) {
		super (productName, productPrice, productType);
	}


	@Override
	public String makeNoise() {
		return "Munch Munch, Yum!";
	}

}
