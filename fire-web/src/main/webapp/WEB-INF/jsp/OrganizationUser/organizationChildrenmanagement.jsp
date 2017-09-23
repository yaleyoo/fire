<%@ include file="../common/LogIncludeTop.jsp"%>

<script type="text/javascript">
	var countdown = 60;
	function settime(obj) {
		if (countdown == 0) {
			obj.removeAttribute("disabled");
			obj.value = "Get the CAPTCHA";
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
		<div class="grid_3 grid_5 agile">
			<div class="showback">
				<div class="w3ls-title">
					<h3 class="agileits-title">Children Account Register</h3>
				</div>
				<div class="alert alert-danger" role="alert">
					<div class="grid_3 grid_4">
						<!--<h3 class="w3ls-hdg">Horizontal Form</h3>-->
						<div class="tab-content">
							<div class="tab-pane active" id="horizontal-form">
								<form class="form-horizontal" name="addNewChildForm"
									id="addNewChildForm">
									<div class="form-group">
										<label for="focusedinput" class="col-sm-2 control-label">First
											Name</label>
										<div class="col-sm-8">
											<input type="text" class="form-control1" name="firstName"
												id="firstName" placeholder="">
										</div>
									</div>
									<div class="form-group">
										<label for="focusedinput" class="col-sm-2 control-label">
											Family Name<span style="color: red">*</span>
										</label>
										<div class="col-sm-8">
											<input type="text" class="form-control1" id="familyName"
												name="familyName" placeholder=""> <span
												id="familyNameInfo"></span>
										</div>
									</div>
									<div class="form-group">
										<label for="focusedinput" class="col-sm-2 control-label">Email
											Address<span style="color: red">*</span>
										</label>
										<div class="col-sm-8">
											<div class="form-control_userName">
												<input type="mail" class="form-control_userName_input"
													id="emailAddr" name="emailAddr" placeholder=""> <input
													type="button" class="button white" value="Get the CAPTCHA"
													onclick="clickToVerifyCode(this);" id="btnMailVerify"
													name="btnMailVerify" /> <br> <span id="emaiInfo"></span>
											</div>
											<input type="text" class="form-control_userName_Captcha"
												id="userMailCode" name="userMailCode" placeholder="">
										</div>
										<span class="userNameInfo"></span>
									</div>
									<div class="form-group">
										<label for="checkbox" class="col-sm-2 control-label">Gender</label>
										<div class="col-sm-8">
											<div class="checkbox-inline1">
												<label><input name="sex" type="radio" checked
													value="1"> Male</label>
											</div>
											<div class="checkbox-inline1">
												<label><input name="sex" type="radio" value="0">
													Female</label>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="inputPassword" class="col-sm-2 control-label">Password<span
											style="color: red">*</span></label>
										<div class="col-sm-8">
											<input type="password" class="form-control1" id="password"
												name="password" placeholder="Password"> <span
												class="psdInfo"></span>
										</div>
									</div>
									<div class="form-group">
										<label for="inputPassword" class="col-sm-2 control-label">Confirm
											Password<span style="color: red">*</span>
										</label>
										<div class="col-sm-8">
											<input type="password" class="form-control1"
												id="confirmPassword" placeholder="Confirm Password" /> <span
												class="psd1Info"></span>
										</div>
									</div>
									<div class="form-group">
										<label for="txtarea1" class="col-sm-2 control-label">Address</label>
										<div class="col-sm-8">
											<textarea id="address" name="address" cols="50" rows="4"
												class="form-control1"></textarea>
										</div>
									</div>
									<div class="form-group">
										<label for="focusedinput" class="col-sm-2 control-label">Contact
											Number<span style="color: red">*</span>
										</label>
										<div class="col-sm-8">
											<input type="text" class="form-control1" id="contactNum"
												name="contactNum" placeholder=""> <span
												id="contectInfo"></span>
										</div>
									</div>
									<div class="form_register">
										<span id="btnInfo"></span> <br> <a
											class="wthree-more w3more1 nina" data-text="Register"
											onclick="addNewChildAccountRequest()"> <span>A</span><span>d</span><span>d</span>
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
<!-- smooth-scrolling-of-move-up -->
<!-- //smooth-scrolling-of-move-up -->
<!-- Bootstrap core JavaScript
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="js/bootstrap.js"></script>

<%@ include file="../common/IncludeBottom.jsp"%>