package com.masai.usecases;

import java.util.Scanner;

import com.masai.bean.Customer;
import com.masai.dao.CustomerDao;
import com.masai.dao.CustomerDaoImpl;
import com.masai.exceptions.CustomerException;

public class GetCustomerUseCase1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Customer Id : ");
		int cid = sc.nextInt();
		CustomerDao dao = new CustomerDaoImpl();
		
		try {
			Customer customer = dao.getCustomerByUsername(cid);
			System.out.println(customer);
		} catch (CustomerException ce) {
			System.out.println(ce.getMessage());
		}
		
	}

}
