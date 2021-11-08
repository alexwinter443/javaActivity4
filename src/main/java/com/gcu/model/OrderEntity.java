package com.gcu.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("ORDERS")
public class OrderEntity {
	
	@Id
	@Column("ID")
	int id = 0;
	
	@Column("ORDER_NUMBER")
	String orderNo = "";
	
	@Column("PRODUCT_NAME")
	String productName = "";
	
	@Column("PRICE")
	float price = 0;
	
	@Column("Quantity")
	int quantity = 0;
	
	public OrderEntity(int id,String orderNo, String productName, float price, int quantity)
	{
		this.id = id;
		this.orderNo = orderNo;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
		
	}
	
	@Override
	public String toString() {
		return "OrderModel [id = " + id + ", orderNo = " + orderNo + ", productName = " + productName + 
				", price = " + price + ", quantity = " + "]";
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
