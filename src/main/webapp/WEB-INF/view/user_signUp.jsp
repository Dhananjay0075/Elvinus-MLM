<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta charset="utf-8" />
<title>Sign Up</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta
	content="A fully featured admin theme which can be used to build CRM, CMS, etc."
	name="description" />
<meta content="Coderthemes" name="author" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />

<!-- App favicon -->
<link rel="shortcut icon"
	href="resource/horizontal/assets/images/favicon.ico">

<!-- Plugins css -->
<link
	href="resource/plugins/bootstrap-timepicker/bootstrap-timepicker.min.css"
	rel="stylesheet">
<link
	href="resource/plugins/bootstrap-colorpicker/css/bootstrap-colorpicker.min.css"
	rel="stylesheet">
<link
	href="resource/plugins/bootstrap-datepicker/css/bootstrap-datepicker.min.css"
	rel="stylesheet">
<link
	href="resource/plugins/clockpicker/css/bootstrap-clockpicker.min.css"
	rel="stylesheet">
<link
	href="resource/plugins/bootstrap-daterangepicker/daterangepicker.css"
	rel="stylesheet">


<!-- App css -->
<link href="resource/horizontal/assets/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="resource/horizontal/assets/css/icons.css" rel="stylesheet"
	type="text/css" />
<link href="resource/horizontal/assets/css/style.css" rel="stylesheet"
	type="text/css" />

<script src="resource/horizontal/assets/js/modernizr.min.js"></script>


<!-- Sweet Alert css -->
        <link href="resource/plugins/sweet-alert/sweetalert2.min.css" rel="stylesheet" type="text/css" />
        
</head>

<body>

	<!-- Begin page -->
	<div class="accountbg"
		style="background: url('resource/horizontal/assets/images/1280x800_growing-plant.jpg'); background-size: cover;"></div>

	<div class="wrapper-page">
		<!-- account-page-full -->

		<div class="col-md-12">
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-8">
					<div class="card">
						<div class="card-block">

							<div class="account-box">

								<div class="card-box p-4 mb-0">
									<h2 class="text-uppercase text-center pb-3">

										<a href="userSignUp" class="text-success"> <span> <img
												src="resource/horizontal/assets/images/Elv_logo.png" alt="">
												<!-- 		Elvinus -->
										</span>
										</a> <span class="membership-cont"> MemberShip</span>
									</h2>

									<form:form class="form-horizontal" id="userRegForm"
										modelAttribute="userReg" method="post"
										action="saveUserRegister">
										
										<input type="hidden" name="uniaccid" value="<%=request.getAttribute("uniRefid")%>" />
										
										<div class="form-group row m-b-20">
											<div class="col-12">
												<label for="username">Reference Id <span
													class="text-danger">*</span></label> <input class="form-control"
													type="text" id="refer_by" value="<%=request.getAttribute("refAccId")%>" readonly
													required="" placeholder="Refered By">
											</div>
										</div>
										<div class="form-group row m-b-20">
											<div class="col-6">
												<label for="username">First Name <span
													class="text-danger">*</span></label> <input class="form-control"
													type="text" id="first_name" name="first_name" required=""
													placeholder="" value="<%=request.getAttribute("refFullName")%>">
												<ul class="parsley-errors-list filled">
													<li class="parsley-required regErr" id="fname_err"></li>
												</ul>

											</div>
											<div class="col-6">
												<label for="username">Last Name <span
													class="text-danger">*</span></label> <input class="form-control"
													type="text" id="last_name" name="last_name" required=""
													placeholder="">
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
													placeholder="" value="<%=request.getAttribute("refEmail")%>">
												<ul class="parsley-errors-list filled">
													<li class="parsley-required regErr" id="email_err"></li>
												</ul>
											</div>

											<div class="col-6">
												<label for="emailaddress">Mobile <span class="text-danger">*</span></label> 
												<input class="form-control" type="text" maxlength="10" id="mobile" name="mobile" required="" placeholder="" value="<%=request.getAttribute("refMobile")%>">
												<ul class="parsley-errors-list filled">
													<li class="parsley-required regErr" id="mobile_err"></li>
												</ul>
											</div>

										</div>

										<div class="form-group row m-b-20">
											<div class="col-6">
												<label for="password">Password <span
													class="text-danger">*</span></label> <input class="form-control"
													type="password" required="" id="password" name="password"
													placeholder="">
												<ul class="parsley-errors-list filled">
													<li class="parsley-required regErr" id="pw_err"></li>
												</ul>
											</div>
											<div class="col-6">
												<label for="password">Confirm Password <span
													class="text-danger">*</span></label> <input class="form-control"
													type="password" required="" id="cnfPassword" placeholder="">
												<ul class="parsley-errors-list filled">
													<li class="parsley-required regErr" id="cnfPw_err"></li>
												</ul>
											</div>
										</div>

										<!-- IDENTITY INFORMATION -->

										<div class="form-group row m-b-20">
											<div class="col-6">
												<label for="password">Pan Id <span
													class="text-danger">*</span></label> <input class="form-control"
													type="text" required="" id="pan_id" name="pan_id"
													placeholder="">
												<ul class="parsley-errors-list filled">
													<li class="parsley-required regErr" id="pan_err"></li>
												</ul>
											</div>
											<div class="col-6">
												<label for="password">Aadhar Id <span
													class="text-danger">*</span></label> <input class="form-control"
													type="text" required="" id="aadhar_id" name="aadhar_id"
													placeholder="">
												<ul class="parsley-errors-list filled">
													<li class="parsley-required regErr" id="aadhar_err"></li>
												</ul>
											</div>
										</div>

										<!-- ADDRESS INFORMATION -->

										<div class="form-group row m-b-20">
											<div class="col-6">
												<label for="password">Gender <span
													class="text-danger">*</span></label><br> <label><input
													type="radio" checked name="gender" value="Female">
													Female</label> <label><input type="radio" name="gender"
													value="Male"> Male</label>
												<ul class="parsley-errors-list filled">
													<li class="parsley-required regErr" id="gender_err"></li>
												</ul>
											</div>
											<div class="col-6">
												<label for="password">DOB <span class="text-danger">*</span></label>
												<input type="text" class="form-control"
													placeholder="mm/dd/yyyy" id="datepicker" name="dob">
												<ul class="parsley-errors-list filled">
													<li class="parsley-required regErr" id="dob_err"></li>
												</ul>
											</div>
										</div>

										<div class="form-group row m-b-20">
											<div class="col-12">
												<label for="password">Area <span class="text-danger">*</span></label>
												<input class="form-control" type="text" required=""
													id="area" name="area" placeholder="">
												<ul class="parsley-errors-list filled">
													<li class="parsley-required regErr" id="area_err"></li>
												</ul>
											</div>
										</div>

										<div class="form-group row m-b-20">
											<div class="col-6">
												<label for="password">City <span class="text-danger">*</span></label><br>
												<input class="form-control" type="text" required=""
													id="city" name="city" placeholder="">
												<ul class="parsley-errors-list filled">
													<li class="parsley-required regErr" id="city_err"></li>
												</ul>
											</div>
											<div class="col-6">
												<label for="password">State <span
													class="text-danger">*</span></label> <input class="form-control"
													type="text" required="" id="state" name="state"
													placeholder="">
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
													name="country" placeholder="">
												<ul class="parsley-errors-list filled">
													<li class="parsley-required regErr" id="country_err"></li>
												</ul>
											</div>
											
											<div class="col-6">
												<label for="password">Pincode <span
													class="text-danger">*</span></label> <input class="form-control"
													type="text" maxlength="6" required="" id="pincode"
													name="pincode" placeholder="">
												<ul class="parsley-errors-list filled">
													<li class="parsley-required regErr" id="pincode_err"></li>
												</ul>
											</div>
										</div>

										<!-- BANK INFORMATION -->

										<div class="form-group row m-b-20">
											<div class="col-6">
												<label for="password">Bank Name <span
													class="text-danger">*</span></label><br> <input
													class="form-control" type="text" required="" id="bank_name"
													name="bank_name" placeholder="">
												<ul class="parsley-errors-list filled">
													<li class="parsley-required regErr" id="bank_name_err"></li>
												</ul>
											</div>
											<div class="col-6">
												<label for="password">Account No <span
													class="text-danger">*</span></label> <input class="form-control"
													type="text" required="" id="bank_account_no"
													name="bank_account_no" placeholder="">
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
													id="bank_ifsc_code" name="bank_ifsc_code" placeholder="">
												<ul class="parsley-errors-list filled">
													<li class="parsley-required regErr" id="bank_ifsc_err"></li>
												</ul>
											</div>
											<div class="col-6">
												<label for="password">Account Holder Name <span
													class="text-danger">*</span></label> <input class="form-control"
													type="text" required="" id="bank_account_name"
													name="bank_account_name" placeholder="">
												<ul class="parsley-errors-list filled">
													<li class="parsley-required regErr" id="bank_ac_name_err"></li>
												</ul>
											</div>
										</div>


										<div class="form-group row m-b-20">

											<div class="col-12">

												<div class="checkbox checkbox-success">
													<input id="remember" type="checkbox"> <label
														for="remember">I accept <a href="#"
														class="text-success">Terms and Conditions</a></label>
													<ul class="parsley-errors-list filled">
														<li class="parsley-required regErr" id="termErrId"></li>
													</ul>
												</div>

											</div>

										</div>

										<div class="form-group row text-center m-t-10">
											<div class="col-12">
												<button id="userSignUpBtn"
													class="btn btn-success btn-custom waves-effect waves-light submit-btnwid"
													type="button">Sign Up</button>
											</div>
										</div>

									</form:form>

									<div class="row m-t-10">
										<div class="col-sm-12 text-center">
											<p class="text-muted">
												Already have an account? <a href="userSignIn"
													class="text-dark m-l-5"><b>Sign In</b></a>
											</p>
										</div>
									</div>

								</div>
							</div>

						</div>
					</div>
				</div>
				<div class="col-md-2"></div>
			</div>
		</div>

		<div class="m-t-40 text-center">
			<p class="account-copyright">2018 © Reserved By Elvinus</p>
		</div>

	</div>

	<%@include file="loader.jsp"%>

	<!-- jQuery  -->
	<script src="resource/horizontal/assets/js/jquery.min.js"></script>
	<script src="resource/horizontal/assets/js/popper.min.js"></script>
	<script src="resource/horizontal/assets/js/bootstrap.min.js"></script>
	<script src="resource/horizontal/assets/js/waves.js"></script>
	<script src="resource/horizontal/assets/js/jquery.slimscroll.js"></script>

	<!-- plugin js -->
	<script src="resource/plugins/moment/moment.js"></script>
	<script
		src="resource/plugins/bootstrap-timepicker/bootstrap-timepicker.js"></script>
	<script
		src="resource/plugins/bootstrap-colorpicker/js/bootstrap-colorpicker.min.js"></script>
	<script
		src="resource/plugins/clockpicker/js/bootstrap-clockpicker.min.js"></script>
	<script
		src="resource/plugins/bootstrap-daterangepicker/daterangepicker.js"></script>
	<script
		src="resource/plugins/bootstrap-datepicker/js/bootstrap-datepicker.min.js"></script>

	<!-- Init js -->
	<script
		src="resource/horizontal/assets/pages/jquery.form-pickers.init.js"></script>

	<!-- App js -->
	<script src="resource/horizontal/assets/js/jquery.core.js"></script>
	<script src="resource/horizontal/assets/js/jquery.app.js"></script>

	<script src="resource/user_script.js"></script>
	
	 <!-- Sweet Alert Js  -->
     <script src="resource/plugins/sweet-alert/sweetalert2.min.js"></script>
     <script src="resource/horizontal/assets/pages/jquery.sweet-alert.init.js"></script>
	
	 <script src="resource/user_script.js"></script>
	 

</body>
</html>