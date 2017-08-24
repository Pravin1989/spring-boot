package com.springmvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.models.Customer;
import com.springmvc.services.CustomerManagerService;

/**
 * @author pravin.budage This is the customer controller which perform
 *         operations related to customer. i.e. create and list the customers.
 */
@Controller
public class CustomerController {
	
	private static Logger logger = LoggerFactory
			.getLogger(CustomerController.class);
	/**
	 * This is customer service instance
	 */
	@Autowired
	CustomerManagerService customerService;

	/**
	 * This method saves the form data
	 * 
	 * @param model
	 * @param customer
	 * @return
	 */
	@RequestMapping(value = "/saveCustomerData", method = RequestMethod.POST)
	public ModelAndView createCustomer(Model model,
			@ModelAttribute("customer") Customer customer) {
		ModelAndView modelAndView = new ModelAndView("customerDetails");
		customerService.saveUser(customer);
		modelAndView.addObject("customers", customerService.listAllCustomers());
		return modelAndView;	
	}

	/**
	 * This method navigates to create customer page
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/createCustomer")
	public String welcome(Model model) {
		model.addAttribute("customer", new Customer());
		return "createCustomer";

	}

	/**
	 * This method returns the list of customers.
	 * 
	 * @return
	 */
	@RequestMapping(value = "/listCustomers")
	public ModelAndView getCustomerDetails() {
		logger.info("Inside Customer Details Controller");
		ModelAndView model = new ModelAndView("customerDetails");
		model.addObject("customers", customerService.listAllCustomers());
		return model;
	}
}