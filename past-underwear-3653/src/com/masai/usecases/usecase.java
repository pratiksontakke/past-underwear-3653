package com.masai.usecases;

import java.util.Scanner;

import com.masai.bean.Administrators;
import com.masai.bean.Customer;
import com.masai.dao.AdministratorsDao;
import com.masai.dao.AdministratorsDaoImpl;
import com.masai.dao.CustomerDao;
import com.masai.dao.CustomerDaoImpl;
import com.masai.exceptions.AdministratorsException;
import com.masai.exceptions.CustomerException;

public class usecase {

	public static void main(String[] args) {
		
		System.out.println("Welcome to Bus Reservation System");
		System.out.println("Type 1 : Login as Customer");
		System.out.println("Type 2 : Login as Administrator");
		System.out.println("Type 3 : Search Buses");
		System.out.println("Type 4 : Exit");
		
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		sc.nextLine();
		
		try {
			
			switch(input) {
				case 1:
					System.out.println("Login as customer : ");
					System.out.print("Enter username : ");
					String cusername = sc.nextLine();
					System.out.print("Enter password : ");
					String cpassword = sc.nextLine();
					CustomerDao daoE = new CustomerDaoImpl();
					try {
						Customer customer = daoE.loginCustomer(cusername, cpassword);
						
						//menu of customer if login is true;
						
						System.out.println("Type 1 : To view " + customer.getCname() + " profile.");
						System.out.println("Type 2 : To view ticket booked by " + customer.getCname());
						System.out.println("Type 3 : To search buses ");
						System.out.println("Type 4 : To book a new ticket");
						System.out.println("Type 5 : Exit");
						
						input = sc.nextInt();
						sc.nextLine();
						boolean customerBoolean = true;
						
						while (customerBoolean) {
						
							switch (input) {
							case 1: {
								System.out.println(customer);
								break;
							}
							case 2: {
								
								break;
							}
							case 3: {
								
								break;
							}
							case 4: {
								
								break;
							}
							case 5: {
								customerBoolean = false;
								break;
							}
							default:
								throw new IllegalArgumentException("Unexpected value: " + input);
							}
						
						}
						
						
					} catch (CustomerException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 2:
					System.out.println("Login as Administrator : ");
					System.out.print("Enter username : ");
					String ausername = sc.nextLine();
					System.out.print("Enter password : ");
					String apassword = sc.nextLine();
					AdministratorsDao daoA = new AdministratorsDaoImpl();
					try {
						Administrators administrator = daoA.loginAdministrator(ausername, apassword);
						System.out.println(administrator);
					} catch (AdministratorsException e) {
						System.out.println(e.getMessage());
					}
					
					break;
				case 3:
					System.out.print("Enter Source : ");
					System.out.print("Enter Distination : ");
					System.out.print("Enter Date of Journey : ");
					break;
				case 4:
					System.out.print("Thankyou");
					break;
				default:
					// code block
			}
						
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
