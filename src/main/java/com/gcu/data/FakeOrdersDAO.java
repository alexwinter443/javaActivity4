package com.gcu.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.gcu.model.OrderModel;

@Repository
public class FakeOrdersDAO implements OrdersDataAccessInterface<OrderModel>{
	
	/* 
	 *  uses OrdersDataAccessInterface
	 */
	
	private List<OrderModel> orders = new ArrayList<OrderModel>();
	
	public FakeOrdersDAO() {
		
		orders = new ArrayList<OrderModel>();
		orders.add(new OrderModel(0, "000", "Sky Diving Experience", 1500.0f, 7));
		orders.add(new OrderModel(1, "001", "Run with the bulls in Rome", 1500.0f, 4));
		orders.add(new OrderModel(2, "002", "Experience Japan with a daylong tour", 1500.0f, 10));
		orders.add(new OrderModel(3, "003", "Experience the Luau at Hawaii", 1500.0f, 20));
		orders.add(new OrderModel(4, "004", "Swim with the turtles", 1500.0f, 20));
		orders.add(new OrderModel(5, "005", "Cruise along the caribbean", 1500.0f, 21));
		orders.add(new OrderModel(6, "006", "Hike along the Grand Canyon", 1500.0f, 12));
		orders.add(new OrderModel(7, "007", "Enjoy a helicopter ride", 1500.0f, 12));
		orders.add(new OrderModel(8, "008", "Jetski in Hawaii", 1500.0f, 11));
		orders.add(new OrderModel(9, "009", "Fish along the coast of California", 1500.0f, 11));
		orders.add(new OrderModel(10, "010", "Explore the wonders of New York", 1500.0f, 12));
		orders.add(new OrderModel(11, "011", "Europe Vacation Package", 1500.0f, 10));
		
	}

	@Override
	public OrderModel getById(int id) {
		
		for (int i = 0; i < orders.size(); i++) {
			if(orders.get(i).getId() == id) {
				return orders.get(id);
			}
			
		}
		return null;
		
	}

	@Override
	public List<OrderModel> getOrders() {
		// TODO Auto-generated method stub
		return orders;
	}

	@Override
	public List<OrderModel> searchOrders(String searchTerm) {
		
		List<OrderModel> foundItems = new ArrayList<OrderModel>();
		for (int i = 0; i < orders.size(); i++) {
			if(orders.get(i).getProductName().toLowerCase().contains(searchTerm.toLowerCase())){
				foundItems.add(orders.get(i));
			}
			
		}
		
		System.out.println("I searched for " + searchTerm + " and found " + foundItems.size() + " items.");
		return foundItems;
		
	}

	// add a new order to the order list
	@Override
	public int addOne(OrderModel newOrder) {
		
		boolean success = orders.add(newOrder);
		System.out.println("I added one item. Now there are " + orders.size() + " items in the list.");
		if(success) {
			return 1;
		}
		return 0;
		
	}

	//given the id number, delete one order from the list.
	@Override
	public boolean deleteOne(long id) {
		
		orders.removeIf(order ->order.getId() == id);
		//for testing print a status message to the server console
		System.out.println("I removed one item. Now there are " + orders.size() + " items in the list.");
		return true;
	}

	@Override
	public OrderModel updateOne(long idToUpdate, OrderModel updateOrder) {
		
		for (int i = 0; i < orders.size(); i++) {
			if(orders.get(i).getId() == idToUpdate) {
				orders.get(i).setOrderNo(updateOrder.getOrderNo());
				orders.get(i).setPrice(updateOrder.getPrice());
				orders.get(i).setProductName(updateOrder.getProductName());
				orders.get(i).setQuantity(updateOrder.getQuantity());
				System.out.println("Updated Order " + updateOrder);
				return updateOrder;
			}
			
		}
		
		System.out.println("You asked me to update order number " + idToUpdate + ". The updated order is " +
				updateOrder.toString());
		
		return null;
		
		
		
	}

}
