package com.gcu;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import com.gcu.business.OrdersBusinessService;
import com.gcu.business.OrdersBusinessServiceInterface;
import com.gcu.business.SecondOrdersBusinessService;
import com.gcu.business.SecurityServiceInterface;
import com.gcu.data.OrdersDataAccessInterface;
import com.gcu.data.OrdersDataService;
import com.gcu.model.FiveValidLogins;

@Configuration
public class SpringConfig {
	
	DataSource datasource;
	
	@Bean(name="ordersBusinessService", initMethod="init", destroyMethod="destroy")
	//@Scope(value="prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
	//@SessionScope
	public OrdersBusinessServiceInterface getOrdersBusinessService() 
	{
		/*
		 * Show ordering vacation packages
		 */
		return new OrdersBusinessService();
		
		
		/*
		 * Show ordering a meal
		 */
		//return new SecondOrdersBusinessService();
	}
	
	@Bean(name="securityService")
	public SecurityServiceInterface getSecurityService()
	{
		
		return new FiveValidLogins();
		
	}
	

}
