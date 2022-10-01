package com.masai.dao;

import java.util.List;

import com.masai.bean.CustomerBookedTickets;
import com.masai.exceptions.CustomerBookedTicketsException;

public interface CustomerBookedTicketsDao {
	
	public List<CustomerBookedTickets> getTicketBookedbyCustomer(String username) throws CustomerBookedTicketsException;
	public String bookedTickets(String username, String busNo, int bookedSeat);

}
