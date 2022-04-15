package com.brainmentors.chatapp.dto;


public class UserDTO {
	private String userid;
	private char[] password;
	private String email;
	private String city;
	private String phone;
	
	
	public UserDTO(String userid, char[] password) {
		this.userid = userid;
		this.password = password;
	}
	
	
	public UserDTO(String userid, char[] password, String email, String city, String phone) {
		this.userid = userid;
		this.password = password;
		this.email = email;
		this.city = city;
		this.phone = phone;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public char[] getPassword() {
		return password;
	}
	public void setPassword(char[] password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}	
	
}