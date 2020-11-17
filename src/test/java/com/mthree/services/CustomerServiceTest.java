package com.mthree.services;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

import com.mthree.daos.CustomerRepository;
import com.mthree.models.Customer;

@SpringBootTest
class CustomerServiceTest {
	
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private CustomerService customerService;

	@Test
	void TestRegisterCustomer(Customer c) {
//		Customer test = customerService.registerCustomer(new Customer(987, "test"));
//		assertNotNull(test);
	}

}
