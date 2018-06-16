package com.techelevator.view;

import java.util.List;
import java.util.Scanner;

import com.techelevator.Money;

public class MenuTwo {
	
	private Scanner nScan = new Scanner(System.in);
	private String moneyString;
	private double checkMoney;
	private String userProductChoice;
	
	private Money money = new Money();
	
	public void MenuTwo() {
		
	}
	
	public void displayProducts(List <String> arrayLines) {
		for (int i = 0; i < arrayLines.size(); i++) {
			String[] fields = arrayLines.get(i).split("\\|");
			System.out.println(fields[0]+": "+fields[1]+"  $"+fields[2]);
		}
	}
	
	public double setUserDeposit ( ) {
		System.out.print("Enter money in whole currency: $");
		moneyString = nScan.nextLine();
		checkMoney = Double.parseDouble(moneyString);
		if (checkMoney % 1 == 0) {
			money.setCurrentMoney(checkMoney);
		}
		else {
			System.out.println("\n Money not accepted, must be a whole number.");
		}
		return checkMoney;
	}
	
	public String setUserProductChoice () {
		System.out.print("Enter the produt code you want: ");
		userProductChoice = nScan.nextLine();
		return userProductChoice;
	}
	
	
}
