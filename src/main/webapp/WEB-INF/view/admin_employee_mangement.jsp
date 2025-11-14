<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    
    <head>
       
        <meta charset="utf-8" />
        <title>Employee Management</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
        <meta content="A fully featured admin theme which can be used to build CRM, CMS, etc." name="description" />
        <meta content="Coderthemes" name="author" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
		
		<%@include file="admin_common_style.jsp"%>
		 
    </head>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
 
    <body>

        <!-- Begin page -->
        <div id="wrapper">

            <!-- ========== Left Sidebar Start ========== -->
            <%@include file="admin_side_bar.jsp"%>
            <!-- Left Sidebar End -->



            <!-- ============================================================== -->
            <!-- Start right Content here -->
            <!-- ============================================================== -->

            <div class="content-page">

                <!-- Top Bar Start -->
                <%@include file="admin_top_bar.jsp"%>
                <!-- Top Bar End -->


                <!-- Start Page content -->
                <div class="content">
                    
                    <div class="container-fluid">

                        <div class="row" id="userView" style="display:none;padding: 5px;
														    border: 1px solid #34deea;
														    background: #d2e9ea;
														    border-radius: 11px;">
                            
                            <%-- <%@include file="admin_view_user.jsp"%> --%>
                            
                        </div>
                                         
                        <div class="row">
                            <div class="col-12">
                                <div class="card-box table-responsive">
                                    <h4 class="m-t-0 header-title">Employee List</h4>
                                    <p class="text-muted font-14 m-b-30">
                                        Check the employee status and their access activity.
                                    </p>
									
									
									<c:if test="${!empty empList}">	
									
		                                    <table id="datatable-buttons" class="table table-bordered table-bordered dt-responsive nowrap" cellspacing="0" width="100%">
		                                        
		                                        <thead>
			                                        <tr>
			                                        	<th>Sl No</th>
			                                            <th>Name</th>
			                                            <th>Email Id</th>
			                                            <th>Mobile</th>
			                                            <th>Start date</th>
			                                            <th>Status</th>
			                                            <th>Child</th>
			                                            <th>Action</th>
			                                        </tr>
		                                        </thead>
		
		                                        <tbody>
		                                        
		                                        <%int j = 1; %> 
		                                  		<c:forEach items="${userList}" var="val">
			                                        
			                                        <tr>
			                                        	<td><%=j++%></td>
			                                            <td>${val.first_name} ${val.last_name}</td>
			                                            <td>${val.email_id}</td>
			                                            <td>${val.mobile}</td>
			                                            <td><fmt:formatDate pattern="dd/MM/yyyy HH:mm:ss" value="${val.cr_date}" /></td>
			                                            <td>${val.account_status}</td>
			                                            <td>5</td>
			                                            <td><button type="button" class="btn btn-icon waves-effect waves-light btn-info" onclick="viewUser('${val.user_id}')"> <i class="mdi mdi-clipboard-account"></i> </button></td>
			                                        </tr>
		                                        
		                                        </c:forEach>
		                                        
		                                       </tbody>
		                                        
		                                    </table>
		                                    
		                               </c:if>
		                               
		                               <c:if test="${empty empList}">	
		                               
		                               		<div class="alert alert-danger alert-dismissible bg-danger text-white border-0 fade show" role="alert">
		                                
				                                As of now no employee assigned !
				                                
				                            </div>
		                       	
		                               			
		                               </c:if>
		                               
		                                     
                                </div>
                            </div>
                        </div>
                        <!-- end row -->

                        
                        
                    </div> <!-- container -->

                </div>  <!-- content -->

                <%@include file="footer.jsp"%>

            </div>


            <!-- ============================================================== -->
            <!-- End Right content here -->
            <!-- ============================================================== -->


        </div>
        <!-- END wrapper -->

       <%@include file="admin_common_script.jsp"%>

    </body>
</html>