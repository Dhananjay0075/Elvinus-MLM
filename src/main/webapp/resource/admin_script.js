
function viewUser(userId)
{
	$("#preloader").show();
	
	$.ajax({  
		 type : "post",   
	     url : "adminViewUser", 
	     data : "userId="+userId,	     		     	     
	     success : function(response) 
	     {  					    	 
	    	 $("#preloader").hide();
	    	 
	    	 $("#userView").html(response);
	    	 			
	    	 $("#userView").show();
	     },
	}); 
}







