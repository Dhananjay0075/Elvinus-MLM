<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    
  <head>
     
      <meta charset="utf-8" />
      <title>Reports</title>
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
                                  <h4 class="m-t-0 header-title">Manage Reports</h4>
                                  
                                  <p class="text-muted font-14 m-b-30">
                                     Manage reports for all transaction, credit etc
                                  </p>

                                  <table id="datatable-buttons" class="table table-striped table-bordered" cellspacing="0" width="100%">
                                      <thead>
	                                      <tr>
	                                          <th>Name</th>
	                                          <th>Email Id</th>
	                                          <th>Mobile</th>
	                                          <th>Start date</th>
	                                          <th>Status</th>
	                                          <th>Child</th>
	                                          <th>Action</th>
	                                      </tr>
                                      </thead>


                                      <tbody>
                                      <tr>
                                          <td>Tiger Nixon</td>
                                          <td>abc@gmail.com</td>
                                          <td>9036007668</td>
                                          <td>06/11/2018</td>
                                          <td>Success</td>
                                          <td>5</td>
                                          <td></td>
                                      </tr>
                                      
                                      </tbody>
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