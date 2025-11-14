package com.elvinus.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.elvinus.model.AdminDetails;
import com.elvinus.model.CreditModel;
import com.elvinus.model.UserRegistration;

@Component
@SuppressWarnings("unused")
@Repository("adminDao")
public class AdminDaoImpl implements AdminDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	private static final Logger LOGGER = Logger.getLogger(AdminDaoImpl.class);
	
	@SuppressWarnings("unchecked")
	public List<AdminDetails> getAdminDetails()
	{
		Session session = sessionFactory.openSession();
		
		String hql = "";
		
		hql = "from AdminDetails where admin_id=1";			
		
		List<AdminDetails> admin = session.createQuery(hql).list();	
		
	    session.close();
	    
	    return admin;	    
	}
	
	
	@SuppressWarnings("unchecked")
	public String getValidateAdmin(String user_id,String password)
	{	
		Session session = sessionFactory.openSession();
		
		String hql = "from AdminDetails where admin_id=1";
		List<AdminDetails> lsdata = session.createQuery(hql).list();
		
		session.close();
		
		if(lsdata.get(0).getAdmin_access().equals("online"))
		{
			return "online";
		}
		else
		{
			if(lsdata.get(0).getAdmin_user_id().equals(user_id) && lsdata.get(0).getAdmin_password().equals(password))
			{				
				Session updateSession = sessionFactory.openSession();
				Transaction tx = updateSession.beginTransaction();

				org.hibernate.Query updateHql = updateSession.createQuery("update AdminDetails set admin_access = :adminAccess , current_access_time = :currentAccessTime , last_access_time = :lastAccessTime where admin_id = :adminId");
				updateHql.setParameter("adminId", 1);
				
				updateHql.setParameter("adminAccess","online");
				updateHql.setParameter("currentAccessTime",new Date());
				updateHql.setParameter("lastAccessTime",lsdata.get(0).getCurrent_access_time());
				
			    int result  = updateHql.executeUpdate();
			    
			    tx.commit();
			    updateSession.close();
			    
				return "correct";
			}
			else
			{
				return "incorrect";
			}
		}		
	}
	
	
	
	public String setAdminAccess(String access)
	{
		Session updateSession = sessionFactory.openSession();
		Transaction tx = updateSession.beginTransaction();

		org.hibernate.Query updateHql = updateSession.createQuery("update AdminDetails set admin_access = :adminAccess where admin_id = :adminId");
		updateHql.setParameter("adminId", 1);
		
		updateHql.setParameter("adminAccess",access);
		
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
	public List<UserRegistration> getUserList()
	{
		Session session = sessionFactory.openSession();
		
		List<UserRegistration> dataList = session.createQuery("from UserRegistration ORDER BY cr_date DESC").list();	
		
		Query q = session.createQuery("SELECT user.user_id,user.first_name, user.last_name, user.email_id, user.mobile, user.account_status, user.cr_date FROM UserRegistration user, UserReference ref");
		
		List<Object[]> results = (List<Object[]>)q.list();

		//List<UserRegistration> userList = entityManager.createQuery("SELECT a FROM UserRegistration a JOIN FETCH a.userReference b WHERE b.status = 'success", UserRegistration.class).getResultList();

	    session.close();
	    
	    return dataList;	    
	}
	
	public long totalMembers()
	{
		String transactionStatus = "";
		Session session = sessionFactory.openSession();
		
		long count = ((Long)session.createQuery("select count(*) from UserRegistration").uniqueResult()).longValue();			
		
		session.close();
		
		return count;
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> getElvinusReferenceStatus(int userId)
	{
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("");
	    List<Object[]> dataStatus = (List<Object[]>)q.list();
	    
	    session.close();
	    
	    return dataStatus;
	}
	
	@SuppressWarnings("unchecked")
	public UserRegistration getUserDetails(int userId)
	{
		Session session = sessionFactory.openSession();
		
		List<UserRegistration> dataList = session.createQuery("from UserRegistration where user_id='"+userId+"'").list();	
		
		session.close();
	    
		if(dataList.size()>0)
		{
			return dataList.get(0);
		}
		else
		{
			return null;
		}
	    	
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> getUsersReferenceStatus()
	{
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("select COUNT(*) as total_ref, (select COUNT(*) from UserReference WHERE status='success') as joined_ref, (select COUNT(*) from UserReference WHERE status='pending') as pending_ref from UserReference");
	    List<Object[]> creditStatus = (List<Object[]>)q.list();
	    
	    session.close();
	    
	    return creditStatus;
	}
	
	@SuppressWarnings("unchecked")
	public List<CreditModel> getParentReward(String rewardType)
	{
		Session session = sessionFactory.openSession();
		
		if(rewardType.equals("Direct"))
		{
			List<CreditModel> creditModel = session.createQuery("from CreditModel where credit_cycle='1'").list();	
			
		    session.close();
		    
		    return creditModel;	   
		}
		else
		{
			List<CreditModel> creditModel = session.createQuery("from CreditModel where credit_cycle='2'").list();	
			
		    session.close();
		    
		    return creditModel;	   
		}		
	}
	
	public String saveEmployee(AdminDetails adminEmp,HttpServletRequest request)
	{
		String transactionStatus = "";
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
		try {			
			transaction = session.beginTransaction();
			session.save(adminEmp);
			transaction.commit();

			if (transaction.wasCommitted()) {
				transactionStatus = "success";
			} else {
				transactionStatus = "failure";
			}
		} catch (Exception e) {
			
			LOGGER.info("During saving the data of AdminDetails exception arise."+e.getMessage());
			
			transactionStatus = "failure";
		} finally {
			session.close();			
		}
		
		return transactionStatus;
	}
	
	@SuppressWarnings("unchecked")
	public AdminDetails viewEmployee(AdminDetails adminEmp)
	{
		Session session = sessionFactory.openSession();
		
		String hql = "";
		
		hql = "from AdminDetails where admin_id="+adminEmp.getAdmin_id()+"";			
		
		List<AdminDetails> admin = session.createQuery(hql).list();	
		
	    session.close();
	    
	    if(admin.size()>0)
	    {return admin.get(0);}
	    else
	    {return null;}	    
	}
	
	
	public String setAdminAccessStatus(String status,int admin_id)
	{
		Session updateSession = sessionFactory.openSession();
		Transaction tx = updateSession.beginTransaction();

		org.hibernate.Query updateHql = updateSession.createQuery("update AdminDetails set access_status = :accessStatus where admin_id = :adminId");
		
		updateHql.setParameter("adminId", admin_id);
		updateHql.setParameter("accessStatus",status);
		
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
	
	
	
}   
