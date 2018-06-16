package com.techelevator;

import java.util.ArrayList;
import java.util.List;

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
	
//	public void createProduct(List<String> arrayOfLines) {
	public void createProduct(List<String> arrayOfLines) {		
		for (int i = 0; i < arrayOfLines.size(); i++) {
			String[] fields = arrayOfLines.get(i).split("\\|");
			if (fields[3].equals("Chip")) {
				Product chip = new Chips(fields[1], Double.parseDouble(fields[2]), fields[3]);	
				slot.loadSlot(itemsPerSlot, chip, fields[0]);
			}
			if (fields[3].equals("Gum")) {
				Product gum = new Gum(fields[1], Double.parseDouble(fields[2]), fields[3]);		
				slot.loadSlot(itemsPerSlot, gum, fields [0]);
			}
			if (fields[3].equals("Drink")) {
				Product drink = new Drink(fields[1], Double.parseDouble(fields[2]), fields[3]);			
				slot.loadSlot(itemsPerSlot, drink, fields[0]);
			}
			if (fields[3].equals("Candy")) {
				Product candy = new Candy(fields[1], Double.parseDouble(fields[2]), fields[3]);	
				slot.loadSlot(itemsPerSlot, candy, fields[0]);
			}				
		}
		
	}
	
	
	
	
	
	
	
}
