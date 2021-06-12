package com.helixstack.projectDemo.model;


public class HubSpotResult {

	private int id;
	private String createdAt;
	private String updatedAt;
	private String archived;
	private Properties properties;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getArchived() {
		return archived;
	}
	public void setArchived(String archived) {
		this.archived = archived;
	}
	public Properties getProperties() {
		return properties;
	}
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	public HubSpotResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HubSpotResult(int id, String createdAt, String updatedAt, String archived, Properties properties) {
		super();
		this.id = id;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.archived = archived;
		this.properties = properties;
	}
	
	
}
