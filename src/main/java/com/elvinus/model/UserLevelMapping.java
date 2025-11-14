package com.elvinus.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user_level_mapping", catalog = "elvinus_ref_v01")
public class UserLevelMapping {

	@Id
    @GeneratedValue(strategy = IDENTITY)
	@Column(name = "level_id", unique = true, nullable = false)
	private int level_id;
    
	@Column(name = "cr_date")
	private Date cr_date;
	
	@Column(name = "user_refer_from")
    private int user_refer_from;
	
	@Column(name = "user_refer_to")
    private int user_refer_to;
    
	
    
    public int getLevel_id() {
		return level_id;
	}

	public void setLevel_id(int level_id) {
		this.level_id = level_id;
	}

	public Date getCr_date() {
		return cr_date;
	}

	public void setCr_date(Date cr_date) {
		this.cr_date = cr_date;
	}

	
	public int getUser_refer_from() {
		return user_refer_from;
	}

	public void setUser_refer_from(int user_refer_from) {
		this.user_refer_from = user_refer_from;
	}

	
	public int getUser_refer_to() {
		return user_refer_to;
	}

	public void setUser_refer_to(int user_refer_to) {
		this.user_refer_to = user_refer_to;
	}

    
}
