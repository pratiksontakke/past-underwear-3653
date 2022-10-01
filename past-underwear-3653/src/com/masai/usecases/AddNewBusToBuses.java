package com.masai.usecases;

import java.util.Scanner;

import com.masai.bean.Buses;

public class AddNewBusToBuses {

	public Buses addnewBus(String ausername) {
		
		Buses bus = new Buses();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Bus Number : ");
		String busNO = sc.nextLine();
		bus.setBusNO(busNO.toUpperCase());
		
		//special case;
		bus.setInsertBy(ausername.toLowerCase());
		
		System.out.print("Enter date of jurney from source (YYYY-MM-DD) : ");
		String date = sc.nextLine();
		bus.setDate(date);
		
		System.out.print("Enter source : ");
		String source = sc.nextLine();
		bus.setSource(source.toUpperCase());
		
		System.out.print("Enter Source Date&Time (YYYY-MM-DD hh:mm:ss) : ");
		String sTime = sc.nextLine();
		bus.setsTime(sTime);
		
		System.out.print("Enter Destination : ");
		String destination = sc.nextLine();
		bus.setDestination(destination.toUpperCase());
		
		System.out.print("Enter Destination Time (YYYY-MM-DD hh:mm:ss) : ");
		String dTime = sc.nextLine();
		bus.setdTime(dTime);
		
		System.out.print("Enter Type of Bus (AC/NON-AC) : ");
		String type = sc.nextLine();
		bus.setType(type.toUpperCase());
		
		//special case
		bus.setBookedSeats(0);
		
		System.out.print("Enter total number of seats : ");
		int totalSeats = sc.nextInt();
		bus.setTotalSeats(totalSeats);
		
		bus.setAvilableSeats(totalSeats, 0);
		
		System.out.print("Enter the fare (fare / person) : ");
		int fare = sc.nextInt();
		bus.setFare(fare);
		
//		System.out.println(bus);
		return bus;
		
	}

}
