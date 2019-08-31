package com.eventmgr.model;

public class Supplier {
		
	private String sId;
	private String companyName;
	private String website;
	private String address;
	private String companyPhneNo;
	private String fName;
	private String lName;
	private String email;
	private String nic;
	
	
	
	public Supplier(String companyName, String website, String address, String companyPhneNo, String fName, String lName,
			String email, String nic) {
		super();
		this.companyName = companyName;
		this.website = website;
		this.address = address;
		this.companyPhneNo = companyPhneNo;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.nic = nic;
	}
	public String getsId() {
		return sId;
	}
	public void setsId(String sId) {
		this.sId = sId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String  getCompanyPhneNo() {
		return companyPhneNo;
	}
	public void setCompanyPhneNo(String companyPhneNo) {
		this.companyPhneNo = companyPhneNo;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNic() {
		return nic;
	}
	public void setNic(String nic) {
		this.nic = nic;
	}
	
	
	
	
	
}
