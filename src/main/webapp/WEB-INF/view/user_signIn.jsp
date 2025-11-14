<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<title>Sign In</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta
	content="A fully featured admin theme which can be used to build CRM, CMS, etc."
	name="description" />
<meta content="Coderthemes" name="author" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- App favicon -->
<link rel="shortcut icon"
	href="resource/horizontal/assets/images/favicon.ico">

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

<body onload="showActivateAlert()">

	<!-- Begin page -->
	<div class="accountbg"
		style="background: url('resource/horizontal/assets/images/1280x800_growing-plant.jpg'); background-size: cover;"></div>

	<div class="wrapper-page">
		<!--  account-page-full -->
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-6">
					<div class="card m-t-50">
						<div class="card-block">

							<div class="account-box">

								<div class="card-box p-4 mb-0">
									<h2 class="text-uppercase text-center pb-3">
										<a href="userSignIn" class="text-success"> <span>
  											<img src="resource/horizontal/assets/images/Elv_logo.png" alt="" > 
										</span>
										</a> <span class="membership-cont"> MemberShip</span>
									</h2>
									
									<%if(!((String)request.getAttribute("actionMessage")).equals("NA")){ %>
									
											<ul class="parsley-errors-list filled">
												<li class="parsley-required" ><%=(String)request.getAttribute("actionMessage")%></li>
											</ul>
											
											<input type="hidden" value="<%=request.getAttribute("actionMessage")%>" id="actionId" />
									
									<%} %>
									
									<form:form class="" action="authUserCredential" modelAttribute="userReg" method="post">

										<div class="form-group m-b-20 row">
											<div class="col-12">
												<label for="emailaddress">Email address</label> <input
													class="form-control" type="email" id="emailaddress"
													required="" name="email_id"  placeholder="">
											</div>
										</div>

										<div class="form-group row m-b-20">
											<div class="col-12">
												
												<a href="#" class="text-muted pull-right"><small>Forgot your password?</small></a> 
														
												<label for="password">Password</label> 
												
												<input class="form-control" type="password" required="" name="password" id="password" placeholder="">
											</div>
										</div>

										<div class="form-group row text-center m-t-10">
											<div class="col-12">
												<button
													class="btn btn-success btn-custom waves-effect waves-light submit-btnwid"
													type="submit">Sign In</button>
											</div>
										</div>

									</form:form>

									<div class="row m-t-10">
										<div class="col-sm-12 text-center">
											<p class="text-muted">
												Don't have an account? <a href="userSignUp"
													class="text-dark m-l-5"><b>Sign Up</b></a>
											</p>
										</div>
									</div>

								</div>
							</div>

						</div>
					</div>
				</div>
				<div class="col-md-3"></div>
			</div>
		</div>

		<div class="m-t-40 text-center">
			<p class="account-copyright">2018 © Reserved By Elvinus</p>
		</div>

	</div>


	<!-- jQuery  -->
	<script src="resource/horizontal/assets/js/jquery.min.js"></script>
	<script src="resource/horizontal/assets/js/popper.min.js"></script>
	<script src="resource/horizontal/assets/js/bootstrap.min.js"></script>
	<script src="resource/horizontal/assets/js/waves.js"></script>
	<script src="resource/horizontal/assets/js/jquery.slimscroll.js"></script>

	<!-- App js -->
	<script src="resource/horizontal/assets/js/jquery.core.js"></script>
	<script src="resource/horizontal/assets/js/jquery.app.js"></script>
	
	 <!-- Sweet Alert Js  -->
     <script src="resource/plugins/sweet-alert/sweetalert2.min.js"></script>
     <script src="resource/horizontal/assets/pages/jquery.sweet-alert.init.js"></script>
	
	 <script src="resource/user_script.js"></script>
	 
	 
	 <p>Google Review </p>
	 <div id="google-reviews"></div>

	<link rel="stylesheet" href="https://cdn.rawgit.com/stevenmonson/googleReviews/master/google-places.css">
	<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script> -->
	<script src="https://cdn.rawgit.com/stevenmonson/googleReviews/6e8f0d79/google-places.js"></script>
	<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&key=AIzaSyDeivU57j-macv2fXXgbhKGM6cqMLmnAFI&signed_in=true&libraries=places"></script>
	
	<script>
		jQuery(document).ready(function( $ ) {
		   $("#google-reviews").googlePlaces({
		        placeId: 'ChIJbU60yXAWrjsR4E9-UejD3_g' //Find placeID @: https://developers.google.com/places/place-id
		      , render: ['reviews']
		      , min_rating: 4
		      , max_rows:4
		   });
		});
	</script>

</body>
</html>