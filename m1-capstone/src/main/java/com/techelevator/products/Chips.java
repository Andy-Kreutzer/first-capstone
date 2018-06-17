package com.techelevator.products;

public class Chips extends Product {
	

	//private String productName;
	//private double productPrice;
	//private String productType;
	
	public Chips(String productName, double productPrice, String productType) {
		super (productName, productPrice, productType);
	}

	@Override
	public String makeNoise() {
		return "Crunch Crunch, Yum!";
		
	}

}
