package com.mthree.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Item {
	
	@Id
	@GeneratedValue // For Auto increment
	@Column(name="id")
	private Integer itemId;
	
	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	@Column(name="price")
	int price;
	
	@Column(name="name")
	String itemName;
	
//	@Transient
//	@ManyToOne
//	@JoinColumn(name="customer_id")
//	private Customer customerId;

	@Override
	public String toString() {
		return "Item [id=" + itemId + ", price=" + price +" EUR"+ ", name=" + itemName + "]";
	}

	public Item( String itemName, int price) {
		super();
		this.price = price;
		this.itemName = itemName;
	}	
	
	public Item() {
	}	
}
