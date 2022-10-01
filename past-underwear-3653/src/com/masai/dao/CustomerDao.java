package com.masai.dao;

import java.util.List;

import com.masai.bean.Customer;
import com.masai.exceptions.CustomerException;

public interface CustomerDao {
	
	public String registerCustomer1(String cname, String source, String destination, String busNo);
	public String registerCustomer2(Customer customer);
	public Customer getCustomerByUsername(String username)throws CustomerException;
	public Customer loginCustomer (String username , String password) throws CustomerException;
	public List<Customer> getAllCustomerDetails() throws CustomerException;
	
}
