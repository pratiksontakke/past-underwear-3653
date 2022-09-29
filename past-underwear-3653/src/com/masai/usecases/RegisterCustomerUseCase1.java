package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.CustomerDao;
import com.masai.dao.CustomerDaoImpl;

public class RegisterCustomerUseCase1 {

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
		
		CustomerDao dao = new CustomerDaoImpl(); // we always use interface based programming
//		CustomerDaoImpl dao = new CustomerDaoImpl();
		String result = dao.registerCustomer(cname, source, destination, busNo);
		System.out.println(result);
	}

}
