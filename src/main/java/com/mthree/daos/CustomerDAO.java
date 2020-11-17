package com.mthree.daos;

import java.util.List;


import com.mthree.models.Customer;

public interface CustomerDAO {
	
	Customer registerCustomer(Customer c);
	
	List<Customer> getCustomers();
	
	Customer validCredentials(String customerName, String email);
	
//	String createSecurePW(String pw);
	
	Customer updateCustomer(Customer oldC, Customer c);

}
