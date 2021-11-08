package com.gcu.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.gcu.model.OrderEntity;
import com.gcu.model.OrderModel;

@Service
public class OrdersDataServiceForRepository implements OrdersDataAccessInterface<OrderEntity>{

	/* 
	 *  uses OrdersDataAccessInterface for adding unimplemented methods
	 */
	
	// ordersRepository is defined as the CRUD repository in SPRING
	// I'm assuming this is its own interface with its own defined methods
	@Autowired
	private OrdersRepositoryInterface ordersRepository;
	@SuppressWarnings("unused")
	// datasource is defined in the application.properties file.
	private DataSource datasource;
	private JdbcTemplate jdbcTemplateObject;
	
	/*
	 * Non-Default constructor for constructor injection
	 */
	public OrdersDataServiceForRepository(OrdersRepositoryInterface ordersRepository, DataSource datasource)
	{
		this.ordersRepository = ordersRepository;
		this.datasource = datasource;
		this.jdbcTemplateObject = new JdbcTemplate(datasource);
	}
	
	
	@Override
	public OrderEntity getById(int id) {
		
		return ordersRepository.findById((long) id ).orElse(null);
		
	}

	@Override
	public List<OrderEntity> getOrders() {
		List<OrderEntity> orders = (List<OrderEntity>) ordersRepository.findAll();
		return orders;
	}

	@Override
	public List<OrderEntity> searchOrders(String searchTerm) {
		
		List<OrderEntity> result = ordersRepository.findByProductNameContainingIgnoreCase(searchTerm);
		return result;
	}

	@Override
	public int addOne(OrderEntity newOrder) {
		
		OrderEntity result = ordersRepository.save(newOrder);
		if(result == null) {
			return 0;
		}
		return ((int) result.getId());
	}

	@Override
	public boolean deleteOne(long id) {
		
		ordersRepository.deleteById(id);
		return true;
	}

	@Override
	public OrderEntity updateOne(long idToUpdate, OrderEntity updateOrder) {
		
		OrderEntity result = ordersRepository.save(updateOrder);
		return result;
	}
	
	

}
