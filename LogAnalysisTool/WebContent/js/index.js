window.onload = function() {
	$("#liLogAnalysis").addClass("active");
	$("#divHistoryReport").hide();
	$("#divCustomizeReportTemplate").hide();
	$("#divEmailSettings").hide();
	$("#divTaskSettings").hide();
	$(".formDate").datetimepicker({
		format : 'yyyy-mm-dd',
		autoclose : true,
		todayBtn : true,
		todayHighlight : true,
		startView : 2,
		minView : 2,
		forceParse : 0,
		showMeridian : true,
	});
	$("#FormStartDate").val("2014-08-02");
	$("#FormEndDate").val("2014-09-03");
	
	$("#tableStartDate").val("2014-08-02");
	$("#tableEndDate").val("2014-09-03");
	$(function() {
		$("[data-toggle='popover']").popover();
	});
};

// dragon
// ****************************************************************************************
function dragonReport() {

	// begin
	ShowDIV('DialogDiv');
	// ./************

	$
			.post(
					'LogAnalysisAction!analysisLog',
					{
						webSite : $("#WebSite").val(),
						server : $("#Server").val(),
						log : $("#Log").val(),
						startDate : $("#StartDate").val(),
						endDate : $("#EndDate").val(),
						reportType : $("#ReportType").val(),
						level : $("#Level").val()
					},
					function(data) {

						// end
						closeDiv('DialogDiv');
						// ./*******

						$("#TipCannotFindChartData").addClass("hide");
						$("#ColorDesc").empty();
						$("#divCanvas").empty();
						$("#divCanvas").append("<canvas id='Canvas' />");
						if (data.lineChartCompleteData != null) {
							window.myLine = new Chart($("#Canvas").get(0)
									.getContext("2d")).Line(
									data.lineChartCompleteData, {
										responsive : true
									});
							if (data.lineChartCompleteData.labels.length > 0) {
								for (var i = 0; i < data.lineChartCompleteData.datasets.length; i++) {
									$("#ColorDesc")
											.append(
													"<tr><td>&nbsp;&nbsp;<span class='glyphicon glyphicon-stop' style='color: "
															+ data.lineChartCompleteData.datasets[i].pointColor
															+ "'></span>"
															+ data.lineChartCompleteData.datasets[i].label
															+ "</td></tr>");
								}
							} else {
								$("#TipCannotFindChartData")
										.removeClass("hide");
							}
						} else if (data.pieBlocks != null) {
							window.Pie = new Chart($("#Canvas").get(0)
									.getContext("2d")).Pie(data.pieBlocks, {
								responsive : true
							});
							if (data.pieBlocks.length == 0) {
								$("#TipCannotFindChartData")
										.removeClass("hide");
							}
						} else {
							$("#TipCannotFindChartData").removeClass("hide");
						}
					}, "json");
}
// history report chart
// ************************************************************************************************
function historyReport() {
	// begin
	ShowDIV('DialogDiv');
	// ./************
	$
			.post(
					'reportAction',
					{
						webSite : $("#FormWebSite").val(),
						server : $("#FormServer").val(),
						log : $("#FormLog").val(),
						startDate : $("#FormStartDate").val(),
						endDate : $("#FormEndDate").val(),
						infoType : $("#FormReportType").val(),
						level : $("#FormLevel").val(),
						tableTypeCount : $("#FormTypeCount").is(':checked'),
						tableTypeDetails : $("#FormTypeDetails").is(':checked')
					},
					function(data) {

						// end
						closeDiv('DialogDiv');
						// ./*******

						initialReportChartAndTable();
						$("#divChartCanvas").append(
								"<canvas id='chartCanvas' />");
						if (data.lineChartCompleteData != null) {
							window.myLine = new Chart($("#chartCanvas").get(0)
									.getContext("2d")).Line(
									data.lineChartCompleteData, {
										responsive : true
									});
							for (var i = 0; i < data.lineChartCompleteData.datasets.length; i++) {
								$("#colorDesc")
										.append(
												"<tr><td>&nbsp;&nbsp;<span class='glyphicon glyphicon-stop' style='color: "
														+ data.lineChartCompleteData.datasets[i].pointColor
														+ "'></span>"
														+ data.lineChartCompleteData.datasets[i].label
														+ "</td></tr>");
							}
						} else if (data.pieBlocks != null) {
							window.Pie = new Chart($("#chartCanvas").get(0)
									.getContext("2d")).Pie(data.pieBlocks, {
								responsive : true
							});
							if (data.count != null) {
								$("#TableCountThead").append(
										"<tr><th>Date</th><th>Error</th>"
												+ "<th>Warn</th></tr>");
								for (var i = 0; i < data.count.length; i++) {
									$("#TableCountTbody").append("<tr>");
									for (var j = 0; j < data.count[i].length; j++) {
										$("#TableCountTbody").append(
												"<td>" + data.count[i][j]
														+ "</td>");
									}
									$("#TableCountTbody").append("</tr>");
								}
							}
							// details *************************************
							if (data.details != null) {
								$("#TableDetailsThead").append(
										"<tr><th>Date Time</th><th>Level</th>"
												+ "<th>Class Name</th>"
												+ "<th>Description</th></tr>");
								for (var i = 0; i < data.details.length; i++) {
									$("#TableDetailsTbody").append("<tr>");
									for (var j = 0; j < data.details[i].length - 1; j++) {
										if (j == 0) {
											data.details[i][j] = dateTimeFormat(data.details[i][j]);
										}
										$("#TableDetailsTbody").append(
												"<td>" + data.details[i][j]
														+ "</td>");
									}
									if (data.details[i][j].length <= 40) {
										$("#TableDetailsTbody").append(
												"<td>" + data.details[i][j]
														+ "</td></tr>");
									} else {
										var desc = data.details[i][j];
										var shortDesc = desc.substring(0, 40);
										$("#TableDetailsTbody")
												.append(
														"<td>"
																+ shortDesc
																+ "&nbsp;<a onclick='tableShowMore("
																+ i
																+ ")'>...show more</a></td></tr>");
										$("#divTableDescTemp").append(
												"<div id='tableDesc" + i
														+ "' class='hide'>"
														+ desc + "</div>");
									}
								}
							}
						} else {
							$("#tipCannotFindReportData").removeClass("hide");
						}
					}, "json");
}
function toggleDivFormLevel() {
	if ($("#FormReportType").val() == "common") {
		$("#divCommonDetails").removeClass("hide");
	} else {
		$("#divCommonDetails").addClass('hide');
	}
}
function tableShowMore(i) {
	$("#modalContent").empty();
	$("#modalContent").append($("#tableDesc" + i).text());
	$('#myModal').modal();
}
function initialReportChartAndTable() {
	$("#tipCannotFindReportData").addClass("hide");
	$("#colorDesc").empty();
	$("#divChartCanvas").empty();
	$("#TableCountThead").empty();
	$("#TableCountTbody").empty();
	$("#TableDetailsThead").empty();
	$("#TableDetailsTbody").empty();
}
// side bar 2 second tab control
// ***********************************************************************
function toggleReport() {
	if ($("#ulReports").hasClass('hide')) {
		$(".sidebarLi").removeClass("active");
		$("#ulReports").removeClass('hide');
		$("#liReport").addClass("active");
	} else {
		$(".sidebarLi").removeClass("active");
		$("#ulReports").addClass('hide');
		$("#liReport").addClass("active");
	}
}
function toggleSettings() {
	if ($("#ulSettings").hasClass('hide')) {
		$(".sidebarLi").removeClass("active");
		$("#liSettings").addClass("active");
		$("#ulSettings").removeClass('hide');
	} else {
		$(".sidebarLi").removeClass("active");
		$("#ulSettings").addClass('hide');
		$("#liSettings").addClass("active");
	}
}
// side bar 5 second block control
// ***********************************************************************
function showLogAnalysis() {
	$(".sidebarLi").removeClass("active");
	$("#liLogAnalysis").addClass("active");
	$(".mainContentDiv").hide();
	$("#divLogAnalysis").show();
	initialReportChartAndTable();
}
function showHistoryReport() {
	$(".sidebarLi").removeClass("active");
	$("#liHistoryReport").addClass("active");
	$(".mainContentDiv").hide();
	$("#divHistoryReport").show();
	initialReportChartAndTable();
}
function showCustomizeReportTemplate() {
	$(".sidebarLi").removeClass("active");
	$("#liCustomizeReportTemplate").addClass("active");
	$(".mainContentDiv").hide();
	$("#divCustomizeReportTemplate").show();
	initialReportChartAndTable();
}
function showEmailSettings() {
	$(".sidebarLi").removeClass("active");
	$("#liEmailSettings").addClass("active");
	$(".mainContentDiv").hide();
	$("#divEmailSettings").show();
	initialReportChartAndTable();
	showEmailSender();
}
function showTaskSettings() {
	$(".sidebarLi").removeClass("active");
	$("#liTaskSettings").addClass("active");
	$(".mainContentDiv").hide();
	$("#divTaskSettings").show();
	initialReportChartAndTable();
}
// Email Settings 6 tab control
// ***********************************************************************
function showEmailSender() {
	$("#divSender").show();
	$("#divSenderModify").hide();
	$("#divServer").hide();
	$("#divServerModify").hide();
	$("#divReceiver").hide();
	$("#divReceiverModify").hide();
	$("#liEmailSender").addClass("active");
	$("#liEmailServer").removeClass("active");
	$("#liEmailReceiver").removeClass("active");
	
	//get the data form database
	$.post("MailSendAction!findSenderConfig()",{},function(data,status){
		if(status=="success"){
			$("#senderTable").empty();
			$("#senderTable").append("<thead><tr>"+
									"<th>Agency</th>"+
									"<th>UserName</th>"+
									"<th>Password</th>"+
									"<th>SenderEmail</th>"+
									"<th>Update</th>"+
									"<th>Server</th>"+
								"</tr></thead>"+"<tbody><tr>"+
									"<td>"+data.agency+"</td>"+
									"<td>"+data.userName+"</td>"+
									"<td>"+data.password+"</td>"+
									"<td>"+data.mailSender+"</td>"+
									"<td><button class='btn btn-primary' onClick='showEmailSenderModify("+data.id+",this)'>update</button></td>"+
									"<td><select style='margin-top: 6px;'><option>"+data.serverName+"</option></select></td>"+
								"</tr></tbody>");
			
			//set server 
			$("#serverSelect").append("<select id='serverName'><option>"+data.serverName+"</option></select>");
		}
	});
	
}

function showEmailSenderModify(id,thisLine) {
	
	//show dialog
	$("body").append("<div id='mask'></div>");
	$("#mask").addClass("mask").fadeIn("slow");
	$("#senderBox").fadeIn("slow");
	//set data in input
	var agency=$(thisLine).parent().prev().prev().prev().prev().text();
	var userName=$(thisLine).parent().prev().prev().prev().text();
	var password=$(thisLine).parent().prev().prev().text();
	var mailSender=$(thisLine).parent().prev().text();
	$("#agency").val(agency);
	$("#userName").val(userName);
	$("#password").val(password);
	$("#mailSender").val(mailSender);
	//update sender data
	$("#senderSubmit").click(function(){
		//get data
		var agency=$("#agency").val();
		var userName=$("#userName").val();
		var password=$("#password").val();
		var mailSender=$("#mailSender").val();
		$.post("MailSendAction!updateSenderConfig",{
			'sender.agency':agency,
			'sender.userName':userName,
			'sender.password':password,
			'sender.mailSender':mailSender,
			'sender.id':id,
		},function(data,status){
			if(status=="success"){
				//close dialog
				$("#senderBox").fadeOut("fast");
				$("#mask").css({
					display : 'none'
				});
				//update data
				if(data.result=="true"){
					$(thisLine).parent().prev().prev().prev().prev().text(data.agency);
					$(thisLine).parent().prev().prev().prev().text(data.userName);
					$(thisLine).parent().prev().prev().text(data.password);
					$(thisLine).parent().prev().text(data.mailSender);
				}
			}
		});
	});
	
}

function addSender(){
	//show dialog
	$("body").append("<div id='mask_add'></div>");
	$("#mask_add").addClass("mask_add").fadeIn("slow");
	$("#senderaddBox").fadeIn("slow");
	
	$("#agencyadd").val("");
	$("#userNameadd").val("");
	$("#passwordadd").val("");
	$("#mailSenderadd").val("");
	$("#senderaddSubmit").click(function(){
		$.post("MailSendAction!",{
			'sender.agency':$("#agencyadd").val(),
			'sender.userName':$("#userNameadd").val(),
			'sender.password':$("#passwordadd").val(),
			'sender.mailSender':$("#mailSenderadd").val(),
			'sender.server.serverName':$("#serverName  option:selected").text(),
		},function(data,status){
			if(status=="success"&&data.result=="true"){
				
			}
		});
	});
	
	
}

function showEmailServer() {
	$("#divSender").hide();
	$("#divSenderModify").hide();
	$("#divServer").show();
	$("#divServerModify").hide();
	$("#divReceiver").hide();
	$("#divReceiverModify").hide();
	$("#liEmailSender").removeClass("active");
	$("#liEmailServer").addClass("active");
	$("#liEmailReceiver").removeClass("active");
	
	//get the data form database
	$.post("MailSendAction!findServerConfig()",{},function(data,status){
		if(status=="success"){
			$("#serverTable").empty();
			$("#serverTable").append("<thead>"+
									"<tr>"+
									"<th>Server</th>"+
									"<th>ServerHost</th>"+
									"<th>update</th>"+
									"<th>Protocol</th>"+
								"</tr></thead>"+"<tbody><tr>"+
									"<td>"+data.serverName+"</td>"+
									"<td>"+data.host+"</td>"+
									"<td><button class='btn btn-primary'onClick='showEmailServerModify("+data.id+",this)'>update</button></td>"+
									"<td><select style='margin-top: 6px;'><option>SMTP</option></select></td>"+
								"</tr></tbody>");
		}
	});
}
function showEmailServerModify(id,thisLine) {
	
	//show dialog
	$("body").append("<div id='mask_ser'></div>");
	$("#mask_ser").addClass("mask_ser").fadeIn("slow");
	$("#serverBox").fadeIn("slow");
	
	//get the data
	var host=$(thisLine).parent().prev().text();
	var serverName=$(thisLine).parent().prev().prev().text();
	
	//set to input
	$("#serverHost").val(host);
	$("#serverName").val(serverName);
	
	$("#serverSubmit").click(function(){
	//ajax update
	$.post("MailSendAction!updateServerConfig",{
		'server.host':$("#serverHost").val(),
		'server.serverName':$("#serverName").val(),
		'server.id':id,
	},function(data,status){
		if(status=="success"){
			//close dialog
			$("#serverBox").fadeOut("fast");
			$("#mask_ser").css({
				display : 'none'
			});
			
			//update data to page
			if(data.result=="true"){
				$(thisLine).parent().prev().text(data.serverHost);
				$(thisLine).parent().prev().prev().text(data.serverName);
			}
		}
	});
	
	});
	
	
}
function showEmailReceiver() {
	$("#divSender").hide();
	$("#divSenderModify").hide();
	$("#divServer").hide();
	$("#divServerModify").hide();
	$("#divReceiver").show();
	$("#divReceiverModify").hide();
	$("#liEmailSender").removeClass("active");
	$("#liEmailServer").removeClass("active");
	$("#liEmailReceiver").addClass("active");
	
	//get the data form database
	$.post("MailSendAction!findReceiver()",{},function(data,status){
		if(status=="success"){
			$("#receiverTable").empty();
			$("#receiverTable").append("<thead><tr>"+
									"<th>ReceiverEmail</th>"+
									"<th>update</th>"+
									"<th>delete</th>"+
								"</tr></thead><tbody>");
			for(var i=0;i<data.receivers.length;i++){
				$("#receiverTable").append("<tr>"+
									"<td>"+data.receivers[i].mailBox+"</td>"+
									"<td><button class='btn btn-primary' onClick='showEmailReceiverModify("+data.receivers[i].id+",this)'>update</button></td>"+
									"<td><button class='btn btn-primary' onClick='receiverDelete("+data.receivers[i].id+",this)'>delete</button></td>"+
								"</tr>");
			}
			$("#receiverTable").append("</tbody>");
		}
	});
	
}

function receiverDelete(id,thisLine){
	$.post("MailSendAction!deleteReceiver",{
		'receiver.id':id,
	},function(data,status){
		if(status="success"&&data.result=="true"){
			$(thisLine).parent().parent().remove();
		}
	});
}

function showEmailReceiverModify(id,thisLine) {
	
	//show dialog
	$("body").append("<div id='mask_rec'></div>");
	$("#mask_rec").addClass("mask_rec").fadeIn("slow");
	$("#receiverBox").fadeIn("slow");
	
	//set data to input
	var mailBox=$(thisLine).parent().prev().text();
	$("#receiverEmail").val(mailBox);
	
	//ajax update
	$("#receiverSubmit").click(function(){
		$.post("MailSendAction!updateReceiver",{
			'receiver.id':id,
			'receiver.mailBox':$("#receiverEmail").val(),
		},function(data,status){
			if(status=="success"){
				//close dialog
				$("#receiverBox").fadeOut("fast");
				$("#mask_rec").css({
					display : 'none'
				});
				
				//update data to page
				$(thisLine).parent().prev().text(data.mailBox);
			}
		});
		
	});
	
	
	
	
}
// big grey DIV
// ********************************************************************************
// ShowDIV('DialogDiv');
// closeDiv('DialogDiv');
// ********************************************************************************
function ShowDIV(thisObjID) {
	$("#BgDiv").css({
		display : "block",
		height : $(document).height()
	});
	$("#" + thisObjID).css("top", "100px");
	$("#" + thisObjID).css("display", "block");
	document.documentElement.scrollTop = 0;
}

function closeDiv(thisObjID) {
	$("#BgDiv").css("display", "none");
	$("#" + thisObjID).css("display", "none");
}
// dateTimeFormat
// ****************************************************************
function dateTimeFormat(date) {
	return date.toString().substring(0, 19);
}