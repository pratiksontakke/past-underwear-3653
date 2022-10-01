package com.masai.bean;

public class Buses {
	
	private String busNO;
	private String insertBy;
	private String date;
	private String source;
	private String sTime;
	private String destination;
	private String dTime;
	private String type;
	private int bookedSeats;
	private int totalSeats;
	private int avilableSeats;
	private int fare;
	
	public Buses() {
		
	}

	//constructor without insertBy;
	public Buses(String busNO, String date, String source, String sTime, String destination, String dTime, String type,
			int bookedSeats, int totalSeats, int fare) {
		super();
		this.busNO = busNO;
		this.date = date;
		this.source = source;
		this.sTime = sTime;
		this.destination = destination;
		this.dTime = dTime;
		this.type = type;
		this.bookedSeats = bookedSeats;
		this.totalSeats = totalSeats;
		this.avilableSeats = totalSeats-bookedSeats;
		this.fare = fare;
	}
	
	//constructor with insertBy;
	public Buses(String busNO, String insertBy, String date, String source, String sTime, String destination,
			String dTime, String type, int bookedSeats, int totalSeats, int fare) {
		super();
		this.busNO = busNO;
		this.insertBy = insertBy;
		this.date = date;
		this.source = source;
		this.sTime = sTime;
		this.destination = destination;
		this.dTime = dTime;
		this.type = type;
		this.bookedSeats = bookedSeats;
		this.totalSeats = totalSeats;
		this.avilableSeats = totalSeats-bookedSeats;
		this.fare = fare;
	}

	public String getBusNO() {
		return busNO;
	}

	public void setBusNO(String busNO) {
		this.busNO = busNO;
	}

	public String getInsertBy() {
		return insertBy;
	}

	public void setInsertBy(String insertBy) {
		this.insertBy = insertBy;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getsTime() {
		return sTime;
	}

	public void setsTime(String sTime) {
		this.sTime = sTime;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getdTime() {
		return dTime;
	}

	public void setdTime(String dTime) {
		this.dTime = dTime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getBookedSeats() {
		return bookedSeats;
	}

	public void setBookedSeats(int bookedSeats) {
		this.bookedSeats = bookedSeats;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public int getAvilableSeats() {
		return avilableSeats;
	}

	public void setAvilableSeats(int totalSeats, int bookedSeats) {
		this.avilableSeats = totalSeats-bookedSeats;
	}

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}

	@Override
	public String toString() {
		return "Buses [busNO=" + busNO + ", insertBy=" + insertBy + ", date=" + date + ", source=" + source + ", sTime="
				+ sTime + ", destination=" + destination + ", dTime=" + dTime + ", type=" + type + ", bookedSeats="
				+ bookedSeats + ", totalSeats=" + totalSeats + ", avilableSeats=" + avilableSeats + ", fare=" + fare
				+ "]";
	};
		
	
	
}
