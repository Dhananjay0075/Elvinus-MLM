package com.elvinus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="credit_model")
public class CreditModel {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="credit_id")
	int credit_id;
	
	@Column(name = "credit_cycle")
	private String credit_cycle;
    
	@Column(name = "credit_level")
	private String credit_level;
    
	@Column(name = "credit_mode")
	private String credit_mode;
    
	@Column(name = "credit_reward")
	private String credit_reward;

	public CreditModel(){
		
	}
	
	public CreditModel(int credit_id, String credit_cycle, String credit_level, String credit_mode,
			String credit_reward) {
		super();
		this.credit_id = credit_id;
		this.credit_cycle = credit_cycle;
		this.credit_level = credit_level;
		this.credit_mode = credit_mode;
		this.credit_reward = credit_reward;
	}

	public int getCredit_id() {
		return credit_id;
	}

	public void setCredit_id(int credit_id) {
		this.credit_id = credit_id;
	}

	public String getCredit_cycle() {
		return credit_cycle;
	}

	public void setCredit_cycle(String credit_cycle) {
		this.credit_cycle = credit_cycle;
	}

	public String getCredit_level() {
		return credit_level;
	}

	public void setCredit_level(String credit_level) {
		this.credit_level = credit_level;
	}

	public String getCredit_mode() {
		return credit_mode;
	}

	public void setCredit_mode(String credit_mode) {
		this.credit_mode = credit_mode;
	}

	public String getCredit_reward() {
		return credit_reward;
	}

	public void setCredit_reward(String credit_reward) {
		this.credit_reward = credit_reward;
	}
    	
}
