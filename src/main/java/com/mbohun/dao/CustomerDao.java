package com.mbohun.dao;

import java.util.List;

import com.mbohun.model.Customer;

public interface CustomerDao {
	List<Customer> findAll();
}
