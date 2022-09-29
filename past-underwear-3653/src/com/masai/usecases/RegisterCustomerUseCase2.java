package com.masai.usecases;

import java.util.Scanner;

import com.masai.bean.Customer;
import com.masai.dao.CustomerDao;
import com.masai.dao.CustomerDaoImpl;

public class RegisterCustomerUseCase2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Customer Name : ");
		String cname = sc.nextLine();
		System.out.print("Enter Source : ");
		String source = sc.nextLine();
		System.out.print("Enter Destination : ");
		String destination = sc.nextLine();
		System.out.print("Enter BusNo : ");
		String busNo = sc.nextLine();
		
		// recommended way to insert data by using object
		CustomerDao dao = new CustomerDaoImpl(); // we always use interface based programming
		Customer customer = new Customer();
		customer.setCname(cname);
		customer.setSource(source);
		customer.setDestination(destination);
		customer.setBusNo(busNo);
		
		String result = dao.registerCustomer2(customer);
		System.out.println(result);
	}

}
