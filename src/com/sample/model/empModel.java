package com.sample.model;

public class empModel {
	
	
	private int id;
	private String username;
	private String password;
	private String firstname;
	private String gender;
	private String lastname;
	private long mob;
	
	
	
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getMob() {
		return mob;
	}
	public void setMob(long mob) {
		this.mob = mob;
	}
	
	
	@Override
	public String toString() {
		return "EmpModel [id=" + id + ", username=" + username + ", password=" + password + ", firstname=" + firstname
				+ ", gender=" + gender + ", mob=" + mob + "]";
	}
	
	
	

}
