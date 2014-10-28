window.onload = function() {

	$.post('serverLogInfoWarnClassNameAction', {}, function(data) {

		window.Pie = new Chart($("#warnClassNamePieChart").get(0).getContext(
				"2d")).Pie(data.pieBlocks, {
			responsive : true
		});
		window.myDoughnut = new Chart($("#warnClassNameDoughnutChart").get(0)
				.getContext("2d")).Doughnut(data.pieBlocks, {
			responsive : true
		});
	}, "json");

	$
			.post(
					'systemMemoryAction',
					{},
					function(data) {
						window.myLine = new Chart($("#memoryLineChart").get(0)
								.getContext("2d")).Line(
								data.lineChartCompleteData, {
									responsive : true
								});
						for (var i = 0; i < data.lineChartCompleteData.datasets.length; i++) {
							$("#colorDesc")
									.append(
											"<tr><td><span class='glyphicon glyphicon-stop' style='color: "
													+ data.lineChartCompleteData.datasets[i].pointColor
													+ "'></span>"
													+ data.lineChartCompleteData.datasets[i].label
													+ "</td></tr>");
						}
					}, "json");

};