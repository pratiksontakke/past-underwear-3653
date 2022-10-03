package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.bean.Customer;
import com.masai.exceptions.CustomerException;
import com.masai.utility.DBUtil;

public class CustomerDaoImpl implements CustomerDao {
	@Override
	public String registerCustomer1(String cuserName, String cpassword, String cname, String address ) {
		String message = "Not Inserted..";
		
		try(Connection conn = DBUtil.provideConnection();) {
			PreparedStatement ps = conn.prepareStatement("insert into customers values('?', '?' ,'?', '?')");
			ps.setString(1, cuserName);
			ps.setString(2, cpassword);
			ps.setString(3, cname);
			ps.setString(4, address);
			
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
			PreparedStatement ps = conn.prepareStatement("insert into customers values(?, ? ,?, ?)");
			ps.setString(1, customer.getCuserName());
			ps.setString(2, customer.getCpassword());
			ps.setString(3, customer.getCname());
			ps.setString(4, customer.getAddress());
			
			int x = ps.executeUpdate();
			
			if(x>0) message = "Customer Registered Successfully";
			
		} catch (SQLException e) {
			message = e.getMessage();
		}
		
		return message;

	}

	@Override
	public Customer getCustomerByUsername(String username) throws CustomerException {
		Customer customer = null;
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from customers where cusername = ?");
			
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				customer = new Customer(rs.getString("cusername"), rs.getString("cpassword"), rs.getString("cname"),rs.getString("address"));
			} else {
				throw new CustomerException("Customer does not exist with Id : " + username);
			}
			
		} catch (SQLException e) {
			e.printStackTrace(); // this print at server side and client get null value
			throw new CustomerException(e.getMessage()); // re-throw to client exception.
		}
		
		return customer;
	}

	@Override
	public Customer loginCustomer(String username , String password) throws CustomerException {
		Customer customer = null;
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from customers where cusername = ? AND cpassword = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				customer = new Customer(rs.getString("cusername"), rs.getString("cpassword"), rs.getString("cname"),rs.getString("address"));
				
			} else {
				throw new CustomerException("Invalid username or password");
			}
			
			
		} catch (SQLException se) {
			se.getMessage();
			throw new CustomerException(se.getMessage());
		}
		
		return customer;
	}

	@Override
	public List<Customer> getAllCustomerDetails() throws CustomerException {
		List<Customer> customers = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from Customer");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Customer customer = new Customer(rs.getString("cname"), rs.getString("source"), rs.getString("destination"),rs.getString("busNo"));
				customers.add(customer);
			}
			
			
		} catch (Exception e) {
			throw new CustomerException(e.getMessage());
		}
		
		if(customers.size() == 0) {
			throw new CustomerException("No Customers found...");
		}
		
		return customers;
	}

	

}
