package com.elvinus.restController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.elvinus.bean.ECommBilling;
import com.elvinus.bean.ECommShipping;
import com.elvinus.bean.ECommUserReg;
import com.elvinus.model.RestAPIModel;
import com.elvinus.model.UserReference;
import com.elvinus.model.UserRegistration;
import com.elvinus.service.AdminService;
import com.elvinus.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/membership")
public class UserRestAPI {

	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private UserService userService;
	
	public static final Logger logger = LoggerFactory.getLogger(UserRestAPI.class);
	
	/*@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
	public ResponseEntity<List<UserRegistration>> userDetails(@PathVariable int userId) {
        
		List<UserRegistration> userDetails = userService.getUserDetails(userId);
		
		return new ResponseEntity<List<UserRegistration>>(userDetails, HttpStatus.OK);
	}*/
	
	
	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
	public ResponseEntity<Object> userDetails(@PathVariable int userId) {
        
		List<UserRegistration> userDetails = userService.getUserDetails(userId);
		
		List<JSONObject> entities = new ArrayList<JSONObject>();
		
		if(userDetails.size()>0)
		{
			userDetails.get(0).setPassword("No Acccess");
			
			//entities.addAll(userDetails.toString());
			
			return new ResponseEntity<Object>(userDetails.get(0), HttpStatus.OK);
			
			//return new ResponseEntity<Object>(entities, HttpStatus.OK);
		}
		else
		{
			UserRegistration UserRegistration =null;
			
			return new ResponseEntity<Object>(UserRegistration, HttpStatus.OK);
		}
		
	}
	
	@RequestMapping(value = "/ecommuser", method = RequestMethod.GET)
	public ResponseEntity<ECommUserReg> ecommUser() {
        
		ECommUserReg ecommUser = new ECommUserReg("abinash.raula@jirehsol.com","Abinash","Raula","ABI127","asd123",new ECommBilling("","","","","","","","","","",""),new ECommShipping("","","","","","","","",""));
		
		return new ResponseEntity<ECommUserReg>(ecommUser, HttpStatus.OK);		
	}
	
	@RequestMapping(value = "/restUserAPI", method = RequestMethod.GET)
	public ResponseEntity<RestAPIModel> userModel() {
        
		RestAPIModel restObj = new RestAPIModel();
		
		ECommUserReg ecommUser = new ECommUserReg("abinash.raula@jirehsol.com","Abinash","Raula","ABI127","asd123",new ECommBilling("","","","","","","","","","",""),new ECommShipping("","","","","","","","",""));
		
		List<ECommUserReg> userList = new ArrayList<ECommUserReg>();
		userList.add(ecommUser);
		
		restObj.setStatus("success");
		restObj.setCode("200");
		//restObj.setData(ecommUser);
		restObj.setData(userList);
		
		return new ResponseEntity<RestAPIModel>(restObj, HttpStatus.OK);		
	}
	
	
	/*@RequestMapping(value = "/user/", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody UserRegistration user, UriComponentsBuilder ucBuilder,HttpServletRequest request) {
        
		//logger.info("Creating User : {}", user);
 
        if (userService.isUserExist(user)) {
            //logger.error("Unable to create. A User with name {} already exist", user.getName());          
        	return new ResponseEntity(new CustomErrorType("Unable to create. A User with name " + user.getFirst_name() + " already exist."),HttpStatus.CONFLICT);
        }
       
        userService.saveUserRegdetails(user,request);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{userId}").buildAndExpand(user.getUser_id()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }*/
	
	
	
	 @RequestMapping(value = "/createUserRef", method = RequestMethod.POST)
	 public ResponseEntity<RestAPIModel> createEmployee(@RequestBody UserReference userRef) {
		 	
		 logger.info("Start User Reference.");
		 
		 userRef.setCr_date(new Date());
		 userRef.setStatus("pending");
		 
		 return null;
	}
	
	
}
