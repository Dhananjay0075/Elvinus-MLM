package com.elvinus.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.elvinus.model.UserCredit;
import com.elvinus.model.UserNotification;
import com.elvinus.model.UserOrder;
import com.elvinus.model.UserReference;
import com.elvinus.model.UserRegistration;

@Component
@SuppressWarnings("unused")
@Repository("userDao")
public class UserDaoImpl implements UserDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	private static final Logger LOGGER = Logger.getLogger(UserDaoImpl.class.getName());
	
	
	
	@SuppressWarnings("unchecked")
	public String saveUserRegdetails(UserRegistration userReg)
	{
		String transactionStatus = "";
		String hql = "";
		
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		List<UserRegistration> userData = new ArrayList<UserRegistration>();
		
		hql = "from UserRegistration where email_id='"+userReg.getEmail_id()+"'";			
		userData = session.createQuery(hql).list();	
		
		if(userData.size()>0)
		{
			return "Email Exist";
		}
		else
		{
			hql = "from UserRegistration where mobile='"+userReg.getMobile()+"'";			
			userData = session.createQuery(hql).list();	
			
			if(userData.size()>0)
			{
				return "Mobile Exist";
			}
			else
			{
				try {
					
					transaction = session.beginTransaction();
					session.saveOrUpdate(userReg);
					transaction.commit();

					if (transaction.wasCommitted()) {
						transactionStatus = "success";
					} else {
						transactionStatus = "failure";
					}
				} catch (Exception e) {
					
					LOGGER.info("During saving the data of UserRegistration exception arise."+e.getMessage());

					transactionStatus = "failure";
				} finally {
					session.close();
				}
				
				return transactionStatus;
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<UserRegistration> getUserDetails(int userId)
	{
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		List<UserRegistration> userData = session.createQuery("from UserRegistration where id="+userId+"").list();	
		
		return userData;
	}
	
	@SuppressWarnings("unchecked")
	public String getValidateUserAuthentication(String emailId,String encryptPassword)
	{
		Session session = sessionFactory.openSession();
		List<String> status = new ArrayList<String>();
				
		String hql = "select account_status from UserRegistration where email_id = '"+emailId+"'";
		status = session.createQuery(hql).list();	
		
		if(status.size()>0)
		{
			hql = "select account_status from UserRegistration where email_id = '"+emailId+"' and password='"+encryptPassword+"'";
			status = session.createQuery(hql).list();	
			
			if(status.size()>0)
			{
				session.close();
				String loginStatus = status.get(0);
				
				if(loginStatus.equals("Active"))
				{
					return status.get(0);
				}
				else if(loginStatus.equals("Deactive"))
				{
					return status.get(0);
				}
				else
				{
					return "Failed";
				}
			}
			else
			{
				return "Failed";
			}
		}
		else
		{
			return "No User";
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<UserRegistration> getUserProfile(String consType,String value)
	{
		Session session = sessionFactory.openSession();
		List<UserRegistration> userData = new LinkedList<UserRegistration>();
				
		Transaction transaction = null;
		
		if(consType.equals("Email"))
		{
			userData = session.createQuery("from UserRegistration where email_id='"+value+"'").list();	
		}
		else if(consType.equals("Mobile"))
		{
			userData = session.createQuery("from UserRegistration where mobile='"+value+"'").list();	
		}
		else
		{
			userData = session.createQuery("from UserRegistration where user_id="+value+"").list();	
		}
			
		session.close();
		
		return userData;
	}
	
	public String saveUserReference(UserReference userRef)
	{
		String transactionStatus = "";
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
		long count = ((Long)session.createQuery("select count(*) from UserReference where email_id='"+userRef.getEmail_id()+"'").uniqueResult()).longValue();			
		
		if(count>0)
		{
			transactionStatus = "exist";
		}
		else
		{
			try {
				
				transaction = session.beginTransaction();
				session.saveOrUpdate(userRef);
				transaction.commit();

				if (transaction.wasCommitted()) {
					transactionStatus = "success";
				} else {
					transactionStatus = "failure";
				}
			} catch (Exception e) {
				
				LOGGER.info("During saving the data of UserReference exception arise."+e.getMessage());

				transactionStatus = "failure";
			} finally {
				session.close();
			}
		}
		
		return transactionStatus;
	}
	
	@SuppressWarnings("unchecked")
	public int getUserIdFromAccId(String accountId)
	{
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		List<Integer> userData = session.createQuery("select user_id from UserRegistration where account_id='"+accountId+"'").list();	
		
		return userData.get(0);
	}
	
	
	@SuppressWarnings("unchecked")
	public String getEmailIdFromAccId(String accountId)
	{
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		List<String> userData = session.createQuery("select email_id from UserRegistration where account_id='"+accountId+"'").list();	
		
		return userData.get(0);
	}
	
	public String updateUserRefStatus(String uniaccid)
	{
		Session updateSession = sessionFactory.openSession();
		Transaction tx = updateSession.beginTransaction();

		org.hibernate.Query updateHql = updateSession.createQuery("update UserReference set status = :success where refer_unique_id = :uniaccid");
		updateHql.setParameter("uniaccid", uniaccid);
		
		updateHql.setParameter("status","success");
		
	    int result  = updateHql.executeUpdate();
	    
	    tx.commit();
	    updateSession.close();
	    
	    if(result==1)
		{			
			return "success";	    
		}
		else
		{			
			return "failed";
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<UserReference> getUserReferences(int userId)
	{
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
		List<UserReference> refData = session.createQuery("from UserReference where user_id="+userId+"").list();	
		
		session.close();
		return refData;
	}
	
	@SuppressWarnings("unchecked")
	public long getUserReferencesCount(int userId,String status)
	{
		Session session = sessionFactory.openSession();
		long count = 0;
		
		if(status.equals("Success"))
		{
			count = ((Long)session.createQuery("select count(*) from UserReference where status='success' and user_id="+userId+"").uniqueResult()).longValue();			
		}
		else if(status.equals("Pending"))
		{
			count = ((Long)session.createQuery("select count(*) from UserReference where status='pending' and user_id="+userId+"").uniqueResult()).longValue();			
		}
		else
		{
			count = ((Long)session.createQuery("select count(*) from UserReference where user_id="+userId+"").uniqueResult()).longValue();			
		}
		
		session.close();
		 
		return count;
	}
	
	public String activateUser(HttpServletRequest request)
	{
		Session updateSession = sessionFactory.openSession();
		Transaction tx = updateSession.beginTransaction();

		org.hibernate.Query updateHql = updateSession.createQuery("update UserRegistration set account_status = :status where account_id = :uniaccid");
		updateHql.setParameter("uniaccid", request.getParameter("account_id"));
		
		updateHql.setParameter("status","Active");
		
	    int result  = updateHql.executeUpdate();
	    
	    tx.commit();
	    updateSession.close();
	    
	    if(result==1)
		{			
			return "success";	    
		}
		else
		{			
			return "failed";
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<UserRegistration> redirecToElvinusShop(HttpServletRequest request)
	{
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		List<UserRegistration> userData = session.createQuery("from UserRegistration where email_id='"+request.getParameter("emailId")+"'").list();	
		
		session.close();
		return userData;
	}
	
	public String saveUserOrder(UserOrder userOrder)
	{
		String transactionStatus = "";
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
		try {
			
			transaction = session.beginTransaction();
			session.save(userOrder);
			transaction.commit();

			if (transaction.wasCommitted()) {
				transactionStatus = "success";
			} else {
				transactionStatus = "failure";
			}
		} catch (Exception e) {
			
			LOGGER.info("During saving the data of UserOrder exception arise."+e.getMessage());

			transactionStatus = "failure";
		} finally {
			session.close();
			
		}
		
		return transactionStatus;
	}
	
	@SuppressWarnings("unchecked")
	public UserReference getUserRefDetails(String email)
	{
		Session session = sessionFactory.openSession();
		List<UserReference> userData = session.createQuery("from UserReference where email_id='"+email+"'").list();	
		
		if(userData.size()>0)
		{
			org.hibernate.Query updateHql = session.createQuery("update UserReference set status = :status where email_id = :email");
			updateHql.setParameter("email", email);
			
			updateHql.setParameter("status","success");
			
		    int result  = updateHql.executeUpdate();
		    
		    session.close();
		}
		
		return userData.get(0);
	}
	
	
	public int getParentRefCount(int parent_user_id)
	{
		Session session = sessionFactory.openSession();
		
		Long count =((Long)session.createQuery("select count(*) from UserReference where status='success' and user_id="+parent_user_id+"").uniqueResult()).longValue();			
		
		session.close();
		 
		return count.intValue();
	}
	
	@SuppressWarnings("unchecked")
	public List<UserCredit> getUserCreditRecord(int userId)
	{
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		List<UserCredit> userData = session.createQuery("from UserCredit where user_id="+userId+"").list();	
		
		session.close();
		return userData;
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> getUserCreditStatus(int userId)
	{
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("select SUM(credit_amount) as total_credit, (select SUM(credit_amount) from UserCredit WHERE "+ 
										"MONTH(credit_date) = MONTH(SYSDATE())  and user_id="+userId+") as cur_month_total_credit, (select SUM(credit_amount) from UserCredit WHERE "+ 
										"DATE(credit_date) = DATE(SYSDATE()) and user_id="+userId+") as today_total_credit from UserCredit where user_id="+userId+"");
	    List<Object[]> creditStatus = (List<Object[]>)q.list();
	    
	    session.close();
	    
	    return creditStatus;
	}
	
	
	@SuppressWarnings({ "unchecked", "null" })
	public String updateAccountDetails(UserRegistration user,String updateType)
	{
		String status = "";
		Session session = sessionFactory.openSession();
		
		if(updateType.equals("Account"))
		{
			
			org.hibernate.Query updateHql = session.createQuery("update UserRegistration set first_name = :firstName,last_name =:lastName,email_id =:email,mobile =:mobile,gender =:gender,dob =:dob,pan_id =:panId,aadhar_id =:aadharId, profile_photo =:photo where user_id = :id");
			updateHql.setParameter("id", user.getUser_id());
			
			updateHql.setParameter("firstName", user.getFirst_name());
			updateHql.setParameter("lastName", user.getLast_name());
			updateHql.setParameter("email", user.getEmail_id());
			updateHql.setParameter("mobile", user.getMobile());
			updateHql.setParameter("gender", user.getGender());
			updateHql.setParameter("dob", user.getDob());
			updateHql.setParameter("panId", user.getPan_id());
			updateHql.setParameter("aadharId", user.getAadhar_id());
			
			List<String> userData = session.createQuery("select profile_photo from UserRegistration where user_id="+user.getUser_id()+"").list();	
			
			if(user.getProfile_photo().equals(""))
			{
				if(userData.size()>0)
				{
					updateHql.setParameter("photo", userData.get(0));
				}
				else
				{
					updateHql.setParameter("photo", user.getProfile_photo());
				}
			}
			else
			{
				updateHql.setParameter("photo", user.getProfile_photo());
			}
			
		    int result  = updateHql.executeUpdate();
		    
		    session.close();
		    
		    if(result==1)
			{			
		    	status = "success";	    
			}
			else
			{			
				status = "failed";
			}
		}
		else if(updateType.equals("Address"))
		{
			org.hibernate.Query updateHql = session.createQuery("update UserRegistration set area = :area,city =:city,state = :state,country =:country, pincode =:pincode  where user_id = :id");
			updateHql.setParameter("id", user.getUser_id());
			
			updateHql.setParameter("area",user.getArea());
			updateHql.setParameter("city", user.getCity());
			updateHql.setParameter("state", user.getState());
			updateHql.setParameter("country", user.getCountry());
			updateHql.setParameter("pincode", user.getPincode());
			
		    int result  = updateHql.executeUpdate();
		    session.close();
		    if(result==1)
			{			
		    	status = "success";	    
			}
			else
			{			
				status = "failed";
			}
		}
		else if(updateType.equals("Bank"))
		{
			org.hibernate.Query updateHql = session.createQuery("update UserRegistration set bank_name = :bankName,bank_account_no =:accNo,ban_ifsc_code =:IFSC,bank_account_name =:accHolderName where user_id = :id");
			updateHql.setParameter("id", user.getUser_id());
			
			updateHql.setParameter("bankName",user.getBank_name());
			updateHql.setParameter("accNo",user.getBank_account_no());
			updateHql.setParameter("IFSC",user.getBank_ifce_code());
			updateHql.setParameter("accHolderName",user.getBank_account_name());
			
		    int result  = updateHql.executeUpdate();
		    
		    session.close();
		    
		    if(result==1)
			{			
		    	status = "success";	    
			}
			else
			{			
				status = "failed";
			}
		}
		else if(updateType.equals("Password"))
		{
			org.hibernate.Query updateHql = session.createQuery("update UserRegistration set password = :password where user_id = :id");
			updateHql.setParameter("id", user.getUser_id());
			
			updateHql.setParameter("password",user.getPassword());
			
		    int result  = updateHql.executeUpdate();
		    
		    session.close();
		    
		    if(result==1)
			{			
		    	status = "success";	    
			}
			else
			{			
				status = "failed";
			}
		}
		else
		{
			org.hibernate.Query updateHql = session.createQuery("update UserRegistration set status = :status where user_id = :id");
			updateHql.setParameter("id", user.getUser_id());
			
			updateHql.setParameter("status","success");
			
		    int result  = updateHql.executeUpdate();
		    
		    session.close();
		    
		    if(result==1)
			{			
		    	status = "success";	    
			}
			else
			{			
				status = "failed";
			}
		}
		
	    return status;
	}
	
	
	public String saveUserNotification(UserNotification notify)
	{
		String transactionStatus = "";
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
		try {
			
			transaction = session.beginTransaction();
			session.save(notify);
			transaction.commit();

			if (transaction.wasCommitted()) {
				transactionStatus = "success";
			} else {
				transactionStatus = "failure";
			}
		} catch (Exception e) {
			
			LOGGER.info("During saving the data of UserNotification exception arise."+e.getMessage());

			transactionStatus = "failure";
		} finally {
			session.close();
			
		}
		
		return transactionStatus;
	}
	
	@SuppressWarnings("unchecked")
	public List<UserNotification> notificationList(int userId)
	{
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
		//List<UserNotification> data = session.createQuery("from UserNotification where notify_to="+userId+"").list();	
		
		List<UserNotification> data = new ArrayList<UserNotification>();
		
		Query q = session.createQuery("SELECT notify.notification_id, user.first_name, user.last_name, notify.notification_msg, notify.notify_date, notify.notification_status FROM UserRegistration user, UserNotification notify WHERE user.user_id = notify.notify_by AND notify.notify_to = "+userId+"");
		
		List<Object[]> results = (List<Object[]>)q.list();

		if(results.size()>0)
		{
			for (Object[] result : results) {
				
				UserNotification notifyData = new UserNotification();
				
				notifyData.setNotification_id((int) result[0]);
				notifyData.setNotify_via(result[1] +" "+ result[2]);
				notifyData.setNotification_msg((String) result[3]);
				notifyData.setNotify_date((Date) result[4]);
				notifyData.setNotification_status((String)result[5]);
				
				data.add(notifyData);
				System.out.println(notifyData.toString());
				
				notifyData = null;
				System.gc();
			}
		}
		
		session.close();
		
		return data;
	}
	
	@SuppressWarnings("unchecked")
	public UserNotification readNotification(int notificationId)
	{
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		List<UserNotification> data = session.createQuery("from UserNotification where notification_id="+notificationId+"").list();	
		
		session.close();
		
		if(data.size()>0)
		{
			return data.get(0);
		}
		else
		{
			return null;
		}		
	}
	
	
	public String updateNotifyStatus(UserNotification notify)
	{
		Session updateSession = sessionFactory.openSession();
		Transaction tx = updateSession.beginTransaction();

		org.hibernate.Query updateHql = updateSession.createQuery("update UserNotification set notification_status = :status where notification_id = :notifyId");
		updateHql.setParameter("notifyId", notify.getNotification_id());
		
		updateHql.setParameter("status","Read");
		
	    int result  = updateHql.executeUpdate();
	    
	    tx.commit();
	    updateSession.close();
	    
	    if(result==1)
		{			
			return "success";	    
		}
		else
		{			
			return "failed";
		}
	}
	
	public String deleteNotification(int notificationId)
	{
		Session updateSession = sessionFactory.openSession();
		Transaction tx = updateSession.beginTransaction();

		org.hibernate.Query updateHql = updateSession.createQuery("Delete from UserNotification where notification_id = :notifyId");
		updateHql.setParameter("notifyId", notificationId);
		
	    int result  = updateHql.executeUpdate();
	    
	    tx.commit();
	    updateSession.close();
	    
	    if(result==1)
		{			
			return "success";	    
		}
		else
		{			
			return "failed";
		}
	}
	
	@SuppressWarnings("unchecked")
	public int getUserIdFromEmail(String emailId)
	{
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
		Query q = session.createQuery("SELECT user_id FROM UserRegistration WHERE email_id = '"+emailId+"'");
		
		List<Integer> results = (List<Integer>)q.list();

		if(results.size()>0)
		{
			return results.get(0);
		}
		else
		{
			return 0;
		}
	}
	
	public String saveUserCredit(UserCredit usCredit)
	{
		String transactionStatus = "";
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
		try {
			
			transaction = session.beginTransaction();
			session.save(usCredit);
			transaction.commit();

			if (transaction.wasCommitted()) {
				transactionStatus = "success";
			} else {
				transactionStatus = "failure";
			}
		} catch (Exception e) {
			
			LOGGER.info("During saving the data of UserCredit exception arise."+e.getMessage());

			transactionStatus = "failure";
		} finally {
			session.close();
			
		}
		
		return transactionStatus;
	}
	
	@SuppressWarnings("unchecked")
	public int getParentIdViaUserId(int childUserId)
	{
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
		List<String> emailData = session.createQuery("Select email_id from UserRegistration  where user_id="+childUserId+"").list();	
		
		List<UserReference> results = session.createQuery("FROM UserReference WHERE email_id ='"+emailData.get(0)+"'").list();	
		
		if(results.size()>0)
		{
			return results.get(0).getUserReg().getUser_id();
		}
		else
		{
			return 0;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<UserReference> getRecentRefActivity(int userId)
	{		
		Session session = sessionFactory.openSession();
		
		Query query = session.createQuery("from UserReference where user_id="+userId+" ORDER BY cr_date DESC");
		query.setFirstResult(0);
		query.setMaxResults(5); 
		List<UserReference> result = query.list();
		
		session.close();
		
		return result;
	}
	
	public List<UserCredit> getRecentCredActivity(int userId)
	{		
		Session session = sessionFactory.openSession();
		
		Query query = session.createQuery("from UserCredit where user_id="+userId+" ORDER BY credit_date DESC");
		query.setFirstResult(0);
		query.setMaxResults(5); 
		List<UserCredit> result = query.list();
		
		session.close();
		
		return result;
	}
	
	public String checkUserPassword(String encPassword,int userId)
	{
		Session session = sessionFactory.openSession();
		
		Query query = session.createQuery("select account_status from UserRegistration where user_id="+userId+" and password='"+encPassword+"'");
		List<String> result = query.list();
		
		session.close();
		
		if(result.size()>0)
		{
			return "correct";
		}
		else
		{
			return "incorrect";
		}
		
	}
	
	public String updatePassword(String encPassword,int userId)
	{
		Session session = sessionFactory.openSession();
		org.hibernate.Query updateHql = session.createQuery("update UserRegistration set password = :password where user_id = :id");
		updateHql.setParameter("id", userId);
		
		updateHql.setParameter("password",encPassword);
		
	    int result  = updateHql.executeUpdate();
	    
	    session.close();
	    
	    if(result==1)
		{			
	    	return "success";	    
		}
		else
		{			
			return "failed";
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public List<UserReference> getUserRefeDetails(String uniRefid)
	{
		Session session = sessionFactory.openSession();
		
		Query query = session.createQuery("from UserReference where refer_unique_id='"+uniRefid+"'");
		query.setFirstResult(0);
		query.setMaxResults(5); 
		List<UserReference> result = query.list();
		
		session.close();
		
		return result;
	}
	
	
	
	
	
}
