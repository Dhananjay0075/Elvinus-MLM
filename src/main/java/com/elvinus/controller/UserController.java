package com.elvinus.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.elvinus.model.UserCredit;
import com.elvinus.model.UserNotification;
import com.elvinus.model.UserReference;
import com.elvinus.model.UserRegistration;
import com.elvinus.service.AdminService;
import com.elvinus.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AdminService adminService;
	
	
	@ExceptionHandler(ResourceNotFoundException.class)
    public String handleResourceNotFoundException() {
        
		return "notfound_404";
    }
	
	@RequestMapping(value = "/serviceNotfound", method = RequestMethod.GET)
    public ModelAndView serviceNotfound() {
    	
		ModelAndView model = new ModelAndView();
    	model.setViewName("notfound_404");
    	return model;
    }
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request,HttpSession session) {
    	
		ModelAndView model = new ModelAndView();
		
		request.setAttribute("actionMessage", "NA");
		
		if(session.getAttribute("userId")==null)
		{
			model.setViewName("user_signIn");
		}
		else
		{
			model.setViewName("redirect:/userDashboard");
		}
    	return model;
    }
	
	@RequestMapping(value = "/userSignIn", method = RequestMethod.GET)
    public ModelAndView userSignIn(HttpServletRequest request,HttpSession session) {
    	
		request.setAttribute("actionMessage", "NA");
		
		ModelAndView model = new ModelAndView();
		
		if(session.getAttribute("userId")==null)
		{
			model.setViewName("user_signIn");
		}
		else
		{
			model.setViewName("redirect:/userDashboard");
		}
		
    	return model;
    }
	
	@RequestMapping(value = "/userSignUp", method = RequestMethod.GET)
    public ModelAndView userSignUp(HttpServletRequest request) {
    	
		Map<String, Object> model = new HashMap<String, Object>();	
		
		if(request.getParameter("uniRefid")!=null)
		{
			request.setAttribute("refAccId",request.getParameter("refAccId"));
			request.setAttribute("uniRefid",request.getParameter("uniRefid"));
			
			List<UserReference> userRef = userService.getUserRefeDetails(request.getParameter("uniRefid"));
			
			request.setAttribute("refFullName",userRef.get(0).getFull_name());
			request.setAttribute("refEmail",userRef.get(0).getEmail_id());
			request.setAttribute("refMobile",userRef.get(0).getMobile());
			
		}
		else
		{
			request.setAttribute("uniRefid","");request.setAttribute("refAccId","");
			
			request.setAttribute("refFullName","");
			request.setAttribute("refEmail","");
			request.setAttribute("refMobile","");
		}
		
    	return new ModelAndView("user_signUp",model);
    }
	
	
	@RequestMapping(value = "/userLogOut", method = RequestMethod.GET)
    public ModelAndView userLogOut(HttpServletRequest request) {
    	
		ModelAndView model = new ModelAndView();
		
		request.setAttribute("actionMessage", "NA");
		
    	model.setViewName("user_signIn");
    	return model;
    }
	
	
	@RequestMapping(value = "/authUserCredential", method = RequestMethod.GET)
	public String authBuyerCredentialWithGet(HttpSession session) {
		
		if (session.getAttribute("userId") == null)
		{							
        	return "redirect:/userSignIn";
        }
		else
		{
			return "redirect:/userDashboard";
		}		
	}
	
	@RequestMapping(value = "/authUserCredential", method = RequestMethod.POST)
	public ModelAndView authBuyerCredential(@ModelAttribute("userDetails") UserRegistration userDetails,HttpSession session,HttpServletRequest request) {
		
		String emailId = userDetails.getEmail_id();
        String password = userDetails.getPassword();
        
        String authenticateStatus = userService.getValidateUserAuthentication(emailId,password);
        
        if(authenticateStatus.equals("Active"))
        {	       	       	
			UserRegistration userModel = userService.getUserProfile("Email",emailId).get(0);
			
			session.setAttribute("userId", userModel.getUser_id());
			session.setAttribute("accountId", userModel.getAccount_id());
			
        	session.setAttribute("USER_SESSION_ID", "JIR"+session.getId()+"K");
        	
			Map<String, Object> model = new HashMap<String, Object>();	
			
			model.put("user",userModel);
			
			session.setAttribute("user", userModel);
			
			model.put("totalRefCount",userService.getUserReferencesCount((int) session.getAttribute("userId"),"Total"));
			model.put("successRefCount",userService.getUserReferencesCount((int) session.getAttribute("userId"),"Success"));
			
			model.put("recentRefActivity",userService.getRecentRefActivity((int) session.getAttribute("userId")));
			
			model.put("recentCreActivity",userService.getRecentCredActivity((int) session.getAttribute("userId")));
			
			return new ModelAndView("user_dashboard",model);
			
        }
        else if(authenticateStatus.equals("Deactive"))
        {
        	request.setAttribute("actionMessage", "Your account is not activated.");
        	
        	return new ModelAndView("user_signIn");       	
        }
        else if(authenticateStatus.equals("Failed")) 
        {
        	request.setAttribute("actionMessage", "Given credential not matched.");
        	
        	return new ModelAndView("user_signIn");
        }
        else
        {
        	request.setAttribute("actionMessage", "Given username is not registered yet.");
        	
        	return new ModelAndView("user_signIn");
        }
	}
	
	
	
	@RequestMapping(value = "/userDashboard", method = RequestMethod.GET)
	public ModelAndView userDashboard(HttpSession session,HttpServletRequest request) {
		
		if (session.getAttribute("userId") == null)
		{									
        	return new ModelAndView("redirect:/userSignIn");
        }
		else
		{
			int value = (int) session.getAttribute("userId");
        	
			UserRegistration userModel = userService.getUserProfile("UserId",value+"").get(0);
			
			Map<String, Object> model = new HashMap<String, Object>();	
			
			model.put("user",userModel);
			
			model.put("totalRefCount",userService.getUserReferencesCount((int) session.getAttribute("userId"),"Total"));
			model.put("successRefCount",userService.getUserReferencesCount((int) session.getAttribute("userId"),"Success"));
			
			model.put("recentRefActivity",userService.getRecentRefActivity((int) session.getAttribute("userId")));
			
			model.put("recentCreActivity",userService.getRecentCredActivity((int) session.getAttribute("userId")));
			
			return new ModelAndView("user_dashboard",model);
		}					
	}
	
	@RequestMapping(value = "/saveUserRegister", method = RequestMethod.POST)
	@ResponseBody public String saveUserRegister(@ModelAttribute("userReg") UserRegistration userReg,HttpSession session,HttpServletRequest request) {
			
		// https://www.elvinus.com/user_auth_login.php?username=ABI127&password=asd123
		
		return userService.saveUserRegdetails(userReg,request);						
	}
	
	@RequestMapping(value = "/redirecToElvinusShop", method = RequestMethod.POST)
	@ResponseBody public String redirecToElvinusShop(HttpServletRequest request) {
		
		
		return userService.redirecToElvinusShop(request);
	}
	
	
	@RequestMapping(value = "/userAccountRedirect", method = RequestMethod.GET)
    public ModelAndView userAccountRedirect(HttpServletRequest request,HttpSession session) {
    	
		if(request.getParameter("account_id")!=null)
		{
			userService.activateUser(request);
			
			request.setAttribute("actionMessage", "Your account activated");
	    			
	    	return new ModelAndView("user_signIn");
		}
		else
		{
			request.setAttribute("actionMessage", "Given username is not registered yet.");
	    	
	    	return new ModelAndView("user_signIn");
		}		
    }
	
	
	/* USER DASHBORAD RELATED CONTROLLER  */
	
	
	@RequestMapping(value = "/userRef", method = RequestMethod.GET)
    public ModelAndView userRef(HttpSession session) {
    	
		if (session.getAttribute("userId") == null)
		{									
        	return new ModelAndView("redirect:/userSignIn");
        }
		else
		{
			Map<String, Object> contentModel = new HashMap<String, Object>();	
			
			contentModel.put("refList",userService.getUserReferences((int) session.getAttribute("userId")));
			
			contentModel.put("totalRefCount",userService.getUserReferencesCount((int) session.getAttribute("userId"),"Total"));
			
			contentModel.put("user",userService.getUserDetails((int) session.getAttribute("userId")).get(0));
			
	    	return new ModelAndView("user_reference",contentModel);
		}
    }
	
	@RequestMapping(value = "/saveUserReference", method = RequestMethod.POST)
	@ResponseBody public String saveUserReference(@ModelAttribute("userRef") UserReference userRef,HttpSession session,HttpServletRequest request) {
			
		return userService.saveUserReference(userRef,session);						
	}
		
	
	@RequestMapping(value = "/userProfileView", method = RequestMethod.POST)
	@ResponseBody public ModelAndView userProfileView(HttpServletRequest request) {
		
		Map<String, Object> model = new HashMap<String, Object>();
		
		UserRegistration userModel = userService.getUserProfile("Email",request.getParameter("emailId")).get(0);
		model.put("userData",userModel);
		
		for(Object[] credit: userService.getUserCreditStatus(userModel.getUser_id())){
	    	
			System.out.println("REF tota1l="+credit);
			
			model.put("total",(Double)credit[0]);
			model.put("montly",(Double)credit[1]);
			model.put("today",(Double)credit[2]);
	    }
				
		
		model.put("totalRef",userService.getUserReferencesCount(userModel.getUser_id(),"Total"));
		model.put("totalSuc",userService.getUserReferencesCount(userModel.getUser_id(),"Success"));
		
		return new ModelAndView("user_profile_info",model);
	}
	
	
	
	
	
	@RequestMapping(value = "/userCredit", method = RequestMethod.GET)
    public ModelAndView userCredit(HttpSession session) {
		
		if (session.getAttribute("userId") == null)
		{									
        	return new ModelAndView("redirect:/userSignIn");
        }
		else
		{
			Map<String, Object> contentModel = new HashMap<String, Object>();	
			
			contentModel.put("creditList",userService.getUserCreditRecord((int) session.getAttribute("userId")));
			
			for(Object[] credit: userService.getUserCreditStatus((int) session.getAttribute("userId"))){
		    	
		    	contentModel.put("total",(Double)credit[0]);
		    	contentModel.put("montly",(Double)credit[1]);
		    	contentModel.put("today",(Double)credit[2]);
		    }
		    
	    	return new ModelAndView("user_credit",contentModel);
	    	
		}
    }
	
	
	
	@RequestMapping(value = "/userAccount", method = RequestMethod.GET)
    public ModelAndView userAccount(HttpSession session) {
		
		if (session.getAttribute("userId") == null)
		{									
        	return new ModelAndView("redirect:/userSignIn");
        }
		else
		{
			Map<String, Object> contentModel = new HashMap<String, Object>();
			
			//UserRegistration userModel = (UserRegistration)session.getAttribute("user");
			
			//System.out.println("UserData="+userModel.toString());
			
			//contentModel.put("user",userModel);
			
			contentModel.put("user",userService.getUserDetails((int) session.getAttribute("userId")).get(0));
			
	    	return new ModelAndView("user_account",contentModel);
		}
    }
	
	@RequestMapping(value = "/updateAccountDetails", method = RequestMethod.POST)
	@ResponseBody public String updateAccountDetails(@ModelAttribute("user") UserRegistration user,HttpSession session,MultipartHttpServletRequest request) {
		
		user.setUser_id((int) session.getAttribute("userId"));
		
		return userService.updateAccountDetails(user,request);						
	}
	
	@RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
	@ResponseBody public String resetPassword(HttpSession session,HttpServletRequest request) {
		
		return userService.resetPassword(request,(int) session.getAttribute("userId"));						
	}
	
	
	@RequestMapping(value = "/userUpdPw", method = RequestMethod.GET)
    public ModelAndView userUpdPw(HttpSession session) {
    	
		if (session.getAttribute("userId") == null)
		{									
        	return new ModelAndView("redirect:/userSignIn");
        }
		else
		{
			ModelAndView model = new ModelAndView();
	    	model.setViewName("user_acc_pw");
	    	return model;
		}
    }
	
	
	@RequestMapping(value = "/userNotification", method = RequestMethod.GET)
    public ModelAndView userNotification(HttpSession session) {
    	
		if (session.getAttribute("userId") == null)
		{									
        	return new ModelAndView("redirect:/userSignIn");
        }
		else
		{
			Map<String, Object> contentModel = new HashMap<String, Object>();
			
			contentModel.put("notifyList",userService.notificationList((int) session.getAttribute("userId")));
			
	    	return new ModelAndView("user_notification",contentModel);
		}
    }
	
	
	@RequestMapping(value = "/sendNotification", method = RequestMethod.POST)
	@ResponseBody public String sendNotification(HttpSession session,HttpServletRequest request) {
		
		UserNotification notify = new UserNotification();
		
		notify.setNotify_by((int) session.getAttribute("userId"));
		
		return userService.saveUserNotification(notify,request);						
	}
	
	@RequestMapping(value = "/readUserNotification", method = RequestMethod.POST)
	@ResponseBody public ModelAndView readUserNotification(HttpSession session,HttpServletRequest request) {
		
		Map<String, Object> contentModel = new HashMap<String, Object>();
		
		
		return new ModelAndView("user_read_message",contentModel);			
	}
	
	@RequestMapping(value = "/deleteNotification", method = RequestMethod.POST)
	@ResponseBody public ModelAndView deleteNotification(HttpSession session,HttpServletRequest request) {
		
		userService.deleteNotification(Integer.parseInt(request.getParameter("notifyId")));
		
		Map<String, Object> contentModel = new HashMap<String, Object>();
		
		contentModel.put("notifyList",userService.notificationList((int) session.getAttribute("userId")));
		
		return new ModelAndView("user_notification_list",contentModel);			
	}
	
	
	
	@SuppressWarnings({ "resource", "unused" })
	@RequestMapping(value = "/previewPicture", method = RequestMethod.GET)
	@ResponseBody public byte[] previewPicture(HttpServletRequest request,HttpSession session) throws IOException {
		
		
		String fileName = request.getParameter("fileName");
		
		int userId = Integer.parseInt(request.getParameter("userId"));
		
		// Required file Config for entire Controller 
		 
		ResourceBundle fileResource = ResourceBundle.getBundle("resources/emailConfig");
		
		String fileDir = fileResource.getString("userProfileDirectory");
		
		fileDir = fileDir+"/"+userId;
		 
		// End of Required file Config for entire Controller 
		 
		ServletContext servletContext = request.getSession().getServletContext();
		
		File ourPath = new File(fileDir);
		
		StringBuilder fPath = new StringBuilder(ourPath.getPath()+"/"+fileName);
		String docCategory = fPath.toString();
		
		InputStream in;
		
		try {					
				FileInputStream docdir = new FileInputStream(fPath.toString());													
				if (docdir != null) 
				{						
					return IOUtils.toByteArray(docdir);					
				} 
				else 
				{							
					return null;
				}			
		} 
		catch (FileNotFoundException e) {
			
			System.out.println(e.getMessage());
			return null; // todo: return safe photo instead
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return null; // todo: return safe photo instead
		}

	}
	
	
	
}
