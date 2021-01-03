package com.music.pojo;

public class User {
	int id;
	String username;
	String password;
	String email;
	String phone;
	String logintime ;
	
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	public String getLogintime() {
		return logintime;
	}
	public void setLogintime(String logintime) {
		this.logintime = logintime;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	
	public User(String username, String password, String email, String phone) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}
	public User(String username, String password, String email, String phone,
			String logintime) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.logintime = logintime;
	}
	public User(int id, String username, String password, String email,
			String phone, String logintime) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.logintime = logintime;
	}
	public User(String username, String password, String email) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", email=" + email + ", phone=" + phone
				+ ", logintime=" + logintime + "]";
	}
	
	
	
	
}
