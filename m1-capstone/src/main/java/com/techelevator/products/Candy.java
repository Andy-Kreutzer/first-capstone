package com.techelevator.products;

public class Candy extends Product {

	
	public Candy(String productName, double productPrice, String productType) {
		super (productName, productPrice, productType);
	}


	@Override
	public void makeNoise() {
		System.out.println("Munch Munch, Yum");

	}

}
