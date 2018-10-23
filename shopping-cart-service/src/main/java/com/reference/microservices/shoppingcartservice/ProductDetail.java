package com.reference.microservices.shoppingcartservice;

import org.springframework.data.annotation.Id;

public class ProductDetail {
	
	private int product_id;
	private String product_Short;
	private String product_Long;
	private int price;
	
	public ProductDetail() {}
	
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_Short() {
		return product_Short;
	}
	public void setProduct_Short(String product_Short) {
		this.product_Short = product_Short;
	}
	public String getProduct_Long() {
		return product_Long;
	}
	public void setProduct_Long(String product_Long) {
		this.product_Long = product_Long;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
