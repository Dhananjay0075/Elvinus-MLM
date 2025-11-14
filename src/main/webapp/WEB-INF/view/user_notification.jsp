<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

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
                                    <li class="breadcrumb-item"><a href="#">Notification</a></li>
                                </ol>
                            </div>
                            <h4 class="page-title">Message</h4>
                        </div>
                    </div>
                </div>
                <!-- end page title end breadcrumb -->


                    <!-- Right Sidebar -->
                    <div class="col-lg-12">
                        <div class="card-box" style="">
                            
                            <div class="inbox-rightbar" style="margin-left: 0px;">

                                <div class="" id="deleteDiv" role="toolbar" style="display:none;">
                                    
                                    <div class="btn-group">
                                    	<a href="#" class="btn btn-danger btn-block waves-effect waves-light">Delete</a>
                                    </div>
                                    
                                </div>

                                <div class="">
                                    <div class="mt-4">
                                        <div class="" id="notificationList">
                                            
                                            <%@include file="user_notification_list.jsp"%>
                                            
                                        </div>

                                    </div> <!-- panel body -->
                                    
                                </div> <!-- panel -->

                            </div>

                            <div class="clearfix"></div>
                        </div>

                    </div> <!-- end Col -->

                </div><!-- End row -->


            </div> <!-- end container -->
        </div>
        
        
        <!-- end wrapper -->


        <!-- Footer -->
        <%@include file="footer.jsp"%>
        <!-- End Footer -->


       
		<%@include file="user_common_script.jsp"%>
		
    </body>
</html>