<%@ include file="../common/LogIncludeTop.jsp"%>

<!-- banner-bottom -->
<div class="codes">
	<div class="container">
		<div class="grid_3 grid_5">
			<div class="showback">
				<h3 class="w3ls-hdg">My calendar</h3>
				<div class="alert alert-success agileits" role="alert">
					<section id="container">
						<section id="main-content">
							<!-- page start-->
							<section class="wrapper">
								<div class="row mt">
									<aside class="col-lg-9 mt">
										<section class="panel">
											<div class="panel-body">
												<div id="calendar" class="has-toolbar"></div>
											</div>
										</section>
									</aside>
								</div>
								<!-- page end-->
							</section>
							<!--wrapper -->
						</section>
						<!-- /MAIN CONTENT -->
					</section>
				</div>
			</div>
			<div class="grid_3 grid_5 w3-agileits w3layouts">
				<div class="showback">
					<h3 class="w3ls-hdg">History courses</h3>
					<div class="alert alert-warning" role="alert">
						<div class="row mt">
							<div class="col-md-12">
								<div class="content-panel">
									<table class="table table-striped table-advance table-hover">
										<div class="qian_right">
											<h4>
												<i class="fa fa-angle-right" href="individualOrderhistory"></i>
												<a href="individualOrderhistory">
													<button type="button" class="btn btn-theme"
														href="individualOrderhistory">
														<i class="fa fa-cog"></i> Show all orders
													</button>
												</a>
											</h4>
										</div>
										<hr>
										<thead>
											<tr>
												<th><i class="fa fa-bullhorn"></i> Course ID</th>
												<th class="hidden-phone"><i
													class="fa fa-question-circle"></i> Description</th>
												<th><i class="fa fa-bookmark"></i> Sum</th>
												<th><i class=" fa fa-edit"></i> Status</th>
												<th></th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td><a href="basic_table.html#">1</a></td>
												<td class="hidden-phone">XXX</td>
												<td>10000.00$</td>
												<td><span class="label label-info label-mini">Unpaid</span></td>
												<td>
													<button class="btn btn-success btn-xs">
														<i class="fa fa-check"></i>
													</button>
													<button class="btn btn-primary btn-xs">
														<i class="fa fa-pencil"></i>
													</button>
													<button class="btn btn-danger btn-xs">
														<i class="fa fa-trash-o "></i>
													</button>
												</td>
											</tr>
											<tr>
												<td><a href="basic_table.html#"> 2 </a></td>
												<td class="hidden-phone">XXX</td>
												<td>10000.00$</td>
												<td><span class="label label-warning label-mini">Paid</span></td>
												<td>
													<button class="btn btn-success btn-xs">
														<i class="fa fa-check"></i>
													</button>
													<button class="btn btn-primary btn-xs">
														<i class="fa fa-pencil"></i>
													</button>
													<button class="btn btn-danger btn-xs">
														<i class="fa fa-trash-o "></i>
													</button>
												</td>
											</tr>
										</tbody>
									</table>
								</div>
								<!-- /content-panel -->
							</div>
							<!-- /col-md-12 -->
						</div>
						<!-- /row -->
					</div>
				</div>
			</div>
			<div class="grid_3 grid_5 ">
				<div class="showback">
					<h3 class="w3ls-hdg w3layouts ">Profile</h3>
					<div class="alert alert-info" role="alert">
						<ol class="breadcrumb">
							<li class="active">Name</li>
							<li class="active">Name</li>
						</ol>
						<ol class="breadcrumb">
							<li class="active">Email address</li>
							<li class="active">Email address</li>
						</ol>
						<ol class="breadcrumb">
							<li class="active">Address</li>
							<li class="active">Address</li>
						</ol>
						<ol class="breadcrumb">
							<li class="active">Contact number</li>
							<li class="active">Contact number</li>
						</ol>
						<ol class="breadcrumb">
							<li class="active">Description</li>
							<li class="active">Description</li>
						</ol>
						<a href="individualProfile">
							<button type="button" class="btn btn-theme"
								href="individualProfile">
								<i class="fa fa-cog"></i> Modify my profile
							</button>
						</a>
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
<!-- //footer -->
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
<!-- Placed at the end of the document so the pages load faster -->
<script src="js/bootstrap.js"></script>

<%@ include file="../common/IncludeBottom.jsp"%>