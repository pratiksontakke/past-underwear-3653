package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.masai.bean.Buses;
import com.masai.exceptions.BusesException;
import com.masai.utility.DBUtil;

public class BusesDaoImpl implements BusesDao {

	@Override
	public List<Buses> searchBuses(String source, String destination, String date) throws BusesException{
		List<Buses> buses = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from buses where source = ? AND destination = ? AND date = ?");
			ps.setString(1, source);
			ps.setString(2, destination);
			ps.setString(3, date);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Buses bus = new Buses(rs.getString("busNO"), rs.getString("insertBy"), rs.getString("date"), 
						rs.getString("source"), rs.getString("sTime"), rs.getString("destination"), 
						rs.getString("dTime"), rs.getString("type"), rs.getInt("bookedSeat"), 
						rs.getInt("totalSeat"), rs.getInt("fare"));
				
				buses.add(bus);
			}
			
		} catch (Exception e) {
			throw new BusesException(e.getMessage());
		}
		
		if(buses.size() == 0) {
			throw new BusesException("No Bus found...");
		}
		
		return buses;
	}

	
	@Override
	public String updateBookedTickets(String busNo, int increment) throws BusesException {
		String message = "Datebase is not update...";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("UPDATE buses SET bookedSeat = bookedSeat+? where busNo = ?");
			ps.setInt(1,increment);
			ps.setString(2, busNo);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				message = "Database is updated";
			}
					
			
		} catch (Exception e) {
			throw new BusesException(e.getMessage());
		}
		
		return message;
	}


	@Override
	public List<Buses> searchBusesAdministrator(String username) throws BusesException {
		List<Buses> buses = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from Buses where insertBy = ?");
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Buses bus = new Buses(rs.getString("busNO"), rs.getString("insertBy"), rs.getString("date"), 
						rs.getString("source"), rs.getString("sTime"), rs.getString("destination"), 
						rs.getString("dTime"), rs.getString("type"), rs.getInt("bookedSeat"), 
						rs.getInt("totalSeat"), rs.getInt("fare"));
				buses.add(bus);
				
			}
			
		} catch (Exception e) {
			throw new BusesException(e.getMessage());
		}
		
		if(buses.size() == 0) {
			throw new BusesException("No Bus found...");
		}
		
		return buses;
	}


	@Override
	public String addBus(Buses bus) throws BusesException {
		String message = "Bus not added in the list";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("insert into buses values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			ps.setString(1, bus.getBusNO());
			ps.setString(2, bus.getInsertBy());
			ps.setString(3, bus.getDate());
			ps.setString(4, bus.getSource());
			ps.setString(5, bus.getsTime());
			ps.setString(6, bus.getDestination());
			ps.setString(7, bus.getdTime());
			ps.setString(8, bus.getType());
			ps.setInt(9, bus.getBookedSeats());
			ps.setInt(10, bus.getTotalSeats());
			ps.setInt(11, bus.getFare());
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				message = "Bus is added.";
			}
			
			
		} catch (Exception e) {
			throw new BusesException(e.getMessage());
		}
		
		return message;
	}


	@Override
	public Buses searchBuseByBusNo(String BusNo) throws BusesException {
		Buses bus = null;
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from buses where busNo = ?");
			ps.setString(1, BusNo);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				bus = new Buses(rs.getString("busNO"), rs.getString("insertBy"), rs.getString("date"), 
						rs.getString("source"), rs.getString("sTime"), rs.getString("destination"), 
						rs.getString("dTime"), rs.getString("type"), rs.getInt("bookedSeat"), 
						rs.getInt("totalSeat"), rs.getInt("fare"));
				
			} else {
				throw new BusesException("No Bus found...");
			}
			
		} catch (Exception e) {
			throw new BusesException(e.getMessage());
		}
		
		return bus;
	}


	@Override
	public String dedateBookedTickets(String busNo, int decrement) throws BusesException {
		String message = "Datebase is not update...";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("UPDATE buses SET bookedSeat = bookedSeat-? where busNo = ?");
			ps.setInt(1,decrement);
			ps.setString(2, busNo);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				message = "Database is updated";
			} else {
				throw new BusesException("No Bus found...");
			}
					
			
		} catch (Exception e) {
			throw new BusesException(e.getMessage());
		}
		
		return message;
	}


	@Override
	public List<Buses> searchBuseByAdministrator(String username) throws BusesException {
		List<Buses> buses = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from buses where insertBy = ?");
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Buses bus = new Buses(rs.getString("busNO"), rs.getString("insertBy"), rs.getString("date"), 
						rs.getString("source"), rs.getString("sTime"), rs.getString("destination"), 
						rs.getString("dTime"), rs.getString("type"), rs.getInt("bookedSeat"), 
						rs.getInt("totalSeat"), rs.getInt("fare"));
				
				buses.add(bus);
			}
			
		} catch (Exception e) {
			throw new BusesException(e.getMessage());
		}
		
		if(buses.size() == 0) {
			throw new BusesException("No Bus found...");
		}
		
		return buses;
	}


	@Override
	public String DeleteBuseByBusNo(String BusNo) throws BusesException {
		String message = "Bus is not delete. Please check your Bus Number ...";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("DELETE FROM buses WHERE busNo = ?");
			ps.setString(1,BusNo);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				message = "Bus is deleted having Bus Number : " + BusNo;
			}
					
		} catch (Exception e) {
			throw new BusesException(e.getMessage());
		}
		
		return message;
	}

}


