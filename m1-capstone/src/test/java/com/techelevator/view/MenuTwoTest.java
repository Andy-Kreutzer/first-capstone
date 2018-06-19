package com.techelevator.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.techelevator.Money;
import com.techelevator.view.MenuTwo;

public class MenuTwoTest {
	
	@Test
	public void testSetUserDeposit() {
		MenuTwo menu2 = new MenuTwo(); 
		
		Assert.assertEquals(10.00, menu2.setUserDeposit(), 0.00);
	}
	
	@Test
	public void checkSetUserProductChoice() {
		
	}

	
}
