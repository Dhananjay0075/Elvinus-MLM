package com.elvinus.bean;

import java.io.Serializable;

public class ECommUserReg implements Serializable{

	private String email;
	private String first_name;
	private String last_name;
	private String username;
	private String password;
	
	private ECommBilling billing;
	
	private ECommShipping shipping;

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
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

	public ECommBilling getBilling() {
		return billing;
	}

	public void setBilling(ECommBilling billing) {
		this.billing = billing;
	}

	public ECommShipping getShipping() {
		return shipping;
	}

	public void setShipping(ECommShipping shipping) {
		this.shipping = shipping;
	}

	public ECommUserReg(){
		
	}
	public ECommUserReg(String email, String first_name, String last_name, String username, String password,
			ECommBilling billing, ECommShipping shipping) {
		super();
		this.email = email;
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.password = password;
		this.billing = billing;
		this.shipping = shipping;
	}

	@Override
	public String toString() {
		return "ECommUserReg [email=" + email + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", username=" + username + ", password=" + password + ", billing=" + billing + ", shipping="
				+ shipping + "]";
	}
	
	
	
	
	
}
