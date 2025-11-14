package com.elvinus.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_credit")
public class UserCredit {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_credit_id")
	int user_credit_id;
	
	@Column(name = "credit_date")
	private Date credit_date;
    
	@Column(name = "credit_status")
	private String credit_status;
    
	@Column(name = "credit_mode")
	private String credit_mode;
    
	@Column(name = "credit_reward")
	private long credit_reward;
    
	@Column(name = "credit_amount")
	private double credit_amount;
    
    @ManyToOne
    @JoinColumn(name="user_id")
    private UserRegistration userReg;

    public UserCredit(){
    	
    }
    
    
	

	public UserCredit(int user_credit_id, Date credit_date, String credit_status, String credit_mode,
			long credit_reward, double credit_amount, UserRegistration userReg) {
		super();
		this.user_credit_id = user_credit_id;
		this.credit_date = credit_date;
		this.credit_status = credit_status;
		this.credit_mode = credit_mode;
		this.credit_reward = credit_reward;
		this.credit_amount = credit_amount;
		this.userReg = userReg;
	}




	public int getUser_credit_id() {
		return user_credit_id;
	}


	public void setUser_credit_id(int user_credit_id) {
		this.user_credit_id = user_credit_id;
	}


	public Date getCredit_date() {
		return credit_date;
	}


	public void setCredit_date(Date credit_date) {
		this.credit_date = credit_date;
	}


	public String getCredit_status() {
		return credit_status;
	}


	public void setCredit_status(String credit_status) {
		this.credit_status = credit_status;
	}


	public String getCredit_mode() {
		return credit_mode;
	}


	public void setCredit_mode(String credit_mode) {
		this.credit_mode = credit_mode;
	}


	public long getCredit_reward() {
		return credit_reward;
	}


	public void setCredit_reward(long credit_reward) {
		this.credit_reward = credit_reward;
	}


	public UserRegistration getUserReg() {
		return userReg;
	}


	public void setUserReg(UserRegistration userReg) {
		this.userReg = userReg;
	}

	
	
	public double getCredit_amount() {
		return credit_amount;
	}




	public void setCredit_amount(double credit_amount) {
		this.credit_amount = credit_amount;
	}




	@Override
	public String toString() {
		return "UserCredit [user_credit_id=" + user_credit_id + ", credit_date=" + credit_date + ", credit_status="
				+ credit_status + ", credit_mode=" + credit_mode + ", credit_reward=" + credit_reward
				+ ", credit_amount=" + credit_amount + ", userReg=" + userReg + "]";
	}

	
}
