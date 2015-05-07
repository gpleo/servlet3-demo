package com.gopersist.demo.servlet3.springmvc;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class User {
	private static int nextId = 1;
	public static int getNextId() {
		return nextId++;
	}
	
	private int id;
	@Size(min=4, max=10, message="用户名最少4位最多10位")
	@Pattern(regexp="^[a-zA-Z0-9]*$", message="用户名必须由字母或数字组成")
	private String username;
	@Size(min=6, max=10, message="密码最少6位最多10位")
	private String password;
	@NotBlank(message="请输入有效的Email地址")
	@Email(message="请输入有效的Email地址")
	private String email;
	
	public User() {
	}
	public User(String username, String password, String email) {
		this.id = nextId++;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "{id:" + this.id + ", username: '" + this.username + "'}";
	}
}
