package com.springmvc.services;

import java.util.List;

import com.springmvc.models.Customer;

public interface CustomerManagerService {
	public int saveUser(Customer user);

	public List<Customer> listAllCustomers();
}
