package com.techelevator.view;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.techelevator.Money;


public class MenuTwo {
	
	private Scanner nScan = new Scanner(System.in);
	private String moneyString;
	private double checkMoney;
	private String userProductChoice;
	private static Money money = new Money();
	static PrintWriter writer;
	static Menu menu;
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
	private DecimalFormat f = new DecimalFormat("#0.00");
	
	
	public MenuTwo() {
	}

	public void printToFile (String option, double d, BigDecimal custBalance) throws IOException {
		try {
		writer = new PrintWriter(new FileOutputStream("VendingLog.txt", true));
		}
		catch (FileNotFoundException e){
            System.out.println("Error opening the file stuff.txt.");
            System.exit(0);
        }
		writer.println(dateFormat.format(date) + " " + option + "   $" + custBalance  + "   $" + f.format(d));
		writer.close();
	}
	
	public void displayProducts(List <String> arrayLines) {
		for (int i = 0; i < arrayLines.size(); i++) {
			String[] fields = arrayLines.get(i).split("\\|");
			System.out.println(fields[0]+": "+fields[1]+"  $"+fields[2]);
		}
	}
	
	public double setUserDeposit () {
		System.out.print("\n Enter money in whole currency: $");
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
	
	public void returnInsufficientFunds () {
		System.out.println("\n Insufficient funds for product choice, please choose again!");
	}
	
	public String setUserProductChoice () {
		System.out.print("\n Enter the produt code you want: ");
		userProductChoice = nScan.nextLine();
		return userProductChoice;
	}
	
	public void returnOutOfProducts() {
		System.out.println("\nSelection is out of inventory, please select another product!");
	}
	
	public String getUserProductChoice () {
		return userProductChoice;
	}
	
}
