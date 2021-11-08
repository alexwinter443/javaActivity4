package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.gcu.data.OrdersDataAccessInterface;
import com.gcu.data.OrdersDataService;
import com.gcu.data.OrdersDataServiceForRepository;
import com.gcu.model.OrderEntity;
import com.gcu.model.OrderModel;

public class OrdersBusinessService implements OrdersBusinessServiceInterface{
	
	//@Autowired
	//OrdersDataService ordersDAO;

	
	
	// uses dependency injection configured in the spring ConfigFile
	// to determine which database (fakeDAO or mysQL, still to be created) will be used
	//@Autowired
	//OrdersDataAccessInterface ordersDAO;	
	
	
	
	
	// uses dependency injection configured in the SPRING CONFIG file.
	// to determine which database (fakeDAO or mysql, still to be created) will be used.
	@Autowired
	OrdersDataServiceForRepository service;
	
	
	// CREATE LIST OF ORDERS
	private List<OrderModel> orders;
	

	@Override
	public void test() {
		System.out.println("The test method of the OrdersBusinessService appears to be working "
				+ "if you can see this test.");
	}
	
	
	@Override
	public void init() {
		System.out.println("Init method in OrdersBusinessService was just called.");
		orders = new ArrayList<OrderModel>();	
	}
	
	@Override
	public void destroy() {
		System.out.println("Destroy method of OrdersBusinessService was just called.");	
	}

	// We must translate from Entity to OrderModel !!
	@Override
	public List<OrderModel> getOrders() {
		// fetch a list of entities
		List<OrderEntity> ordersE = service.getOrders();
		// create an empty list of orders
		List<OrderModel> orders = new ArrayList<OrderModel>();
		// for each entity in list, create a new order and add to orders
		for (OrderEntity entity : ordersE) 
		{
			// translate from Entity to OrderModel
			orders.add(new OrderModel(entity.getId(), entity.getOrderNo(), entity.getProductName(), entity.getPrice(), entity.getQuantity()));
		}
		return orders;
	}
	
	// We must translate from Entity to OrderModel !!
	@Override
	public List<OrderModel> searchOrders(String searchTerm) {
		
			List<OrderEntity> ordersE = service.searchOrders(searchTerm);
			List<OrderModel> orders = new ArrayList<OrderModel>();
			
			for(OrderEntity entity : ordersE) {
				orders.add(new OrderModel(entity.getId(), entity.getOrderNo(), entity.getProductName(), entity.getPrice(), entity.getQuantity()));
			}
			return orders;
	}

	
	@Override
	public int addOne(OrderModel newOrder) {
		
		OrderEntity entity = new OrderEntity(newOrder.getId(), newOrder.getOrderNo(), newOrder.getProductName(), newOrder.getPrice(), newOrder.getQuantity());
		return service.addOne(entity);
	}

	@Override
	public boolean deleteOne(long l) {
		return service.deleteOne(l);
	}

	@Override
	public OrderModel updateOne(long idToUpdate, OrderModel updateOrder) {
		
		OrderEntity entity = new OrderEntity(updateOrder.getId(), updateOrder.getOrderNo(), updateOrder.getProductName(), updateOrder.getPrice(), updateOrder.getQuantity());
				
		OrderEntity result = service.updateOne(idToUpdate, entity);
		
		OrderModel updated = new OrderModel(result.getId(), result.getOrderNo(), result.getProductName(), result.getPrice(), result.getQuantity());
		
		return updated;
		
	}

	@Override
	public OrderModel getOne(int id) {
		
		OrderEntity result = service.getById(id);
		
		OrderModel order = new OrderModel(result.getId(), result.getOrderNo(), result.getProductName(), result.getPrice(), result.getQuantity());
		
		return order;		
				
				
	}
	
	
}
