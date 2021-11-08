package com.gcu.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class OrdersMapper implements RowMapper<OrderModel>{
	
	/* Match the property names in Order Model with the column names in the database 
	 * 
	 * Class          Table
	 * Properties 	  Column Names
	 * =============================
	 * id             ID 
	 * orderNo        ORDER_NUMBER
	 * productName    PRODUCT_NAME
	 * price          PRICE
	 * quantity       QUANTITY
	 */

	@Override
	public OrderModel mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		
		OrderModel order = new OrderModel(
				resultSet.getInt("ID"),
				resultSet.getString("ORDER_NUMBER"),
				resultSet.getString("PRODUCT_NAME"),
				resultSet.getFloat("PRICE"),
				resultSet.getInt("QUANTITY")
				);
	
		return order;
	}

}
