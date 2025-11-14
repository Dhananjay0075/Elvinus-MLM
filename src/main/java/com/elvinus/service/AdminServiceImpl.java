package com.elvinus.service;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.elvinus.dao.AdminDao;
import com.elvinus.model.AdminDetails;
import com.elvinus.model.CreditModel;
import com.elvinus.model.UserRegistration;
import com.elvinus.util.PasswordGenerator;


@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminDao adminDao;
	
	@Transactional(readOnly = false)
	public String getValidateAdmin(String user_id,String password)
	{
		String encPassword = "";
		
		try {
			encPassword = PasswordGenerator.encrypt(password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return adminDao.getValidateAdmin(user_id,encPassword);
	}
	
	public AdminDetails getAdminDetails()
	{
		AdminDetails adminObj = new AdminDetails();
		
		List<AdminDetails> listObj = adminDao.getAdminDetails();
		
		if(listObj.size()>0)
		{
			return listObj.get(0);
		}
		else
		{
			return adminObj;
		}
	}
	
	public String setAdminAccess(String access)
	{
		return adminDao.setAdminAccess(access);
	}
	
	public List<UserRegistration> getUserList()
	{
		return adminDao.getUserList();
	}
	
	public long totalMembers()
	{
		return adminDao.totalMembers();
	}
	
	public UserRegistration getUserDetails(int userId)
	{
		return adminDao.getUserDetails(userId);
	}
	
	public List<Object[]> getUsersReferenceStatus()
	{
		return adminDao.getUsersReferenceStatus();
	}
	
	public List<CreditModel> getParentReward(String rewardType)
	{
		return adminDao.getParentReward(rewardType);
	}
	
	public String saveEmployee(AdminDetails adminEmp,HttpServletRequest request)
	{
		
		return adminDao.saveEmployee(adminEmp,request);	
	}
	
	public AdminDetails viewEmployee(AdminDetails adminEmp)
	{
		return adminDao.viewEmployee(adminEmp);
	}
	
	public String setAdminAccessStatus(String status,int admin_id)
	{
		return adminDao.setAdminAccessStatus(status,admin_id);
	}
	
	
	
	
	
	
}
