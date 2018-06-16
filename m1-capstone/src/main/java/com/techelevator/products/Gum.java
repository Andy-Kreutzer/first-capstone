package com.techelevator.products;

public class Gum extends Product {
	
	public Gum(String productName, double productPrice, String productType) {
		super (productName, productPrice, productType);
	}


	@Override
	public void makeNoise() {
		System.out.println("Chew Chew, Yum!");
		
	}

}
