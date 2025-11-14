<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta charset="utf-8" />
        <title>Account</title>
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
                                    <li class="breadcrumb-item active">Password Setting</li>
                                </ol>
                            </div>
                            <h4 class="page-title">Manage Password</h4>
                        </div>
                    </div>
                </div>
                <!-- end page title end breadcrumb -->

                <div class="row">
                   <div class="col-md-12">
                        <div class="card-box">
                            <ul class="nav nav-pills navtab-bg nav-justified pull-in ">
                                <li class="nav-item">
                                    <a href="#home1" data-toggle="tab" aria-expanded="true" class="nav-link active">
                                        <i class="fa fa-key"></i> Change password
                                    </a>
                                </li>
                                
                            </ul>
                            
                            <div class="tab-content">
                                <div class="tab-pane show active" id="home1">
                                    
                                     <div class="card-box">
			                            <h4 class="header-title m-t-0">Reset Password</h4>
			                            <p class="text-muted font-14 m-b-20">
			                                Update your password details.
			                            </p>
			
			                            <form action="#">
			                              	 
			                              	 <div class="form-group row m-b-20">
												<div class="col-4">
													<label for="username">Current Password <span class="text-danger">*</span></label> 
														<input class="form-control" type="password" id="cur_pw" name="cur_pw" required="">
													<ul class="parsley-errors-list filled">
														<li class="parsley-required regErr" id="curPw_err"></li>
													</ul>
			
												</div>
												<div class="col-4">
													<label for="username">New Password<span
														class="text-danger">*</span></label> 
														<input class="form-control" type="password" id="new_pw" name="new_pw" required="">
													<ul class="parsley-errors-list filled">
														<li class="parsley-required regErr" id="newPw_err"></li>
													</ul>
												</div>
												<div class="col-4">
													<label for="username">Confirm New Password<span
														class="text-danger">*</span></label> 
														<input class="form-control" type="password" id="cnf_pw" name="cnf_pw" required="" >
													<ul class="parsley-errors-list filled">
														<li class="parsley-required regErr" id="cnfPw_err"></li>
													</ul>
												</div>
											</div>
											
			                                <div class="form-group text-right m-b-0">
			                                    <button class="btn btn-custom waves-effect waves-light" type="button" id="resetPassword">
			                                        Submit
			                                    </button>
			                                    <button type="reset" class="btn btn-light waves-effect m-l-5">
			                                        Reset
			                                    </button>
			                                </div>
			
			                            </form>
			                        </div> 
                                     
                                </div>
                               
                                
                                
                            </div>
                        </div>
                    </div> <!-- end col -->
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