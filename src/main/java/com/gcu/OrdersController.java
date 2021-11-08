package com.gcu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.business.OrdersBusinessServiceInterface;
import com.gcu.model.OrderModel;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {
	
	// This will get one of the two orders Services we have defined
	// The SpringConfig.java file determines whether the app will return
	// either junk food (SecondOrdersBusinessService) or exciting summer fun (OrdersBusinessService).
	
	// uses dependency Injection configuration found in the spring config file.
	// to choose which business service will be utilized.
	@Autowired
	private OrdersBusinessServiceInterface ordersService;
	
	@GetMapping("/")
	public List<OrderModel> showAllOrders(){
		return ordersService.getOrders();
	}
	
	@GetMapping("/{id}")
	public OrderModel getOne(@PathVariable(name="id") int id) {
		return ordersService.getOne(id);
	}
	
	@GetMapping("/searchTerm/{searchTerm}")
	public List<OrderModel> searchOrders(@PathVariable(name="searchTerm") String searchTerm){
		return ordersService.searchOrders(searchTerm);
	}
	
	@PostMapping("/addOrder")
	public OrderModel addOrder(@RequestBody OrderModel addOrder) {
		ordersService.addOne(addOrder);
		return addOrder;
	}
	
	@DeleteMapping("/deleteOrder/{id}")
	public boolean deleteOrder(@PathVariable(name="id") int id) {
		return ordersService.deleteOne(id);
	}
	
	@PutMapping("/updateOrder")
	public OrderModel updateOrder(@RequestBody OrderModel updateOrder) {
		return ordersService.updateOne(updateOrder.getId(), updateOrder);
	}
	
	
	
	
	
	
	
	
	
	
//	@GetMapping("/")
//	public String showAllOrders(Model model)
//	{
//		
//		// Create some orders
//		// this version of the controller will always send back the same list of products
//		// first version does not use the business service nor dependency injection
//		ordersService.test();
//		
//		List<OrderModel> orders = ordersService.getOrders();
//		
//		model.addAttribute("title", "Here is what you ordered");
//		model.addAttribute("orders", orders);
//		return "orders";
//		
//		
//	}

	
//	@GetMapping("/")
//	public String showAllOrders(Model model)
//	{
//		
//		// Create some orders
//		// this version of the controller will always send back the same list of products
//		// first version does not use the business service nor dependency injection
//		
//		List<OrderModel> orders = new ArrayList<OrderModel>();
//		orders.add(new OrderModel(0L, "000", "Sky Diving Experience", 1500.0f, 7));
//		orders.add(new OrderModel(1L, "001", "Run with the bulls in Rome", 1500.0f, 4));
//		orders.add(new OrderModel(2L, "002", "Experience Japan with a daylong tour", 1500.0f, 10));
//		orders.add(new OrderModel(3L, "003", "Experience the Luau at Hawaii", 1500.0f, 20));
//		orders.add(new OrderModel(4L, "004", "Swim with the turtles", 1500.0f, 20));
//		orders.add(new OrderModel(5L, "005", "Cruise along the caribbean", 1500.0f, 21));
//		orders.add(new OrderModel(6L, "006", "Hike along the Grand Canyon", 1500.0f, 12));
//		orders.add(new OrderModel(7L, "007", "Enjoy a helicopter ride", 1500.0f, 12));
//		orders.add(new OrderModel(8L, "008", "Jetski in Hawaii", 1500.0f, 11));
//		orders.add(new OrderModel(9L, "009", "Fish along the coast of California", 1500.0f, 11));
//		orders.add(new OrderModel(10L, "010", "Explore the wonders of New York", 1500.0f, 12));
//		orders.add(new OrderModel(11L, "011", "Europe Vacation Package", 1500.0f, 10));
//		
//		model.addAttribute("title", "Here is what I want to do this summer");
//		model.addAttribute("orders", orders);
//		return "orders";
//		
//		
//	}
	
	
}
