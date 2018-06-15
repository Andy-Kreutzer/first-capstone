package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Product {
	
	private VendingMachineCLI vending;
	
	private String slotNumber;
	private String productName;
	private String productPrice;
	private String productType;
	private int productQuantity;
	List<String> productList = vending.getProductsToFill();
	private ArrayList products = new ArrayList<String>();
		
	
	public ArrayList Product() {
		for (int i = 0; i < productList.size(); i++) {
			String[] fields = productList.get(i).split("\\|");
			this.slotNumber = fields[0];
			this.productName = fields[1];
			this.productPrice = fields[2];
			this.productType = fields[3];
			this.productQuantity = 5;
			products.add(slotNumber);
			products.add(productName);
			products.add(productPrice);
			products.add(productType);
		}
		return products;
	}
	
	public String getProductName() {
		return this.productName;
	}

	public String getProductPrice() {
		return this.productPrice;
	}

	public String getProductType() {
		return this.productType;
	}

	/*public ArrayList getProducts() {
		return products;
	}*/
	
	
	
}
