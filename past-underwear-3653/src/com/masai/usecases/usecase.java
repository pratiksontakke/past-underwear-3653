package com.masai.usecases;

import java.util.List;

import java.util.Scanner;
import com.masai.bean.Administrators;
import com.masai.bean.Buses;
import com.masai.bean.Customer;
import com.masai.bean.CustomerBookedTickets;
import com.masai.dao.AdministratorsDao;
import com.masai.dao.AdministratorsDaoImpl;
import com.masai.dao.BusesDaoImpl;
import com.masai.dao.CustomerBookedTicketsDaoImpl;
import com.masai.dao.CustomerDao;
import com.masai.dao.CustomerDaoImpl;
import com.masai.exceptions.AdministratorsException;
import com.masai.exceptions.CustomerException;

public class usecase {

	public static void main(String[] args) {
		
		boolean menuBoolean = true;
		
		while(menuBoolean) {
			System.out.println();
			System.out.println("Welcome to Bus Reservation System");
			System.out.println("Type 1 : create a new customer account : ");
			System.out.println("Type 2 : Login as Customer");
			System.out.println("Type 3 : Login as Administrator");
			System.out.println("Type 4 : Search Buses");
			System.out.println("Type 5 : Exit");
			
			Scanner sc = new Scanner(System.in);
			int input = sc.nextInt();
			sc.nextLine();
			
			try {
				
				switch(input) {
					case 1:
						Customer newcustomer = new Customer();
						
						System.out.println("create a new customer account.");
						System.out.print("Enter your gmail : ");
						String newcusername = sc.nextLine();
						newcustomer.setCuserName(newcusername);
						System.out.print("Enter your name : ");
						String newname = sc.nextLine();
						newcustomer.setCname(newname);
						System.out.print("Enter your address : ");
						String newaddress = sc.nextLine();
						newcustomer.setAddress(newaddress);
						System.out.print("Enter password : ");
						String newpassword = sc.nextLine();
						newcustomer.setCpassword(newpassword);
						
						String messagec = new CustomerDaoImpl().registerCustomer2(newcustomer);
						System.out.println(messagec);
						break;
					case 2:
						System.out.println("Login as customer : ");
						System.out.print("Enter username : ");
						String cusername = sc.nextLine();
						System.out.print("Enter password : ");
						String cpassword = sc.nextLine();
						CustomerDao daoE = new CustomerDaoImpl();
						try {
							Customer customer = daoE.loginCustomer(cusername, cpassword);
							
							boolean customerBoolean = true;
							
							while (customerBoolean) {
							
								//menu of customer if login is true;
								System.out.println();
								System.out.println("Type 1 : To view " + customer.getCname() + " profile.");
								System.out.println("Type 2 : To view ticket booked by " + customer.getCname());
								System.out.println("Type 3 : To search buses ");
								System.out.println("Type 4 : To book a new ticket");
								System.out.println("Type 5 : To cancel a ticket");
								System.out.println("Type 6 : Exit");
								input = sc.nextInt();
								sc.nextLine();
							
								switch (input) {
								case 1: {
									System.out.println(customer);
									break;
								}
								case 2: {
									List<CustomerBookedTickets> tickets = new CustomerBookedTicketsDaoImpl().getTicketBookedbyCustomer(cusername);
									tickets.forEach(t -> System.out.println(t));
									break;
								}
								case 3: {
									System.out.print("Enter Source : ");
									String source = sc.nextLine();
									System.out.print("Enter Destination : ");
									String destination = sc.nextLine();
									System.out.print("Enter Date of Travel (YYYY-MM-DD): ");
									String date = sc.nextLine();
									List<Buses> buses = new BusesDaoImpl().searchBuses(source, destination, date);
									buses.forEach(b -> System.out.println(b));
									break;
								}
								case 4: {
									System.out.print("Enter Source : ");
									String source = sc.nextLine();
									System.out.print("Enter Destination : ");
									String destination = sc.nextLine();
									System.out.print("Enter Date of Travel (YYYY-MM-DD): ");
									String date = sc.nextLine();
									List<Buses> buses = new BusesDaoImpl().searchBuses(source, destination, date);
									buses.forEach(b -> System.out.println(b));
									
									System.out.print("Type the Bus Number that you want to book tickets : ");
									String busNo = sc.nextLine();
									System.out.print("Number of seats you want to book : ");
									int bookedSeat = sc.nextInt();
									
									String message = new CustomerBookedTicketsDaoImpl().bookedTickets(cusername, busNo, bookedSeat) ;
									System.out.println(message);
									
									break;
								}
								case 5: {
									List<CustomerBookedTickets> tickets = new CustomerBookedTicketsDaoImpl().getTicketBookedbyCustomer(cusername);
									tickets.forEach(t -> System.out.println(t + "\n" + "PNR Number : " + t.getBookingTime()));
									
									System.out.print("Enter the PNR Number to cancel ticket : ");
									String pnr = sc.nextLine();
									String message = new CustomerBookedTicketsDaoImpl().cancelTickets(pnr);
									System.out.println(message);
									break;
								}
								case 6: {
									customerBoolean = false;
									System.out.println("---Thankyou---");
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
					case 3:
						System.out.println("Login as Administrator : ");
						System.out.print("Enter username : ");
						String ausername = sc.nextLine();
						System.out.print("Enter password : ");
						String apassword = sc.nextLine();
						AdministratorsDao daoA = new AdministratorsDaoImpl();
						try {
							Administrators administrator = daoA.loginAdministrator(ausername, apassword);
							boolean administratorBoolean = true;
							
							while (administratorBoolean) {
								
								// menu of customer if login is true;
								System.out.println();
								System.out.println("Type 1 : To view " + administrator.getAname() + " profile.");
								System.out.println("Type 2 : To view Busses added by " + administrator.getAname());
								System.out.println("Type 3 : To search bus ");
								System.out.println("Type 4 : To add a new bus");
								System.out.println("Type 5 : To Cancle a Bus, Enter Bus Number : ");
								System.out.println("Type 6 : Exit");
								input = sc.nextInt();
								sc.nextLine();
							
								switch (input) {
								case 1: {
									System.out.println(administrator);
									break;
								}
								case 2: {
									List<Buses> buses = new BusesDaoImpl().searchBusesAdministrator(ausername);
									buses.forEach(b -> System.out.println(b));
									break;
								}
								case 3: { 
									System.out.print("Enter Source : ");
									String source = sc.nextLine();
									System.out.print("Enter Destination : ");
									String destination = sc.nextLine();
									System.out.print("Enter Date of Travel (YYYY-MM-DD): ");
									String date = sc.nextLine();
									List<Buses> buses = new BusesDaoImpl().searchBuses(source, destination, date);
									buses.forEach(b -> System.out.println(b));
									break;
								}
								case 4: {
									Buses bus = new AddNewBusToBuses().addnewBus(ausername);
									String message = new BusesDaoImpl().addBus(bus);
									System.out.println(message);
									break;
								}
								case 5: {
									List<Buses> buses = new BusesDaoImpl().searchBuseByAdministrator(ausername);
									buses.forEach(b -> System.out.println(b + "\n"));
									System.out.print("Enter the Bus Number to cancel bus : ");
									String busNo = sc.nextLine();
									String message = new BusesDaoImpl().DeleteBuseByBusNo(busNo);
									System.out.println(message);
									
									break;
								}
								case 6: {
									administratorBoolean = false;
									System.out.println("---Thankyou---");
									break;
								}
								default:
									throw new IllegalArgumentException("Unexpected value: " + input);
								}
							
							}
							
						} catch (AdministratorsException e) {
							System.out.println(e.getMessage());
						}
						
						break;
					case 4:
						System.out.print("Enter Source : ");
						String source = sc.nextLine();
						System.out.print("Enter Destination : ");
						String destination = sc.nextLine();
						System.out.print("Enter Date of Travel (YYYY-MM-DD): ");
						String date = sc.nextLine();
						List<Buses> buses = new BusesDaoImpl().searchBuses(source, destination, date);
						System.out.println();
						buses.forEach(b -> System.out.println(b));
						break;
					case 5:
						System.out.print("---Thankyou---");
						menuBoolean = false;
						break;
					default:
						throw new IllegalArgumentException("Unexpected value: " + input);
				}
				
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		
		}
		
	}

}
