<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    
    <head>
       
        <meta charset="utf-8" />
        <title>Settings</title>
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
                   <div class="col-md-12">
                        <div class="card-box">
                            <ul class="nav nav-pills navtab-bg nav-justified pull-in ">
                                <li class="nav-item">
                                    <a href="#home1" data-toggle="tab" aria-expanded="true" class="nav-link active">
                                        <i class="fa fa-address-card-o"></i> Account
                                    </a>
                                </li>
                                <li class="nav-item">
                                    <a href="#profile1" data-toggle="tab" aria-expanded="false" class="nav-link">
                                        <i class="fa fa-home"></i>Password
                                    </a>
                                </li>
                                
                            </ul>
                            
                            <div class="tab-content">
                                <div class="tab-pane show active" id="home1">
                                    
                                     <div class="card-box">
			                            <h4 class="header-title m-t-0">Account Details</h4>
			                            <p class="text-muted font-14 m-b-20">
			                                Update your account details.
			                            </p>
			
			                            <form id="adminAccountForm" name="adminAccountForm">
			                              	 
			                              	 <div class="form-group row m-b-20">
												<div class="col-6">
													<label for="username">Username <span
														class="text-danger">*</span></label> <input class="form-control"
														type="text" id="admin_user_id" name="admin_user_id" required=""
														placeholder="" value="${adminData.admin_user_id}">
													<ul class="parsley-errors-list filled">
														<li class="parsley-required regErr" id="fname_err"></li>
													</ul>
			
												</div>
												<div class="col-6">
													<label for="username">Full Name <span
														class="text-danger">*</span></label> <input class="form-control"
														type="text" id="admin_name" name="admin_name" required=""
														placeholder="" value="${adminData.admin_name}">
													<ul class="parsley-errors-list filled">
														<li class="parsley-required regErr" id="lname_err"></li>
													</ul>
												</div>
											</div>
											
			                                <div class="form-group row m-b-20">
			
												<div class="col-6">
													<label for="emailaddress">Designation <span class="text-danger">*</span></label> 
														<input class="form-control" type="text" id="admin_designation" name="admin_designation" required=""
														placeholder="" value="${adminData.admin_designation}">
													<ul class="parsley-errors-list filled">
														<li class="parsley-required regErr" id="email_err"></li>
													</ul>
												</div>
			
												<div class="col-6">
													<label for="emailaddress">Photo <span class="text-danger">*</span></label> 
													<input class="form-control" type="file" id="file" name="file">
													<ul class="parsley-errors-list filled">
														<li class="parsley-required regErr" id="mobile_err"></li>
													</ul>
												</div>
			
											</div>
												
			                                <div class="form-group text-right m-b-0">
			                                    <button class="btn btn-custom waves-effect waves-light" onclick="updateAdminAccount()">Update</button>
			                                </div>
			
			                            </form>
			                        </div> 
                                     
                                </div>
                               
                                <div class="tab-pane" id="profile1">
                                   
                                    <div class="card-box">
			                            <p class="text-muted font-14 m-b-20">
			                                Change password
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


                        

                        
                        

                    </div> <!-- container -->

                </div> <!-- content -->

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