<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
 
<div class="row">
    <div class="col-sm-12">
        <!-- meta -->
        <div class="profile-user-box card-box bg-custom" style="padding: 3px;">
            
            <div class="row">
                
                <div class="col-sm-6">
                    
                    <c:set var="userId" value="${userData.user_id}"/>
					<%int userIden = (Integer)pageContext.getAttribute("userId"); %>
				 				
                    <c:set var="profilePhoto" value="${userData.profile_photo}"/>
					<% String profilePhoto = (String)pageContext.getAttribute("profilePhoto");%>
								
								
                    <span class="pull-left mr-3">
                    	
                    	<%if(profilePhoto.equals("")){ %>
                    		
                    		<img src="resource/horizontal/assets/images/users/usr-images.png" alt="" class="thumb-lg rounded-circle">
                    	
                    	<%}else{ %>
                    	
                    		<img src="${pageContext.request.contextPath}<%="/previewPicture?fileName="+profilePhoto+"&userId="+userIden+""%>" alt="Profile Picture" class="thumb-lg rounded-circle" />
                    	
                    	<%} %>
                    	
                    </span>
                    
                    <div class="media-body text-white">
                        <h4 class="mt-1 mb-1 font-18">${userData.first_name} ${userData.last_name}</h4>
                        <p class="text-light mb-0"><i class="fa fa-volume-control-phone"></i> &nbsp;  (+91) ${userData.mobile}</p> 
                        <p class="text-light mb-0"><i class="fa fa-envelope"></i>  &nbsp; ${userData.email_id}</p>
                        <p class="text-light mb-0">
                        	
                        	<c:if test = "${userData.gender == 'Female'}">
                        		
                        		<i class="fa fa-female"></i> 
                        		
                        	</c:if>
                        	
                        	<c:if test = "${userData.gender == 'Male'}">
                        	
                        		<i class="fa fa-male"></i>
                        		
                        	</c:if>
                        	
                        	&nbsp;  ${userData.gender}
                        	
                        </p>
                    </div>
                    
                </div>
                
                <div class="col-sm-6" style="margin-top: 33px;">
                    <div class="text-right" >
                        <i class="fa fa-calendar"></i>
                        <span style="color:#fff;">Joined Date : <b><fmt:formatDate pattern="dd/MM/yyyy HH:mm:ss" value="${userData.cr_date}" /></b></span>
                        <br>
                        <span style="color:#fff;">Status : <b>${userData.account_status}</b></span>
                        
                        <!-- <button type="button" class="btn btn-light waves-effect">
                            <i class="mdi mdi-account-settings-variant mr-1"></i> Edit Profile
                        </button> -->
                    </div>
                </div>
            </div>
        </div>
        <!--/ meta -->
    </div>
</div> 
 
 
<div class="row">
    
    <div class="col-md-4">
        
        <!-- Personal-Information -->
        <div class="card-box">
             <h4 class="header-title mt-0 m-b-20">Address Information</h4>
             <div class="panel-body">
                 
                 <div class="text-left">
                     <p class="text-muted font-13"><strong>Area :</strong> <span class="m-l-15">${userData.area}</span></p>
                     
                     <p class="text-muted font-13"><strong>City :</strong> <span class="m-l-15">${userData.city}</span></p>
                     
                     <p class="text-muted font-13"><strong>State :</strong> <span class="m-l-15">${userData.state}</span></p>
                     
                     <p class="text-muted font-13"><strong>Country :</strong> <span class="m-l-15">${userData.country}</span></p>
                     
                     <p class="text-muted font-13"><strong>Pincode :</strong> <span class="m-l-15">${userData.pincode}</span></p>
                </div>

             </div>
         </div>
         <!-- Personal-Information -->

    </div>

    <div class="col-md-8">

        <div class="row">

            <div class="col-sm-6">
                <div class="card-box tilebox-one">
                    <i class="icon-layers float-right text-muted"></i>
                    <h6 class="text-muted text-uppercase mt-0">Total Referee</h6>
                    <h2 class="m-b-20" data-plugin="counterup">${totalRef}</h2>
                </div>
            </div><!-- end col -->

            <div class="col-sm-6">
                <div class="card-box tilebox-one">
                    <i class="icon-paypal float-right text-muted"></i>
                    <h6 class="text-muted text-uppercase mt-0">Joined Referee</h6>
                    <h2 class="m-b-20"><span data-plugin="counterup">${totalSuc}</span></h2>
                </div>
            </div><!-- end col -->

            <div class="col-sm-6">
                 <div class="card-box tilebox-one">
                    <i class="icon-rocket float-right text-muted"></i>
                    <h6 class="text-muted text-uppercase mt-0">Total Credit</h6>
                   
                    <c:if test = "${total == null}">
                    	<h2 class="m-b-20" data-plugin="counterup">0</h2>
                    </c:if>
                    <c:if test = "${total != null}">
                    	<h2 class="m-b-20" data-plugin="counterup">${total}</h2>
                    </c:if>
                    
                 </div>
            </div><!-- end col -->
            
            <div class="col-sm-6">
                 <div class="card-box tilebox-one">
                    <i class="icon-rocket float-right text-muted"></i>
                    <h6 class="text-muted text-uppercase mt-0">Month Credit</h6>
                    
                    <c:if test = "${montly == null}">
                    	<h2 class="m-b-20" data-plugin="counterup">0</h2>
                    </c:if>
                    <c:if test = "${montly != null}">
                    	<h2 class="m-b-20" data-plugin="counterup">${montly}</h2>
                    </c:if>
                    
                 </div>
            </div><!-- end col -->

        </div>
        <!-- end row -->


    </div>
    <!-- end col -->

</div>
<!-- end row -->