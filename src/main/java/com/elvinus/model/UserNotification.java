package com.elvinus.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_notification")
public class UserNotification {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="notification_id")
	private int notification_id;
	
	@Column(name="notify_via")
	private String notify_via;
	
	@Column(name="notify_by")
	private int notify_by;
	
	@Column(name="notify_to")
	private int notify_to;
	
	@Column(name="notification_msg")
	private String notification_msg;
	
	@Column(name="notify_date")
	private Date notify_date;
	
	@Column(name="notification_status")
	private String notification_status;

	
	public UserNotification(){
		
	}
	
	public UserNotification(int notification_id, String notify_via, int notify_by, int notify_to,
			String notification_msg, Date notify_date, String notification_status) {
		super();
		this.notification_id = notification_id;
		this.notify_via = notify_via;
		this.notify_by = notify_by;
		this.notify_to = notify_to;
		this.notification_msg = notification_msg;
		this.notify_date = notify_date;
		this.notification_status = notification_status;
	}

	public int getNotification_id() {
		return notification_id;
	}

	public void setNotification_id(int notification_id) {
		this.notification_id = notification_id;
	}

	public String getNotify_via() {
		return notify_via;
	}

	public void setNotify_via(String notify_via) {
		this.notify_via = notify_via;
	}

	public int getNotify_by() {
		return notify_by;
	}

	public void setNotify_by(int notify_by) {
		this.notify_by = notify_by;
	}

	public int getNotify_to() {
		return notify_to;
	}

	public void setNotify_to(int notify_to) {
		this.notify_to = notify_to;
	}

	public String getNotification_msg() {
		return notification_msg;
	}

	public void setNotification_msg(String notification_msg) {
		this.notification_msg = notification_msg;
	}

	public Date getNotify_date() {
		return notify_date;
	}

	public void setNotify_date(Date notify_date) {
		this.notify_date = notify_date;
	}

	public String getNotification_status() {
		return notification_status;
	}

	public void setNotification_status(String notification_status) {
		this.notification_status = notification_status;
	}

	@Override
	public String toString() {
		return "UserNotification [notification_id=" + notification_id + ", notify_via=" + notify_via + ", notify_by="
				+ notify_by + ", notify_to=" + notify_to + ", notification_msg=" + notification_msg + ", notify_date="
				+ notify_date + ", notification_status=" + notification_status + "]";
	}
	
}
