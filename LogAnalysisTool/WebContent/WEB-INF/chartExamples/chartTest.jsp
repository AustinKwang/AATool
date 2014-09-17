<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Chart.js</title>

<!-- CSS file ************************************************** -->

<!-- bootstrap -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">

<!-- self -->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/common.css">

<!-- /.CSS file -->
</head>
<body>
	<h1>Hello,welcome to golden's chart testing web site.</h1>

	<div class="row">
		<div class="col-xs-10 col-xs-offset-1">
			<h4>warn class name</h4>
		</div>
		<div class="col-xs-11 col-sm-5 col-md-4">
			<canvas id="warnClassNamePieChart" />
		</div>
		<div class="col-xs-11 col-sm-5 col-md-4">
			<canvas id="warnClassNameDoughnutChart" />
		</div>
	</div>

	<div class="row">
		<div class="col-xs-11 col-xs-offset-1">
			<h4>memory</h4>
		</div>
		<div class="col-xs-8 col-xs-offset-1">
			<canvas id="memoryLineChart" />
		</div>
		<div class="col-xs-2">
			<table id="colorDesc"></table>
		</div>
	</div>



	<!-- JS file************************************************************** -->

	<!-- JQuery -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/jquery/jquery-1.11.1.js"></script>

	<!-- bootstrap -->
	<script
		src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>

	<!-- chart -->
	<script
		src="${pageContext.request.contextPath}/bootstrap-chart/Chart.js"></script>

	<!-- self -->
	<script src="${pageContext.request.contextPath}/js/chartTest.js"
		type="text/javascript" charset="UTF-8"></script>

	<!-- /.JS file -->
</body>
</html>