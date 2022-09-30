package com.masai.dao;

import com.masai.bean.Administrators;
import com.masai.exceptions.AdministratorsException;

public interface AdministratorsDao {
	
	public Administrators loginAdministrator (String username, String password) throws AdministratorsException;
	

}
