package com.techelevator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Slot {
	
	String slotNum;
	Product productInfo;
	Map<String, Product> slot = new HashMap<String, Product>();
	
	public Map Slot(String slotNumber, Product productStuff) {
		this.slotNum = slotNumber;
		slot.put(this.slotNum, productStuff);
		return slot;
	}
}
