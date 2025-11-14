package com.elvinus.util;

import java.util.ResourceBundle;

public class EmailNotificationUtil {


	public String emailNotification(String fullName,String emailId,String fileName,String link,String action,String reasonFor,String extraInfo)
	{		
		         
		         // Send Email to User that register in the block
		         
				 ResourceBundle resource = ResourceBundle.getBundle(fileName);
				 	
					String defaultUrl = resource.getString("defaultUrl");
					String mailSubject = resource.getString("mailSubject");
			
					String headerText = resource.getString("headerText");
					String headerLogo = defaultUrl + resource.getString("headerLogo");
			
					String bodyHeading = resource.getString("bodyHeading");
					String bodyMessage1 = resource.getString("bodyMessage1");
					String bodyMessage2 = resource.getString("bodyMessage2");
			
					String footerMessage = resource.getString("footerMessage");
			
					String facebookicon = defaultUrl + resource.getString("facebookicon");
					String twittericon = defaultUrl + resource.getString("twittericon");
					String googleicon = defaultUrl + resource.getString("googleicon");
					String linkedicon = defaultUrl + resource.getString("linkedicon");
			
					String facebookLink = resource.getString("facebookLink");
					String twitterLink = resource.getString("twitterLink");
					String googlePlus = resource.getString("googlePlus");
					String linkedIn = resource.getString("linkedIn");
			   	 
			     StringBuilder text = new StringBuilder();
				        			        
				        
					    /* Sending Emails to Register user */
					       
				        text.append("<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'>");
				        text.append("<html xmlns='http://www.w3.org/1999/xhtml'><head><meta name='viewport' content='width=device-width' /><meta http-equiv='Content-Type' content='text/html; charset=UTF-8' /></head>");
				       
				        text.append("<body marginwidth='0' style='font-family:Verdana, Geneva, sans-serif;' marginheight='0' topmargin='0' leftmargin='0'>");
				       
				        text.append("<table width='100%' border='0' cellpadding='0' cellspacing='0' align='center'>");
				        
						        text.append("<tr>");
						        
						          text.append("<td width='100%' valign='top' bgcolor='' style='padding-top:20px;'>");
							       
						            text.append("<table width='600' border='0' cellpadding='0' cellspacing='0' align='center' style='margin:0 auto;border: 1px solid #59c45b;'>");					        
							         
						              text.append("<tr style='background-color:#fff;'>");
							            
						                text.append("<td>");
								       
								            text.append("<table border='0' cellpadding='0' cellspacing='0' align='left' class='title'>");
									        text.append("<tr><td>");
									        text.append("<a href='"+defaultUrl+"' target='_'><img src='"+headerLogo+"' style='width:190px;height:64px'/><span style='color:#fff;font-size: 44px;'></span></a>");
									        text.append("</td></tr>");
									        text.append("</table>");
								        
								        text.append("</td>");
								        
						              text.append("</tr>");
						             
						              text.append("<tr><td style='text-align: center;'height='3'></td></tr>");
						             
						              text.append("<tr><td height='30' width='100%' bgcolor='#515151' style='vertical-align: top;background-color:#59c45b;' valign='top'>");
						              text.append("<a  style='text-decoration: none; font-size: 20px;color:#fff;font-family: Verdana, Geneva, sans-serif;'>"+bodyHeading+"</a>");
						              text.append("</td></tr>");
						              						              
						            text.append("</table>");
						        
						        text.append("<table bgcolor='#f5f5f5'  width='600'  cellspacing='0' cellpadding='0' border='0' align='center' style='height:auto;margin-top:3px;text-align: center; border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;' >");
						        text.append("<tbody>");
						        text.append("<tr>");
						        text.append("<td width='100%' valign='middle' style='text-align: left; font-family:cursive,Arial,sans-serif; font-size: 14px; color: rgb(63, 67, 69); line-height: 24px;' t-style='not6Text' mc:edit='41' object='text-editable'>");
						        text.append("<p style='font-family:cursive,Arial,sans-serif; font-weight: normal;'>");
						        text.append("Dear "+fullName+",");
						        text.append("</p><br>");
						        
						        text.append("<p style='font-family:cursive,Arial,sans-serif; font-weight: normal;'>");
						        text.append(bodyMessage1);
						        text.append("</p>");
						        
						        if(reasonFor.equals("NotRequired"))
						        {
						        	 text.append("<p style='font-family:cursive,Arial,sans-serif; font-weight: normal;'>");
								     text.append(bodyMessage2);
								     text.append("</p>");								        
						        }
						       
						        if(reasonFor.equals("ServiceNotify"))
						        {
						        	text.append("<p style='font-family:cursive,Arial,sans-serif; font-weight: normal;'>");
							        text.append(bodyMessage2+" '"+extraInfo+"'");
							        text.append("</p>");						        	
						        }
						        
						        if(reasonFor.equals("Credential"))
						        {
						        	String credentialArray[] = extraInfo.split("/");
						        	text.append("<p style='font-family:cursive,Arial,sans-serif; font-weight: normal;'>");
							        text.append("<b>Username</b> - "+ credentialArray[0] +"<br>");
							        text.append("<b>Password</b> - "+ credentialArray[1]);
							        text.append("</p>");
						        }
						        
						        text.append("</td></tr>");
						        
						        if(!link.equals("NotRequired"))
						        {
							        text.append("<tr><td align='center'>");
							        
							        text.append("<a href='"+link+"' style='font-size:14px;font-weight:bold;text-align:center;text-decoration:none;font-family:Verdana, Geneva, sans-serif;-webkit-text-size-adjust:none;padding: 4px 6px;color:#fff !important;background-color:#59c45b;'>"+action+"</a>");
							        
							        text.append("</td></tr>");
						        }
						        
						        text.append("<tr><td>&nbsp;&nbsp;</td></tr>");
						        
						        text.append("</tbody></table>");
						        
						        text.append("<table width='600' border='0' cellpadding='0' cellspacing='0' align='center' style='margin:0 auto;'>");
						        text.append("<tr><td height='3'></td></tr>");
						        text.append("<tr><td align='center' style='font-size:15px;' bgcolor='#e1e1e1' >");
						        text.append("<a target='_' href='"+facebookLink+"'><img src='"+facebookicon+"'></a>&nbsp;&nbsp;&nbsp;");
						        text.append("<a target='_' href='"+twitterLink+"'><img src='"+twittericon+"'></a>&nbsp;&nbsp;&nbsp;");
						        text.append("<a target='_' href='"+googlePlus+"'><img src='"+googleicon+"'></a>&nbsp;&nbsp;&nbsp;");
						        text.append("<a target='_' href='"+linkedIn+"'><img src='"+linkedicon+"'></a>");
						        text.append("</td></tr>");
						        text.append("<tr><td height='3'></td></tr>");
						        text.append("<tr><td bgcolor='#e1e1e1' align='center'>"+footerMessage+"</td></tr>");
						        text.append("</table>");
						        
						        text.append("<table width='600' border='0' cellpadding='0' cellspacing='0' align='center'  style='margin:0 auto;background-color: #29363E;'>");
						        text.append("<tr><td>");
						        text.append("<table width='600' border='0' cellpadding='0' cellspacing='0' align='center' style='margin:0 auto;font-size: 12px;'>");
						        text.append("<tr><td style='padding:0px;line-height:20px;font-size:10px;color:#ffffff;text-align:center;'>");
						        text.append("&#169; 2017 DormsIndia&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
						        text.append("<span>");					      
						        text.append("</span>");
						        text.append("<br>");
						        text.append(" DormsIndia <span>Design and Developed by <a href='http://jirehsol.co.in/' target='_' style='text-decoration:underline;color:#ffffff;'>Jireh</a>.</span>");
						        text.append("</td></tr></table>");
						        
						        
						    text.append("</td></tr><table>");
						      
						    text.append("</td></tr>");    
						    
				        text.append("</table>");
				        
				        text.append("</body>");
				        text.append("</html>");
				       
				        /* END OF BODY PART */
				        
				       
				        return text.toString();
				      
	}
	
	
	/*public static void main(String arg[])
	{
		EmailNotificationUtil obj = new EmailNotificationUtil();
		//(String fullName,String emailId,String fileName,String link,String action,String reasonFor,String extraInfo)
		String status = obj.emailNotification("Abinash", "abinash.raula@jirehsol.com", "resources/wellcomeRegistration","http://localhost:8081/AOneTerminal/", "Go to Home","","");
	
		System.out.println("result="+status);
	}*/
	
	
}
