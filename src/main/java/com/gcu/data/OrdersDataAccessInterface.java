package com.gcu.data;

import java.util.List;

import com.gcu.model.OrderEntity;
import com.gcu.model.OrderModel;

public interface OrdersDataAccessInterface<T> {
	
	public T getById(int id);
	public List<T> getOrders();
	public List<T> searchOrders(String searchTerm);
	public int addOne(T newOrder);
	public boolean deleteOne(long id);
	public T updateOne(long idToUpdate, T updateOrder);

}
