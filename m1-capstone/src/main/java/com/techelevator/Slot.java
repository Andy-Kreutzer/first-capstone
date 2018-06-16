package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.techelevator.products.Product;


public class Slot {
	private Map <String, ArrayList<Product>> productsInSlot = new LinkedHashMap <String, ArrayList<Product>> ();
	private ArrayList <Product> productInArray = new ArrayList<Product>(); 
	
	private String currentKey;
	
	public Slot () {
	}

	public void loadSlot(int itemsPerSlot, Product productInfo, String productSlot) {
		for(int i = 0; i < itemsPerSlot; i++) { 
			productInArray.add(productInfo);
			this.productsInSlot.put(productSlot, productInArray);  

		}
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
