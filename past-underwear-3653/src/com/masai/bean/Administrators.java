package com.masai.bean;

public class Administrators {
	private String ausername; 
	private String apassword;
	private String aname;
	private String address;
	
	public Administrators() {
		
	}
	
	public Administrators(String ausername, String apassword, String aname, String address) {
		super();
		this.ausername = ausername;
		this.apassword = apassword;
		this.aname = aname;
		this.address = address;
	}

	public String getAusername() {
		return ausername;
	}

	public void setAusername(String ausername) {
		this.ausername = ausername;
	}

	public String getApassword() {
		return apassword;
	}

	public void setApassword(String apassword) {
		this.apassword = apassword;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Administrators [ausername=" + ausername + ", apassword=" + apassword + ", aname=" + aname + ", address="
				+ address + "]";
	}
	
	
	

}
