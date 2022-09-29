package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.masai.utility.DBUtil;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public String registerCustomer(String cname, String source, String destination, String busNo) {
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

	

}
