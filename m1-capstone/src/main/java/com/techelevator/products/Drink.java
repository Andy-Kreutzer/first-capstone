package com.techelevator.products;

public class Drink extends Product {

	
	public Drink(String productName, double productPrice, String productType) {
		super (productName, productPrice, productType);
	}


	@Override
	public void makeNoise() {
		
		System.out.println("Glug Glug, Yum!");
	}

}
