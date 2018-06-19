package com.techelevator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.techelevator.products.Chips;
import com.techelevator.products.Product;
import com.techelevator.view.Menu;
import com.techelevator.view.MenuTwo;

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
	private static MenuTwo menuTwo = new MenuTwo();
	private static List <String> arrayOfLines = new ArrayList <String> ();
	private BigDecimal custBalance = new BigDecimal("0.00");
	private static String userProductChoice;
	private int itemsPerSlot = 5;
	private Money money = new Money();
	private static Inventory inventory = new Inventory();
	private String productSelection;
	private static Slot slot = new Slot();
	private static Map <String, ArrayList<Product>> slotMap = new LinkedHashMap<String, ArrayList<Product>>();
	
	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}
	
	public void run() throws IOException {
		while(true) {
			String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			
			if(choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
			menuTwo.displayProducts(arrayOfLines);
			} else if(choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				boolean keepGoing = true;		
				while (keepGoing == true) {
					custBalance = new BigDecimal(money.getCurrentMoney()).setScale(2, RoundingMode.HALF_UP);
					System.out.println("\n Current Balance: $" + custBalance);
					String subChoice = (String)menu.getChoiceFromOptions(SUB_MENU_OPTIONS);
					if (subChoice.equals(SUB_MENU_OPTION_FEED_MONEY)) {
						money.setCurrentMoney(menuTwo.setUserDeposit());
						menuTwo.printToFile("Feed Money", money.getCurrentMoney(), custBalance);
					} 
					else if(subChoice.equals(SUB_MENU_OPTION_SELECT_PRODUCT)) {
						userProductChoice = menuTwo.setUserProductChoice();
						handleProductChoice();
						menuTwo.printToFile(slotMap.get(userProductChoice).get(1).getProductName(), money.getCurrentMoney(), custBalance);
					}
					else  {
						money.returnChange();
						menuTwo.printToFile("Return Change", money.getCurrentMoney(), custBalance);
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
		slot.getProductsInSlot();
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
		Map <String, ArrayList<Product>> loadedSlots = new LinkedHashMap <String, ArrayList<Product>> (inventory.createProduct(arrayOfLines));
		slotMap = loadedSlots;
	}
	
	public Map<String, ArrayList<Product>> getSlotMap() {
		return slotMap;
	}

	public void handleProductChoice() {
		ArrayList<Product> productList = slotMap.get(userProductChoice);
		Product product = productList.get(0);
		if (product != null) {
			if (product.getProductPrice() > money.getCurrentMoney()) {
				menuTwo.returnInsufficientFunds();
			}
			else {
				System.out.println(product.makeNoise());
				System.out.println(product.getProductName() + "  $" + product.getProductPrice());
				slotMap = slot.reduceInventoryInSlot(userProductChoice, slotMap);
				money.subtractMoney(product.getProductPrice());
				money.getCurrentMoney();
			}
		}
		else {
			menuTwo.returnOutOfProducts();
		}
	}
}


	





