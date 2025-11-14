<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
 

<div class="col-sm-12">
                        			
	<div class="row">
	       <div class="col-sm-12">
	           <!-- meta -->
	           <div class="profile-user-box card-box bg-custom">
	               <div class="row">
	                   <div class="col-sm-6">
	                       
	                        <c:set var="userId" value="${userData.user_id}"/>
							<%int userIden = (Integer)pageContext.getAttribute("userId"); %>
						 				
		                    <c:set var="profilePhoto" value="${userData.profile_photo}"/>
							<% String profilePhoto = (String)pageContext.getAttribute("profilePhoto");%>
						    
						    <%if(profilePhoto.equals("")){ %>
						    
	                           <span class="pull-left mr-3"><img src="resource/vertical/assets/images/users/avatar-1.jpg" alt="" class="thumb-lg rounded-circle"></span>
	                       
	                        <%}else{ %>
	                        
	                           <span class="pull-left mr-3"><img src="${pageContext.request.contextPath}<%="/previewPicture?fileName="+profilePhoto+"&userId="+userIden+""%>" alt="" class="thumb-lg rounded-circle"></span>
	                        	
	                        <%} %>
	                       
	                       <div class="media-body text-white">
	                           <h4 class="mt-1 mb-1 font-18">${userData.first_name} ${userData.last_name}</h4>
	                           <!-- <p class="font-13 text-light"> User Experience Specialist</p> -->
	                           <p class="text-light mb-0">${userData.state}, ${userData.country}</p>
	                       </div>
	                   </div>
	                   <div class="col-sm-6">
	                       <div class="text-right">
	                           
                               <button type="button" class="btn btn-light waves-effect waves-light" data-toggle="modal" data-target="#myModal" onclick="showNotifyForm('${userData.email_id}','${userData.first_name}')">Send Message to ${userData.first_name}</button>
                               
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
	                          <h4 class="header-title mt-0 m-b-20">Contact Information</h4>
	                          <div class="panel-body">
	                              
	                              <div class="text-left">
	                                  <p class="text-muted font-13"><strong>Mobile :</strong><span class="m-l-15">(+91) ${userData.mobile}</span></p>
	
	                                  <p class="text-muted font-13"><strong>Email :</strong> <span class="m-l-15">${userData.email_id}</span></p>
	
	                                  <p class="text-muted font-13"><strong>Area :</strong> <span class="m-l-15">${userData.area}</span></p>
	                                  
	                                  <p class="text-muted font-13"><strong>City :</strong> <span class="m-l-15">${userData.city}</span></p>
	                                  
	                                  <p class="text-muted font-13"><strong>State :</strong> <span class="m-l-15">${userData.state}</span></p>
	                                  
	                                  <p class="text-muted font-13"><strong>Country :</strong> <span class="m-l-15">${userData.country}</span></p>
	                             </div>
	
	                             
	                          </div>
	                      </div>
	                      <!-- Personal-Information -->
	
	
	        </div>
	
	
	        <div class="col-md-8">
	
	            <div class="row">
	
	                <div class="col-sm-4">
	                    <div class="card-box tilebox-one">
	                        <i class="icon-layers float-right text-muted"></i>
	                        <h6 class="text-muted text-uppercase mt-0">Total Referee</h6>
	                        <h2 class="m-b-20" data-plugin="counterup">${totalRef}</h2>
	                    </div>
	                </div><!-- end col -->
	
	                <div class="col-sm-4">
	                    <div class="card-box tilebox-one">
	                        <i class="icon-paypal float-right text-muted"></i>
	                        <h6 class="text-muted text-uppercase mt-0">Joined Referee</h6>
	                        <h2 class="m-b-20"><span data-plugin="counterup">${totalSuc}</span></h2>
	                    </div>
	                </div><!-- end col -->
	
	                <div class="col-sm-4">
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
	
	            </div>
	            
	            <!-- end row -->
	
	
	
	            <div class="card-box">
	                
	                <h4 class="header-title mb-3">Credit Status</h4>
	
	                <div class="table-responsive">
	                   
	                   <c:if test="${!empty creditList}">	
	                    
		                    <table class="table m-b-0">
		                        
		                        <thead>
			                        <tr>
			                            <th>#</th>
			                            <th>Mode</th>
			                            <th>Reward</th>
			                            <th>Amount</th>
			                            <th>Date</th>
			                            <th>Status</th>
			                            <th>Action</th>
			                        </tr>
		                        </thead>
		                        
		                        <tbody>
		                       
			                       <%int r = 1; %>
								   <c:forEach items="${creditList}" var="val">
				                        
				                        <tr>
				                            <td><%=r++%></td>
				                            <td>${val.credit_mode}</td>
											<td>${val.credit_reward}</td>
											<td>${val.credit_amount}</td>
		                                    <td><fmt:formatDate pattern="dd/MM/yyyy HH:mm:ss" value="${val.credit_date}" /></td>
											<td>
		                                        <span class="badge badge-success">${val.credit_status}</span>
		                                    </td>
		                                    <td>
		                                        <div class="btn-group dropdown">
		                                            <a href="#" class="table-action-btn arrow-none btn btn-light btn-sm" ><i class="mdi mdi-dots-horizontal"></i></a>
		                                        </div>
		                                    </td>
				                        </tr>	
			                        
			                        </c:forEach>
		                        
		                        </tbody>
		                        
		                    </table>
		                    
		                  </c:if>
		                  
		                  <c:if test="${empty creditList}">	
		                       
	                       		<div class="alert alert-danger alert-dismissible bg-danger text-white border-0 fade show" role="alert">
	                                
	                                As of now ${userData.first_name} didn't get any any reward !
	                                
	                            </div>
	                       
	                       </c:if>
		                            
		                    
	                </div>
	            </div>
	
	        </div>
	        <!-- end col -->
	
	  </div>
				
</div>


<div id="myModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
     <div class="modal-dialog">
         <div class="modal-content">
             <div class="modal-header">
                 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                 <h4 class="modal-title" id="myModalLabel">Send Message</h4>
             </div>
             <div class="modal-body">
                         
                   <form role="form" id="notificationForm" >
                       
                       <div class="form-group">
                           <input type="email" readonly name="reciverUserId" id="reciverUserId" class="form-control" placeholder="To">
                       </div>

                       <div class="form-group">
                          <textarea class="form-control" name="notify_msg" id="notify_msg" rows="" cols=""></textarea>
                       </div>

                   </form>
              
              </div>
              <div class="modal-footer">
                   <button type="button" class="btn btn-light waves-effect" data-dismiss="modal">Close</button>
                   <button type="button" class="btn btn-primary waves-effect waves-light" onclick="sendMessage()">Send</button>
              </div>
               
         </div><!-- /.modal-content -->
     </div><!-- /.modal-dialog -->
 </div><!-- /.modal -->
                                    