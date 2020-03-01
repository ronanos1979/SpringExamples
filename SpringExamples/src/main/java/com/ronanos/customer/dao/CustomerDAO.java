package com.ronanos.customer.dao;

import com.ronanos.customer.model.Customer;

public interface CustomerDAO {
	public void insert(Customer customer);
	public Customer findByCustomerId(int custId);
}