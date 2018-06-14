package com.techelevator;

import java.util.ArrayList;

public class FileWriteIn {

	private String productSlot;
	private String productName;
	private String productPrice;
	private String productType;
	
	public FileWriteIn() {
	
	}

	@Override
	public String toString() {
		return "Slot [productSlot=" + productSlot + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productType=" + productType + "]" + "\n";
	}

	public String getProductSlot() {
		return productSlot;
	}

	public String getProductName() {
		return productName;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductSlot(String productSlot) {
		this.productSlot = productSlot;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	


}
