package com.techelevator;

public class Money {
	
	private double totalMoney;
	private int quarters, dimes, nickels;
	
	public Money () {
		
	}
	
	public void setCurrentMoney(double userMoney) {
		this.totalMoney += userMoney;
	}
	
	public void subtractMoney (double moneySpent) {
		this.totalMoney -= moneySpent;
	}
	
	public void returnChange() {
		double change = this.totalMoney * 100;
		quarters = (int)(change / 25);
		change %= 25;
		dimes = (int)(change / 10);
		change %= 10;
		nickels = (int)(change / 5);
		change %= 5;
		System.out.println("\n Your change is: " + quarters + " quarters, " + dimes + " dimes, " + nickels + " nickels." );
		this.totalMoney = 0.0;
	}
	
	public double getCurrentMoney () {
		return this.totalMoney;
	}
}
