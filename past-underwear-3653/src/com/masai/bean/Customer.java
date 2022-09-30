package com.masai.bean;

public class Customer {
	private String cname;
	private String source;
	private String destination;
	private String busNo;
	
	public Customer() {
		
	}
	
	public Customer(String cname, String source, String destination, String busNo) {
		super();
		this.cname = cname;
		this.source = source;
		this.destination = destination;
		this.busNo = busNo;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getBusNo() {
		return busNo;
	}

	public void setBusNo(String busNo) {
		this.busNo = busNo;
	}

	@Override
	public String toString() {
		return "Customer [cname=" + cname + ", source=" + source + ", destination=" + destination + ", busNo=" + busNo
				+ "]";
	}
	
	
}
