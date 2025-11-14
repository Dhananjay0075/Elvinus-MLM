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
@Table(name = "user_order")
public class UserOrder {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_order_id")
	int user_order_id;
	
	@Column(name = "order_date")
	private Date order_date;
    
	@Column(name = "order_amount")
	private double order_amount;
    
	@Column(name = "payment_mode")
	private String payment_mode;
    
	@Column(name = "elvinus_order_id")
	private long elvinus_order_id;
    
	@ManyToOne
    @JoinColumn(name="user_id")
    private UserRegistration userReg;
    
    public UserOrder()
	{
		
	}

	public UserOrder(int user_order_id, Date order_date, double order_amount, String payment_mode,
			long elvinus_order_id, UserRegistration userReg) {
		super();
		this.user_order_id = user_order_id;
		this.order_date = order_date;
		this.order_amount = order_amount;
		this.payment_mode = payment_mode;
		this.elvinus_order_id = elvinus_order_id;
		this.userReg = userReg;
	}

	public int getUser_order_id() {
		return user_order_id;
	}

	public void setUser_order_id(int user_order_id) {
		this.user_order_id = user_order_id;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public double getOrder_amount() {
		return order_amount;
	}

	public void setOrder_amount(double order_amount) {
		this.order_amount = order_amount;
	}

	public String getPayment_mode() {
		return payment_mode;
	}

	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}

	public long getElvinus_order_id() {
		return elvinus_order_id;
	}

	public void setElvinus_order_id(long elvinus_order_id) {
		this.elvinus_order_id = elvinus_order_id;
	}

	public UserRegistration getUserReg() {
		return userReg;
	}

	public void setUserReg(UserRegistration userReg) {
		this.userReg = userReg;
	}

	@Override
	public String toString() {
		return "UserOrder [user_order_id=" + user_order_id + ", order_date=" + order_date + ", order_amount="
				+ order_amount + ", payment_mode=" + payment_mode + ", elvinus_order_id=" + elvinus_order_id
				+ ", userReg=" + userReg + "]";
	}
    
}
