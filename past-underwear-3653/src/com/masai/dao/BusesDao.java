package com.masai.dao;

import java.util.List;

import com.masai.bean.Buses;
import com.masai.exceptions.BusesException;

public interface BusesDao {
	
	public List<Buses> searchBuses(String source, String destination, String date) throws BusesException;

}
