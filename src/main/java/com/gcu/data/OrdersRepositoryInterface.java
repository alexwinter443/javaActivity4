package com.gcu.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.gcu.model.OrderEntity;
import com.gcu.model.OrderModel;

@Component
public interface OrdersRepositoryInterface extends CrudRepository<OrderEntity, Long>{
	
	List<OrderEntity> findByProductNameContainingIgnoreCase(String searchTerm);


}
