<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
     
<head>
   
    <meta charset="utf-8" />
    <title>Pricing</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta content="A fully featured admin theme which can be used to build CRM, CMS, etc." name="description" />
    <meta content="Coderthemes" name="author" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />

	<%@include file="admin_common_style.jsp"%>

</head>

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


                        <div class="row">
                            <div class="col-12">
                                <div class="card-box table-responsive">
                                    <h4 class="m-t-0 header-title">Direct Parent Pricing</h4>
                                    <p class="text-muted font-14 m-b-30">
                                        Manage the 
                                    </p>

                                    <table id="datatable-buttons" class="table table-striped table-bordered" cellspacing="0" width="100%">
                                        
                                        <thead>
	                                        <tr>
	                                            <th>Sl.No</th>
	                                            <th>Level</th>
	                                            <th>Mode</th>
	                                            <th>Reward</th>
	                                            <th>Action</th>
	                                        </tr>
                                        </thead>
										
										<c:forEach items="${directParentReward}" var="val">
	                                        
	                                        <tbody>
		                                        <tr>
		                                            <td>1</td>
		                                            <td>${val.credit_level}</td>
		                                            <td>${val.credit_mode}</td>
		                                            <td><input type="text" disabled value="${val.credit_reward}" id="creditReward" /></td>
		                                            <td><button id="" onclick="">Edit</button></td>
		                                        </tr>
	                                        </tbody>
                                       
                                       </c:forEach>
                                        
                                    </table>
                                </div>
                            </div>
                        </div>
                        <!-- end row -->
                        
                        
                        
                        <div class="row">
                            <div class="col-12">
                                <div class="card-box table-responsive">
                                    <h4 class="m-t-0 header-title">Indirect Parent Pricing</h4>
                                    <p class="text-muted font-14 m-b-30">
                                        Check the pricing details.
                                    </p>

                                    <table id="datatable-buttons1" class="table table-striped table-bordered" cellspacing="0" width="100%">
                                        
                                        <thead>
	                                        <tr>
	                                            <th>Sl.No</th>
	                                            <th>Level</th>
	                                            <th>Mode</th>
	                                            <th>Reward</th>
	                                            <th>Action</th>
	                                        </tr>
                                        </thead>
										
										<c:forEach items="${indirectParentReward}" var="val">
	                                        
	                                        <tbody>
		                                        <tr>
		                                            <td>1</td>
		                                            <td>${val.credit_level}</td>
		                                            <td>${val.credit_mode}</td>
		                                            <td><input type="text" disabled value="${val.credit_reward}" id="creditReward" /></td>
		                                            <td><button id="" onclick="">Edit</button></td>
		                                        </tr>
	                                        </tbody>
                                       
                                       </c:forEach>
                                    </table>
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

