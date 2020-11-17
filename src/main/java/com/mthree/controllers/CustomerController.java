package com.mthree.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.mthree.models.Customer;
import com.mthree.models.Item;
import com.mthree.services.CustomerService;
import com.mthree.services.ItemService;

@Controller
@SessionAttributes({"logedInUser", "itemList"})
public class CustomerController {

	
	@Autowired
	private CustomerService customerService;
	@Autowired
	private ItemService itemService;
	
	
	@ModelAttribute("loggedInUser")
	public Customer customer() {
		return new Customer();
	}
	
	@ModelAttribute("itemList")
	public List<Item> itemKist() {
		return new ArrayList<>();
	}
	

	@GetMapping("/")
	public String index(ModelMap model) {
		return "index";  
	}
	
	
	@GetMapping("/regForm")
	public String registerForm() {
		return "register";  //Name of the page has to be loaded. 
							// By default Spring Boot searches dependencies from the application.properties
							// spring.mvc.view.prefix=/WEB-INF/views/
							// spring.mvc.view.suffix=.jsp
	}
	
	@GetMapping("/change")
	public String updateForm(ModelMap model) {
		return "update"; 
	}
	
	@PostMapping("/buyItem")  
	public String buyItem(@RequestParam("productID") Integer itemID,  ModelMap model) {
		Customer customer = (Customer) model.getAttribute("logedInUser");
		customer.addToBasket(itemService.getItemById(itemID));
		model.addAttribute("logedInUser", customer);
		
		ArrayList<Item> list = (ArrayList<Item>) model.getAttribute("itemList");
		list = itemService.deleteItemFromListById(list , itemID);
		model.addAttribute("itemList", list);
		return "greetings";
	}
	
	@PostMapping("/dropItem")  
	public String dropItem(@RequestParam("productID") Integer itemID,  ModelMap model,@ModelAttribute("logedInUser") Customer customer,
			@ModelAttribute("itemList") ArrayList<Item> list) {
	//	Customer customer = (Customer) model.getAttribute("logedInUser");
		Item item = customer.dropFromBasket(itemID);
		model.addAttribute("logedInUser", customer);
		
		//ArrayList<Item> list = (ArrayList<Item>) model.getAttribute("itemList");
		list = itemService.addItemToList(list, item);
		model.addAttribute("itemList", list);
		return "greetings";
	}
	
	
	@PostMapping("/registerCustomer") 
	public String regCustomer(@ModelAttribute Customer c) {
				
		// Calls registerCustomer method in Service class
		Customer registerCustomer = customerService.registerCustomer(c);
		
		if(registerCustomer!=null) {
			return "success";
		}
		else {
			return "failure";
		}
	}
	
	@PostMapping("/updateCustomer") 
	public String updCustomer(@ModelAttribute Customer c, ModelMap model) {
		
		Customer oldCustomer = (Customer) model.getAttribute("logedInUser");		
		Customer registerCustomer = customerService.updateCustomer(oldCustomer, c);
		registerCustomer.setBasket(oldCustomer.getBasket());
		
		model.addAttribute("logedInUser", c);
		
		return "successUpdate";
		
//		Customer oldCustomer = (Customer) model.getAttribute("logedInUser");		
//		Customer registerCustomer = customerService.updateCustomer(oldCustomer, c);
//		model.addAttribute("logedInUser", c);
//		
//		if(registerCustomer!=null) {
//			return "successUpdate";
//		}
//		else {
//			return "faliureUpdate";
//		}
	}
	
	@PostMapping("/login")  
	public String login(@RequestParam("customerName") String customerName, @RequestParam("password") String password, ModelMap model) {
//		itemService.populateItemsDB();
		Customer c = customerService.validCredentials(customerName, password);
		ArrayList<Item> l = itemService.getItems();
		if(c==null) {
			return "failureLogin";
		}
		if(c.getBasket() == null) {	
			c.setNewBasket();
			model.addAttribute("logedInUser", c);
			model.addAttribute("itemList", l);
		}
		
		return "greetings";
	}
	
	@GetMapping("/logout") 
	public String logout(ModelMap model) {
//		model.clear();
		return "index";
	}
	
	@GetMapping("/checkout") 
	public String checkout(ModelMap model) {
		Customer customer = (Customer) model.getAttribute("logedInUser");
		ArrayList<Item> list = customer.getBasket();
		for(Item i : list)
		itemService.deleteItem(i);
		return "checkout";
	}
	
	@GetMapping("/settings") 
	public String settings(ModelMap model) {
		return "settings";
	}
	
	@GetMapping("/greetings") 
	public String greetings(ModelMap model) {
		return "greetings";
	}
}
