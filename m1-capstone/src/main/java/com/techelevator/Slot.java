package com.techelevator;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import com.techelevator.products.Product;


public class Slot {
	public Map <String, ArrayList<Product>> productsInSlot = new LinkedHashMap <String, ArrayList<Product>> ();
	private String currentKey;
	
	public Slot () {
	}

	public void loadSlot(String productSlot, Product product, int itemsPerSlot) {
		ArrayList <Product> productInArray = new ArrayList<Product>();
		for(int j = 0; j < itemsPerSlot; j++) { 
			productInArray.add(product);
		}
		this.productsInSlot.put(productSlot, productInArray);  
	}

	@Override
	public String toString() {
		return "Slot [productsInSlot=" + productsInSlot + "]";
	}

	public void setCurrentProductChoice(String userProductChoice) {
		this.currentKey = userProductChoice;
	}
	public Map<String, ArrayList<Product>> getProductsInSlot() {
		return this.productsInSlot;
	}
	
	public Map<String, ArrayList<Product>> reduceInventoryInSlot(String slot, Map<String, ArrayList<Product>> slotMap) {
		ArrayList <Product> productToReduce = slotMap.get(slot);
		productToReduce.remove(0);
		return slotMap;
	}
			
}
