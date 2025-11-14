package com.elvinus.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.elvinus.model.AdminDetails;
import com.elvinus.model.CreditModel;
import com.elvinus.model.UserRegistration;

public interface AdminDao {

	
	public String getValidateAdmin(String user_id,String password);
	
	public List<AdminDetails> getAdminDetails();
	
	public String setAdminAccess(String access);
	
	public List<UserRegistration> getUserList();
	
	public long totalMembers();
	
	public UserRegistration getUserDetails(int userId);
	
	public List<Object[]> getUsersReferenceStatus();
	
	public List<CreditModel> getParentReward(String rewardType);
	
	public String saveEmployee(AdminDetails adminEmp,HttpServletRequest request);	
	
	public AdminDetails viewEmployee(AdminDetails adminEmp);
	
	public String setAdminAccessStatus(String status,int admin_id);
	
	
}
