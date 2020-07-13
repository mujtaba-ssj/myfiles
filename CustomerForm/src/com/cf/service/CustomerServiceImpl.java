package com.cf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cf.dao.CustomerDao;
import com.cf.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	@Transactional
	@Override
	public List<Customer> getCustomers() {
		
		return customerDao.getCustomers();
	}

	@Transactional
	@Override
	public void saveCustomer(Customer theCustomer) {
		// TODO Auto-generated method stub
		customerDao.saveCustomer(theCustomer);
	}

	@Transactional
	@Override
	public Customer getCustomers(int theId) {
		// TODO Auto-generated method stub
		return customerDao.getCustomers(theId);
		
	}

	@Transactional
	@Override
	public void deleteCustomer(int theId) {
		customerDao.deleteCustomer(theId);
	}

	@Transactional
	@Override
	public List<Customer> searchCustomers(String name) {
		// TODO Auto-generated method stub
		return customerDao.searchCustomer(name);
	}

}
