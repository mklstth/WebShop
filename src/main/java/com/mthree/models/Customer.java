package com.mthree.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer{
		
	@Id
	@GeneratedValue // For Auto increment
	@Column(name="id")
	private int customerId;

	@Column(name="name")
	private String customerName;

	@Column(name="email")
	private String email;
	
	@Column(name="firstName")
	private String firstName;

	@Column(name="familyName")
	private String familyName;
	
	@Column(name="password")
	private String password;
	
//	@OneToMany(mappedBy = "customerId")
	@javax.persistence.Transient
	ArrayList<Item> basket;
	
	public ArrayList<Item> getBasket(){
		return basket;
	}

	public String getPassword(){
		return password;
	}
	
	public int getCustomerId() {
		return customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setBasket(ArrayList<Item> basket) {
		this.basket = basket;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setNewBasket() {
		this.basket = new ArrayList();
	}

	public void addToBasket(Item item) {
		basket.add(item);		
	}
	
	public Item dropFromBasket(Integer id){
		Item findItem = basket.stream().filter(item -> id.equals(item.getItemId())).findAny().orElse(null);		
		if(findItem != null) {
			basket.remove(findItem);
			return findItem;
		}
		return null;
	}

	
}
