package com.elvinus.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

//@SuppressWarnings("serial")
@Entity
@Table(name = "user_registration")
public class UserRegistration implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = IDENTITY)
	@Column(name = "user_id", unique = true, nullable = false)
	private int user_id;
    
	@Column(name = "first_name", length = 20)
	private String first_name;
	
	@Column(name = "last_name", length = 20)
    private String last_name;
	
	@Column(name = "email_id", length = 40)
    private String email_id;
	
	@Column(name = "mobile", length = 10)
    private String mobile;
	
	@Column(name = "password")
    private String password;
	
	@Column(name = "pan_id")
    private String pan_id;
	
	@Column(name = "aadhar_id")
    private String aadhar_id;
	
	@Column(name = "gender")
    private String gender;
	
	@Column(name = "area")
    private String area;
	
	@Column(name = "city")
    private String city;
	
	@Column(name = "state")
    private String state;
	
	@Column(name = "country")
    private String country;
	
	@Column(name = "pincode")
    private String pincode;
	
	@Column(name = "dob")
    private Date dob;
    
	@Column(name = "bank_name")
    private String bank_name;
	
	@Column(name = "bank_account_no")
    private String bank_account_no;
	
	@Column(name = "bank_ifce_code")
    private String bank_ifce_code;
	
	@Column(name = "bank_account_name")
    private String bank_account_name;
    
	@Column(name = "cr_date")
    private Date cr_date;
    
	@Column(name = "account_status")
    private String account_status;
    
	@Column(name = "account_id")
    private String account_id;
    
	@Column(name = "profile_photo")
    private String profile_photo;
    
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="userReg", cascade = CascadeType.ALL)
    private Set<UserReference> userReference;
	
	
    public UserRegistration() {
    	
    }
    
    //
	
    public UserRegistration(int user_id, String first_name, String last_name, String email_id,
			String mobile, String password, String pan_id, String aadhar_id, String gender, String area, String city,
			String state, String country, String pincode, Date dob, String bank_name, String bank_account_no,
			String bank_ifce_code, String bank_account_name, Date cr_date, String account_status, String account_id,Set<UserReference> userReference,String profile_photo) {
		super();
		this.user_id = user_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email_id = email_id;
		this.mobile = mobile;
		this.password = password;
		this.pan_id = pan_id;
		this.aadhar_id = aadhar_id;
		this.gender = gender;
		this.area = area;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
		this.dob = dob;
		this.bank_name = bank_name;
		this.bank_account_no = bank_account_no;
		this.bank_ifce_code = bank_ifce_code;
		this.bank_account_name = bank_account_name;
		this.cr_date = cr_date;
		this.account_status = account_status;
		this.account_id = account_id;
		this.userReference = userReference;
		this.profile_photo = profile_photo;
	}


	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
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

	public String getPan_id() {
		return pan_id;
	}

	public void setPan_id(String pan_id) {
		this.pan_id = pan_id;
	}

	public String getAadhar_id() {
		return aadhar_id;
	}


	public void setAadhar_id(String aadhar_id) {
		this.aadhar_id = aadhar_id;
	}

	public String getArea() {
		return area;
	}


	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}

	public String getPincode() {
		return pincode;
	}


	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public String getBank_account_no() {
		return bank_account_no;
	}

	public void setBank_account_no(String bank_account_no) {
		this.bank_account_no = bank_account_no;
	}

	public String getBank_ifce_code() {
		return bank_ifce_code;
	}

	public void setBank_ifce_code(String bank_ifce_code) {
		this.bank_ifce_code = bank_ifce_code;
	}

	public String getBank_account_name() {
		return bank_account_name;
	}

	public void setBank_account_name(String bank_account_name) {
		this.bank_account_name = bank_account_name;
	}

	public Date getCr_date() {
		return cr_date;
	}

	public void setCr_date(Date cr_date) {
		this.cr_date = cr_date;
	}

	public String getAccount_status() {
		return account_status;
	}

	public void setAccount_status(String account_status) {
		this.account_status = account_status;
	}

	public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAccount_id() {
		return account_id;
	}

	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}

	
	public Set<UserReference> getUserReference() {
		return userReference;
	}

	public void setUserReference(Set<UserReference> userReference) {
		this.userReference = userReference;
	}

	public String getProfile_photo() {
		return profile_photo;
	}

	public void setProfile_photo(String profile_photo) {
		this.profile_photo = profile_photo;
	}

	@Override
	public String toString() {
		return "UserRegistration [user_id=" + user_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", email_id=" + email_id + ", mobile=" + mobile + ", password=" + password + ", pan_id=" + pan_id
				+ ", aadhar_id=" + aadhar_id + ", gender=" + gender + ", area=" + area + ", city=" + city + ", state="
				+ state + ", country=" + country + ", pincode=" + pincode + ", dob=" + dob + ", bank_name=" + bank_name
				+ ", bank_account_no=" + bank_account_no + ", bank_ifce_code=" + bank_ifce_code + ", bank_account_name="
				+ bank_account_name + ", cr_date=" + cr_date + ", account_status=" + account_status + ", account_id="
				+ account_id + ", userReference=" + userReference + "]";
	}

	
	
}
