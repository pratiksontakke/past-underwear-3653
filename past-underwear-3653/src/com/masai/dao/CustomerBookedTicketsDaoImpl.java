package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.masai.bean.Customer;
import com.masai.bean.CustomerBookedTickets;
import com.masai.exceptions.CustomerBookedTicketsException;
import com.masai.exceptions.CustomerException;
import com.masai.utility.DBUtil;

public class CustomerBookedTicketsDaoImpl implements CustomerBookedTicketsDao {

	@Override
	public List<CustomerBookedTickets> getTicketBookedbyCustomer(String username) throws CustomerBookedTicketsException {
		List<CustomerBookedTickets> tickets  = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from CustomerBookedTickets where cuserName = ?");
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();	
			while(rs.next()) {
				CustomerBookedTickets ticket = new CustomerBookedTickets(rs.getString("cuserName"), rs.getString("busNo"), rs.getString("bookingTime"), rs.getString("bookedSeat"));
				tickets.add(ticket);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(tickets.size() == 0) {
			throw new CustomerBookedTicketsException(username+" not book a single ticket");
		}
		
		return tickets;
	}

	@Override
	public String bookedTickets(String username, String busNo, int bookedSeat) {
		String message = "Failed";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("insert into CustomerBookedTickets values(?,?,NOW(),?)");
			ps.setString(1, username);
			ps.setString(2, busNo);
			ps.setInt(3, bookedSeat);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				message = "Ticket booked !";
				String DBmsg = new BusesDaoImpl().updateBookedTickets(busNo, bookedSeat);
				System.out.println(DBmsg);
			}
			
		} catch (Exception e) {
			e.getMessage();
		}
		
		return message;
	}

}
