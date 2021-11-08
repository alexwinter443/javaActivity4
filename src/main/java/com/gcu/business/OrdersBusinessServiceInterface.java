package com.gcu.business;

import java.util.List;

import com.gcu.model.OrderModel;

public interface OrdersBusinessServiceInterface {
	
	public void test();
	public List<OrderModel> getOrders();
	
	public OrderModel getOne(int id);
	public List<OrderModel> searchOrders(String searchTerm);
	public int addOne(OrderModel orderModel);
	public boolean deleteOne(long l);
	public OrderModel updateOne(long idToUpdate, OrderModel updateOrder);
	
	public void init();
	public void destroy();
	
}
