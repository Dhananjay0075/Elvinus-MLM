<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    
    <head>
       
        <meta charset="utf-8" />
        <title>Notification</title>
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

                            <!-- Right Sidebar -->
                            <div class="col-lg-12">
                                <div class="card-box">
                                    
                                    
                                    <div class="inbox-rightbar" style="margin-left: 0px;">

                                        <div class="" role="toolbar">
                                            
                                            <div class="btn-group">
		                                    	<a href="#" class="btn btn-danger btn-block waves-effect waves-light">Delete</a>
		                                    </div>
		                                    
                                            
                                        </div>

                                        <div class="">
                                            <div class="mt-4">
                                                <div class="">
                                                    
                                                     <%@include file="user_notification_list.jsp"%>
                                                    
                                                </div>

                                            </div> <!-- panel body -->
                                        </div> <!-- panel -->

                                        
                                    </div>

                                    <div class="clearfix"></div>
                                </div>

                            </div> <!-- end Col -->

                        </div><!-- End row -->

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