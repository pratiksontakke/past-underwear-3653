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

	@Override
	public Customer getCustomerByCid(int cid) throws CustomerException {
		Customer customer = null;
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from customer where cid = ?");
			
			ps.setInt(1, cid);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				rs.getInt("cid");
				customer = new Customer(rs.getString("cname"), rs.getString("source"), rs.getString("destination"),rs.getString("busNo"));
			} else {
				throw new CustomerException("Customer does not exist with Id : " + cid);
			}
			
		} catch (SQLException e) {
			e.printStackTrace(); // this print at server side and client get null value
			throw new CustomerException(e.getMessage()); // re-throw to client exception.
		}
		
		return customer;
	}

	@Override
	public Customer loginCustomer(int cid, String cname) throws CustomerException {
		Customer customer = null;
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from customer where cid = ? AND cname = ?");
			ps.setInt(1, cid);
			ps.setString(2, cname);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				rs.getInt("cid");
				customer = new Customer(rs.getString("cname"), rs.getString("source"), rs.getString("destination"),rs.getString("busNo"));
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
				rs.getInt("cid");
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
