package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Product {
	
	private String productName;
	private String productPrice;
	private String productType;
	private ArrayList products = new ArrayList<String>();
	
	public ArrayList Product(String[] product) {
		this.productName = product[1];
		this.productPrice = product[2];
		this.productType = product[3];
		products.add(productName);
		products.add(productPrice);
		products.add(productType);
		return products;
	}
	
	public ArrayList <String> displayProducts () {
		ArrayList <String> productList = new ArrayList <String>();
		
		return products;
		
	}
	public String getProductName() {
		return productName;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public String getProductType() {
		return productType;
	}

	public ArrayList getProducts() {
		return products;
	}
	
	
	
}
