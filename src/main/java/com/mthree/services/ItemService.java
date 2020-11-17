package com.mthree.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mthree.daos.ItemDAO;
import com.mthree.daos.ItemRepository;
import com.mthree.models.Item;

@Service
public class ItemService implements ItemDAO{
	
	@Autowired
	private ItemRepository itemRepository;

	@Override
	public Item registerItem(Item i) {
		return itemRepository.save(i);
	}

	@Override
	public ArrayList<Item> getItems() {
		ArrayList<Item> items = new ArrayList<>();
		itemRepository.findAll().forEach(items::add);
	    return items;
	}

	@Override
	public Item getItemById(Integer id) {
		return itemRepository.getOne(id);
	}
	
	@Override
	public void deleteItemById(Integer itemID) {
		itemRepository.delete(itemRepository.getOne(itemID));		
	}
	
	public void populateItemsDB() {
		Item i = new Item("Tv", 123);
		Item i2 = new Item("Radio", 23);
		
		itemRepository.save(i);
		itemRepository.save(i2);
	}
	
	public ArrayList<Item> deleteItemFromListById(ArrayList<Item> list, Integer id) {
	    Item findItem = list.stream().filter(item -> id.equals(item.getItemId())).findAny().orElse(null);		
		if(findItem != null) {
			list.remove(findItem);
			return list;
		}
		return null;
	}
	
	public ArrayList<Item> addItemToList(ArrayList<Item> list, Item item) {
		list.add(item);
	    return list;
	}
	
	public void deleteItem(Item item) {
		itemRepository.delete(item);		
	}

}
