package com.elvinus.job;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

import com.elvinus.dao.UserDao;


public class EmailSentJob {

	@Autowired
	private UserDao userDao;
	
	private static final Logger LOGGER = Logger.getLogger(EmailSentJob.class);
	
	@Async
	public String getEmailSent(String emailId,String subject,String messageBody)
	{		 
		    String resetStatus = "";
		    
		    ResourceBundle smsresource = ResourceBundle.getBundle("resources/emailConfig");
			
		    String auth=smsresource.getString("mail.smtp.auth");
			String starttls = smsresource.getString("mail.smtp.starttls.enable");
			String host = smsresource.getString("mail.smtp.host");			
			String port = smsresource.getString("mail.smtp.port");
			String emailusername = smsresource.getString("emailusername");
			String emailpassword = smsresource.getString("emailpassword");
				
		    String from = emailusername;
		    final String username = from;//change accordingly
		    final String password = emailpassword;//change accordingly
		    Properties props = new Properties();
		      
			props.put("mail.smtp.auth", auth);
			props.put("mail.smtp.starttls.enable", starttls);
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", port);
			
			Session session = Session.getInstance(props,
					  new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(username, password);
						}
					  });
			
			try {
	 
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(from));
				message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(emailId));
					
				message.setSubject(subject);
				message.setContent(messageBody, "text/html");
	 
				Transport.send(message);
	 
				resetStatus = "success";	
			
			} catch (MessagingException e) {
				
				  resetStatus = "failed";
	 			  System.out.println("Due to certain reason it has not worked");
	 			  e.printStackTrace();	
	 		 	
			}
	      
		  if(resetStatus.equals("failed"))	
		  {
			  /*EmailModel mailRecord = new EmailModel();
			  
			  mailRecord.setEmail_id(emailId);
			  mailRecord.setEmail_subject(subject);
			  mailRecord.setEmail_content(messageBody);
			  mailRecord.setCr_date(new Date());
			  mailRecord.setEmail_status("Pending");
			  
			  adminDao.saveFailedMailRecord(mailRecord);*/
			  
		  }
			
	      return resetStatus;
	}
	
	
	
	
	
	public String sentEmailWithAttachment(String emailId,String subject,String messageBody,List<String> attachFiles)
	{
		String sentStatus = "";
		
		 ResourceBundle smsresource = ResourceBundle.getBundle("resources/emailConfig");
			
		    String auth=smsresource.getString("mail.smtp.auth");
			String starttls = smsresource.getString("mail.smtp.starttls.enable");
			String host = smsresource.getString("mail.smtp.host");			
			String port = smsresource.getString("mail.smtp.port");
			String emailusername = smsresource.getString("emailusername");
			String emailpassword = smsresource.getString("emailpassword");

		    String from = emailusername;
		    final String username = from;//change accordingly
		    final String password = emailpassword;//change accordingly
		    Properties props = new Properties();
		      
			props.put("mail.smtp.auth", auth);
			props.put("mail.smtp.starttls.enable", starttls);
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", port);
			
			Session session = Session.getInstance(props,
					  new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(username, password);
						}
					  });
	 
			
			
			// creates a new e-mail message
	        Message msg = new MimeMessage(session);
	        
	        try{
	        	
	        	
	        	msg.setFrom(new InternetAddress(emailusername));
		        InternetAddress[] toAddresses = { new InternetAddress(emailId) };
		        msg.setRecipients(Message.RecipientType.TO, toAddresses);
		        msg.setSubject(subject);
		        msg.setSentDate(new Date());
		 
		        // creates message part
		        MimeBodyPart messageBodyPart = new MimeBodyPart();
		        messageBodyPart.setContent(messageBody, "text/html");
		 
		        // creates multi-part
		        Multipart multipart = new MimeMultipart();
		        multipart.addBodyPart(messageBodyPart);
		        
		        
		        // adds attachments
		        if (attachFiles != null && attachFiles.size() > 0) {
		        	
		            for (int i=0;i<attachFiles.size();i++) {
		            	
		                MimeBodyPart attachPart = new MimeBodyPart();
		 
		                try {
		                    attachPart.attachFile(attachFiles.get(i));
		                } catch (IOException ex) {
		                    ex.printStackTrace();
		                }
		 
		                multipart.addBodyPart(attachPart);
		            }
		        }
		 
		        // sets the multi-part as e-mail's content
		        msg.setContent(multipart);
		 
		        // sends the e-mail
		        Transport.send(msg);
		        
		        sentStatus = "success";
	        }
	        catch(Exception e)
	        {
	        	sentStatus =  "failed";
	        	
	        	LOGGER.error("While sending mail to user with attachement it was failed.");
	        }
	        
		
		
		
		return sentStatus;
	}
	
	
	
	
	/*public static void main(String arg[])
	{
	    EmailNotificationUtil obj = new EmailNotificationUtil();
	    String content = obj.emailNotification("Abinash", "abinash.raula@jirehsol.com", "resources/wellcomeRegistration","http://localhost:8081/AOneTerminal/", "Go to Home","","");
	
	
		EmailSentUtil email = new EmailSentUtil();
		
		//System.out.println("Result Status=="+email.getEmailSent("abinash.raula@jirehsol.com", "TEXT EMAIL", content));
		
		 String[] attachFiles = new String[3];
	        attachFiles[0] = "E:/UI_SHARING_FILE/conatct_us.jpg";
	        attachFiles[1] = "E:/UI_SHARING_FILE/HomePage.jpg";
	        attachFiles[2] = "E:/UI_SHARING_FILE/location.png";
	 
		System.out.println("Result Status=="+email.sentEmailWithAttachment("abinash.raula@jirehsol.com", "TEXT EMAIL", content,attachFiles));
	}*/
	
	
}
