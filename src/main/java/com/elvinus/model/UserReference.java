package com.elvinus.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "user_reference")
public class UserReference {
	
	@Id
    @GeneratedValue(strategy = IDENTITY)
	@Column(name = "reference_id", unique = true, nullable = false)
	private int reference_id;
    
	@Column(name = "full_name", length = 20)
    private String full_name;
    
	@Column(name = "email_id")
	private String email_id;
    
	@Column(name = "mobile", length = 10)
	private String mobile;

	@Column(name = "cr_date")
	private Date cr_date;
    
	@Column(name = "status")
	private String status;
    
    @Column(name = "refer_unique_id")
    private String refer_unique_id;
    
    @ManyToOne
    @JoinColumn(name="user_id")
    private UserRegistration userReg;
    
    public UserReference()
	{
		
	}

	public UserReference(int reference_id, String full_name, String email_id, String mobile, Date cr_date,
			String status, String refer_unique_id, UserRegistration userReg) {
		
		super();
		this.reference_id = reference_id;
		this.full_name = full_name;
		this.email_id = email_id;
		this.mobile = mobile;
		this.cr_date = cr_date;
		this.status = status;
		this.refer_unique_id = refer_unique_id;
		this.userReg = userReg;
		
	}

	public int getReference_id() {
		return reference_id;
	}

	public void setReference_id(int reference_id) {
		this.reference_id = reference_id;
	}

	
	
	public String getFull_name() {
		return full_name;
	}



	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}



	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	
	public Date getCr_date() {
		return cr_date;
	}

	public void setCr_date(Date cr_date) {
		this.cr_date = cr_date;
	}

	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

	public UserRegistration getUserReg() {
		return userReg;
	}

	public void setUserReg(UserRegistration userReg) {
		this.userReg = userReg;
	}

	public String getRefer_unique_id() {
		return refer_unique_id;
	}

	public void setRefer_unique_id(String refer_unique_id) {
		this.refer_unique_id = refer_unique_id;
	}

	@Override
	public String toString() {
		return "UserReference [reference_id=" + reference_id + ", full_name=" + full_name + ", email_id=" + email_id + ", mobile=" + mobile + ", cr_date=" + cr_date + ", status=" + status
				+ ", userReg=" + userReg + "]";
	}
	
}
