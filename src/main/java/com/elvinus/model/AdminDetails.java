package com.elvinus.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin_details")
public class AdminDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="admin_id")
	private int admin_id;
	
	@Column(name="admin_name")
	private String admin_name;
	
	@Column(name="admin_photo")
	private String admin_photo;
	
	@Column(name="admin_designation")
	private String admin_designation;
		
	@Column(name="admin_user_id")
	private String admin_user_id;
	
	@Column(name="admin_password")
	private String admin_password;
	
	@Column(name="admin_updated_date")
	private Date admin_updated_date;

	@Column(name="mobile")
	private String mobile;
	
	@Column(name="admin_access")
	private String admin_access;
	
	@Column(name="access_status")
	private String access_status;
	
	@Column(name="last_access_time")
	private Date last_access_time;
	
	@Column(name="current_access_time")
	private Date current_access_time;
	
	
	public int getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}

	public String getAdmin_name() {
		return admin_name;
	}

	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}

	public String getAdmin_photo() {
		return admin_photo;
	}

	public void setAdmin_photo(String admin_photo) {
		this.admin_photo = admin_photo;
	}

	public String getAdmin_designation() {
		return admin_designation;
	}

	public void setAdmin_designation(String admin_designation) {
		this.admin_designation = admin_designation;
	}

	public String getAdmin_user_id() {
		return admin_user_id;
	}

	public void setAdmin_user_id(String admin_user_id) {
		this.admin_user_id = admin_user_id;
	}

	public String getAdmin_password() {
		return admin_password;
	}

	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}

	public Date getAdmin_updated_date() {
		return admin_updated_date;
	}

	public void setAdmin_updated_date(Date admin_updated_date) {
		this.admin_updated_date = admin_updated_date;
	}

	public String getAdmin_access() {
		return admin_access;
	}

	public void setAdmin_access(String admin_access) {
		this.admin_access = admin_access;
	}

	public Date getLast_access_time() {
		return last_access_time;
	}

	public void setLast_access_time(Date last_access_time) {
		this.last_access_time = last_access_time;
	}

	public Date getCurrent_access_time() {
		return current_access_time;
	}

	public void setCurrent_access_time(Date current_access_time) {
		this.current_access_time = current_access_time;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAccess_status() {
		return access_status;
	}

	public void setAccess_status(String access_status) {
		this.access_status = access_status;
	}

	@Override
	public String toString() {
		return "AdminDetails [admin_id=" + admin_id + ", admin_name=" + admin_name + ", admin_photo=" + admin_photo
				+ ", admin_designation=" + admin_designation + ", admin_user_id=" + admin_user_id + ", admin_password="
				+ admin_password + ", admin_updated_date=" + admin_updated_date + ", mobile=" + mobile
				+ ", admin_access=" + admin_access + ", last_access_time=" + last_access_time + ", current_access_time="
				+ current_access_time + "]";
	}

	@Override
	public int hashCode() {
		
		final int prime = 31;
		int result = 1;
		result = prime * result + ((admin_access == null) ? 0 : admin_access.hashCode());
		result = prime * result + ((admin_designation == null) ? 0 : admin_designation.hashCode());
		result = prime * result + admin_id;
		result = prime * result + ((admin_name == null) ? 0 : admin_name.hashCode());
		result = prime * result + ((admin_password == null) ? 0 : admin_password.hashCode());
		result = prime * result + ((admin_photo == null) ? 0 : admin_photo.hashCode());
		result = prime * result + ((admin_updated_date == null) ? 0 : admin_updated_date.hashCode());
		result = prime * result + ((admin_user_id == null) ? 0 : admin_user_id.hashCode());
		result = prime * result + ((current_access_time == null) ? 0 : current_access_time.hashCode());
		result = prime * result + ((last_access_time == null) ? 0 : last_access_time.hashCode());
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AdminDetails other = (AdminDetails) obj;
		if (admin_access == null) {
			if (other.admin_access != null)
				return false;
		} else if (!admin_access.equals(other.admin_access))
			return false;
		if (admin_designation == null) {
			if (other.admin_designation != null)
				return false;
		} else if (!admin_designation.equals(other.admin_designation))
			return false;
		if (admin_id != other.admin_id)
			return false;
		if (admin_name == null) {
			if (other.admin_name != null)
				return false;
		} else if (!admin_name.equals(other.admin_name))
			return false;
		if (admin_password == null) {
			if (other.admin_password != null)
				return false;
		} else if (!admin_password.equals(other.admin_password))
			return false;
		if (admin_photo == null) {
			if (other.admin_photo != null)
				return false;
		} else if (!admin_photo.equals(other.admin_photo))
			return false;
		if (admin_updated_date == null) {
			if (other.admin_updated_date != null)
				return false;
		} else if (!admin_updated_date.equals(other.admin_updated_date))
			return false;
		if (admin_user_id == null) {
			if (other.admin_user_id != null)
				return false;
		} else if (!admin_user_id.equals(other.admin_user_id))
			return false;
		if (current_access_time == null) {
			if (other.current_access_time != null)
				return false;
		} else if (!current_access_time.equals(other.current_access_time))
			return false;
		if (last_access_time == null) {
			if (other.last_access_time != null)
				return false;
		} else if (!last_access_time.equals(other.last_access_time))
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		return true;
	}
	
	
}
