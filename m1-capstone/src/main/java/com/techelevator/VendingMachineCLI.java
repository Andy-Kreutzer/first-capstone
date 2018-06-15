package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.techelevator.view.Menu;

@SuppressWarnings("unused")
public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS,
													   MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };
	private static final String SUB_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String SUB_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String SUB_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] SUB_MENU_OPTIONS = { SUB_MENU_OPTION_FEED_MONEY, SUB_MENU_OPTION_SELECT_PRODUCT, SUB_MENU_OPTION_FINISH_TRANSACTION};
	
	
	private Menu menu;
	
	static ArrayList <Product> productList = new ArrayList <Product> ();
	static Map <String, Product> slotProductMap = new HashMap <String, Product> ();
	static List <String> arrayOfLines = new ArrayList <String> ();
	static List <String> fieldArray = new ArrayList <String> ();
	static FileWriteIn fileInArrayList;
	private double custBalance;
	
	Money money = new Money();
	
	
	
	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}
	
	public void run() {
		while(true) {
			String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			
			if(choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
			displayProducts();
			} else if(choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				boolean keepGoing = true;		
				while (keepGoing == true) {
					custBalance = money.getCurrentMoney();
					System.out.println("\n Current Balance: $" + custBalance);	
					String subChoice = (String)menu.getChoiceFromOptions(SUB_MENU_OPTIONS);
					if (subChoice.equals(SUB_MENU_OPTION_FEED_MONEY)) {
						money.userMoney();
					} else if(subChoice.equals(SUB_MENU_OPTION_SELECT_PRODUCT)) {
						//System.out.println(fileInArrayList.toString());
					}
					else  {
						money.returnChange();
						keepGoing = false;
					}
				}
			}
			else {
				System.exit(3);
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		fileRead();
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
	
	public static void fileRead () throws IOException {
		File newFile = new File("vendingmachine.csv");
		try(Scanner fileScanner = new Scanner(newFile)) {
			while(fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				arrayOfLines.add(line);
			}
		}
	}
	
	public List<String> getProductsToFill() {
		return arrayOfLines;
	}
	
	public void displayProducts() {
		for (int i = 0; i < arrayOfLines.size(); i++) {
			String[] fields = arrayOfLines.get(i).split("\\|");
			System.out.println(fields[0]+": "+fields[1]+"  $"+fields[2]);
		}
	}			

}




