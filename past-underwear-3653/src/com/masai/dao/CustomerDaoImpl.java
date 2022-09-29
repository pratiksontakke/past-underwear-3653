package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.masai.bean.Customer;
import com.masai.utility.DBUtil;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public String registerCustomer1(String cname, String source, String destination, String busNo) {
		String message = "Not Inserted..";
		
		try(Connection conn = DBUtil.provideConnection();) {
			PreparedStatement ps = conn.prepareStatement("insert into customer(cname, source, destination, busNo) values(?, ?, ?, ?)");
			ps.setString(1, cname);
			ps.setString(2, source);
			ps.setString(3, destination);
			ps.setString(4, busNo);
			
			int x = ps.executeUpdate();
			
			if(x>0) message = "Customer Registered Successfully";
			
		} catch (SQLException e) {
			message = e.getMessage();
		}
		
		return message;
	}

	@Override //recommended method
	public String registerCustomer2(Customer customer) {
		String message = "Not Inserted..";
		
		try(Connection conn = DBUtil.provideConnection();) {
			PreparedStatement ps = conn.prepareStatement("insert into customer(cname, source, destination, busNo) values(?, ?, ?, ?)");
			ps.setString(1, customer.getCname());
			ps.setString(2, customer.getSource());
			ps.setString(3, customer.getDestination());
			ps.setString(4, customer.getBusNo());
			
			int x = ps.executeUpdate();
			
			if(x>0) message = "Customer Registered Successfully";
			
		} catch (SQLException e) {
			message = e.getMessage();
		}
		
		return message;

	}

	

}
