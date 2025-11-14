
function redirectUrl(url)
{
	window.location = url;
}

var alfanumeric = /^[a-zA-Z0-9]*$/;        	
var nameWithOutSpace = /^[a-zA-Z]+$/;
var nameWithSpace = /^[a-zA-Z\s]*$/;	
var phNo = /^[0-9]{10}$/;	
var email = /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/;
var poi= /^[a-zA-Z0-9]{6,20}$/;



///////------------------------------ USER REGISTRATION SCRIPT ////////////////////////////////////////////////////////////////////////////////



$(document).ready(function () {
    $('#userSignUpBtn').click(function () {
       
    	var flag = 'true';
    	
    	var fName= $("#first_name").val();
    	var lName= $("#last_name").val();
    	var emailId= $("#email_id").val();
    	var mobileNo= $("#mobile").val();
    	var password= $("#password").val();
    	var confirmPassword = $("#cnfPassword").val();
    	
    	var pan_id = $("#pan_id").val();
    	var aadhar_id = $("#aadhar_id").val();
    	//var gender = $("#gender").val();
    	var area = $("#area").val();
    	
    	var city = $("#city").val();
    	var state = $("#state").val();
    	var country = $("#country").val();
    	var pincode = $("#pincode").val();
    	
    	var bank_name = $("#bank_name").val();
    	var bank_account_no = $("#bank_account_no").val();
    	var bank_ifsc_code = $("#bank_ifce_code").val();
    	var bank_account_name = $("#bank_account_name").val();
    	
    	
    	var agree = document.getElementById("remember");
        
        
    	if(fName=="")
    	{		
    		flag = 'false';
    		$("#fname_err").show();
            $("#fname_err").html("Please enter your first name.");	               
    	}
        
        if(fName!="")
    	{
    		if(!fName.match(nameWithSpace))  
            {  		
    			flag = 'false';
    			$("#fname_err").show();
    	        $("#fname_err").html("Only alphabets are allowed.");		           
            }
    		else
    		{
    			$("#fname_err").hide();
    		}
    	}  
        
        if(lName=="")
    	{		
    		flag = 'false';
    		$("#lname_err").show();
            $("#lname_err").html("Please enter your last name.");	               
    	}
        
        if(lName!="")
    	{
    		if(!lName.match(nameWithSpace))  
            {  		
    			flag = 'false';
    			$("#lname_err").show();
    	        $("#lname_err").html("Only alphabets are allowed.");		           
            }
    		else
    		{
    			$("#lname_err").hide();
    		}
    	}  
        
        if(emailId=="")
    	{		
    		flag = 'false';
    		$("#email_err").show();
            $("#email_err").html("Please enter your email id.");                  
    	}
        
        if(emailId!="")
    	{
    		if(!emailId.match(email))  
            {  			
    			flag = 'false';
    			$("#email_err").show();
    	        $("#email_err").html("Please enter a valid email id.");		           
            }
    		else
    		{
    			$("#email_err").hide();
    		}
    	}
           
        if(mobileNo=="")
    	{		
    		flag = 'false';
    		$("#mobile_err").show();
            $("#mobile_err").html("Please enter your mobile no.");	
        }
        
        if(mobileNo!="")
    	{
    		if(!mobileNo.match(phNo))  
            {  			
    			flag='false';
    			$("#mobile_err").show();
    	        $("#mobile_err").html("Please enter a valid mobile no.");
    	    }
    		else
    		{
    			$("#mobile_err").hide();
    		}
    	}
    	
        if(password=="")
    	{
        	flag='false';
    		$("#pw_err").show();
            $("#pw_err").html("Please set a password for the account.");
        }
        
        if(password!="")
    	{
    		$("#pw_err").hide();
    	}
       
        if(confirmPassword=="")
    	{
        	flag='false';
    		$("#cnfPw_err").show();
            $("#cnfPw_err").html("Please confirm your password.");
        }
        
        if(confirmPassword!="")
    	{
    		$("#cnfPw_err").hide();	 
    	}
       
        if(password!=confirmPassword)
    	{
        	flag='false';
    		$("#cnfPw_err").show();
            $("#cnfPw_err").html("Confirm password not matched with password.");
        }
        
        if(pan_id=="")
    	{
        	flag='false';
    		$("#pan_err").show();
            $("#pan_err").html("Please mention your pan id.");
        }
        
        if(pan_id!="")
    	{
    		$("#pan_err").hide();
    	}
        
        if(aadhar_id=="")
    	{
        	flag='false';
    		$("#aadhar_err").show();
            $("#aadhar_err").html("Please mention your aadhar id.");
        }
        
        if(aadhar_id!="")
    	{
    		$("#aadhar_err").hide();
    	}
        
        
        if(area=="")
    	{
        	flag='false';
    		$("#area_err").show();
            $("#area_err").html("Please mention your area address.");
        }
        
        if(area!="")
    	{
    		$("#area_err").hide();
    	}
        
        if(city=="")
    	{
        	flag='false';
    		$("#city_err").show();
            $("#city_err").html("Please mention city name.");
        }
        
        if(city!="")
    	{
    		$("#city_err").hide();
    	}
        
        if(state=="")
    	{
        	flag='false';
    		$("#state_err").show();
            $("#state_err").html("Please mention state name.");
        }
        
        if(state!="")
    	{
    		$("#state_err").hide();
    	}
        
        if(country=="")
    	{
        	flag='false';
    		$("#country_err").show();
            $("#country_err").html("Please mention country name.");
        }
        
        if(country!="")
    	{
    		$("#country_err").hide();
    	}
        
        if(pincode=="")
    	{
        	flag='false';
    		$("#pincode_err").show();
            $("#pincode_err").html("Please mention area pincode.");
        }
        
        if(pincode!="")
    	{
    		$("#pincode_err").hide();
    	}
        
        
        if(bank_name=="")
    	{
        	flag='false';
    		$("#bank_name_err").show();
            $("#bank_name_err").html("Please mention bank name.");
        }
        
        if(bank_name!="")
    	{
    		$("#bank_name_err").hide();
    	}
        
        if(bank_account_no=="")
    	{
        	flag='false';
    		$("#bank_acc_err").show();
            $("#bank_acc_err").html("Please mention account no.");
        }
        
        if(bank_account_no!="")
    	{
    		$("#bank_acc_err").hide();
    	}
        
        if(bank_ifsc_code=="")
    	{
        	flag='false';
    		$("#bank_ifsc_err").show();
            $("#bank_ifsc_err").html("Please mention bank IFSC code.");
        }
        
        if(bank_ifsc_code!="")
    	{
    		$("#bank_ifsc_err").hide();
    	}
        
        if(bank_account_name=="")
    	{
        	flag='false';
    		$("#bank_ac_name_err").show();
            $("#bank_ac_name_err").html("Please mention bank IFSC code.");
        }
        
        if(bank_account_name!="")
    	{
    		$("#bank_ac_name_err").hide();
    	}
        
        
        if(agree.checked==false)
        {
        	flag='false';
    		$("#termErrId").show();
            $("#termErrId").html("Are you agree with the terms and conditions.");
           // return false;
        } 
        
        if(agree.checked==true)
        {
    		$("#termErrId").hide();		
        }  
    	
        if(flag=='true')
    	{
    		$("#preloader").show();
    	    
       	 	var formData = new FormData($("#userRegForm")[0]);
       	 
    		$.ajax({  
     			
    		     type : "post",   
    		     url : "saveUserRegister", 
    		     data : formData,	     		     	     
    		     success : function(response) 
    		     {  											    	 
    		    	 $("#preloader").hide();
    		    	 
    		    	 if(response=="Email Exist")
    		      	 {
    		    		$("#email_err").html("This email id already registered.");
    		    		$("#email_err").show();
    		 	     }
    		    	 else if(response=="Mobile Exist")
    		      	 {
    		    		 $("#mobileErrId").html("This mobile no already registered.");
    		    		 $("#mobileErrId").show();
    			 	 }
    		    	 else if(response=="success")
    		      	 {					
    	    		 	 
    		    		 swal(
			                {
			                    title: 'Success',
			                    text: 'You have successfully registered.',
			                    type: 'success',
			                    confirmButtonClass: 'btn btn-confirm mt-2'
			                }
			            )
	            
    		    		 // REDIRECT TO E-COMM URL TO PURCHASE THE PRODUCTS
    		    		 
    		    		 redirecToElvinusShop(emailId);
    		    		 
    	    			 //urlRedirect = "redirectToShop?emId="+emailId+"";
    				 }
    		      	 else
    		      	 {		      		    
    	      		 	 $("#alertPopUp").slideDown();
    	      		 	
    	      		 	 $("#alertDivId").removeClass("popupSuccess");
    	      		 	 $("#alertDivId").addClass("popupError");
    	      		 	 
    	      		 	 $("#alertHead").html("Error Message");
    	      		 	 $("#alertMsg").html("There is some problem arise,Please try again later.");	    										      		 	
    		      	 }											    	 
    		     },
    		     cache: false,
    		     contentType: false,
    		     processData: false,
    	     }); 
    	}
    	
        
    });
});


function redirecToElvinusShop(emailId)
{
	$("#preloader").show();
	
	$.ajax({  
			
	     type : "post",   
	     url : "redirecToElvinusShop", 
	     data : "emailId="+emailId,	     		     	     
	     success : function(response) 
	     {  											    	 
	    	 $("#preloader").hide();
	    	 
	    	 if(response!="")
	    	 {
	    		 window.location = "https://www.elvinus.com/user_auth_login.php?"+response;
	    	 }
	    	 											    	 
	     },
	}); 
}

function showActivateAlert()
{	
	var actionVal = $("#actionId").val();
	
	if(actionVal=="Your account activated")
	{
		swal(
	            {
	                title: 'Good job!',
	                text: 'You have successfully registered',
	                type: 'success',
	                confirmButtonClass: 'btn btn-confirm mt-2'
	            }
	        )	
	}
}


$(document).ready(function () {
	
    $('#refButtonId').click(function () {
        
    	var flag = 'true';
    	
    	var fName= $("#full_name").val();
    	var emailId= $("#email_id").val();
    	var mobileNo= $("#mobile").val();
    	
    	if(fName=="")
    	{		
    		flag = 'false';
    		$("#fname_err").show();
            $("#fname_err").html("Please enter referee name.");	               
    	}
        
        if(fName!="")
    	{
    		if(!fName.match(nameWithSpace))  
            {  		
    			flag = 'false';
    			$("#fname_err").show();
    	        $("#fname_err").html("Only alphabets are allowed.");		           
            }
    		else
    		{
    			$("#fname_err").hide();
    		}
    	}  
        
        
        if(emailId=="")
    	{		
    		flag = 'false';
    		$("#email_err").show();
            $("#email_err").html("Please enter your email id.");                  
    	}
        
        if(emailId!="")
    	{
    		if(!emailId.match(email))  
            {  			
    			flag = 'false';
    			$("#email_err").show();
    	        $("#email_err").html("Please enter a valid email id.");		           
            }
    		else
    		{
    			$("#email_err").hide();
    		}
    	}
           
        if(mobileNo=="")
    	{		
    		flag = 'false';
    		$("#mobile_err").show();
            $("#mobile_err").html("Please enter your mobile no.");	
        }
        
        if(mobileNo!="")
    	{
    		if(!mobileNo.match(phNo))  
            {  			
    			flag='false';
    			$("#mobile_err").show();
    	        $("#mobile_err").html("Please enter a valid mobile no.");
    	    }
    		else
    		{
    			$("#mobile_err").hide();
    		}
    	}
    	
        if(flag=='true')
    	{
    		$("#preloader").show();
    	    
       	 	var formData = new FormData($("#userRefForm")[0]);
       	 
    		$.ajax({  
     			
    		     type : "post",   
    		     url : "saveUserReference", 
    		     data : formData,	     		     	     
    		     success : function(response) 
    		     {  											    	 
    		    	 $("#preloader").hide();
    		    	 
    		    	 if(response=="exist")
    		      	 {
    		    		alert("You have already sent a reference request.");
    		    	 }
    		    	 else if(response=="failure")
    		      	 {
    		    		 swal({
    	                        title: 'Cancelled',
    	                        text: "Please try again later, There is some issue.",
    	                        type: 'error',
    	                        confirmButtonClass: 'btn btn-confirm mt-2'
    	                    }
    	                    )
    		    		 
    			 	 }
    		    	 else if(response=="success")
    		      	 {					
    		    		 swal(
    		   	                 {
    		   	                     title: 'Success',
    		   	                     text: 'You have successfully sent the reference request.',
    		   	                     type: 'success',
    		   	                     confirmButtonClass: 'btn btn-confirm mt-2'
    		   	                 }
    		   	             )
    		   	           
    		    		 // REDIRECT TO E-COMM URL TO PURCHASE THE PRODUCTS
    		    		 
    	    			 window.location = "userRef";
    				 }
    		      	 else
    		      	 {		      		    
    	      		 	     										      		 	
    		      	 }											    	 
    		     },
    		     cache: false,
    		     contentType: false,
    		     processData: false,
    	     }); 
    	}
    	
        
    });
});



function updateAccount(updateCategory)
{
	var flag = 'true';
	
	
	if(updateCategory=="Account")
	{
		var fi = document.getElementById('file');
		
		if(fi.files.length>0)
		{	
			var extension = new Array("JPG","jpg","jpeg","JPEG","gif","GIF","png","PNG");	
		    
			var fsize = 0;
			
			var condition = "NotGranted";
			
			for (var f = 0; f <= fi.files.length - 1; f++) 
			{
				var fname = fi.files.item(f).name;
				var ext=fname.substring(fname.lastIndexOf('.')+1)
				
				for(var m=0;m<extension.length;m++)
				{
				    if(ext==extension[m])
			    	{				    	    
			    	   condition="Granted";				    	    
			    	}			    
				}
				
				if(condition=="NotGranted")
				{
				    flag = 'false';	
				    $("#file_err").show();
				    $("#file_err").html("Only image files are allowed.");
					return false;				  
				}
				
				var fileSizeinBytes = fi.files.item(f).size;   
				var sizeinKB = +fileSizeinBytes / 1024;
		  		var sizeinMB = +sizeinKB / 1024;
		  		
		  		fsize = fsize + sizeinMB;		  		
			}
			
			if(fsize>1)
			{
				flag = 'false';
				$("#file_err").show();
				$("#file_err").html("choose a file less then 1 MB.");
				return false;	 		   		 
			}					
		}
		
		if(flag=='true')
		{
			$("#preloader").show();
		    
			var formData = new FormData($("#userAccountForm")[0]);
			formData.append("updateType",updateCategory);
			
			$.ajax({  
	 			
			     type : "post",   
			     url : "updateAccountDetails", 
			     data : formData,	     		     	     
			     success : function(response) 
			     {  					    	 
			    	 $("#preloader").hide();
			    	 
			    	 if(response=="failure")
			      	 {
			    		 alert("Please try again later,There is some issue.");
				 	 }
			    	 else if(response=="success")
			      	 {					
		    		 	 swal(
    		   	                 {
    		   	                     title: 'Success',
    		   	                     text: 'You have successfully updated your account.',
    		   	                     type: 'success',
    		   	                     confirmButtonClass: 'btn btn-confirm mt-2'
    		   	                 }
    		   	             )
    		   	             
		    		 	 window.location = "userAccount";
					 }
			      	 else
			      	 {		      		    
		      		 	     										      		 	
			      	 }											    	 
			     },
			     cache: false,
			     contentType: false,
			     processData: false,
		     }); 
		}
	}
	else if(updateCategory=="Address")
	{
		
	}
	else if(updateCategory=="Bank")
	{
		
	}
	else
	{
		
	}	
}


function deleteMsg(notifyId)
{
	$("#preloader").show();
	
	$.ajax({  
			
	     type : "post",   
	     url : "deleteNotification", 
	     data : "notifyId="+notifyId,	     		     	     
	     success : function(response) 
	     {  											    	 
	    	 $("#preloader").hide();
	    	 
	    	 $("#notificationList").html(response);
	    	 											    	 
	     },
	}); 
}

function showNotifyForm(email,name)
{
	$("#reciverUserId").val(email);
}

function sendMessage()
{
    $("#preloader").show();
    
	var formData = new FormData($("#notificationForm")[0]);
	
	$.ajax({  
			
	     type : "post",   
	     url : "sendNotification", 
	     data : formData,	     		     	     
	     success : function(response) 
	     {  											    	 
	    	 $("#preloader").hide();
	    	 
	    	 if(response=="failure")
	      	 {
	    		 alert("Please try again later, There is some issue.");
		 	 }
	    	 else if(response=="success")
	      	 {					
    		 	 swal(
	                {
	                    title: 'Sent',
	                    text: 'Message successfully sent to the user.',
	                    type: 'success',
	                    confirmButtonClass: 'btn btn-confirm mt-2'
	                }
	            )
    		 	
	            $("#notify_msg").val("");
	            $(".messageClass").click();
    		 }
	      	 else
	      	 {		      		    
      		 	     										      		 	
	      	 }											    	 
	     },
	     cache: false,
	     contentType: false,
	     processData: false,
     }); 
}



$('#resetPassword').click(function () {
    
	
	var flag = 'true';
	
	var curPassword = $("#cur_pw").val();
	var newPassword = $("#new_pw").val();
	var cnfPassword = $("#cnf_pw").val();
	
	if(curPassword=="")
	{
    	flag='false';
		$("#curPw_err").show();
        $("#curPw_err").html("Please enter your current password.");
    }
    
    if(curPassword!="")
	{
		$("#curPw_err").hide();
	}
    
	if(newPassword=="")
	{
    	flag='false';
		$("#newPw_err").show();
        $("#newPw_err").html("Please set a password for the account.");
    }
    
    if(newPassword!="")
	{
		$("#newPw_err").hide();
	}
   
    if(cnfPassword=="")
	{
    	flag='false';
		$("#cnfPw_err").show();
        $("#cnfPw_err").html("Please confirm your password.");
    }
    
    if(cnfPassword!="")
	{
		$("#cnfPw_err").hide();	 
	}
   
    if(newPassword!=cnfPassword)
	{
    	flag='false';
		$("#cnfPw_err").show();
        $("#cnfPw_err").html("Confirm password not matched with password.");
    }
    
    if(flag=='true')
    {		
    	 $("#preloader").show();
    	 
	    	$.ajax({  
				
	   	     type : "post",   
	   	     url : "resetPassword", 
	   	     data : "curPassword="+curPassword+"&newPassword="+newPassword,	     		     	     
	   	     success : function(response) 
	   	     {  
	   	    	
	   	    	 
	   	    	 $("#preloader").hide();
	   	    	 
	   	    	 if(response=="Incorrect")
	   	      	 {
	   	    		$("#curPw_err").show();
	   	    		$("#curPw_err").html("Current paswword is not correct.");
	   		 	 }
	   	    	 else if(response=="success")
	   	      	 {					
	   	    		swal(
	   	                 {
	   	                     title: 'Success',
	   	                     text: 'You have successfully changed the password',
	   	                     type: 'success',
	   	                     confirmButtonClass: 'btn btn-confirm mt-2'
	   	                 }
	   	             )
	   	             
	   	            $("#cur_pw").val("");
	   	    		$("#new_pw").val("");
	   	    		$("#cnf_pw").val("");
	       		 }
	   	    	 else
	   	    	 {
	   	    		swal({
                        title: 'Failed',
                        text: "There might be some problem, Please try again later",
                        type: 'error',
                        confirmButtonClass: 'btn btn-confirm mt-2'
                     }
                    )
	   	    	 }
	   	      	 									    	 
	   	     },
	   	    }); 
    }
	
});


function viewUserProfile(emailId)
{
	$("#preloader").show();
	
	$.ajax({  
		 type : "post",   
	     url : "userProfileView", 
	     data : "emailId="+emailId,	     		     	     
	     success : function(response) 
	     {  					    	 
	    	 $("#preloader").hide();
	    	 
	    	 $("#userView").html(response);
	    	 			
	    	 $("#userView").show();
	     },
	}); 
}


