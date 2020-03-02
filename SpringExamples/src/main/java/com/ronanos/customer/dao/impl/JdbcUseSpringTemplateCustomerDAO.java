package com.ronanos.customer.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.ronanos.customer.dao.CustomerDAO;
import com.ronanos.customer.model.Customer;
import com.ronanos.customer.model.CustomerRowMapper;

public class JdbcUseSpringTemplateCustomerDAO extends JdbcDaoSupport implements CustomerDAO
{
	//no need to set datasource here
	public void insert(Customer customer){

		String sql = "INSERT INTO CUSTOMER " +
				"(CUST_ID, NAME, AGE) VALUES (?, ?, ?)";

		getJdbcTemplate().update(sql, new Object[] { customer.getCustId(),
				customer.getName(),customer.getAge()  
		});

	}

	
	public Customer findByCustomerId(int custId){
		
		String sql = "SELECT * FROM CUSTOMER WHERE CUST_ID = ?";


		Customer customer = (Customer)getJdbcTemplate().queryForObject(
				sql, new Object[] { custId }, new CustomerRowMapper());
	
		return customer;
	}
}