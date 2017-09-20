<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<html lang="en">
<head>
<title>Organization OrderHistory</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="keywords" content="" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">



<!-- Custom Theme files -->
<link href="css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
<link href="css/font-awesome.css" rel="stylesheet"> <!-- font-awesome icons --> 


<link href="assets/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link href="assets/js/fullcalendar/bootstrap-fullcalendar.css" rel="stylesheet" />
        
    <!-- Custom styles for this template -->
    <link href="assets/css/style.css" rel="stylesheet">
    <link href="assets/css/style-responsive.css" rel="stylesheet">

<link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
<link href="assets/js/fullcalendar/bootstrap-fullcalendar.css" rel="stylesheet" />
<link href="assets/css/style.css" rel="stylesheet">
<link href="assets/css/style-responsive.css" rel="stylesheet">
<link href="css/style.css" type="text/css" rel="stylesheet" media="all"> 

<!-- //Custom Theme files --> 
<!-- js -->
<script src="js/jquery-2.2.3.min.js"></script>  
<script src="js/jquery-1.9.1.min.js"></script>
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>


	<script src="assets/js/jquery.js"></script>
    <script src="assets/js/jquery-ui-1.9.2.custom.min.js"></script>
	<script src="assets/js/fullcalendar/fullcalendar.min.js"></script>    
    <script src="assets/js/bootstrap.min.js"></script>
    <script class="include" type="text/javascript" src="assets/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="assets/js/jquery.scrollTo.min.js"></script>
    <script src="assets/js/jquery.nicescroll.js" type="text/javascript"></script>
    <!--common script for all pages-->

    <!--script for this page-->
	<script src="assets/js/calendar-conf-events.js"></script>    
  <script src="js/jquery-2.2.3.min.js"></script>  
<script src="js/jquery-1.9.1.min.js"></script>
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>


<!-- //js -->
<!-- web-fonts -->   
<link href="http://fonts.googleapis.com/css?family=Roboto+Condensed:300,300i,400,400i,700" rel="stylesheet">
<link href="http://fonts.googleapis.com/css?family=Oswald:200,300,400,500,600,700" rel="stylesheet"> 
<!-- //web-fonts -->
</head>
<body> 
	<!-- banner -->
	<div class="banner jarallax">
		<div class="banner-agileinfo">
			<!-- header -->
			<div class="">
				<div class="container">
					<div class="logo">
						<h1><a href="index.html">Fes Booking</a></h1>
					</div> 

					<div class="social-w3licon"> 
						<ul class="social_agileinfo">
						</ul>
					</div>
					<div class="menu">
						<a href="#" class="navicon"></a> 
						<div class="toggle"> 
							<ul class="toggle-menu">
								<li><a href="index.html" class="active"> Home</a></li>
								<li><a href="courselist.html">Course list</a></li>  
								<li><a href="history.html">History order</a></li>
								<li><a href="porfile.html">Profile</a></li>
								<li><a href="mail.html">Mail Us</a></li>
								<li><a href="index.html">Log Out</a></li>
							</ul>
						</div> 
					</div>
					<div class="clearfix"> </div>
					</div>
			</div>
			<div  class="banner-w3lstext agileits-w3layouts">  
				<ol class="breadcrumb">
					<li><a href="index.html">Course List</a></li> 
					<li class="active" id="customername">Welcome, Customer name!</li>
				</ol>  
			</div>
		</div>
	</div>
	<!-- //banner --> 
	<!-- banner-bottom -->

	<div class="codes">
		<div class="container"> 	
			<div class="w3ls-title">
				<!--<h3 class="agileits-title">Short Codes</h3> -->
			</div> 
			<div class="grid_3 grid_5 w3-agileits w3layouts">
			<div
			 class="showback">
				<h3 class="w3ls-hdg">History courses</h3>
				<div class="alert alert-warning" role="alert">

					<div class="row mt">
                  		<div class="col-md-12">
                      		<div class="content-panel">
                          		<table class="table table-striped table-advance table-hover">
			                  	  	  <div class="qian_right">
						<!-- Split button -->
    						<div class="btn-group">
    						  <button type="button" class="btn btn-theme03">Filter by</button>
    						  <button type="button" class="btn btn-theme03 dropdown-toggle" data-toggle="dropdown">
    						    <span class="caret"></span>
    						    <span class="sr-only">Toggle Dropdown</span>
    						  </button>
    						  <ul class="dropdown-menu" role="menu">
    						    <li><a href="#">Unpaid</a></li>
    						    <li><a href="#">Paid</a></li>
    						    <li class="divider"></li>
    						    <li><a href="#">Starred</a></li>
    						  </ul>
    						</div>      				
          		</div></h4>
									</div>
		                              <thead>
		                              <tr>
		                                  <th><i class="fa fa-bullhorn"></i> Course ID</th>
		                                  <th class="hidden-phone"><i class="fa fa-question-circle"></i> Descrition</th>
		                                  <th><i class="fa fa-bookmark"></i> Sum</th>
		                                  <th><i class=" fa fa-edit"></i> Status</th>
		                                  <th></th>
		                              </tr>
		                              </thead>
		                              <tbody>
		                              <tr>
		                                  <td><a href="basic_table.html#">1</a></td>
		                                  <td class="hidden-phone">XXX</td>
		                                  <td>10000.00$ </td>
		                                  <td><span class="label label-info label-mini">Unpaid</span></td>
		                                  <td>
		                                      <button class="btn btn-success btn-xs"><i class="fa fa-check"></i></button>
		                                      <button class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></button>
		                                      <button class="btn btn-danger btn-xs"><i class="fa fa-trash-o "></i></button>
		                                  </td>
		                              </tr>
		                              <tr>
		                                  <td>
		                                      <a href="basic_table.html#">
		                                          2
		                                      </a>
		                                  </td>
		                                  <td class="hidden-phone">XXX</td>
		                                  <td>10000.00$ </td>
		                                  <td><span class="label label-warning label-mini">Paid</span></td>
		                                  <td>
		                                      <button class="btn btn-success btn-xs"><i class="fa fa-check"></i></button>
		                                      <button class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></button>
		                                      <button class="btn btn-danger btn-xs"><i class="fa fa-trash-o "></i></button>
		                                  </td>
		                              </tr>
		                              <tr>
		                                  <td>
		                                      <a href="basic_table.html#">
		                                          3
		                                      </a>
		                                  </td>
		                                  <td class="hidden-phone">XXX</td>
		                                  <td>10000.00$ </td>
		                                  <td><span class="label label-warning label-mini">Paid</span></td>
		                                  <td>
		                                      <button class="btn btn-success btn-xs"><i class="fa fa-check"></i></button>
		                                      <button class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></button>
		                                      <button class="btn btn-danger btn-xs"><i class="fa fa-trash-o "></i></button>
		                                  </td>
		                              </tr>
		                              <tr>
		                                  <td>
		                                      <a href="basic_table.html#">
		                                          4
		                                      </a>
		                                  </td>
		                                  <td class="hidden-phone">XXX</td>
		                                  <td>10000.00$ </td>
		                                  <td><span class="label label-warning label-mini">Paid</span></td>
		                                  <td>
		                                      <button class="btn btn-success btn-xs"><i class="fa fa-check"></i></button>
		                                      <button class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></button>
		                                      <button class="btn btn-danger btn-xs"><i class="fa fa-trash-o "></i></button>
		                                  </td>
		                              </tr>
		                              <tr>
		                                  <td><a href="basic_table.html#">5</a></td>
		                                   <td class="hidden-phone">XXX</td>
		                                  <td>10000.00$ </td>
		                                  <td><span class="label label-warning label-mini">Paid</span></td>
		                                  <td>
		                                      <button class="btn btn-success btn-xs"><i class="fa fa-check"></i></button>
		                                      <button class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></button>
		                                      <button class="btn btn-danger btn-xs"><i class="fa fa-trash-o "></i></button>
		                                  </td>
		                              </tr>
		                              </tbody>
		                          </table>
		                      </div><!-- /content-panel -->
		                  </div><!-- /col-md-12 -->
		              </div><!-- /row -->

				</div>
				</div>
			</div>
			
		</div> 
	</div>  
	<!-- //short-codes -->      
	 



    <!-- Bootstrap core CSS -->
    
    <!-- js placed at the end of the document so the pages load faster -->
    <script src="assets/js/jquery.js"></script>
    <script src="assets/js/jquery-ui-1.9.2.custom.min.js"></script>
	 <script src="assets/js/fullcalendar/fullcalendar.min.js"></script>    
    <script src="assets/js/bootstrap.min.js"></script>
    <script class="include" type="text/javascript" src="assets/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="assets/js/jquery.scrollTo.min.js"></script>
    <script src="assets/js/jquery.nicescroll.js" type="text/javascript"></script>


    <!--common script for all pages-->

    <!--script for this page-->
	<script src="assets/js/calendar-conf-events.js"></script>    
  
  <script>
      //custom select box

      $(function(){
          $("select.styled").customSelect();
      });

  </script>

  </body>
</html>








<!DOCTYPE html>
<html lang="en">
  <head>	
	<!-- wthree-slid -->
	
	<!-- footer-top -->  
	<!-- footer-top -->  
	<div class="footer-agiletop">
		<div class="container"> 
			<div class="col-md-8 w3agile_hire_left">
				<h4>We are always ready to help you. There are many ways to contact us</h4>
			</div>
			<div class="col-md-4 w3agile_hire_right">

				<a href="mail.html" class="wthree-more w3more1 nina" data-text="contect me"> 
					<span>c</span><span>o</span><span>n</span><span>t</span><span>e</span><span>c</span><span>t</span> <span>m</span><span>e</span>
				</a> 
			</div>
			<div class="clearfix"> </div>   
		</div>
	</div>
	<!-- //footer-top -->   
	<!-- footer -->
	<div class="footer">
		<div class="container">
			<div class="col-md-4 w3layouts_footer_grid">
				<h2>Follow <span>Us</span></h2>
				
			</div>
			<div class="col-md-8 w3layouts_footer_grid">
				<ul class="social_agileinfo">
					<li><a href="#" class="w3_facebook"><i class="fa fa-facebook"></i></a></li>
					<li><a href="#" class="w3_twitter"><i class="fa fa-twitter"></i></a></li>
					<li><a href="#" class="w3_instagram"><i class="fa fa-instagram"></i></a></li>
					<li><a href="#" class="w3_google"><i class="fa fa-google-plus"></i></a></li>
				</ul>
				
				
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>
	<!-- //footer -->   
	<!-- menu-js -->
	<script>
		$('.navicon').on('click', function (e) {
		  e.preventDefault();
		  $(this).toggleClass('navicon--active');
		  $('.toggle').toggleClass('toggle--active');
		});
	</script> 
	<!-- //menu-js -->
	<!-- Progressive-Effects-Animation-JavaScript -->  
	<script type="text/javascript" src="js/numscroller-1.0.js"></script>
	<!-- //Progressive-Effects-Animation-JavaScript --> 
	<!-- jarallax -->  
	<script src="js/SmoothScroll.min.js"></script> 
	<script src="js/jarallax.js"></script> 
	<script type="text/javascript">
		/* init Jarallax */
		$('.jarallax').jarallax({
			speed: 0.5,
			imgWidth: 1366,
			imgHeight: 768
		})
	</script>  
	<!-- //jarallax --> 
	<!-- start-smooth-scrolling --> 
	<script type="text/javascript" src="js/move-top.js"></script>
	<script type="text/javascript" src="js/easing.js"></script>	
	<script type="text/javascript">
			jQuery(document).ready(function($) {
				$(".scroll").click(function(event){		
					event.preventDefault();
			
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
				});
			});
	</script>
	<!-- //end-smooth-scrolling -->	 
	<!-- smooth-scrolling-of-move-up -->
	<script type="text/javascript">
		$(document).ready(function() {
			/*
			var defaults = {
				containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
			};
			*/
			
			$().UItoTop({ easingType: 'easeOutQuart' });
			
		});
	</script>
	
	<!-- //smooth-scrolling-of-move-up -->   
	<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="js/bootstrap.js"></script>
</body>
</html>