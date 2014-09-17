<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>LogAnalysis</title>
<!-- CSS file ********************************************************************************************************************** -->

<!-- bootstrap -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">

<!-- date time picker -->
<link
	href="${pageContext.request.contextPath}/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet" media="screen">

<!-- self -->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/common.css">
<link rel="Stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/loginDialog.css" />

<!-- /.CSS file -->

</head>
<body>

	<!-- navigation bar ***************************************************************************************************** -->


	<div class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="index"><font size="4"><b>Log&nbsp;Analysis</b></font></a>
			</div>
		</div>
	</div>
	<!-- navigation bar -->




	<div class="container-fluid">
		<div class="row">


			<!-- side bar **************************************************************************************** -->
			<div class="col-xs-2 sidebar">
				<ul class="nav nav-sidebar">
					<li id="liLogAnalysis" class="sidebarLi"><a
						onclick="showLogAnalysis()">Log Analysis</a></li>
					<li id="liReport" class="sidebarLi"><a
						onclick="toggleReport()">Reports</a>
						<ul class="nav nav-sidebar2 hide" id="ulReports">
							<li id="liHistoryReport" class="sidebarLi"><a
								onclick="showHistoryReport()">History Reports</a></li>
							<li id="liCustomizeReportTemplate" class="sidebarLi"><a
								onclick="showCustomizeReportTemplate()">Customize Report
									Template</a></li>
						</ul></li>
					<li id="liSettings" class="sidebarLi"><a
						onclick="toggleSettings()">Settings</a>
						<ul class="nav nav-sidebar2 hide" id="ulSettings">
							<li id="liEmailSettings" class="sidebarLi"><a
								onclick="showEmailSettings()">Email Settings</a></li>
							<li id="liTaskSettings" class="sidebarLi"><a
								onclick="showTaskSettings()">Task Settings</a></li>
						</ul></li>
				</ul>
			</div>
			<!-- /.side bar -->


			<!-- main content **************************************************************************************** -->
			<div class="col-xs-10 col-xs-offset-2 main">
				<div class="col-xs-12 col-xs-offset-0">

					<!-- LogAnalysis ********************************************************************************************** -->
					<div id="divLogAnalysis" class="mainContentDiv">

						<h3 class="page-header">Log&nbsp;Analysis</h3>
						<br>
						<form class="form-horizontal">
							<div class="form-group">
								<label class="col-xs-1 control-label">Web Site:</label>
								<div class="col-xs-3">
									<select class="form-control" id="WebSite">
										<option>Agency</option>
									</select>
								</div>
								<label class="col-xs-1 control-label">Server:</label>
								<div class="col-xs-3">
									<select class="form-control" id="Server">
										<option>biz</option>
										<option>server</option>
										<option>360</option>
									</select>
								</div>
								<label class="col-xs-1 control-label">Log:</label>
								<div class="col-xs-3">
									<select class="form-control" id="Log">
										<option>server</option>
										<option>profile</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-1 control-label">Start Date:</label>
								<div class="col-xs-3">
									<div class="input-group date formDate">
										<input class="form-control pionter" type="text" readonly
											id="StartDate"><span class="input-group-addon"><span
											class="glyphicon glyphicon-calendar"></span></span>
									</div>
								</div>
								<label class="col-xs-1 control-label">End Date:</label>
								<div class="col-xs-3">
									<div class="input-group date formDate">
										<input class="form-control pionter" type="text" readonly
											id="EndDate"><span class="input-group-addon"><span
											class="glyphicon glyphicon-calendar"></span></span>
									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-1 control-label">Report Type:</label>
								<div class="col-xs-3">
									<select class="form-control" id="ReportType">
										<option>common</option>
										<option>memory</option>
									</select>
								</div>
								<label class="col-xs-1 control-label">Level:</label>
								<div class="col-xs-3">
									<select class="form-control" id="Level">
										<option>WARN</option>
										<option>ERROR</option>
									</select>
								</div>
							</div>
						</form>

						<p class="btn btn-lg btn-primary col-xs-offset-1"
							onclick="dragonReport()">Submit&nbsp;&raquo;</p>
						<br> <br> <br>

						<div class="row">
							<div class="col-xs-5 col-xs-offset-3 alert alert-info hide"
								id="TipCannotFindChartData">Sorry,can't find any data.</div>
							<div class="col-xs-10" id="divCanvas"></div>
							<div class="col-xs-2">
								<table id="ColorDesc"></table>
							</div>
						</div>
					</div>
					<!-- /。LogAnalysis -->




					<!-- HistoryReport **************************************************************************** -->

					<div id="divHistoryReport" class="mainContentDiv">

						<h3 class="page-header">History&nbsp;Report</h3>
						<br>
						<form class="form-horizontal">
							<div class="form-group">
								<label class="col-xs-1 control-label">Web Site:</label>
								<div class="col-xs-3">
									<select class="form-control" id="FormWebSite">
										<option>Agency</option>
									</select>
								</div>
								<label class="col-xs-1 control-label">Server:</label>
								<div class="col-xs-3">
									<select class="form-control" id="FormServer">
										<option>biz</option>
										<option>server</option>
										<option>360</option>
									</select>
								</div>
								<label class="col-xs-1 control-label">Log:</label>
								<div class="col-xs-3">
									<select class="form-control" id="FormLog">
										<option>ServerLog</option>
										<option>Profile</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-1 control-label">Start Date:</label>
								<div class="col-xs-3">
									<div class="input-group date formDate">
										<input class="form-control pionter" type="text" readonly
											id="FormStartDate"><span class="input-group-addon"><span
											class="glyphicon glyphicon-calendar"></span></span>
									</div>
								</div>
								<label class="col-xs-1 control-label">End Date:</label>
								<div class="col-xs-3">
									<div class="input-group date formDate">
										<input class="form-control pionter" type="text" readonly
											id="FormEndDate"><span class="input-group-addon"><span
											class="glyphicon glyphicon-calendar"></span></span>
									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-1 control-label">Info Type:</label>
								<div class="col-xs-3">
									<select class="form-control" id="FormReportType"
										onChange="toggleDivFormLevel()">
										<option>common</option>
										<option>memory</option>
									</select>
								</div>
							</div>
							<div class="form-group" id="divCommonDetails">
								<label class="col-xs-1 control-label">Level:</label>
								<div class="col-xs-3">
									<select class="form-control" id="FormLevel">
										<option>ERROR</option>
										<option>WARN</option>
									</select>
								</div>
								<div class="col-xs-8">
									<label class="checkbox-inline"><input type="checkbox"
										id="FormTypeDetails" checked="checked">Details</label> <label
										class="checkbox-inline"><input type="checkbox"
										id="FormTypeCount" checked="checked">Count</label>
								</div>
							</div>
						</form>

						<p class="btn btn-lg btn-primary col-xs-offset-1"
							onclick="historyReport()">Run&nbsp;&raquo;</p>
						<br> <br> <br>

						<div class="row">
							<div class="col-xs-5 col-xs-offset-3 alert alert-info hide"
								id="tipCannotFindReportData">Sorry,can't find any data.</div>
							<div class="col-xs-10" id="divChartCanvas"></div>
							<div class="col-xs-2">
								<table id="colorDesc"></table>
							</div>
						</div>
						<div class="table-responsive col-lg-12">
							<table border="1">
								<thead id="TableCountThead" align="center"></thead>
								<tbody id="TableCountTbody" align="center"></tbody>
							</table>
							<table class="table">
								<thead id="TableDetailsThead"></thead>
								<tbody id="TableDetailsTbody"></tbody>
							</table>
							<div id="divTableDescTemp"></div>
						</div>
					</div>
				</div>
				<!-- history report -->


					<div id="divEmailSettings">
						<ol class="breadcrumb">
							<li>Accela&nbsp;Tools</li>
							<li>Log&nbsp;Analysis</li>
							<li>Settings</li>
							<li>Email&nbsp;Settings</li>
						</ol>
						<h3 class="page-header">Email&nbsp;Settings</h3>
						<ul class="nav nav-tabs nav-justified">
							<li id="liEmailSender"><a onclick="showEmailSender()">Sender</a></li>
							<li id="liEmailServer"><a onclick="showEmailServer()">Server</a></li>
							<li id="liEmailReceiver"><a onclick="showEmailReceiver()">Receiver</a></li>
						</ul>
						<br> <br> <br>
						
						
						<div id="divSender">
							 <!-- update -->
							 
							   <div id="senderBox">
							       <div class="row1111">
							           Update Sender
							           <a href="javascript:void(0)" class="close_btn_bbb" id="closeBtn">×</a>
							       </div>
							       <div class="row111">
							          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Agency:
							           <span class="inputBox">
							               <input type="text" id="agency" class="styleInput"/>
							           </span>
							       </div>
							       <div class="row111">
							         &nbsp;&nbsp;&nbsp; UserName:
							          <span class="inputBox">
							               <input type="text" id="userName" class="styleInput" />
							           </span>
							       </div>
							         <div class="row111">
							         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Password:
							          <span class="inputBox">
							               <input type="text" id="password" class="styleInput" />
							           </span>
							       </div>
							         <div class="row111">
							          SenderEmail:
							          <span class="inputBox">
							               <input type="text" id="mailSender" class="styleInput" />
							           </span>
							       </div>
							       <div class="row111">
							           <a href="javascript:void(0)" id="senderSubmit">submit</a>
							       </div>
							   </div>
							   
							  <!-- add --> 
							  <div id="senderaddBox">
							       <div class="row1111">
							           Add Sender
							           <a href="javascript:void(0)" class="close_btn_bbb" id="closeBtn">×</a>
							       </div>
							       <div class="rowadd111">
							          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Agency:
							           <span class="inputBox">
							               <input type="text" id="agencyadd" class="styleInput"/>
							           </span>
							       </div>
							       <div class="rowadd111">
							         &nbsp;&nbsp;&nbsp;UserName:
							          <span class="inputBox">
							               <input type="text" id="userNameadd" class="styleInput" />
							           </span>
							       </div>
							         <div class="rowadd111">
							         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Password:
							          <span class="inputBox">
							               <input type="text" id="passwordadd" class="styleInput" />
							           </span>
							       </div>
							         <div class="rowadd111">
							          SenderEmail:
							          <span class="inputBox">
							               <input type="text" id="mailSenderadd" class="styleInput" />
							           </span>
							       </div>
							       <div class="rowadd111">
							         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Server:
							          <span class="inputBox" id="serverSelect">
							           </span>
							       </div>
							       <div class="rowadd111">
							           <a href="javascript:void(0)" id="senderaddSubmit">submit</a>
							       </div>
							   </div>
						
							<table id="senderTable" class="table table-hover">
							</table>
							<button class="btn btn-primary" onClick='addSender()'>add</button>
						</div>


				<!-- CustomizeReportTemplate ************************************************************************************** -->


				<div id="divCustomizeReportTemplate" class="mainContentDiv">
					<h3 class="page-header">Customize&nbsp;Report&nbsp;Template</h3>
				</div>
				<!-- CustomizeReportTemplate -->



				<!-- Settings ************************************************************************************** -->
				<div id="divEmailSettings" class="mainContentDiv">
					<h3 class="page-header">Email&nbsp;Settings</h3>
					<ul class="nav nav-tabs nav-justified">
						<li id="liEmailSender"><a onclick="showEmailSender()">Sender</a></li>
						<li id="liEmailServer"><a onclick="showEmailServer()">Server</a></li>
						<li id="liEmailReceiver"><a onclick="showEmailReceiver()">Receiver</a></li>
					</ul>
					<br> <br> <br>
					<div id="divSender">
						<form class="form-horizontal">
							<div class="form-group">
								<label class="col-xs-2 control-label">User&nbsp;Name:</label>
								<div class="col-xs-10">
									<p id="realName" class="form-control-static">Golden Huang</p>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-2 control-label">Email&nbsp;Address:</label>
								<div class="col-xs-10">
									<p id="birthday" class="form-control-static">jz_golden_huang@163.com</p>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-2 control-label">Password:</label>
								<div class="col-xs-10">
									<p id="sex" class="form-control-static">123456</p>
								</div>
							</div>
						</form>
						<p class="btn btn-lg btn-primary col-xs-offset-2"
							onclick="showEmailSenderModify()">Modify&nbsp;&raquo;</p>
					</div>

					<div id="divSenderModify">
						<form class="form-horizontal">
							<div class="form-group">
								<label class="col-xs-2 control-label">User&nbsp;Name:</label>
								<div class="col-xs-3">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-2 control-label">Email&nbsp;Address:</label>
								<div class="col-xs-3">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-2 control-label">Password:</label>
								<div class="col-xs-3">
									<input type="text" class="form-control">
								</div>
							</div>
						</form>
						<p class="btn btn-lg btn-primary col-xs-offset-2" onclick="">Submit&nbsp;&raquo;</p>
						<p class="btn btn-lg btn-primary" onclick="showEmailSender()">Back</p>
					</div>

						<div id="divServer">
						
							 <div id="serverBox">
							       <div class="row1111">
							           Server Update
							           <a href="javascript:void(0)" class="close_btn_bbb" id="closeBtn_server">×</a>
							       </div>
							       <div class="serverrow1">
							          &nbsp;&nbsp;ServerName:
							           <span class="inputBox">
							               <input type="text" id="serverName" class="styleInput"/>
							           </span>
							         </div>
							       <div class="serverrow2">
							          &nbsp;&nbsp;&nbsp;&nbsp;ServerHost:
							           <span class="inputBox">
							               <input type="text" id="serverHost" class="styleInput"/>
							           </span>
							       </div>
							       <div class="serverrow2">
							           <a href="javascript:void(0)" id="serverSubmit">submit</a>
							       </div>
							   </div>
							
						
							<table id="serverTable" class="table table-hover">
							</table>
						</div>
					<div id="divServer">
						<form class="form-horizontal">
							<div class="form-group">
								<label class="col-xs-2 control-label">Receiving&nbsp;Server:</label>
								<div class="col-xs-10">
									<p id="" class="form-control-static">pop.sina.com.cn</p>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-2 control-label">Sending&nbsp;Server:</label>
								<div class="col-xs-10">
									<p id="" class="form-control-static">smtp.sina.com.cn</p>
								</div>
							</div>
						</form>
						<p class="btn btn-lg btn-primary col-xs-offset-2"
							onclick="showEmailServerModify()">Modify&nbsp;&raquo;</p>
					</div>

					<div id="divServerModify">
						<form class="form-horizontal">
							<div class="form-group">
								<label class="col-xs-2 control-label">Receiving&nbsp;Server:</label>
								<div class="col-xs-3">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-2 control-label">Sending&nbsp;Server:</label>
								<div class="col-xs-3">
									<input type="text" class="form-control">
								</div>
							</div>
						</form>
						<p class="btn btn-lg btn-primary col-xs-offset-2" onclick="">Submit&nbsp;&raquo;</p>
						<p class="btn btn-lg btn-primary" onclick="showEmailServer()">Back</p>
					</div>

						<div id="divReceiver">
						
							<div id="receiverBox">
							       <div class="row1111">
							           Server Update
							           <a href="javascript:void(0)" class="close_btn_bbb" id="closeBtn_receiver">×</a>
							       </div>
							       <div class="receiverrow1">
							          &nbsp;&nbsp;&nbsp;ReceiverEmail:
							           <span class="inputBox">
							               <input type="text" id="receiverEmail" class="styleInput"/>
							           </span>
							         </div>
							       <div class="serverrow1">
							           <a href="javascript:void(0)" id="receiverSubmit">submit</a>
							       </div>
							   </div>
						
						
							<table id="receiverTable" class="table table-hover">
							</table>
					<div id="divReceiver">
						<form class="form-horizontal">
							<div class="form-group">
								<label class="col-xs-2 control-label">Email&nbsp;Address:</label>
								<div class="col-xs-10">
									<p id="" class="form-control-static">121082612@qq.com</p>
								</div>
							</div>
						</form>
						<p class="btn btn-lg btn-primary col-xs-offset-2"
							onclick="showEmailReceiverModify()">Modify&nbsp;&raquo;</p>

					</div>

					<div id="divReceiverModify">
						<form class="form-horizontal">
							<div class="form-group">
								<label class="col-xs-2 control-label">Email&nbsp;Address:</label>
								<div class="col-xs-3">
									<input type="text" class="form-control">
								</div>
							</div>
						</form>
						<p class="btn btn-lg btn-primary col-xs-offset-2" onclick="">Submit&nbsp;&raquo;</p>
						<p class="btn btn-lg btn-primary" onclick="showEmailReceiver()">Back</p>
					</div>


				</div>

				<div id="divTaskSettings" class="mainContentDiv">
					<h3 class="page-header">Task&nbsp;Settings</h3>
					<div class="panel panel-default">
						<div class="panel-heading">My Task</div>
						<table class="table table-hover">
							<thead>
								<tr>
									<th>Task Name</th>
									<th>Set Time</th>
									<th>Web Site Type</th>
									<th>Execute Type</th>
									<th>Description</th>
									<th>Operation</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>Task 1</td>
									<td>2014-08-01</td>
									<td>Server</td>
									<td>Every Day</td>
									<td>Warn & Class Name</td>
									<td><p class="btn btn-primary">Modify</p>&nbsp;
										<p class="btn btn-primary">Delete</p></td>
								</tr>
								<tr>
									<td>Task 2</td>
									<td>2014-09-02</td>
									<td>V360</td>
									<td>Every Day</td>
									<td>Warn & Class Name</td>
									<td><p class="btn btn-primary">Modify</p>&nbsp;
										<p class="btn btn-primary">Delete</p></td>
								</tr>
								<tr>
									<td>Task 3</td>
									<td>2014-08-30</td>
									<td>BIZ</td>
									<td>Every Day</td>
									<td>Warn & Class Name</td>
									<td><p class="btn btn-primary">Modify</p>&nbsp;
										<p class="btn btn-primary">Delete</p></td>
								</tr>
								<tr>
									<td>Task 4</td>
									<td>2014-05-10</td>
									<td>Server</td>
									<td>Every Day</td>
									<td>Memory</td>
									<td><p class="btn btn-primary">Modify</p>&nbsp;
										<p class="btn btn-primary">Delete</p></td>
								</tr>
							</tbody>
						</table>
						<ul class="pager">
							<li id="liRecordPreviousPage"><a
								onclick="recordsPreviousPage()">Previous&nbsp;Page</a></li>
							<li id="liRecordsNextPage"><a onclick="recordsNextPage()">Next&nbsp;Page</a></li>
						</ul>
						<p align="center" id="records_pageDetails">page&nbsp;1&nbsp;of&nbsp;1</p>
						<input type="hidden" id="currentPage" value="1" />
						<div class="panel-body">
							<p class="btn btn-primary btn-lg">New&nbsp;Task</p>
						</div>
					</div>
				</div>
				<!-- /.task -->
			</div>
			<!-- main content -->
		</div>
		<!-- row -->
	</div>
	<!-- container-fluid -->

	

	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">Description</h4>
				</div>
				<div class="modal-body" id="modalContent"></div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-dismiss="modal">close</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>

	<div id="BgDiv"></div>
	<div id="DialogDiv" style="display: none" align="center">
		<img src="${pageContext.request.contextPath}/pic/analyzing.gif">
		<h2>Analyzing...</h2>
	</div>

	<!-- JS file**************************************************************************************** -->


	<!-- JQuery -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/jquery/jquery-1.11.1.js"></script>

	<!-- bootstrap -->
	<script
		src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/bootstrap/js/transition.js"></script>
	<script
		src="${pageContext.request.contextPath}/bootstrap/js/tooltip.js"></script>
	<script
		src="${pageContext.request.contextPath}/bootstrap/js/popover.js"></script>


	<!-- chart -->
	<script
		src="${pageContext.request.contextPath}/bootstrap-chart/Chart.js"></script>

	<!-- date time picker -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"
		charset="UTF-8"></script>

	<!-- self -->
	<script src="${pageContext.request.contextPath}/js/index.js"
		type="text/javascript" charset="UTF-8"></script>

	<!-- /.JS file -->
	
	<!-- dialog -->
	<script src="${pageContext.request.contextPath}/js/dialog.js"></script>
	<!-- dialog -->
</body>
</html>