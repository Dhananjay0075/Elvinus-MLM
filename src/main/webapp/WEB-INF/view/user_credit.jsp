<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.text.SimpleDateFormat" %><%@ page import="java.util.Date" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
 
<html>
    <head>
       
        <meta charset="utf-8" />
        <title>Credit</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
        <meta content="A fully featured admin theme which can be used to build CRM, CMS, etc." name="description" />
        <meta content="Coderthemes" name="author" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />

		<%@include file="user_common_style.jsp"%>
		 
    </head>

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
                                    <li class="breadcrumb-item"><a href="#">User</a></li>
                                    <li class="breadcrumb-item active">Credit</li>
                                </ol>
                            </div>
                            <h4 class="page-title">Credit</h4>
                        </div>
                    </div>
                </div>
                <!-- end page title end breadcrumb -->

                <div class="row">
                    <div class="col-12">
                        <div class="card-box">
                            <h4 class="header-title">Check Credit Status</h4>

                            <div class="text-center mt-4 mb-4">
                                <div class="row">
                                    <div class="col-xs-6 col-sm-4">
                                        <div class="card-box widget-flat border-custom bg-custom text-white">
                                            <i class="fi-tag"></i>
                                            <h3 class="m-b-10">
                                            		<c:if test="${!empty today}">${today}</c:if>
                                            		<c:if test="${empty today}">0</c:if>	
                                            </h3>
                                            <p class="text-uppercase m-b-5 font-13 font-600">Today's earning</p>
                                        </div>
                                    </div>
                                    <div class="col-xs-6 col-sm-4">
                                        <div class="card-box bg-primary widget-flat border-primary text-white">
                                            <i class="fi-archive"></i>
                                            <h3 class="m-b-10">
                                            	<c:if test="${!empty montly}">${montly}</c:if>
                                            	<c:if test="${empty montly}">0</c:if>	
                                           </h3>
                                            <p class="text-uppercase m-b-5 font-13 font-600"><%=new SimpleDateFormat("MMMM").format(new Date())%> month earning</p>
                                        </div>
                                    </div>
                                    <div class="col-xs-6 col-sm-4">
                                        <div class="card-box bg-danger widget-flat border-danger text-white">
                                            <i class="fi-delete"></i>
                                            <h3 class="m-b-10">
                                            	<c:if test="${!empty total}">${total}</c:if>
                                            	<c:if test="${empty total}">0</c:if>	
                                            </h3>
                                            <p class="text-uppercase m-b-5 font-13 font-600">Total earning</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
						    
						    
						    
						    
						    <c:if test="${!empty creditList}">	
						    
                            <table class="table table-hover m-0 tickets-list table-actions-bar dt-responsive nowrap" cellspacing="0" width="100%" id="datatable">
                                
                                <thead>
	                                <tr>
	                                    <th>Sl No</th>
	                                    <th>Credit For</th>
	                                    <th>Credit Mode</th>
	                                    <th>Reward</th>
	                                    <th>Amount</th>
	                                    <th>Credited Date</th>
	                                    <th>Status</th>
	                                    <th class="hidden-sm">Action</th>
	                                </tr>
                                </thead>

                                <tbody>
                                 	
                                 	 <%int i = 1; %> 
	                                 <c:forEach items="${creditList}" var="val">
		                                 
		                                 <tr>
		                                    <td><b><%=i++%></b></td>
		                                    
		                                    <td>
		                                        <span class="ml-2">Referral reward</span>
		                                    </td>
		
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
		                                
		                                Till now nothing has credited to your account !
		                                
		                            </div>
                            
                            </c:if>
                            
                            
                        </div>
                    </div><!-- end col -->
                </div>
                <!-- end row -->

            </div> <!-- end container -->
        </div>
        <!-- end wrapper -->


        <!-- Footer -->
        <%@include file="footer.jsp"%>
        <!-- End Footer -->


       
		<%@include file="user_common_script.jsp"%>
		
    </body>
</html>