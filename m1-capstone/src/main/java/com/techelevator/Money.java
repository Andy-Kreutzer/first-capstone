package com.techelevator;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Money {
	
	public Money () {
		
	}
	
	private String moneyInput;
	private double totalMoney;

	public double addMoney (String userInput) {
		moneyInput = userInput.substring(5,userInput.length()-1);
		this.totalMoney = Double.parseDouble(moneyInput);
		return this.totalMoney;
	}
	
}
