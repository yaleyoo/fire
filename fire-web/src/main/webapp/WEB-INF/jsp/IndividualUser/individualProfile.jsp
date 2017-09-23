<%@ include file="../common/LogIncludeTop.jsp"%>
<script type="text/javascript">
	var countdown = 60;
	function settime(obj) {
		if (countdown == 0) {
			obj.removeAttribute("disabled");
			obj.value = "sent a verification email to your mailbox";
			countdown = 60;
			return;
		} else {
			obj.setAttribute("disabled", true);
			obj.value = "resent(" + countdown + ")";
			countdown--;
		}
		setTimeout(function() {
			settime(obj)
		}, 1000)
	}
</script>
<div class="codes">
	<div class="container">
		<div class="grid_3 grid_5 ">
			<div class="showback">
				<div class="w3ls-title">
					<h3 class="agileits-title">Modify Profile</h3>
				</div>
				<div class="alert alert-info" role="alert">
					<div class="tab-pane active" id="horizontal-form">
						<form class="form-horizontal" name="form1">
							<div class="form-group">
								<label for="focusedinput" class="col-sm-2 control-label">First
									Name</label>
								<div class="col-sm-8">
									<input type="text" class="form-control1" id="First Name"
										placeholder="First Name" />
								</div>
							</div>
							<div class="form-group">
								<label for="focusedinput" class="col-sm-2 control-label">
									Family Name</label>
								<div class="col-sm-8">
									<input type="text" class="form-control1" id="Family Name"
										placeholder="Family Name" />
								</div>
							</div>
							<div class="form-group">
								<label for="checkbox" class="col-sm-2 control-label">Gender</label>
								<div class="col-sm-8">
									<div class="checkbox-inline1">
										<label><input type="checkbox"> Male</label>
									</div>
									<div class="checkbox-inline1">
										<label><input type="checkbox"> Female</label>
									</div>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword" class="col-sm-2 control-label">Password</label>
								<div class="col-sm-8">
									<input type="password" class="form-control1" id="inputPassword"
										placeholder="Password"> <span class="psdInfo"></span>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword" class="col-sm-2 control-label">Confirm
									Password</label>
								<div class="col-sm-8">
									<input type="password" class="form-control1"
										id="confirmPassword" placeholder="Confirm Password" /> <span
										class="psd1Info"></span>
								</div>
							</div>
							<div class="form-group">
								<label for="txtarea1" class="col-sm-2 control-label">Address</label>
								<div class="col-sm-8">
									<textarea name="txtarea1" id="txtarea1" cols="50" rows="4"
										class="form-control1" placeholder="Address"></textarea>
								</div>
							</div>
							<div class="form-group">
								<label for="focusedinput" class="col-sm-2 control-label">Contact
									Number</label>
								<div class="col-sm-8">
									<input type="text" class="form-control1" id="Contect Number"
										placeholder="Contect Number" />
								</div>
							</div>
							<div class="form-group">
								<label for="txtarea1" class="col-sm-2 control-label">Description</label>
								<div class="col-sm-8">
									<textarea name="txtarea1" id="txtarea1" cols="50" rows="4"
										class="form-control1" placeholder="Description" /></textarea>
								</div>
							</div>
							<div class="form_register">
								<a href="" class="wthree-more w3more1 nina" data-text="Modify">
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

<!-- //short-codes -->
<!-- Bootstrap core CSS -->
<!-- js placed at the end of the document so the pages load faster -->
<script src="assets/js/jquery.js"></script>
<script src="assets/js/jquery-ui-1.9.2.custom.min.js"></script>
<script src="assets/js/fullcalendar/fullcalendar.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script class="include" type="text/javascript"
	src="assets/js/jquery.dcjqaccordion.2.7.js"></script>
<script src="assets/js/jquery.scrollTo.min.js"></script>
<script src="assets/js/jquery.nicescroll.js" type="text/javascript"></script>
<!--common script for all pages-->
<!--script for this page-->
<script src="assets/js/calendar-conf-events.js"></script>
<script>
	//custom select box
	$(function() {
		$("select.styled").customSelect();
	});
</script>

<!-- menu-js -->
<script>
	$('.navicon').on('click', function(e) {
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
<!-- start-smooth-scrolling -->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<!-- //end-smooth-scrolling -->

<!-- //smooth-scrolling-of-move-up -->
<!-- Bootstrap core JavaScript
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="js/bootstrap.js"></script>
<%@ include file="../common/IncludeBottom.jsp"%>