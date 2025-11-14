<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %>

<html>
    <head>
       
        <meta charset="utf-8" />
        <title>Dashboard</title>
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
                                    <li class="breadcrumb-item"><a href="#">Elvinus</a></li>
                                    <li class="breadcrumb-item active">Dashboard</li>
                                </ol>
                            </div>
                            <h4 class="page-title">Dashboard</h4>
                        </div>
                    </div>
                </div>
                
                <!-- end page title end breadcrumb -->

				<div class="row">
                    
                    <div class="col-xs-12 col-md-6 col-lg-6 col-xl-3">
                        <div class="card-box tilebox-one">
                            <i class="icon-paypal float-right text-muted"></i>
                            <h6 class="text-muted text-uppercase mt-0">Total Referenced</h6>
                            <h2 class="m-b-20"><span data-plugin="counterup">${totalRefCount}</span></h2>
                            <!-- <span class="badge badge-danger"> 10/11/2018 </span> <span class="text-muted">Last reference</span> -->
                        </div>
                    </div>

                    <div class="col-xs-12 col-md-6 col-lg-6 col-xl-3">
                        <div class="card-box tilebox-one">
                            <i class="icon-paypal float-right text-muted"></i>
                            <h6 class="text-muted text-uppercase mt-0">Joined Referenced</h6>
                            <h2 class="m-b-20"><span data-plugin="counterup">${successRefCount}</span></h2>
                            <!-- <span class="badge badge-danger"> 10/11/2018 </span> <span class="text-muted">Last reference joined</span> -->
                        </div>
                    </div>

                    <div class="col-xs-12 col-md-6 col-lg-6 col-xl-3">
                        <div class="card-box tilebox-one">
                            <i class="icon-chart float-right text-muted"></i>
                            <h6 class="text-muted text-uppercase mt-0">Today's Credit</h6>
                            <h2 class="m-b-20"><span data-plugin="counterup">1</span></h2>
                            <!-- <span class="badge badge-custom"> 10/11/2018  </span> <span class="text-muted">Last ordered</span> -->
                        </div>
                    </div>

					<div class="col-xs-12 col-md-6 col-lg-6 col-xl-3">
                        <div class="card-box tilebox-one">
                            <i class="icon-layers float-right text-muted"></i>
                            <h6 class="text-muted text-uppercase mt-0">Total Credit</h6>
                            <h2 class="m-b-20" data-plugin="counterup">36.9</h2>
                            <!-- <span class="badge badge-custom"> 10/11/2018 </span> <span class="text-muted">Last credit amount</span> -->
                        </div>
                    </div>
                    
                    <!-- <div class="col-xs-12 col-md-6 col-lg-6 col-xl-3">
                        <div class="card-box tilebox-one">
                            <i class="icon-rocket float-right text-muted"></i>
                            <h6 class="text-muted text-uppercase mt-0">Total credit</h6>
                            <h2 class="m-b-20" data-plugin="counterup">0</h2>
                            <span class="badge badge-custom">&nbsp;</span> <span class="text-muted">&nbsp;</span>
                        </div>
                    </div> -->
                    
                </div>
                        
                    
                <!-- <div class="row">
                    <div class="col-lg-6">
                        <div class="card-box">
                            <h4 class="header-title">Order Overview</h4>

                            <div id="website-stats" style="height: 350px;" class="flot-chart mt-5"></div>

                        </div>
                    </div>

                    <div class="col-lg-6">
                        <div class="card-box">
                            <h4 class="header-title">Sales Overview</h4>

                            <div id="combine-chart">
                                <div id="combine-chart-container" class="flot-chart mt-5" style="height: 350px;">
                                
                                
                                </div>
                            </div>

                        </div>
                    </div>
                </div> -->
                <!-- end row -->


                <div class="row">
                    
                    <div class="col-lg-8">
                        
                        <div class="card-box">
                            
                            <h4 class="header-title mb-3">Recent Reference Status</h4>

                            <div class="table-responsive">
                                
                                <c:if test="${!empty recentRefActivity}">	
	                                
	                                <table class="table table-hover table-centered m-0">
	
	                                    <thead>
	                                    <tr>
	                                        <th>Name</th>
	                                        <th>Email Id</th>
	                                        <th>Status</th>
	                                        <th>Date</th>
	                                        <th>Action</th>
	                                    </tr>
	                                    </thead>
	                                    <tbody>
	                                    
	                                    <c:forEach items="${recentRefActivity}" var="val">
		                                    
		                                    <tr>
		                                        
		                                        <td>
		                                            <h5 class="m-0 font-weight-normal">${val.full_name}</h5>
		                                            <p class="mb-0 text-muted"><small>${val.mobile}</small></p>
		                                        </td>
												
												<td>
		                                            ${val.email_id}
		                                        </td>
		                                        
		                                        <td>
		                                            <!-- <i class="mdi mdi-currency-btc text-primary"></i>  -->${val.status}
		                                        </td>
		
		                                        <td>
		                                            <fmt:formatDate pattern="dd/MM/yyyy HH:mm:ss" value="${val.cr_date}" />
		                                        </td>
		
		                                        <td>
		                                            <a href="#" class="btn btn-sm btn-custom"><i class="mdi mdi-plus"></i></a>
		                                            <a href="#" class="btn btn-sm btn-danger"><i class="mdi mdi-minus"></i></a>
		                                        </td>
		                                    </tr>
	
	                                    </c:forEach>
	
	                                    </tbody>
	                                </table>
	                                
	                              </c:if>
	                                
                            </div>
                        </div>

                    </div>

                    <div class="col-lg-4">
                        <div class="card-box">
                            <h4 class="m-t-0 header-title">Recent Credit Status</h4>


                            <div class="table-responsive">
                                
                                <c:if test="${!empty recentCreActivity}">	
	                                
	                                <table class="table table-hover table-centered m-0">
	
	                                    <thead>
		                                    <tr>
		                                        <th>Date</th>
		                                        <th>Reward</th>
		                                        <th>Amount</th>
		                                        <th>Status</th>
		                                    </tr>
	                                    </thead>
	                                    
	                                    <tbody>
	                                    
	                                     <c:forEach items="${recentCreActivity}" var="val">
		                                    
		                                    <tr>
		                                        
		                                        <td>
		                                            <fmt:formatDate pattern="dd/MM/yyyy HH:mm:ss" value="${val.credit_date}" />
		                                        </td>
		
												<td>
		                                            ${val.credit_reward}
		                                        </td>
		                                        
		                                        <td>
		                                            <i class="mdi mdi-currency-btc text-primary"></i>${val.credit_amount}
		                                        </td>
												
												<td>${val.credit_status}</td>
		                                    
		                                    </tr>
	
	                                     </c:forEach>
	
	                                    </tbody>
	                                    
	                                </table>
	                                
	                              </c:if>
	                                
                            </div>

                        </div>

                    </div>
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