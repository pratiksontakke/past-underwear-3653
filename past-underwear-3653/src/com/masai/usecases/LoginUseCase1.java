package com.masai.usecases;

import java.util.Scanner;

import com.masai.bean.Customer;
import com.masai.dao.CustomerDao;
import com.masai.dao.CustomerDaoImpl;
import com.masai.exceptions.CustomerException;

public class LoginUseCase1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your id");	
		int cid = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter your name");
		String cname = sc.nextLine();
		
		CustomerDao dao = new CustomerDaoImpl();
		
		 try {
			Customer customer = dao.loginCustomer(cid, cname);
			
			System.out.println(customer);
			
		} catch (CustomerException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
