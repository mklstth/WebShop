package com.mthree.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mthree.models.Item;

//Closest layer to DB 
 
@Repository												
public interface ItemRepository extends JpaRepository<Item, Integer>{

//	List<Item> findCustomerByCustomerName(String customerName);
//	Item findCustomerByCustomerNameAndPassword(String customerName, String password);
}