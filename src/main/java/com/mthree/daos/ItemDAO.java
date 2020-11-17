package com.mthree.daos;

import java.util.ArrayList;
import java.util.List;

import com.mthree.models.Item;

public interface ItemDAO {
	
	Item registerItem(Item i);
	
	List<Item> getItems();
	
	Item getItemById(Integer id);
	
	void deleteItemById(Integer itemID);
}
