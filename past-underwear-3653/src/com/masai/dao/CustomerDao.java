package com.masai.dao;

import com.masai.bean.Customer;

public interface CustomerDao {
	public String registerCustomer1(String cname, String source, String destination, String busNo);
	public String registerCustomer2(Customer customer);
}
