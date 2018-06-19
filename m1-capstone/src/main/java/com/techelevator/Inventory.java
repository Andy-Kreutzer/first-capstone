package com.techelevator;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.techelevator.products.Candy;
import com.techelevator.products.Chips;
import com.techelevator.products.Drink;
import com.techelevator.products.Gum;
import com.techelevator.products.Product;

public class Inventory {

	int itemsPerSlot = 5;
	Slot slot = new Slot();
	String productSlot;
	
	public Inventory() {
		
	}
	
	public Map <String, ArrayList<Product>> createProduct(List<String> arrayOfLines) {		
		for (int i = 0; i < arrayOfLines.size(); i++) {
			String[] fields = arrayOfLines.get(i).split("\\|");
			if (fields[3].equals("Chip")) {
				Product chip = new Chips(fields[1], Double.parseDouble(fields[2]), fields[3]);
				slot.loadSlot(fields[0], chip, itemsPerSlot);
			}
			if (fields[3].equals("Gum")) {
				Product gum = new Gum(fields[1], Double.parseDouble(fields[2]), fields[3]);		
				slot.loadSlot(fields[0], gum, itemsPerSlot);
			}
			if (fields[3].equals("Drink")) {
				Product drink = new Drink(fields[1], Double.parseDouble(fields[2]), fields[3]);			
				slot.loadSlot(fields[0], drink, itemsPerSlot);
			}
			if (fields[3].equals("Candy")) {
				Product candy = new Candy(fields[1], Double.parseDouble(fields[2]), fields[3]);	
				slot.loadSlot(fields[0], candy, itemsPerSlot);
			}				
		}
		Map <String, ArrayList<Product>> loadedSlots = new LinkedHashMap <String, ArrayList<Product>> (slot.getProductsInSlot());
		return loadedSlots;
	}
	
	
	
	
	
	
	
}
