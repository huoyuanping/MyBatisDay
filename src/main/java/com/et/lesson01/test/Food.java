package com.et.lesson01.test;

public class Food {
	private String foodname;
	private String price;
	
	public Food(){
		
	}

	public Food(String foodname, String price) {
		super();
		this.foodname = foodname;
		this.price = price;
	}

	public String getFoodname() {
		return foodname;
	}

	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
}
