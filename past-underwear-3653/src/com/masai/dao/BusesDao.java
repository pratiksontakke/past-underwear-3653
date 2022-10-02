package com.masai.dao;

import java.util.List;

import com.masai.bean.Buses;
import com.masai.exceptions.BusesException;

public interface BusesDao {
	
	public List<Buses> searchBuses(String source, String destination, String date) throws BusesException;
	public String updateBookedTickets(String busNo, int increment) throws BusesException;
	public String dedateBookedTickets(String busNo, int decrement) throws BusesException;
	public List<Buses> searchBusesAdministrator(String username) throws BusesException;
	public String addBus(Buses bus) throws BusesException;
	public Buses searchBuseByBusNo(String BusNo) throws BusesException;
	public List<Buses> searchBuseByAdministrator(String username) throws BusesException;
	public String DeleteBuseByBusNo(String BusNo) throws BusesException;
	
	

}
