<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta charset="utf-8" />
        <title>Admin</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
        <meta content="A fully featured admin theme which can be used to build CRM, CMS, etc." name="description" />
        <meta content="Coderthemes" name="author" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />

        <!-- App favicon -->
        <link rel="shortcut icon" href="resource/vertical/assets/images/favicon.ico">

        <!-- App css -->
        <link href="resource/vertical/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="resource/vertical/assets/css/icons.css" rel="stylesheet" type="text/css" />
        <link href="resource/vertical/assets/css/metismenu.min.css" rel="stylesheet" type="text/css" />
        <link href="resource/vertical/assets/css/style.css" rel="stylesheet" type="text/css" />

        <script src="resource/vertical/assets/js/modernizr.min.js"></script>

    </head>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    <body class="account-pages">

        <!-- Begin page -->
        <div class="accountbg" style="background: url('resource/vertical/assets/images/bg-3.jpg');background-size: cover;"></div>

        <div class="wrapper-page account-page-full">

            <div class="card">
                <div class="card-block">

                    <div class="account-box">

                        <div class="card-box p-5">
                            
                            <h2 class="text-uppercase text-center pb-3">
								<a href="userSignIn" class="text-success"> <span>
											<img src="resource/horizontal/assets/images/Elv_logo.png" alt="" > 
								</span>
								<br>
								</a> <span class="membership-cont"> Admin</span>
							</h2>
							
							
							<%if(!((String)request.getAttribute("actionMessage")).equals("NA")){ %>
									
								<ul class="parsley-errors-list filled">
									<li class="parsley-required" ><%=(String)request.getAttribute("actionMessage")%></li>
								</ul>
							
							<%} %>
							
                            <form:form modelAttribute="adminDetails"  method="post" action="authAdminCredential" class="form-horizontal" >
			
                                <div class="form-group m-b-20 row">
                                    <div class="col-12">
                                        <label for="emailaddress">Username</label>
                                        <input class="form-control" type="text" id="emailaddress" name="admin_user_id" required="" placeholder="Username">
                                    </div>
                                </div>

                                <div class="form-group row m-b-20">
                                    <div class="col-12">
                                        <label for="password">Password</label>
                                        <input class="form-control" type="password" required="" id="password" name="admin_password" placeholder="Enter your password">
                                    </div>
                                </div>

                                

                                <div class="form-group row text-center m-t-10">
                                    <div class="col-12">
                                        <button class="btn btn-block btn-custom waves-effect waves-light" type="submit">Sign In</button>
                                    </div>
                                </div>

                           </form:form>

                            

                        </div>
                    </div>

                </div>
            </div>

            <div class="m-t-40 text-center">
                <p class="account-copyright">2018 © Reserved By. - Elvinus</p>
            </div>

        </div>



        <!-- jQuery  -->
        <script src="resource/vertical/assets/js/jquery.min.js"></script>
        <script src="resource/vertical/assets/js/popper.min.js"></script>
        <script src="resource/vertical/assets/js/bootstrap.min.js"></script>
        <script src="resource/vertical/assets/js/metisMenu.min.js"></script>
        <script src="resource/vertical/assets/js/waves.js"></script>
        <script src="resource/vertical/assets/js/jquery.slimscroll.js"></script>

        <!-- App js -->
        <script src="resource/vertical/assets/js/jquery.core.js"></script>
        <script src="resource/vertical/assets/js/jquery.app.js"></script>

    </body>
</html>