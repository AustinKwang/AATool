$(function($) {
	// sender dialog
	$("#senderSubmit").hover(function() {
		$(this).stop().animate({
			opacity : '1'
		}, 600);
	}, function() {
		$(this).stop().animate({
			opacity : '0.8'
		}, 1000);
	});
	
	$(".close_btn_bbb").hover(function() {
		$(this).css({
			color : 'black'
		});
	}, function() {
		$(this).css({
			color : '#999'
		});
	}).on('click', function() {
		$("#senderBox").fadeOut("fast");
		$("#mask").css({
			display : 'none'
		});
	});
	
	
	//sender all dialog
	$("#senderaddSubmit").hover(function() {
		$(this).stop().animate({
			opacity : '1'
		}, 600);
	}, function() {
		$(this).stop().animate({
			opacity : '0.8'
		}, 1000);
	});
	
	$(".close_btn_bbb").hover(function() {
		$(this).css({
			color : 'black'
		});
	}, function() {
		$(this).css({
			color : '#999'
		});
	}).on('click', function() {
		$("#senderaddBox").fadeOut("fast");
		$("#mask_add").css({
			display : 'none'
		});
	});
	
	//server dialog
	$("#serverSumbit").hover(function() {
		$(this).stop().animate({
			opacity : '1'
		}, 600);
	}, function() {
		$(this).stop().animate({
			opacity : '0.8'
		}, 1000);
	});
	
	$(".close_btn_bbb").hover(function() {
		$(this).css({
			color : 'black'
		});
	}, function() {
		$(this).css({
			color : '#999'
		});
	}).on('click', function() {
		$("#serverBox").fadeOut("fast");
		$("#mask_ser").css({
			display : 'none'
		});
	});
	
	
	//receiver dialog
	$("#receiverSumbit").hover(function() {
		$(this).stop().animate({
			opacity : '1'
		}, 600);
	}, function() {
		$(this).stop().animate({
			opacity : '0.8'
		}, 1000);
	});
	
	$(".close_btn_bbb").hover(function() {
		$(this).css({
			color : 'black'
		});
	}, function() {
		$(this).css({
			color : '#999'
		});
	}).on('click', function() {
		$("#receiverBox").fadeOut("fast");
		$("#mask_rec").css({
			display : 'none'
		});
	});
	
	
});
