package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class MoneyTest {

	@Test
	public void testCurrentMoney() {
		Money money = new Money();
		
		money.setCurrentMoney(10);
		Assert.assertEquals(10, money.getCurrentMoney(), 0.0);
		
		money.subtractMoney(5);
		Assert.assertEquals(5, money.getCurrentMoney(), 0.0);
		
	}

}
