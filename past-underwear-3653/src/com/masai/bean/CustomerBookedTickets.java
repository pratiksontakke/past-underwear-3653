package com.masai.bean;

public class CustomerBookedTickets {
	
	private String cuserName;
	private String busNo;
	private String bookingTime;
	private String bookedSeat;
	
	public CustomerBookedTickets(String cuserName, String busNo, String bookingTime, String bookedSeat) {
		super();
		this.cuserName = cuserName;
		this.busNo = busNo;
		this.bookingTime = bookingTime;
		this.bookedSeat = bookedSeat;
	}

	public String getCuserName() {
		return cuserName;
	}

	public void setCuserName(String cuserName) {
		this.cuserName = cuserName;
	}

	public String getBusNo() {
		return busNo;
	}

	public void setBusNo(String busNo) {
		this.busNo = busNo;
	}

	public String getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(String bookingTime) {
		this.bookingTime = bookingTime;
	}

	public String getBookedSeat() {
		return bookedSeat;
	}

	public void setBookedSeat(String bookedSeat) {
		this.bookedSeat = bookedSeat;
	}

	@Override
	public String toString() {
		return "GetTicketBookedbyCustomer [cuserName=" + cuserName + ", busNo=" + busNo + ", bookingTime=" + bookingTime
				+ ", bookedSeat=" + bookedSeat + "]";
	}
	
	
	
	
}
