package com.springmvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.models.Customer;
import com.springmvc.repository.CustomerDAO;

@Service
public class CustomerManagerServiceImpl implements CustomerManagerService {

	@Autowired
	CustomerDAO customerDAO;

	@Override
	public int saveUser(Customer customer) {
		System.out.println("Inside Service Layer");
		return customerDAO.saveCustomer(customer);
	}

	@Override
	public List<Customer> listAllCustomers() {
		return customerDAO.listAllCustomers();
	}
}