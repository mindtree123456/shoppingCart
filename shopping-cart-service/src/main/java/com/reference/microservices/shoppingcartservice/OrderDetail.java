package com.reference.microservices.shoppingcartservice;
//import javax.persistence.Id;
import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "testMS")
public class OrderDetail {

	@Id
	private String id;	
	
	private int customer_id;
	private Long order_value;
	private ProductDetail productDetail;
	private int quantity;
	
	public OrderDetail() {}
	
	public OrderDetail(String id, int customer_id, Long order_value, ProductDetail productDetail,
			int quantity) {
		super();
		this.id = id;
		this.customer_id = customer_id;
		this.order_value = order_value;
		this.productDetail = productDetail;
		this.quantity = quantity;
	}
	

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public Long getOrder_value() {
		return order_value;
	}
	public void setOrder_value(Long order_value) {
		this.order_value = order_value;
	}
	public ProductDetail getProductDetail() {
		return productDetail;
	}
	public void setProductDetail(ProductDetail productDetail) {
		this.productDetail = productDetail;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
