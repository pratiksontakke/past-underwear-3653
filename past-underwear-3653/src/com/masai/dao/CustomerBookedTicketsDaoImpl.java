package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.masai.bean.Buses;
import com.masai.bean.CustomerBookedTickets;
import com.masai.exceptions.BusesException;
import com.masai.exceptions.CustomerBookedTicketsException;
import com.masai.utility.DBUtil;


// pnr == bookingTime;
public class CustomerBookedTicketsDaoImpl implements CustomerBookedTicketsDao {

	@Override
	public List<CustomerBookedTickets> getTicketBookedbyCustomer(String username) throws CustomerBookedTicketsException {
		List<CustomerBookedTickets> tickets  = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from CustomerBookedTickets where cuserName = ?");
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();	
			while(rs.next()) {
				CustomerBookedTickets ticket = new CustomerBookedTickets(rs.getString("cuserName"), rs.getString("busNo"), rs.getString("bookingTime"), rs.getInt("bookedSeat"));
				tickets.add(ticket);
			}
		} catch (Exception e) {
			e.getMessage();
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
	
	@Override
	public CustomerBookedTickets getSingleTicketBookedbyCustomer(String bookingTime) throws CustomerBookedTicketsException {
		CustomerBookedTickets ticket  = null;
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from CustomerBookedTickets WHERE bookingTime = ?");
			ps.setString(1, bookingTime);
			
			ResultSet rs = ps.executeQuery();	
			if(rs.next()) {
				ticket = new CustomerBookedTickets(rs.getString("cuserName"), rs.getString("busNo"), rs.getString("bookingTime"), rs.getInt("bookedSeat"));
			} else {
				throw new CustomerBookedTicketsException("No Bus found...");
			}
		} catch (Exception e) {
			e.getMessage();
			throw new CustomerBookedTicketsException(e.getMessage());
		}
		
		
		return ticket;
	}

	@Override
	public String cancelTickets(String bookingTime) throws CustomerBookedTicketsException {
		String message = "Not found ticket having PNR No : " + bookingTime;
		
		try(Connection conn = DBUtil.provideConnection()) {
		
			//search ticket by using pnr form CustomerBookedTickets table;
			CustomerBookedTickets ticket = getSingleTicketBookedbyCustomer(bookingTime);
			
			//search bus by using busNo form Buses table;
			Buses bus = new BusesDaoImpl().searchBuseByBusNo(ticket.getBusNo());
			
			//to delete from CustomerBookedTickets table.
			PreparedStatement ps1 = conn.prepareStatement("DELETE FROM CustomerBookedTickets WHERE bookingTime = ?");
			
			ps1.setString(1, bookingTime);
			
			int x = ps1.executeUpdate();
			
			if(x>0) {
				message = "Ticket successfully cancelled having PNR Number " + bookingTime;
				String DBmsg = new BusesDaoImpl().dedateBookedTickets(bus.getBusNO(), bus.getBookedSeats());
				System.out.println(DBmsg);
			} else {
				throw new CustomerBookedTicketsException("No ticket found please recheck your PNR Number...");
			}
			
		} catch (Exception e) {
			e.getMessage();
			throw new CustomerBookedTicketsException(e.getMessage()); 
		}
		
		return message;
	}

	

}
