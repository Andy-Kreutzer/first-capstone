package com.techelevator;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import com.techelevator.products.Product;


public class Slot {
	private Map <String, ArrayList<Product>> productsInSlot = new LinkedHashMap <String, ArrayList<Product>> ();
	private String currentKey;
	
	public Slot () {
	}

	public void loadSlot(String productSlot, Product product, int itemsPerSlot) {
		ArrayList <Product> productInArray = new ArrayList<Product>();
		for(int j = 0; j < itemsPerSlot; j++) { 
			productInArray.add(product);
		}
		this.productsInSlot.put(productSlot, productInArray);  
		
		System.out.println(productsInSlot);

	}

	@Override
	public String toString() {
		return "Slot [productsInSlot=" + productsInSlot + "]";
	}

	public void setCurrentProductChoice(String userProductChoice) {
		this.currentKey = userProductChoice;
	}
	public Map<String, ArrayList<Product>> getProductsInSlot() {
		return productsInSlot;
	}
	
	public void reduceInventory() {
		if (this.productsInSlot.containsKey(this.currentKey)) {
			this.productsInSlot.remove(this.currentKey);
		}
	}
			
}
