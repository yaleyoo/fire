<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<html lang="en">
<head>
<title>Individual Profile</title>
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

<script type="text/javascript"> 
var countdown=60; 
function settime(obj) { 
    if (countdown == 0) { 
        obj.removeAttribute("disabled");    
        obj.value="sent a verification email to your mailbox"; 
        countdown = 60; 
        return;
    } else { 
        obj.setAttribute("disabled", true); 
        obj.value="resent(" + countdown + ")"; 
        countdown--; 
    } 
setTimeout(function() { 
    settime(obj) }
    ,1000) 
}
  
</script>

<script type="text/javascript">
 function checkpwd(){
  var p1=document.getElementById("inputPassword");
  var p2=document.getElementById("confirmPassword");//获取重新输入的密码值
  if(p1==""){
   alert("please enter a password");
   return false;
  }
  
  if(p1!=p2){
   document.getElementsByClassName("msg").innerHTML="cannot match";//
   return false;
  }else{
   
  }
 }
</script>


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
					<li><a href="Individual_home.html">Homepage</a></li> 
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
			<div class="grid_3 grid_5 ">
				<div class="showback">
				
				<div class="w3ls-title">
				<h3 class="agileits-title">Modify Profile</h3> 
				</div>
				<div class="alert alert-info" role="alert">
					<div class="grid_3 grid_4">
				<!--<h3 class="w3ls-hdg">Horizontal Form</h3>-->
				<div class="tab-content">
					<div class="tab-pane active" id="horizontal-form">
						<form class="form-horizontal" name="form1">
							
							<div class="form-group">
								<label for="focusedinput" class="col-sm-2 control-label">First Name</label>
								<div class="col-sm-8">
									<input type="text" class="form-control1" id="First Name" placeholder="First Name"/>
								</div>
							</div>
							<div class="form-group">
								<label for="focusedinput" class="col-sm-2 control-label">
								Family Name</label>
								<div class="col-sm-8">
									<input type="text" class="form-control1" id="Family Name" placeholder="Family Name"/>
								</div>
							</div>
							
							<div class="form-group">
								<label for="checkbox" class="col-sm-2 control-label">Gender</label>
								<div class="col-sm-8">
									<div class="checkbox-inline1"><label><input type="checkbox"> Male</label></div>
									<div class="checkbox-inline1"><label><input type="checkbox"> Female</label></div>
								</div>
							</div> 

							<div class="form-group">
								<label for="inputPassword" class="col-sm-2 control-label" >Password</label>
								<div class="col-sm-8">
									<input type="password" class="form-control1" id="inputPassword" placeholder="Password" >
									<span class="psdInfo"></span>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword" class="col-sm-2 control-label" >Confirm Password</label>
								<div class="col-sm-8">
									<input type="password" class="form-control1" id="confirmPassword" placeholder="Confirm Password"/>
									<span class="psd1Info"></span>
								</div>
							</div>
							<div class="form-group">
								<label for="txtarea1" class="col-sm-2 control-label">Address</label>
								<div class="col-sm-8"><textarea name="txtarea1" id="txtarea1" cols="50" rows="4" class="form-control1" placeholder="Address"></textarea></div>
							</div>
							<div class="form-group">
								<label for="focusedinput" class="col-sm-2 control-label">Contect Number</label>
								<div class="col-sm-8">
									<input type="text" class="form-control1" id="Contect Number" placeholder="Contect Number"/>
								</div>
							</div>

							<div class="form-group">
								<label for="txtarea1" class="col-sm-2 control-label">Description</label>
								<div class="col-sm-8"><textarea name="txtarea1" id="txtarea1" cols="50" rows="4" class="form-control1" placeholder="Description"/></textarea></div>
							</div>


							<div class="form_register">
								
								<a href="mail.html" class="wthree-more w3more1 nina" data-text="Modify"> 
								<span>M</span><span>O</span><span>D</span><span>I</span><span>F</span><span>Y</span>
								</a> 
							</div>
						</form>
					</div>
				</div>
			</div>
				</div>
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
	
<script>
	function findStr(str,n){
		var temp=0;
		for(var i=0;i<str.length;i++){
			if(str.charAt(i)==n){
				temp++;
			};
		};
		return temp;
	};
	window.onload=function() {
		var Fname = document.getElementById("familyName");
		var userName = document.getElementById("userName");
		var psd = document.getElementById("inputPassword")
		var psd1=document.getElementById("confirmPassword");
		var ctNum = document.getElementById("contectNumber");
		var count=document.getElementsByClassName('count')[0];
		var FnameInfo=document.getElementsByClassName("FnameInfo")[0];
		var userNameInfo=document.getElementsByClassName("userNameInfo")[0];
		var psdInfo=document.getElementsByClassName("psdInfo")[0];
		var psd1Info=document.getElementsByClassName('psd1Info')[0];
		var contectInfo=document.getElementsByClassName("contectInfo")[0];
		var fl=document.getElementsByClassName("fl")[0];
		var name_length=0;
		var reg=/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/g;
		var re_n=/[^\d]/g;
		var re_t=/[^a-zA-Z]/g
		
		psd.onfocus=function(){
			psdInfo.style.display="inline-block";
			psdInfo.innerHTML='<i class="warn"></i> The password requires 6 to 16 characters, which should include number and letter';
		}


		psd.onblur=function(){
			var m=findStr(this.value,this.value[0]);
			if(this.value.length<6||this.value.length>16){
				psdInfo.innerHTML='<i class="cuo"></i> The password requires 6 to 16 characters';
			}else if(!re_n.test(this.value)){
				psdInfo.innerHTML='<i class="cuo"></i> password requires at least one letter';
			}else if(!re_t.test(this.value)){
				psdInfo.innerHTML='<i class="cuo"></i> password requires at least one number';
			}else{
				psdInfo.innerHTML='<i class="right"></i> OK';
			}
		}

		psd1.onblur=function(){
			if(this.value!=psd.value){
				psd1Info.innerHTML='<i class="cuo"></i> inconsistent';
			}
			else if(this.value==psd.value && psd.value==""){
				psd1Info.innerHTML='<i class="cuo"></i> please enter a password';
			}
			else{
				psd1Info.innerHTML='<i class="right"></i> OK';
			}
		}
	}
	function getLength(str){
		return str.replace(/[^\x00-xff]/g,"xx").length;
	}


</script>

	<!-- //smooth-scrolling-of-move-up -->   
	<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="js/bootstrap.js"></script>
</body>
</html>