package com.elvinus.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.elvinus.model.UserCredit;
import com.elvinus.model.UserNotification;
import com.elvinus.model.UserOrder;
import com.elvinus.model.UserReference;
import com.elvinus.model.UserRegistration;

public interface UserDao {

	public String saveUserRegdetails(UserRegistration userReg);
	
	public List<UserRegistration> getUserDetails(int userId);
	
	public String getValidateUserAuthentication(String emailId,String encryptPassword);
	
	public List<UserRegistration> getUserProfile(String consType,String emailId);
	
	public String saveUserReference(UserReference userRef);
	
	public int getUserIdFromAccId(String accountId);
	
	public String updateUserRefStatus(String uniaccid);
	
	public List<UserReference> getUserReferences(int userId);
	
	public long getUserReferencesCount(int userId,String status);
	
	public String activateUser(HttpServletRequest request);
	
	public List<UserRegistration> redirecToElvinusShop(HttpServletRequest request);
	
	public String saveUserOrder(UserOrder userOrder);
	
	public String getEmailIdFromAccId(String accountId);
	
	public UserReference getUserRefDetails(String email);
	
	public int getParentRefCount(int parent_user_id);
	
	public List<UserCredit> getUserCreditRecord(int userId);
	
	public List<Object[]> getUserCreditStatus(int userId);
	
	public String updateAccountDetails(UserRegistration user,String updateType);
	
	public String saveUserNotification(UserNotification notify);
	public String updateNotifyStatus(UserNotification notify);
	public List<UserNotification> notificationList(int userId);
	public UserNotification readNotification(int notificationId);
	public String deleteNotification(int notificationId);
	
	public int getUserIdFromEmail(String emailId);
	
	public String saveUserCredit(UserCredit usCredit);
	
	public int getParentIdViaUserId(int childUserId);
	
	public List<UserReference> getRecentRefActivity(int userId);
	
	public List<UserCredit> getRecentCredActivity(int userId);
	
	public String checkUserPassword(String encPassword,int userId);
	
	public String updatePassword(String encPassword,int userId);
	
	
	public List<UserReference> getUserRefeDetails(String uniRefid);
	
	
	
}
