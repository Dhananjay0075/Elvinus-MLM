<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta charset="utf-8" />
        <title>Reference</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
        <meta content="A fully featured admin theme which can be used to build CRM, CMS, etc." name="description" />
        <meta content="Coderthemes" name="author" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />

		 <%@include file="user_common_style.jsp"%>
		 
       
    </head>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
 
    <body>

        <!-- Navigation Bar-->
        <header id="topnav">
            <%@include file="user_topbar.jsp"%>

			
			<%@include file="user_menu.jsp"%>
        </header>
        <!-- End Navigation Bar-->


        <div class="wrapper">
            <div class="container-fluid">

                <!-- Page-Title -->
                <div class="row">
                    <div class="col-sm-12">
                        <div class="page-title-box">
                            <div class="btn-group pull-right">
                                <ol class="breadcrumb hide-phone p-0 m-0">
                                    <li class="breadcrumb-item"><a href="#">Elvinus</a></li>
                                    <li class="breadcrumb-item active">Reference</li>
                                </ol>
                            </div>
                            
                            <h4 class="page-title">User Reference</h4>
                            
                            
                        </div>
                    </div>
                </div>
                <!-- end page title end breadcrumb -->
                
                <div class="row">
                    <div class="col-sm-4">
                    	
                    	<button type="button"  class="btn btn-primary waves-effect waves-light" data-toggle="modal" data-target="#myModal2"> <i class="fa fa-mail-forward"></i> Send Invitation</button>
         
                    </div>
                </div>
                <br>
                
                <div id="userView" style="display:none;padding: 18px;background-color: #dcf5f5;border-radius: 6px;">
                
                	<%-- <%@include file="user_profile_info.jsp"%>	 --%>
                
                </div>
                
                <br>
                
                <div class="row">
                    
                    <div class="col-12">
                        
                        <div class="card-box table-responsive">
                            
                            <h4 class="m-t-0 header-title">Refer Record</h4>
                            
                            <p class="text-muted font-14 m-b-30">
                                Your refereed user list check the status of acceptance
                            </p>
							
							<c:if test="${!empty refList}">	
							 
		                            <table id="responsive-datatable" class="table table-bordered table-bordered dt-responsive nowrap" cellspacing="0" width="100%">
		                                <thead>
			                                <tr>
			                                    <th>Sl No</th>
			                                    <th>Name</th>
			                                    <th>Email Id</th>
			                                    <th>Mobile</th>
			                                    <th>Sent date</th>
			                                    <th>Status</th>
			                                    <th>Action</th>
			                                </tr>
		                                </thead>
		
		                                <tbody>
		                                	
		                                  <%int i = 1; %> 
		                                  <c:forEach items="${refList}" var="val">
				                                
				                                <tr>
				                                    <td><%=i++%></td>
				                                    <td>${val.full_name}</td>
				                                    <td>${val.email_id}</td>
				                                    <td>${val.mobile}</td>
				                                    <td><fmt:formatDate pattern="dd/MM/yyyy HH:mm:ss" value="${val.cr_date}" /></td>
				                                    <td>
				                                        <c:if test = "${val.status == 'pending'}">
				                                        	<span class="badge label-table badge-danger">Pending</span>
				                                        </c:if>
				                                        
				                                        <c:if test = "${val.status == 'success'}">
				                                        	<span class="badge label-table badge-success">Success</span>
				                                        </c:if>
				                                    </td>
				                                    <td>
				                                    	<c:if test = "${val.status == 'pending'}">
				                                    		<button type="button" class="btn btn-primary waves-effect waves-light messageClass" data-toggle="modal" data-target="#myModal" onclick="showNotifyForm('${val.email_id}','${val.full_name}')"> <i class="fa fa-mail-forward"></i></button>
				                                   		</c:if>
				                                   		
				                                   		<c:if test = "${val.status == 'success'}">
				                                   			
				                                   			<button type="button" class="btn btn-primary waves-effect waves-light messageClass" data-toggle="modal" data-target="#myModal" onclick="showNotifyForm('${val.email_id}','${val.full_name}')"> <i class="fa fa-mail-forward"></i></button>
				                                   			
				                                   			<button type="button" class="btn btn-icon waves-effect waves-light btn-success" onclick="viewUserProfile('${val.email_id}')"> <i class="fa fa-eye"></i> </button>
				                                   		</c:if>
				                                    </td>
				                                </tr>
				                                
		                                  </c:forEach>
		                                  
		                                </tbody>
		                            </table>
		                            
		                       </c:if>
		                       
		                       <c:if test="${empty refList}">	
		                       
		                       		<div class="alert alert-danger alert-dismissible bg-danger text-white border-0 fade show" role="alert">
		                                
		                                As of now you didn't referred anyone !
		                                
		                            </div>
		                       
		                       </c:if>
		                            
                        </div>
                    </div>
                </div> <!-- end row -->
                
            </div> <!-- end container -->
        </div>
        <!-- end wrapper -->

		
		
		
		 <!-- SEND NOTIFICATION modal content -->
         <div id="myModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
             <div class="modal-dialog" style="max-width: 705px;">
                 <div class="modal-content">
                     <div class="modal-header" style="background-color: #02c0ce;color: #fff;">
                         <button type="button" class="close" data-dismiss="modal" aria-hidden="true">X</button>
                         <h4 class="modal-title" id="myModalLabel">Send Message </h4>
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
         </div>
         
         <!-- /.modal -->
         
         
         
         
          <!-- SEND INVITATION modal content -->
         <div id="myModal2" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
             <div class="modal-dialog" style="max-width: 705px;">
                 <div class="modal-content">
                     <div class="modal-header" style="background-color: #02c0ce;color: #fff;">
                         <button type="button" class="close" data-dismiss="modal2" aria-hidden="true">X</button>
                         <h4 class="modal-title" id="myModalLabel">Send Invitation </h4>
                     </div>
                     <div class="modal-body">
                         
                         <div class="card-box">
                            
                            <h4 class="header-title m-t-0">Refer Others</h4>
                            
                            <p class="text-muted font-14 m-b-20">
                               Your account id will links to invite request it will notify via mail & SMS.
                            </p>

                            <form:form id="userRefForm" modelAttribute="userRef" method="post">
                                
                                <div class="form-group">
                                    <label for="fullName">User Name<span class="text-danger">*</span></label>
                                    <input type="text" class="form-control" name="full_name" placeholder="Enter full name"  id="full_name">
                                    <ul class="parsley-errors-list filled">
										<li class="parsley-required regErr" id="fname_err"></li>
									</ul>       
                                </div>
                                
                                <div class="form-group">
                                    <label for="email_id">Email address<span class="text-danger">*</span></label>
                                    <input type="email" name="email_id" placeholder="Enter email" class="form-control" id="email_id">
                                    <ul class="parsley-errors-list filled">
										<li class="parsley-required regErr" id="email_err"></li>
									</ul>       
                                </div>
                                
                                <div class="form-group">
                                    <label for="mobile">Mobile<span class="text-danger">*</span></label>
                                    <input id="mobile" name="mobile" type="phone" placeholder="mobile no" 
                                           class="form-control">
                                    <ul class="parsley-errors-list filled">
										<li class="parsley-required regErr" id="mobile_err"></li>
									</ul>       
                                </div>
                                
                            </form:form>
                            
                        </div> <!-- end card-box -->
                    
                    </div>
                     <div class="modal-footer">
                         <button type="button" class="btn btn-light waves-effect" data-dismiss="modal">Close</button>
                         <button id="refButtonId" class="btn btn-custom waves-effect waves-light" type="button">Submit</button>
                     </div>
                 </div><!-- /.modal-content -->
             </div><!-- /.modal-dialog -->
         </div>
         
         <!-- /.modal -->
         
		
		
		
		
        <!-- Footer -->
        <%@include file="footer.jsp"%>
        <!-- End Footer -->


       
		<%@include file="user_common_script.jsp"%>
		
    </body>
</html>