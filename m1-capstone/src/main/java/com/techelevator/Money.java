package com.techelevator;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import com.techelevator.products.Product;
import com.techelevator.view.MenuTwo;

public class Money {
	
	private double totalMoney;
	private int quarters, dimes, nickels;
	private double priceForItem;
	
	public Money () {
		
	}
	
	public void setCurrentMoney(Double userMoney) {
		this.totalMoney += userMoney;
	}
	
	public void takeMoneyFromTotal () {
		this.totalMoney -= priceForItem;
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
