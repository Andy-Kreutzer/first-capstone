package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.junit.Assert;
import org.junit.Test;


import com.techelevator.Inventory;
import com.techelevator.products.Product;

public class InventoryTest {

	@Test
	public void testCreateProduct() {
		Inventory inv = new Inventory();
		List <String> arrayTest = new ArrayList <String> ();
		arrayTest.add("A1|Potato Crisps|3.05|Chip");
		Map<String, ArrayList<Product>> testMap = inv.createProduct(arrayTest);
		Assert.assertEquals(1, testMap.size());
		
	}
	
}
