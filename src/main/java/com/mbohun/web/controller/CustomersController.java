package com.mbohun.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mbohun.dao.CustomerDao;
import com.mbohun.model.Customer;

@Controller
public class CustomersController {

	private static final Logger logger = LoggerFactory.getLogger(CustomersController.class);

	@Autowired
	CustomerDao customerDao;
	
	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public String customers(Model model) {
		List<Customer> customers = customerDao.findAll();
		System.out.println(customers);
		model.addAttribute("customers", customers);
		return "customers";
	}

}
