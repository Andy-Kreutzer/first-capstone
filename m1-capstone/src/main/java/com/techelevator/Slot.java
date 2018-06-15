package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Slot {
	
	private Map <String, ArrayList<String[]>> productsInSlot = new LinkedHashMap <String, ArrayList<String[]>> ();
	
	public Slot () {
	}

	public void loadSlot(int itemsPerSlot, List<String> products) {
		int n = 0;
		while (n < products.size()) {
			String[] fields = products.get(n).split("\\|");
			ArrayList<String[]> productInfo = new ArrayList<>(); 
			for(int i = 0; i < itemsPerSlot; i++) { 
				Collections.addAll(productInfo, fields); 
			} 
			this.productsInSlot.put(fields[0], productInfo);
		}
	}

	public Map<String, ArrayList<String[]>> getProductsInSlot() {
		return productsInSlot;
	}
			
}
