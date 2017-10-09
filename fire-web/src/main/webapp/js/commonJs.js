addEventListener("load", function() {
	setTimeout(hideURLbar, 0);
}, false);
function hideURLbar() {
	window.scrollTo(0, 1);
}

//menu
$(".navicon").on('click', function(e) {
	e.preventDefault();
	$(this).toggleClass('navicon--active');
	$('.toggle').toggleClass('toggle--active');
});

/* init Jarallax */
$(".jarallax").jarallax({
	speed : 0.5,
	imgWidth : 1366,
	imgHeight : 768
})
// jarallax

jQuery(document).ready(function($) {
	$(".scroll").click(function(event) {
		event.preventDefault();

		$('html,body').animate({
			scrollTop : $(this.hash).offset().top
		}, 1000);
	});
});

//smooth-scrolling-of-move-up
$(document).ready(function() {
	/*
	 * var defaults = { containerID: 'toTop', // fading element id
	 * containerHoverID: 'toTopHover', // fading element hover id scrollSpeed:
	 * 1200, easingType: 'linear' };
	 */
	$().UItoTop({
		easingType : 'easeOutQuart'
	});
});
// smooth-scrolling-of-move-up

$(function() {
	$('#loginform').submit(function(e) {
		return false;
	});

	$('#modaltrigger').leanModal({
		top : 110,
		overlay : 0.45,
		closeButton : ".hidemodal"
	});
});


