package com.masai.usecases;

import java.util.List;

import com.masai.bean.Customer;
import com.masai.dao.CustomerDao;
import com.masai.dao.CustomerDaoImpl;
import com.masai.exceptions.CustomerException;

public class GetAllCustomerUseCase1 {

	public static void main(String[] args) {
		
		CustomerDao dao = new CustomerDaoImpl();
		try {
			List<Customer> customers = dao.getAllCustomerDetails();
			customers.forEach(c -> System.out.println(c));
			
		} catch (CustomerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
