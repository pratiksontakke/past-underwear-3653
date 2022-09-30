package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.masai.bean.Administrators;
import com.masai.exceptions.AdministratorsException;
import com.masai.utility.DBUtil;

public class AdministratorsDaoImpl implements AdministratorsDao {

	@Override
	public Administrators loginAdministrator(String username, String password) throws AdministratorsException {
		Administrators administrator = null;
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from administrators where ausername = ? AND apassword = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				administrator = new Administrators(rs.getString("ausername"), rs.getString("apassword"), rs.getString("aname"),rs.getString("address"));
			} else {
				throw new AdministratorsException("Invalid username or password");
			}
			
		} catch (SQLException se) {
			se.getMessage();
			throw new AdministratorsException(se.getMessage());
		}
		
		
		return administrator;
	}

}
