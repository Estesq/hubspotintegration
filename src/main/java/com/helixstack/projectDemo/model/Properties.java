package com.helixstack.projectDemo.model;

public class Properties {

	 private String company;
	 private String createdate;
	 private String email;
	 private String hs_object_id;
	 private String lastmodifieddate;
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHs_object_id() {
		return hs_object_id;
	}
	public void setHs_object_id(String hs_object_id) {
		this.hs_object_id = hs_object_id;
	}
	public String getLastmodifieddate() {
		return lastmodifieddate;
	}
	public void setLastmodifieddate(String lastmodifieddate) {
		this.lastmodifieddate = lastmodifieddate;
	}
	public Properties() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Properties(String company, String createdate, String email, String hs_object_id, String lastmodifieddate) {
		super();
		this.company = company;
		this.createdate = createdate;
		this.email = email;
		this.hs_object_id = hs_object_id;
		this.lastmodifieddate = lastmodifieddate;
	}
	 
	 
}
