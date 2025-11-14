<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
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
                                    <li class="breadcrumb-item active">Account</li>
                                </ol>
                            </div>
                            <h4 class="page-title">Manage Account details</h4>
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
                                        <i class="fa fa-address-card-o"></i> Account
                                    </a>
                                </li>
                                <li class="nav-item">
                                    <a href="#profile1" data-toggle="tab" aria-expanded="false" class="nav-link">
                                        <i class="fa fa-home"></i>Address
                                    </a>
                                </li>
                                <li class="nav-item">
                                    <a href="#messages1" data-toggle="tab" aria-expanded="false" class="nav-link">
                                        <i class="fa fa-bank"></i> Bank
                                    </a>
                                </li>
                                <!-- <li class="nav-item">
                                    <a href="#settings1" data-toggle="tab" aria-expanded="false" class="nav-link">
                                        <i class="fi-cog mr-2"></i> Settings
                                    </a>
                                </li> -->
                            </ul>
                            
                            <div class="tab-content">
                                <div class="tab-pane show active" id="home1">
                                    
                                     <div class="card-box">
			                            <h4 class="header-title m-t-0">Account Details</h4>
			                            <p class="text-muted font-14 m-b-20">
			                                Update your account details.
			                            </p>
			
			                            <form:form id="userAccountForm" name="userAccountForm" modelAttribute="user">
			                              	 
			                              	 <div class="form-group row m-b-20">
												<div class="col-6">
													<label for="username">First Name <span
														class="text-danger">*</span></label> <input class="form-control"
														type="text" id="first_name" name="first_name" required=""
														placeholder="" value="${user.first_name}">
													<ul class="parsley-errors-list filled">
														<li class="parsley-required regErr" id="fname_err"></li>
													</ul>
			
												</div>
												<div class="col-6">
													<label for="username">Last Name <span
														class="text-danger">*</span></label> <input class="form-control"
														type="text" id="last_name" name="last_name" required=""
														placeholder="" value="${user.last_name}">
													<ul class="parsley-errors-list filled">
														<li class="parsley-required regErr" id="lname_err"></li>
													</ul>
												</div>
											</div>
											
			                                <div class="form-group row m-b-20">
			
												<div class="col-6">
													<label for="emailaddress">Email address <span
														class="text-danger">*</span></label> <input class="form-control"
														type="email" id="email_id" name="email_id" required=""
														placeholder="" value="${user.email_id}">
													<ul class="parsley-errors-list filled">
														<li class="parsley-required regErr" id="email_err"></li>
													</ul>
												</div>
			
												<div class="col-6">
													<label for="emailaddress">Mobile <span class="text-danger">*</span></label> 
													<input class="form-control" type="text" maxlength="10" id="mobile" name="mobile" required="" placeholder="" value="${user.mobile}">
													<ul class="parsley-errors-list filled">
														<li class="parsley-required regErr" id="mobile_err"></li>
													</ul>
												</div>
			
											</div>
													
			                                <div class="form-group row m-b-20">
												<div class="col-6">
													<label for="password">Pan Id <span
														class="text-danger">*</span></label> <input class="form-control"
														type="text" required="" id="pan_id" name="pan_id"
														placeholder="" value="${user.pan_id}">
													<ul class="parsley-errors-list filled">
														<li class="parsley-required regErr" id="pan_err"></li>
													</ul>
												</div>
												
												<div class="col-6">
													<label for="password">Aadhar Id <span class="text-danger">*</span></label> 
													<input class="form-control"
														type="text" required="" id="aadhar_id" name="aadhar_id"
														placeholder="" value="${user.aadhar_id}">
													<ul class="parsley-errors-list filled">
														<li class="parsley-required regErr" id="aadhar_err"></li>
													</ul>
												</div>
												
											</div>
											
											<div class="form-group row m-b-20">
												
												<div class="col-6">
													
													<label for="password">Gender <span class="text-danger">*</span></label><br> 
														
														<c:if test = "${user.gender == 'Female'}">
															<label><input type="radio" checked name="gender" value="Female"> Female</label>
															<label><input type="radio" name="gender" value="Male"> Male</label>
														</c:if>
														
														<c:if test = "${user.gender == 'Male'}">
															<label><input type="radio" name="gender" value="Female"> Female</label>
															<label><input type="radio" checked name="gender" value="Male"> Male</label>
														</c:if>
														
													<ul class="parsley-errors-list filled">
														<li class="parsley-required regErr" id="gender_err"></li>
													</ul>
												</div>
												
												<div class="col-6">
													<label for="password">DOB <span class="text-danger">*</span></label>
													<input type="text" class="form-control" placeholder="dd/mm/yyyy" id="datepicker" name="dob" value="<fmt:formatDate pattern='dd/MM/yyyy' value='${user.dob}'/>">
													<ul class="parsley-errors-list filled">
														<li class="parsley-required regErr" id="dob_err"></li>
													</ul>
												</div>
												
											</div>
											
											<div class="form-group row m-b-20">
												
												<div class="col-6">
													<label for="password">Profile Picture <span class="text-danger"></span></label>
													<input type="file" class="btn-light" id="file" name="file">
													<ul class="parsley-errors-list filled">
														<li class="parsley-required regErr" id="file_err"></li>
													</ul>
												</div>
												
											</div>
											
			
			                                <div class="form-group text-right m-b-0">
			                                    <button class="btn btn-custom waves-effect waves-light" type="button" onclick="updateAccount('Account')">Submit</button>
			                                    <button type="reset" class="btn btn-light waves-effect m-l-5">Cancel</button>
			                                </div>
			
			                            </form:form>
			                            
			                        </div> 
                                     
                                </div>
                               
                                <div class="tab-pane" id="profile1">
                                   
                                    <div class="card-box">
			                            <h4 class="header-title m-t-0">Address Details</h4>
			                            <p class="text-muted font-14 m-b-20">
			                                Update address details.
			                            </p>
			
			                            <form class="" id="userAddressForm" name="userAddressForm">
			                                
			                                <div class="form-group row m-b-20">
												<div class="col-12">
													<label for="password">Area <span class="text-danger">*</span></label>
													<input class="form-control" type="text" required=""
														id="area" name="area" placeholder="" value="${user.area}">
													<ul class="parsley-errors-list filled">
														<li class="parsley-required regErr" id="area_err"></li>
													</ul>
												</div>
											</div>
												
			                                <div class="form-group row m-b-20">
												<div class="col-6">
													<label for="password">City <span class="text-danger">*</span></label><br>
													<input class="form-control" type="text" required=""
														id="city" name="city" placeholder="" value="${user.city}">
													<ul class="parsley-errors-list filled">
														<li class="parsley-required regErr" id="city_err"></li>
													</ul>
												</div>
												<div class="col-6">
													<label for="password">State <span
														class="text-danger">*</span></label> <input class="form-control"
														type="text" required="" id="state" name="state"
														placeholder="" value="${user.state}">
													<ul class="parsley-errors-list filled">
														<li class="parsley-required regErr" id="state_err"></li>
													</ul>
												</div>
											</div>
			                                
			                                <div class="form-group row m-b-20">
												<div class="col-6">
													<label for="password">Country <span
														class="text-danger">*</span></label><br> <input
														class="form-control" type="text" required="" id="country"
														name="country" placeholder="" value="${user.country}">
													<ul class="parsley-errors-list filled">
														<li class="parsley-required regErr" id="country_err"></li>
													</ul>
												</div>
												
												<div class="col-6">
													<label for="password">Pincode <span
														class="text-danger">*</span></label> <input class="form-control"
														type="text" maxlength="6" required="" id="pincode"
														name="pincode" placeholder="" value="${user.pincode}">
													<ul class="parsley-errors-list filled">
														<li class="parsley-required regErr" id="pincode_err"></li>
													</ul>
												</div>
											</div>
			                                
			                                <div class="form-group text-right m-b-0">
			                                    <button class="btn btn-custom waves-effect waves-light" type="submit">
			                                        Submit
			                                    </button>
			                                    <button type="reset" class="btn btn-light waves-effect m-l-5">
			                                        Cancel
			                                    </button>
			                                </div>
			                                
			                            </form>
			                        </div>
			                        
                                </div>
                                
                                <div class="tab-pane" id="messages1">
                                    
                                     <div class="card-box">
			                            <h4 class="header-title m-t-0">Bank Details</h4>
			                            <p class="text-muted font-14 m-b-20">
			                                Manage your bank account information.
			                            </p>
			
			                            <form id="userBankForm" name="userBankForm">
			
			                                <div class="form-group row m-b-20">
												<div class="col-6">
													<label for="password">Bank Name <span
														class="text-danger">*</span></label><br> <input
														class="form-control" type="text" required="" id="bank_name"
														name="bank_name" placeholder="" value="${user.bank_name}">
													<ul class="parsley-errors-list filled">
														<li class="parsley-required regErr" id="bank_name_err"></li>
													</ul>
												</div>
												<div class="col-6">
													<label for="password">Account No <span
														class="text-danger">*</span></label> <input class="form-control"
														type="text" required="" id="bank_account_no"
														name="bank_account_no" placeholder="" value="${user.bank_account_no}">
													<ul class="parsley-errors-list filled">
														<li class="parsley-required regErr" id="bank_acc_err"></li>
													</ul>
												</div>
											</div>
										
			                                <div class="form-group row m-b-20">
												<div class="col-6">
													<label for="password">IFSC Code <span
														class="text-danger">*</span></label><br> <input
														class="form-control" type="text" required=""
														id="bank_ifce_code" name="bank_ifce_code" placeholder="" value="${user.bank_ifce_code}">
													<ul class="parsley-errors-list filled">
														<li class="parsley-required regErr" id="bank_ifsc_err"></li>
													</ul>
												</div>
												<div class="col-6">
													<label for="password">Account Holder Name <span
														class="text-danger">*</span></label> <input class="form-control"
														type="text" required="" id="bank_account_name"
														name="bank_account_name" placeholder="" value="${user.bank_account_name}">
													<ul class="parsley-errors-list filled">
														<li class="parsley-required regErr" id="bank_ac_name_err"></li>
													</ul>
												</div>
											</div>
			                                
			
			                                <div class="form-group text-right m-b-0">
			                                    <button class="btn btn-custom waves-effect waves-light" type="button">
			                                        Submit
			                                    </button>
			                                    <button type="reset" class="btn btn-light waves-effect m-l-5">
			                                        Cancel
			                                    </button>
			                                </div>
			                                
			                            </form>
			
			                        </div> <!-- end card-box -->
                                     
                                </div>
                                
                                <div class="tab-pane" id="settings1">
                                   
                                   	
                                    
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