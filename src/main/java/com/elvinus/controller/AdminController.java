package com.elvinus.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.elvinus.model.AdminDetails;
import com.elvinus.model.UserRegistration;
import com.elvinus.service.AdminService;
import com.elvinus.service.UserService;

@Controller
public class AdminController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value = "/adminLogout", method = RequestMethod.GET)
	public String adminLogout(HttpSession session,HttpServletRequest request) {
		
		session.removeAttribute("adminId");			 
		
		request.setAttribute("actionMessage", "Successfully logout !");
		
		adminService.setAdminAccess("offline");
		
		return "admin_signin";							
	}
	
	@RequestMapping(value = "/adminSignIn", method = RequestMethod.GET)
    public ModelAndView adminSignIn(HttpServletRequest request) {
    	
		request.setAttribute("actionMessage", "NA");
		
		adminService.setAdminAccess("offline");
		
		ModelAndView model = new ModelAndView();
    	model.setViewName("admin_signin");
    	return model;
    }
	
	@RequestMapping(value = "/adminDashboard", method = RequestMethod.GET)
    public ModelAndView adminDashboard() {
    	
		ModelAndView model = new ModelAndView();
    	model.setViewName("admin_dashboard");
    	return model;
    }
	
	
	@RequestMapping(value = "/authAdminCredential", method = RequestMethod.GET)
	public String getValidateAdminWithGet(HttpSession session) {
		
		if (session.getAttribute("adminId") == null)
		{							
			
        	return "redirect:/adminSignIn";
        }
		else
		{
			return "redirect:/adminHome";	
		}				
	}
	
	
	@RequestMapping(value = "/authAdminCredential", method = RequestMethod.POST)
	public String getValidateAdmin(@ModelAttribute("adminDetails") AdminDetails adminDetails,HttpSession session,HttpServletRequest request) {
		
		String admin_user_id = adminDetails.getAdmin_user_id();
        String admin_password = adminDetails.getAdmin_password();
        
        String authenticateStatus = adminService.getValidateAdmin(admin_user_id,admin_password);
        
        System.out.println("authenticateStatus="+authenticateStatus); 
        
        if(authenticateStatus.equals("correct"))
        {
        	session.setAttribute("adminId", admin_user_id);
        	session.setAttribute("USER_SESSION_ID", "JIR"+session.getId()+"K");
        	
        	return "redirect:/adminHome";	
        }
        else if(authenticateStatus.equals("online"))
        {
        	request.setAttribute("actionMessage", "You have already login");
        	
        	return "admin_signin";	
        }
        else
        {
        	request.setAttribute("actionMessage", "Incorrect credential");
        	
        	return "admin_signin";
        }	
        
	}
	
	
	@RequestMapping(value = "/adminHome", method = RequestMethod.GET)
	public ModelAndView adminDash(HttpServletRequest request,HttpSession session) {
		
		if (session.getAttribute("adminId") == null)
		{					
			
        	return new ModelAndView("redirect:/adminSignIn");
        }
		else
		{			
			Map<String, Object> model = new HashMap<String, Object>();
			
			model.put("adminData",adminService.getAdminDetails());
			
			model.put("membershipCount",adminService.totalMembers());
			
			for(Object[] credit: adminService.getUsersReferenceStatus()){
		    	
				model.put("total",(Long)credit[0]);
				model.put("successRef",(Long)credit[1]);
		    	model.put("pendingRef",(Long)credit[2]);
		    }
			
			return new ModelAndView("admin_dashboard",model);				
		}							
	}
	
	@RequestMapping(value = "/emailTemplate", method = RequestMethod.GET)
	public String emailTemplate(HttpSession session) {
		
		return "email_template";			
	}
	

	/* ============================================================== */
	/* START OF EMPLOYEE MANAGEMENT
    /* ============================================================== -->*/

	
	@RequestMapping(value = "/employeeMangt", method = RequestMethod.GET)
	public ModelAndView employeeMangt(HttpServletRequest request,HttpSession session) {
		
		if (session.getAttribute("adminId") == null)
		{					
			
        	return new ModelAndView("redirect:/adminSignIn");
        }
		else
		{			
			Map<String, Object> model = new HashMap<String, Object>();
			
			model.put("adminData",adminService.getAdminDetails());
			
			// model.put("empList",adminService.getEmployeeList());
			
			return new ModelAndView("admin_employee_mangement",model);				
		}							
	}
	
	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	@ResponseBody public String saveEmployee(@ModelAttribute("adminEmp") AdminDetails adminEmp,HttpSession session,HttpServletRequest request) {
			
		return adminService.saveEmployee(adminEmp,request);						
	}
	
	
	@RequestMapping(value = "/viewEmployee", method = RequestMethod.POST)
	@ResponseBody public ModelAndView viewEmployee(HttpSession session,HttpServletRequest request) {
			
		return new ModelAndView("");						
	}
	
	@RequestMapping(value = "/updateStatusEmployee", method = RequestMethod.POST)
	@ResponseBody public String updateStatusEmployee(HttpSession session,HttpServletRequest request) {
			
		return "";						
	}
	
	
	/* ============================================================== */
	/* END OF EMPLOYEE MANAGEMENT
    /* ============================================================== -->*/


	
	
	
	/*   ============================================================== */
	/*   START OF USER MANAGEMENT
    /*   ============================================================== -->*/

	
    
	@RequestMapping(value = "/userMang", method = RequestMethod.GET)
	public ModelAndView userMang(HttpServletRequest request,HttpSession session) {
		
		if (session.getAttribute("adminId") == null)
		{					
			
        	return new ModelAndView("redirect:/adminSignIn");
        }
		else
		{			
			Map<String, Object> model = new HashMap<String, Object>();
			
			model.put("adminData",adminService.getAdminDetails());
			
			model.put("userList",adminService.getUserList());
			
			return new ModelAndView("admin_user_mangement",model);				
		}							
	}
	
	
	@RequestMapping(value = "/adminViewUser", method = RequestMethod.POST)
	@ResponseBody public ModelAndView adminViewUser(HttpServletRequest request) {
		
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("userData",adminService.getUserDetails(Integer.parseInt(request.getParameter("userId"))));
		
		model.put("creditList",userService.getUserCreditRecord(Integer.parseInt(request.getParameter("userId"))));
				
		for(Object[] credit: userService.getUserCreditStatus(Integer.parseInt(request.getParameter("userId")))){
	    	
			model.put("total",(Double)credit[0]);
			model.put("montly",(Double)credit[1]);
			model.put("today",(Double)credit[2]);
	    }
				
		
		model.put("totalRef",userService.getUserReferencesCount(Integer.parseInt(request.getParameter("userId")),"Total"));
		model.put("totalSuc",userService.getUserReferencesCount(Integer.parseInt(request.getParameter("userId")),"Success"));
		
		
		return new ModelAndView("admin_view_user",model);
	}
	
	
	/* ============================================================== */
	/* END OF USER MANAGEMENT
    /* ============================================================== -->*/

	
	@RequestMapping(value = "/priceManage", method = RequestMethod.GET)
	public ModelAndView priceManage(HttpServletRequest request,HttpSession session) {
		
		if (session.getAttribute("adminId") == null)
		{								
        	return new ModelAndView("redirect:/adminSignIn");
        }
		else
		{			
			Map<String, Object> model = new HashMap<String, Object>();
			
			model.put("adminData",adminService.getAdminDetails());
			
			model.put("directParentReward",adminService.getParentReward("Direct"));
			
			model.put("indirectParentReward",adminService.getParentReward("Indirect"));
			
			return new ModelAndView("admin_pricing",model);				
		}							
	}
	
	
	@RequestMapping(value = "/reports", method = RequestMethod.GET)
	public ModelAndView reports(HttpServletRequest request,HttpSession session) {
		
		if (session.getAttribute("adminId") == null)
		{					
			
        	return new ModelAndView("redirect:/adminSignIn");
        }
		else
		{			
			Map<String, Object> model = new HashMap<String, Object>();
			
			model.put("adminData",adminService.getAdminDetails());
			
			return new ModelAndView("admin_reports",model);				
		}							
	}
	
	@RequestMapping(value = "/setting", method = RequestMethod.GET)
	public ModelAndView setting(HttpServletRequest request,HttpSession session) {
		
		if (session.getAttribute("adminId") == null)
		{								
        	return new ModelAndView("redirect:/adminSignIn");
        }
		else
		{			
			Map<String, Object> model = new HashMap<String, Object>();
			
			model.put("adminData",adminService.getAdminDetails());
			
			return new ModelAndView("admin_setting",model);				
		}							
	}
	
	@RequestMapping(value = "/adNotification", method = RequestMethod.GET)
	public ModelAndView adNotification(HttpServletRequest request,HttpSession session) {
		
		if (session.getAttribute("adminId") == null)
		{								
        	return new ModelAndView("redirect:/adminSignIn");
        }
		else
		{			
			Map<String, Object> model = new HashMap<String, Object>();
			
			model.put("adminData",adminService.getAdminDetails());
			
			return new ModelAndView("admin_notification",model);				
		}							
	}
	
	
	
	
	
}
