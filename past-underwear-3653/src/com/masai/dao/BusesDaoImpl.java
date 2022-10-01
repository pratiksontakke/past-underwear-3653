package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.masai.bean.Buses;
import com.masai.exceptions.BusesException;
import com.masai.exceptions.CustomerException;
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

}
