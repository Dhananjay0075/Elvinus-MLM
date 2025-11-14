<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>

<div class="topbar-main">
    <div class="container-fluid">

        <!-- Logo container-->
        <div class="logo">
            
            <!-- Text Logo -->
            <a href="userDashboard" class="logo">
               <img src="resource/horizontal/assets/images/Elv_logo.png" alt="" height="36" class="logo-small">
                <img src="resource/horizontal/assets/images/Elv_logo.png" alt="" height="42" class="logo-large">
            
            </a>
            <!-- Image Logo -->
           <!--  <a href="userDashboard" class="logo">
                
                <img src="resource/horizontal/assets/images/Elv_logo.png" alt="" height="26" class="logo-small">
                <img src="resource/horizontal/assets/images/Elv_logo.png" alt="" height="22" class="logo-large">
            
            	
            </a> -->

        </div>
        <!-- End Logo container-->


        <div class="menu-extras topbar-custom">

            <ul class="list-unstyled topbar-right-menu float-right mb-0">

                <li class="menu-item">
                    <!-- Mobile menu toggle-->
                    <a class="navbar-toggle nav-link">
                        <div class="lines">
                            <span></span>
                            <span></span>
                            <span></span>
                        </div>
                    </a>
                    <!-- End mobile menu toggle-->
                </li>
                
                <li class="dropdown notification-list hide-phone">
                    
                    <br>
                       
                    <div id="google_translate_element"></div>
                    <script type="text/javascript">
						function googleTranslateElementInit() {
						  new google.translate.TranslateElement({pageLanguage: 'en', layout: google.translate.TranslateElement.InlineLayout.SIMPLE}, 'google_translate_element');
						}
					</script>
					<script type="text/javascript" src="//translate.google.com/translate_a/element.js?cb=googleTranslateElementInit"></script>
					                        
                </li>

                
                <li class="dropdown notification-list">
                    
                    <a class="nav-link dropdown-toggle arrow-none waves-effect" data-toggle="dropdown" href="#" role="button"
                       aria-haspopup="false" aria-expanded="false">
                        <i class="fi-speech-bubble noti-icon"></i>
                        <span class="badge badge-dark badge-pill noti-icon-badge">6</span>
                    </a>
                    
                    <div class="dropdown-menu dropdown-menu-right dropdown-lg">

                        <!-- item-->
                        
                        <div class="dropdown-item noti-title">
                            <h6 class="m-0"><span class="float-right"><a href="" class="text-dark"><small>Clear All</small></a> </span>Notification</h6>
                        </div>

                        <div class="slimscroll" style="max-height: 230px;">
                            <!-- item-->
                            <a href="javascript:void(0);" class="dropdown-item notify-item">
                                <div class="notify-icon"><img src="resource/horizontal/assets/images/users/avatar-2.jpg" class="img-fluid rounded-circle" alt="" /> </div>
                                <p class="notify-details">Cristina Pride</p>
                                <p class="text-muted font-13 mb-0 user-msg">Hi, How are you? What about our next meeting</p>
                            </a>

                            <!-- item-->
                            <a href="javascript:void(0);" class="dropdown-item notify-item">
                                <div class="notify-icon"><img src="resource/horizontal/assets/images/users/avatar-3.jpg" class="img-fluid rounded-circle" alt="" /> </div>
                                <p class="notify-details">Sam Garret</p>
                                <p class="text-muted font-13 mb-0 user-msg">Yeah everything is fine</p>
                            </a>

                            <!-- item-->
                            <a href="javascript:void(0);" class="dropdown-item notify-item">
                                <div class="notify-icon"><img src="resource/horizontal/assets/images/users/avatar-4.jpg" class="img-fluid rounded-circle" alt="" /> </div>
                                <p class="notify-details">Karen Robinson</p>
                                <p class="text-muted font-13 mb-0 user-msg">Wow that's great</p>
                            </a>

                            <!-- item-->
                            <a href="javascript:void(0);" class="dropdown-item notify-item">
                                <div class="notify-icon"><img src="resource/horizontal/assets/images/users/avatar-5.jpg" class="img-fluid rounded-circle" alt="" /> </div>
                                <p class="notify-details">Sherry Marshall</p>
                                <p class="text-muted font-13 mb-0 user-msg">Hi, How are you? What about our next meeting</p>
                            </a>

                            <!-- item-->
                            <a href="javascript:void(0);" class="dropdown-item notify-item">
                                <div class="notify-icon"><img src="resource/horizontal/assets/images/users/avatar-6.jpg" class="img-fluid rounded-circle" alt="" /> </div>
                                <p class="notify-details">Shawn Millard</p>
                                <p class="text-muted font-13 mb-0 user-msg">Yeah everything is fine</p>
                            </a>
                        </div>

                        <!-- All-->
                        <a href="userNotification" class="dropdown-item text-center text-primary notify-item notify-all">
                            View all <i class="fi-arrow-right"></i>
                        </a>

                    </div>
                </li>


                <li class="dropdown notification-list">
                    
                    <a class="nav-link dropdown-toggle waves-effect nav-user" data-toggle="dropdown" href="#" role="button"
                       aria-haspopup="false" aria-expanded="false">
                        
                        <c:set var="userId" value="${user.user_id}"/>
						<%int userIden = (Integer)pageContext.getAttribute("userId"); %>
					 				
	                    <c:set var="profilePhoto" value="${user.profile_photo}"/>
						<% String profilePhoto = (String)pageContext.getAttribute("profilePhoto");%>
						
						<%if(profilePhoto.equals("")){ %>
						
                         	<img src="resource/horizontal/assets/images/users/usr-images.png" alt="user" class="rounded-circle"> <span class="ml-1 pro-user-name">${user.first_name}<i class="mdi mdi-chevron-down"></i> </span>
                    
                    	<%}else{ %>
                    		
                    		<img src="${pageContext.request.contextPath}<%="/previewPicture?fileName="+profilePhoto+"&userId="+userIden+""%>" alt="user" class="rounded-circle"> <span class="ml-1 pro-user-name">${user.first_name}<i class="mdi mdi-chevron-down"></i> </span>
                    		
                    	<%} %>
                    </a>
                    
                    <div class="dropdown-menu dropdown-menu-right profile-dropdown ">
                        
                        <!-- item-->
                        <div class="dropdown-item noti-title">
                            <h6 class="text-overflow m-0">Welcome ${user.first_name} !</h6>
                        </div>

                        <!-- item-->
                        <a href="userDashboard" class="dropdown-item notify-item">
                            <i class="fi-head"></i> <span>My Account</span>
                        </a>

                        <!-- item-->
                        <a href="userAccount" class="dropdown-item notify-item">
                            <i class="fi-cog"></i> <span>Settings</span>
                        </a>

                        <!-- item-->
                        <a href="userSupport" class="dropdown-item notify-item">
                            <i class="fi-help"></i> <span>Support</span>
                        </a>

                        <!-- item-->
                        <a href="userLogOut" class="dropdown-item notify-item">
                            <i class="fi-power"></i> <span>Logout</span>
                        </a>

                    </div>
                    
                </li>
                
            </ul>
        </div>
        
        <!-- end menu-extras -->

        <div class="clearfix"></div>

    </div> <!-- end container -->
    
</div>
            <!-- end topbar-main -->