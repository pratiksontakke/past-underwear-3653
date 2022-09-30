package com.masai.usecases;

import java.util.Scanner;

import com.masai.bean.Customer;
import com.masai.dao.CustomerDao;
import com.masai.dao.CustomerDaoImpl;
import com.masai.exceptions.CustomerException;

public class LoginUseCase1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your username");	
		String username = sc.nextLine();
		System.out.println("Enter your password");
		String password = sc.nextLine();
		
		CustomerDao dao = new CustomerDaoImpl();
		
		 try {
			Customer customer = dao.loginCustomer(username, password);
			
			System.out.println(customer);
			
		} catch (CustomerException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
