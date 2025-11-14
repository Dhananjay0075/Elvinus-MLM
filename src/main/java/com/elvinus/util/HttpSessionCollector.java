package com.elvinus.util;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HttpSessionCollector implements ServletContextListener, HttpSessionListener, ServletRequestListener {

    private static final String ATTRIBUTE_NAME = "com.elvinus.util.HttpSessionCollector";
    private static final Map<String,HttpSession> sessions = new ConcurrentHashMap<String,HttpSession>();
    private static final Map<String,String> userSessions = new ConcurrentHashMap<String,String>();
    private static final Map<String,String> userFiles = new ConcurrentHashMap<String,String>();
   
    //Scheduler scheduler = null;

	
    public void contextInitialized(ServletContextEvent event) {
    	
    	event.getServletContext().setAttribute(ATTRIBUTE_NAME, this);
             
        // initialize log4j here to track every action in logger file in logger directory
        
        ServletContext context = event.getServletContext();
         
    }

   
    
   
    public void requestInitialized(ServletRequestEvent event) {
    	 	
        HttpServletRequest request = (HttpServletRequest) event.getServletRequest();
        HttpSession session = request.getSession(false);
        if(session != null)
        {       
        	/*System.out.println("Session is Exist !");           */			   		
        }
        else
        {
        	System.out.println("Session is Destroyed !");           		
        }
    }

  
    
    public void sessionDestroyed(HttpSessionEvent event) {
    	
    	System.out.println("Session was Destroyed !");
    	       
    	//String USER_ID = userSessions.get(event.getSession().getId());
       	
    	sessions.remove(event.getSession().getId());
  
    }

    
    public void sessionCreated(HttpSessionEvent event) {
    	// No logic needed.
    }

    
    public void requestDestroyed(ServletRequestEvent event) {
        // No logic needed.
    }

   
    public void contextDestroyed(ServletContextEvent event) {
        // NOOP. No logic needed. Maybe some future cleanup?
    	
    	
    }

    public static HttpSessionCollector getInstance(ServletContext context) {
        return (HttpSessionCollector) context.getAttribute(ATTRIBUTE_NAME);
    }

    public static Map<String,HttpSession> getAllSession(String myUser) {
        return sessions;
    }
    
    public static HttpSession find(String sessionId) {
    	
        return sessions.get(sessionId);
        
    }
    
    public static void updateReqDetails(String sessionId,String userId) {
    	
    	userSessions.put(sessionId,userId);
    	
    }
    
    public static String getUserSessions(String myUser,String sessionId){
    	
    	if("cache_Session".equals(myUser))
    	{
    		return userSessions.get(sessionId);
    	}
    	else
    	{
    		return null;
    	}
    	
    }
     
}