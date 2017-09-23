<%@ include file="../common/LogIncludeTop.jsp"%>
<div class="codes">
	<div class="container">
		<div class="w3ls-title"></div>
		<div class="grid_3 grid_5 w3-agileits w3layouts">
			<div class="showback">
				<h3 class="w3ls-hdg">History courses</h3>
				<div class="alert alert-warning" role="alert">
					<div class="row mt">
						<div class="col-md-12">
							<div class="content-panel">
								<table class="table table-striped table-advance table-hover">
									<div class="qian_right">
										<!-- Split button -->
										<div class="btn-group">
											<button type="button" class="btn btn-theme03">Filter
												by</button>
											<button type="button" class="btn btn-theme03 dropdown-toggle"
												data-toggle="dropdown">
												<span class="caret"></span> <span class="sr-only">Toggle
													Dropdown</span>
											</button>
											<ul class="dropdown-menu" role="menu">
												<li><a href="#">Unpaid</a></li>
												<li><a href="#">Paid</a></li>
												<li class="divider"></li>
												<li><a href="#">Starred</a></li>
											</ul>
										</div>
									</div>
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
<!-- Bootstrap core JavaScript
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="js/bootstrap.js"></script>
<%@ include file="../common/IncludeBottom.jsp"%>