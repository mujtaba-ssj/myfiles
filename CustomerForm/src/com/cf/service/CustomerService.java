package com.cf.service;

import java.util.List;

import com.cf.entity.Customer;

public interface CustomerService {

	List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomers(int theId);

	public void deleteCustomer(int theId);

	public List<Customer> searchCustomers(String name);
}
