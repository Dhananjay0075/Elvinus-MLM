package com.elvinus.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.elvinus.model.UserCredit;
import com.elvinus.model.UserNotification;
import com.elvinus.model.UserReference;
import com.elvinus.model.UserRegistration;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface UserService{

	
	public String saveUserRegdetails(UserRegistration userReg,HttpServletRequest request);
	
	public List<UserRegistration> getUserDetails(int userId);
	
	public String getValidateUserAuthentication(String emailId,String password);
	
	public List<UserRegistration> getUserProfile(String consType,String emailId);
	
	public String saveUserReference(UserReference userRef,HttpSession session);
	
	public List<UserReference> getUserReferences(int userId);
	
	public long getUserReferencesCount(int userId,String status);
	
	public String activateUser(HttpServletRequest request);
	
	public String redirecToElvinusShop(HttpServletRequest request);
	
	public List<UserCredit> getUserCreditRecord(int userId);
	
	public List<Object[]> getUserCreditStatus(int userId);
	
	public String updateAccountDetails(UserRegistration user,MultipartHttpServletRequest request);
	
	public String saveUserNotification(UserNotification notify,HttpServletRequest request);
	public String updateNotifyStatus(UserNotification notify);
	public List<UserNotification> notificationList(int userId);
	public UserNotification readNotification(int notificationId);
	public String deleteNotification(int notificationId);
	
	public List<UserReference> getRecentRefActivity(int userId);
	
	public List<UserCredit> getRecentCredActivity(int userId);
	
	public String resetPassword(HttpServletRequest request,int userId);
	
	public List<UserReference> getUserRefeDetails(String uniRefid);
	
	
	
}
