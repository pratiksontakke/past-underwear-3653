package com.masai.bean;

public class Customer {
	private String cuserName;
	private String cpassword;
	private String cname;
	private String address;
	
	public Customer() {
		
	}

	public Customer(String cuserName, String cpassword, String cname, String address) {
		super();
		this.cuserName = cuserName;
		this.cpassword = cpassword;
		this.cname = cname;
		this.address = address;
	}

	public String getCuserName() {
		return cuserName;
	}

	public void setCuserName(String cuserName) {
		this.cuserName = cuserName;
	}

	public String getCpassword() {
		return cpassword;
	}

	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [cuserName=" + cuserName + ", cpassword=" + cpassword + ", cname=" + cname + ", address="
				+ address + "]";
	}

	
	
	
	
}
