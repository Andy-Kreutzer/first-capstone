package com.techelevator;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Money {
	
	private double totalMoney;
	private double moneySpent;
	private int quarters, dimes, nickels;
	
	public Money () {
		
	}
	
	public void setCurrentMoney(Double userMoney) {
		this.totalMoney += userMoney;
	}
	public double moneySpent () {
		return this.moneySpent;
	}
	
	public void returnChange() {
		double change = this.totalMoney * 100;
		quarters = (int)(change / 25);
		change %= 25;
		dimes = (int)(change / 10);
		change %= 10;
		nickels = (int)(change / 5);
		change %= 5;
		System.out.println("Your change is: " + quarters + " quarters, " + dimes + " dimes, " + nickels + " nickels." );
		this.totalMoney = 0.0;
	}
	
	public double getCurrentMoney () {
		return this.totalMoney;
	}
}
