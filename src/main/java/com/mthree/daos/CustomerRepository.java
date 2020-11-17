package com.mthree.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mthree.models.Customer;

//Closest layer to DB 
 
@Repository												//...this  // this matching with primary key field of... 
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	//Spring Data JPA GENERATE QUERYs!!!!!!!!!!!!
	// We can jsut call predefined methodes as we extended this JPARepo, no need to qrite querys
	
	List<Customer> findCustomerByCustomerName(String customerName);
	Customer findCustomerByCustomerNameAndPassword(String customerName, String password);
}
