package com.elvinus.service;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.elvinus.bean.ECommBilling;
import com.elvinus.bean.ECommShipping;
import com.elvinus.bean.ECommUserReg;
import com.elvinus.client.HitEcommClient;
import com.elvinus.dao.AdminDao;
import com.elvinus.dao.UserDao;
import com.elvinus.model.UserCredit;
import com.elvinus.model.UserNotification;
import com.elvinus.model.UserOrder;
import com.elvinus.model.UserReference;
import com.elvinus.model.UserRegistration;
import com.elvinus.util.CipherEncryption;
import com.elvinus.util.CreditCalculation;
import com.elvinus.util.EmailSentUtil;
import com.elvinus.util.PasswordGenerator;
import com.elvinus.util.RandomNoGenerator;
import com.elvinus.util.ReadFileToString;


@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private AdminDao adminDao;
	
	private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);
	
	public String saveUserRegdetails(UserRegistration userReg,HttpServletRequest request)
	{	
		CipherEncryption.DarKnight nestedObject = new CipherEncryption.DarKnight(); 
        
		String status = "";
		
		userReg.setProfile_photo("");
		
		userReg.setCr_date(new Date());
		String accountId = "ELV"+userReg.getAadhar_id().substring((userReg.getAadhar_id().length()-4), (userReg.getAadhar_id().length()-1))+userReg.getMobile().substring((userReg.getMobile().length()-4), (userReg.getMobile().length()-1));
		
		userReg.setAccount_id(accountId);
		
		userReg.setAccount_status("Deactive");
		
		try {
			
			userReg.setPassword(nestedObject.getEncrypted(userReg.getPassword())); 
			
			 //userReg.setPassword(PasswordGenerator.encrypt(userReg.getPassword()));
		} 
		catch (Exception e) {
			
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
		status = userDao.saveUserRegdetails(userReg);
		
		System.out.println("User Save Status="+status);
		
		
		if(status.equals("success"))
		{		
					/*if(request.getParameter("uniRefid")!=null)
					{
						//int referedId = userDao.getUserIdFromAccId(request.getParameter("refId"));
						
						// refer_by
						
						if(userDao.updateUserRefStatus(request.getParameter("refAccId")).equals("success"))
						{
							
						}				
					}*/
			
			// POST API TO SAVE THE USER DETAILS IN E-COMM APPLICATION
			
			try {
				
				ECommBilling billingDetail = new ECommBilling(userReg.getFirst_name(),userReg.getLast_name(),"",userReg.getArea(),"",userReg.getCity(),userReg.getState(),userReg.getPincode(),userReg.getCountry(),userReg.getEmail_id(),userReg.getMobile());
				
				ECommShipping shippingDetails = new ECommShipping(userReg.getFirst_name(),userReg.getLast_name(),"",userReg.getArea(),"",userReg.getCity(),userReg.getState(),userReg.getPincode(),userReg.getCountry());
				
				ECommUserReg ecomReg = new ECommUserReg(userReg.getEmail_id(),userReg.getFirst_name(),userReg.getLast_name(),userReg.getAccount_id(),nestedObject.getDecrypted(userReg.getPassword()),billingDetail,shippingDetails);
		    	
				HitEcommClient.createUser(ecomReg);
				
				System.out.println("Ecomm User-"+ecomReg.toString());
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			return "success";
		}
		else
		{
			return status;
		}		
	}
	
	
	public String activateUser(HttpServletRequest request)
	{
		if(userDao.activateUser(request).equals("success"))
		{
			int userId = userDao.getUserIdFromAccId(request.getParameter("account_id"));
			String email = userDao.getEmailIdFromAccId(request.getParameter("account_id"));
			
			// https://www.elvinus.com/wp-json/wc/v3/orders/1725
			
			// GET ORDER RECORDS FORM THE CURRENT ORDER
			
			UserOrder userOrder = HitEcommClient.getOrderDetails(Integer.parseInt(request.getParameter("order_id")));
			
			UserRegistration useReg = new UserRegistration();
			useReg.setUser_id(userId);
			
			userOrder.setUserReg(useReg);
			
			// SAVE USER ORDER DETAILS
			
			userDao.saveUserOrder(userOrder);
			
			// SAVE CURRENT PARENT USER CREDIT DETAILS
			
			UserReference usRef = userDao.getUserRefDetails(email);
			
			UserCredit usCredit = new UserCredit();
			
			System.out.println("ParentId-"+usRef.getUserReg().getUser_id());
			
			int refCount = userDao.getParentRefCount(usRef.getUserReg().getUser_id()); // SUCCESS REFERCOUNT OF PARENT
			
			System.out.println("refCount="+refCount+"=AMount="+userOrder.getOrder_amount());
					
			int rewardPer = CreditCalculation.getReferenceCreditReward(refCount); 
			System.out.println("rewardPer="+rewardPer);
			double rewardAmount = ((rewardPer/100.0f)*userOrder.getOrder_amount());
			rewardAmount =Double.parseDouble(new DecimalFormat("##.####").format(rewardAmount));
			
			System.out.println("rewardAmt="+rewardAmount);
			
			usCredit.setCredit_date(new Date());
			usCredit.setCredit_status("Onboard");
			
			usCredit.setCredit_mode("Percentage");
			usCredit.setCredit_reward(rewardPer);
			usCredit.setCredit_amount(rewardAmount);
			
			UserRegistration parentId = new UserRegistration();
			parentId.setUser_id(usRef.getUserReg().getUser_id());
			usCredit.setUserReg(parentId);
			
			if(userDao.saveUserCredit(usCredit).equals("success"))
			{
				// UPDATE THE REWARD TO PARENT-2PARENT
				
				rewardToPrevParent(refCount,usRef.getUserReg().getUser_id());
			}			
		}
		
		return "success";
	}
	
	public String rewardToPrevParent(int refCount,int childUserId)
	{		
		int parentId = userDao.getParentIdViaUserId(childUserId);
		
		if(parentId>0)
		{
			UserRegistration parentObj = new UserRegistration();
			parentObj.setUser_id(parentId);
			
			UserCredit usCredit = new UserCredit();
			
			usCredit.setCredit_date(new Date());
			usCredit.setCredit_status("Onboard");
			usCredit.setUserReg(parentObj);
			
			usCredit.setCredit_mode("Point");
			usCredit.setCredit_reward(CreditCalculation.getParentRewardPoint(refCount));
			usCredit.setCredit_amount(0);
			
			return userDao.saveUserCredit(usCredit);
		}
		else
		{
			return "success";
		}
	}
	
	
	public List<UserRegistration> getUserDetails(int userId)
	{
		return userDao.getUserDetails(userId);
	}
	
	
	public String getValidateUserAuthentication(String emailId,String password)
	{
		String status = "";
		
		CipherEncryption.DarKnight cipherObj = new CipherEncryption.DarKnight(); 
		
		try {
					
			//String encryptPassword = PasswordGenerator.encrypt(password);
			
			String encryptPassword = cipherObj.getEncrypted(password);
			
			status = userDao.getValidateUserAuthentication(emailId,encryptPassword);		
			
			//log.info("Status-="+status);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 			
		return status;
	}
	
	public List<UserRegistration> getUserProfile(String consType,String emailId)
	{
		return userDao.getUserProfile(consType,emailId);
	}
	
	public String saveUserReference(UserReference userRef,HttpSession session)
	{
		UserRegistration userObj = new UserRegistration();
		userObj.setUser_id((int)session.getAttribute("userId"));
		
		userRef.setStatus("pending");
		userRef.setCr_date(new Date());
		userRef.setUserReg(userObj);
		
		try {
			userRef.setRefer_unique_id(RandomNoGenerator.generatePin()+"");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String status = userDao.saveUserReference(userRef);
		
		if(status.equals("success"))
		{					
			ResourceBundle resource = ResourceBundle.getBundle("resources/userReference");
			
			String redirectURL = resource.getString("defaultUrl") +"userSignUp?refAccId="+session.getAttribute("accountId")+"&uniRefid="+userRef.getRefer_unique_id();
			String emailBody = ReadFileToString.readUsingFileInputStream();
			
			LOGGER.info("Email Body String Size="+emailBody.length());
			
			emailBody = emailBody.replaceAll("resource/horizontal/assets/images/Elv_logo.png", resource.getString("defaultUrl")+"resource/horizontal/assets/images/Elv_logo.png");
			emailBody = emailBody.replaceAll("MAILHEADING", resource.getString("bodyHeading"));
			emailBody = emailBody.replaceAll("FULLNAME", userRef.getFull_name());
			emailBody = emailBody.replaceAll("BODY_CONT_1", resource.getString("bodyMessage1"));
			emailBody = emailBody.replaceAll("ACTION_BUTTON", "<a href='"+redirectURL+"' class='btn-primary' style='font-family: Helvetica Neue,Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; color: #FFF; text-decoration: none; line-height: 2em; font-weight: bold; text-align: center; cursor: pointer; display: inline-block; border-radius: 5px; text-transform: capitalize; background-color: #02c0ce; margin: 0; border-color: #02c0ce; border-style: solid; border-width: 0px 4px;'>Join on Elvinus Membership</a>");
			
			LOGGER.info("Body Set Will go to Mail");
			
			EmailSentUtil.getEmailSent(userRef.getEmail_id(), resource.getString("mailSubject"), emailBody);
		}
		
		return status;
	}
	
	public List<UserReference> getUserReferences(int userId)
	{
		return userDao.getUserReferences(userId);
	}
	
	public long getUserReferencesCount(int userId,String status)
	{
		return userDao.getUserReferencesCount(userId,status);
	}
	
	public String redirecToElvinusShop(HttpServletRequest request)
	{
		List<UserRegistration> userData= userDao.redirecToElvinusShop(request);
		
		String response = "username="; //ABI127&password=asd123
		
		response += userData.get(0).getAccount_id();
		
		try {
			
			//response += "&password="+PasswordGenerator.decrypt(userData.get(0).getPassword());
			
			response += "&password="+userData.get(0).getPassword();
			
			System.out.println("Response="+response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return response;
	}
	
	public List<UserCredit> getUserCreditRecord(int userId)
	{
		return userDao.getUserCreditRecord(userId);
	}
	
	public List<Object[]> getUserCreditStatus(int userId)
	{
		List<Object[]> creditStatus = new ArrayList<Object[]>();
		
		creditStatus = userDao.getUserCreditStatus(userId);
		
	    System.out.println("Credit="+creditStatus.toString());
	    
		return creditStatus;
	}
	
	
	public String updateAccountDetails(UserRegistration user,MultipartHttpServletRequest request)
	{
		String status = "";
		
		if(request.getParameter("updateType").equals("Account"))
		{			
			String fileName = "";
			
			MultipartFile multipartFile = request.getFile("file");
		    fileName = multipartFile.getOriginalFilename();
		    
		    if(!fileName.equals(""))
		    {
		    	fileName = fileName.replaceAll(" ","_");  
		    }
		    
		    user.setProfile_photo(fileName);
		    
			if(userDao.updateAccountDetails(user,request.getParameter("updateType")).equals("success"))
			{
				if(!fileName.equals(""))
			    {
					ResourceBundle fileResource = ResourceBundle.getBundle("resources/emailConfig");
			 	    
			 	    String filePath = fileResource.getString("userProfileDirectory");
			 	    		
			 	    File ourPath = new File(filePath);
			 	    
			 	    String storePath = ourPath.getPath()+"/"+user.getUser_id()+"/";	 	    
			 	    
			        if(!fileName.equals(""))
					{	    				
				        File fld = new File(storePath);
				    	
				        if(!fld.exists())
				    	{
						    fld.mkdirs();
				    	}
				        try 
				        {
			            	multipartFile.transferTo(new File(storePath+fileName));
						} 
				        catch (Exception e) 
				        {
							// TODO Auto-generated catch block
							e.printStackTrace();					                    
			            }		        
			 	        // End of saving File
					}
			    }				
			}
			
			
	        
	        
	        return "success";
			
		}
		else if(request.getParameter("updateType").equals(""))
		{
			return "";
		}
		else
		{
			return "";
		}		
	}
	
	public String saveUserNotification(UserNotification notify,HttpServletRequest request)
	{
		int reciverUserId = userDao.getUserIdFromEmail(request.getParameter("reciverUserId"));
				
		if(reciverUserId>0)
		{
			notify.setNotify_to(reciverUserId);
			notify.setNotification_msg(request.getParameter("notify_msg"));
			notify.setNotification_status("Unread");
			notify.setNotify_date(new Date());
			
			return userDao.saveUserNotification(notify);
		}
		else
		{
			ResourceBundle resource = ResourceBundle.getBundle("resources/userNotification");
			
			String emailBody = ReadFileToString.readUsingFileInputStream();
			
			emailBody = emailBody.replaceAll("resource/horizontal/assets/images/Elv_logo.png", resource.getString("defaultUrl")+"resource/horizontal/assets/images/Elv_logo.png");
			emailBody = emailBody.replaceAll("MAILHEADING", resource.getString("bodyHeading"));
			emailBody = emailBody.replaceAll("FULLNAME", "User");
			emailBody = emailBody.replaceAll("BODY_CONT_1", request.getParameter("notify_msg"));
			emailBody = emailBody.replaceAll("ACTION_BUTTON", "");
			
			return EmailSentUtil.getEmailSent(request.getParameter("reciverUserId"), resource.getString("mailSubject"), emailBody);
		}
		
	}
	
	public String updateNotifyStatus(UserNotification notify)
	{
		return userDao.updateNotifyStatus(notify);
	}
	
	public List<UserNotification> notificationList(int userId)
	{
		return userDao.notificationList(userId);
	}
	public UserNotification readNotification(int notificationId)
	{
		return userDao.readNotification(notificationId);
	}
	public String deleteNotification(int notificationId)
	{
		return userDao.deleteNotification(notificationId);
	}
	
	public List<UserReference> getRecentRefActivity(int userId)
	{
		return userDao.getRecentRefActivity(userId);
	}
	
	public List<UserCredit> getRecentCredActivity(int userId)
	{
		return userDao.getRecentCredActivity(userId);
	}
	
	@SuppressWarnings("static-access")
	public String resetPassword(HttpServletRequest request,int userId)
	{
		CipherEncryption.DarKnight cipherObj = new CipherEncryption.DarKnight();
		
		if(userDao.checkUserPassword(cipherObj.getEncrypted(request.getParameter("curPassword")),userId).equals("correct"))
		{
			return userDao.updatePassword(cipherObj.getEncrypted(request.getParameter("newPassword")),userId);
		}
		else
		{
			return "Incorrect";
		}	
	}
	
	public List<UserReference> getUserRefeDetails(String uniRefid)
	{
		return userDao.getUserRefeDetails(uniRefid);
	}
	
	
}
