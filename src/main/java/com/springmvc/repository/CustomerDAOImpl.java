package com.springmvc.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.controller.WelcomeController;
import com.springmvc.models.Customer;

@Repository(value="customerRepo")
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private static Logger logger = LoggerFactory
			.getLogger(CustomerDAOImpl.class);
	
	@Override
	public List<Customer> listAllCustomers() {
		
		List<Customer> customers = new ArrayList<Customer>();
		List<Map<String, Object>> rows = jdbcTemplate
				.queryForList("select * from customer_table");
		logger.info("Data from DB is retrieved");
		for (Map row : rows) {
			Customer customer = new Customer();
			customer.setCustomer_id((Integer) row.get("customer_id"));
			customer.setName((String) row.get("name"));
			customer.setEmail((String) row.get("email"));
			customer.setAddress((String) row.get("address"));
			customer.setSalary((Float) row.get("salary"));
			customers.add(customer);
		}		
		return customers;
	}

	@Override
	public int saveCustomer(Customer customer) {
		logger.info("Inside DAO layer");
		return jdbcTemplate
		.update("INSERT INTO customer_table(name, email, address,salary) VALUES (?,?,?,?)",
				customer.getName(), customer.getEmail(),
				customer.getAddress(), customer.getSalary());		
	}
}