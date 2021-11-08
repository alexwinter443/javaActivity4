package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.OrdersDataAccessInterface;
import com.gcu.model.OrderEntity;
import com.gcu.model.OrderModel;

public class SecondOrdersBusinessService implements OrdersBusinessServiceInterface{

	private List<OrderModel> orders;
	
	
	
	@Autowired
	OrdersDataAccessInterface ordersDAO;
	
	@Override
	public void test() {
		System.out.println("The test method of SecondOrdersBusinessService is working.");
		
	}

	@Override
	public void init() {
		System.out.println("Init method of SECOND ordersbusinessService was called.");
		orders = new ArrayList<OrderModel>();	
	}
	
	@Override
	public void destroy() {
		System.out.println("Destroy method of SECONDOrdersBusinessService was just called.");
	}
	
	@Override
	public List<OrderModel> getOrders() {
		return ordersDAO.getOrders();
	}

	@Override
	public List<OrderModel> searchOrders(String searchTerm) {
		return ordersDAO.searchOrders(searchTerm);
	}
	
	@Override
	public OrderModel getOne(int id) {
		return (OrderModel) ordersDAO.getById(id);
	}

	@Override
	public int addOne(OrderModel orderModel) {
		return ordersDAO.addOne(orderModel);
	}

	@Override
	public boolean deleteOne(long l) {
		return ordersDAO.deleteOne(l);
	}

	@Override
	public OrderModel updateOne(long idToUpdate, OrderModel updateOrder) {
		return (OrderModel) ordersDAO.updateOne(idToUpdate, updateOrder);
	}
	
//	@Override
//	public List<OrderModel> getOrders() {
//		orders.add(new OrderModel(10L, "AAA", "Big Mac", 3.00f, 5));
//		orders.add(new OrderModel(10L, "AAB", "Large Fries", 3.00f, 5));
//		orders.add(new OrderModel(10L, "AAC", "Chicken Nuggets", 3.00f, 5));
//		orders.add(new OrderModel(10L, "AAD", "Coke", 3.00f, 5));
//		orders.add(new OrderModel(10L, "AAE", "Apple Pie", 3.00f, 5));
//		
//		return orders;
//	}

}
