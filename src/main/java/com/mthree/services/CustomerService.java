package com.mthree.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mthree.daos.CustomerDAO;
import com.mthree.daos.CustomerRepository;
import com.mthree.models.Customer;

@Service
public class CustomerService implements CustomerDAO{
		
	
	// We are replacing jdbcTemplate with Repository
	@Autowired
	private CustomerRepository customerRepository;

	
	@Override
	public Customer registerCustomer(Customer c) {
//		c.setPassword(createSecurePW(c.getPassword()));
		return customerRepository.save(c);
	}

	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Override
	public Customer validCredentials(String customerName, String password) {
				
		return customerRepository.findCustomerByCustomerNameAndPassword(customerName, password);
	}
	
	@Override
	public Customer updateCustomer(Customer oldC, Customer c) {
		customerRepository.delete(oldC);
		return customerRepository.save(c);
	}

//	@Override
//	public String createSecurePW(String pw) {
//		return new BCryptPasswordEncoder().encode(pw);
//	}
}
