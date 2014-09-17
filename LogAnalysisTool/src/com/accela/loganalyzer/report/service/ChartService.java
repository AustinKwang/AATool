package com.accela.loganalyzer.report.service;

import com.accela.loganalyzer.report.converter.ChartDataContext;

/**
 * <pre>
 * 
 *  N/A
 *  File: ChartService.java
 * 
 *  N/A, Inc.
 *  Copyright (C): 2014
 * 
 *  Description:
 *  TODO
 * 
 *  Revision History
 *  Date,		Who,		What;
 *  2014年9月11日		Golden Huang		Initial.
 * 
 * </pre>
 */
public interface ChartService
{
	public void getChartData(String webSite, String server, String log, String startDate, String endDate,
			String reportType, String level, ChartDataContext chartDataContext);
}

/*
 * $Log: $
 */