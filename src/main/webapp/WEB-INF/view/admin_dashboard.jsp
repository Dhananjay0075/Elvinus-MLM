<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    
    <head>
       
        <meta charset="utf-8" />
        <title>Admin Dashboard</title>
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
                                <div class="card-box">
                                    <h4 class="header-title mb-4">Account Overview</h4>

                                    
                                    <div class="row text-center">
					                    <div class="col-sm-6 col-lg-6 col-xl-3">
					                        <div class="card-box widget-flat border-custom bg-custom text-white">
					                            <i class="fi-tag"></i>
					                            <h3 class="m-b-10">${membershipCount}</h3>
					                            <p class="text-uppercase m-b-5 font-13 font-600">Total Membership</p>
					                        </div>
					                    </div>
					                    <div class="col-sm-6 col-lg-6 col-xl-3">
					                        <div class="card-box bg-primary widget-flat border-primary text-white">
					                            <i class="fi-archive"></i>
					                            <h3 class="m-b-10">${total}</h3>
					                            <p class="text-uppercase m-b-5 font-13 font-600">Total Referenced</p>
					                        </div>
					                    </div>
					                    <div class="col-sm-6 col-lg-6 col-xl-3">
					                        <div class="card-box widget-flat border-success bg-success text-white">
					                            <i class="fi-help"></i>
					                            <h3 class="m-b-10">${successRef}</h3>
					                            <p class="text-uppercase m-b-5 font-13 font-600">Total Joined Reference</p>
					                        </div>
					                    </div>
					                    <div class="col-sm-6 col-lg-6 col-xl-3">
					                        <div class="card-box bg-danger widget-flat border-danger text-white">
					                            <i class="fi-delete"></i>
					                            <h3 class="m-b-10">${pendingRef}</h3>
					                            <p class="text-uppercase m-b-5 font-13 font-600">Total Not Joined From Reference</p>
					                        </div>
					                    </div>
					                </div>
                
                                    <div class="row">
                                        
                                        <div class="col-sm-6 col-lg-6 col-xl-3">
                                            <div class="card-box mb-0 widget-chart-two">
                                                <div class="float-right">
                                                    <input data-plugin="knob" data-width="80" data-height="80" data-linecap=round
                                                           data-fgColor="#0acf97" value="37" data-skin="tron" data-angleOffset="180"
                                                           data-readOnly=true data-thickness=".1"/>
                                                </div>
                                                <div class="widget-chart-two-content">
                                                    <p class="text-muted mb-0 mt-2">Daily Sales</p>
                                                    <h3 class="">$35,715</h3>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="col-sm-6 col-lg-6 col-xl-3">
                                            <div class="card-box mb-0 widget-chart-two">
                                                <div class="float-right">
                                                    <input data-plugin="knob" data-width="80" data-height="80" data-linecap=round
                                                           data-fgColor="#f9bc0b" value="92" data-skin="tron" data-angleOffset="180"
                                                           data-readOnly=true data-thickness=".1"/>
                                                </div>
                                                <div class="widget-chart-two-content">
                                                    <p class="text-muted mb-0 mt-2">Sales Analytics</p>
                                                    <h3 class="">$97,511</h3>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="col-sm-6 col-lg-6 col-xl-3">
                                            <div class="card-box mb-0 widget-chart-two">
                                                <div class="float-right">
                                                    <input data-plugin="knob" data-width="80" data-height="80" data-linecap=round
                                                           data-fgColor="#f1556c" value="14" data-skin="tron" data-angleOffset="180"
                                                           data-readOnly=true data-thickness=".1"/>
                                                </div>
                                                <div class="widget-chart-two-content">
                                                    <p class="text-muted mb-0 mt-2">Statistics</p>
                                                    <h3 class="">$954</h3>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="col-sm-6 col-lg-6 col-xl-3">
                                            <div class="card-box mb-0 widget-chart-two">
                                                <div class="float-right">
                                                    <input data-plugin="knob" data-width="80" data-height="80" data-linecap=round
                                                           data-fgColor="#2d7bf4" value="60" data-skin="tron" data-angleOffset="180"
                                                           data-readOnly=true data-thickness=".1"/>
                                                </div>
                                                <div class="widget-chart-two-content">
                                                    <p class="text-muted mb-0 mt-2">Total Revenue</p>
                                                    <h3 class="">$32,540</h3>
                                                </div>

                                            </div>
                                        </div>
                                        
                                    </div>
                                    <!-- end row -->
                                    
                                </div>
                            </div>
                        </div>
                        <!-- end row -->


                        <div class="row">
                            <div class="col-lg-8">
                                <div class="card-box">
                                    <h4 class="header-title mb-3">Wallet Balances</h4>

                                    <div class="table-responsive">
                                        <table class="table table-hover table-centered m-0">

                                            <thead>
	                                            <tr>
	                                                <th>Profile</th>
	                                                <th>Name</th>
	                                                <th>Currency</th>
	                                                <th>Balance</th>
	                                                <th>Reserved in orders</th>
	                                                <th>Action</th>
	                                            </tr>
                                            </thead>
                                            
                                            <tbody>
                                            <tr>
                                                <td>
                                                    <img src="resource/vertical/assets/images/users/avatar-2.jpg" alt="contact-img" title="contact-img" class="rounded-circle thumb-sm" />
                                                </td>

                                                <td>
                                                    <h5 class="m-0 font-weight-normal">Tomaslau</h5>
                                                    <p class="mb-0 text-muted"><small>Member Since 2017</small></p>
                                                </td>

                                                <td>
                                                    <i class="mdi mdi-currency-btc text-primary"></i> INR
                                                </td>

                                                <td>
                                                    0.00816117 
                                                </td>

                                                <td>
                                                    0.00097036 
                                                </td>

                                                <td>
                                                    <a href="#" class="btn btn-sm btn-custom"><i class="mdi mdi-plus"></i></a>
                                                    <a href="#" class="btn btn-sm btn-danger"><i class="mdi mdi-minus"></i></a>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td>
                                                    <img src="resource/vertical/assets/images/users/avatar-3.jpg" alt="contact-img" title="contact-img" class="rounded-circle thumb-sm" />
                                                </td>

                                                <td>
                                                    <h5 class="m-0 font-weight-normal">Erwin E. Brown</h5>
                                                    <p class="mb-0 text-muted"><small>Member Since 2017</small></p>
                                                </td>

                                                <td>
                                                    <i class="mdi mdi-currency-eth text-primary"></i> INR
                                                </td>

                                                <td>
                                                    3.16117008 
                                                </td>

                                                <td>
                                                    1.70360009 
                                                </td>

                                                <td>
                                                    <a href="#" class="btn btn-sm btn-custom"><i class="mdi mdi-plus"></i></a>
                                                    <a href="#" class="btn btn-sm btn-danger"><i class="mdi mdi-minus"></i></a>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <img src="resource/vertical/assets/images/users/avatar-4.jpg" alt="contact-img" title="contact-img" class="rounded-circle thumb-sm" />
                                                </td>

                                                <td>
                                                    <h5 class="m-0 font-weight-normal">Margeret V. Ligon</h5>
                                                    <p class="mb-0 text-muted"><small>Member Since 2017</small></p>
                                                </td>

                                                <td>
                                                    <i class="mdi mdi-currency-eur text-primary"></i> INR
                                                </td>

                                                <td>
                                                    25.08 
                                                </td>

                                                <td>
                                                    12.58 
                                                </td>

                                                <td>
                                                    <a href="#" class="btn btn-sm btn-custom"><i class="mdi mdi-plus"></i></a>
                                                    <a href="#" class="btn btn-sm btn-danger"><i class="mdi mdi-minus"></i></a>
                                                </td>
                                            </tr>
                                            

                                            </tbody>
                                        </table>
                                    </div>
                                </div>

                            </div>

                            <div class="col-lg-4">
                                <div class="card-box">
                                    <h4 class="m-t-0 header-title">Total Wallet Balance</h4>


                                    <div id="donut-chart">
                                        <div id="donut-chart-container" class="flot-chart mt-5" style="height: 340px;">
                                        </div>
                                    </div>

                                </div>

                            </div>
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