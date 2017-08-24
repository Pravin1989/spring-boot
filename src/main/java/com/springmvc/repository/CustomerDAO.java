package com.springmvc.repository;

import java.util.List;

import com.springmvc.models.Customer;

public interface CustomerDAO {
	public int saveCustomer(Customer customer);

	public List<Customer> listAllCustomers();
}