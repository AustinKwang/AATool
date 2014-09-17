package com.accela.loganalyzer.report.service;

import com.accela.loganalyzer.report.action.TableContext;

/**
 * <pre>
 * 
 *  N/A Automation
 *  File: TableService.java
 * 
 *  N/A, Inc.
 *  Copyright (C): 2014
 * 
 *  Description:
 *  TODO
 * 
 *  Revision History
 *  Date,		Who,		What,
 *  2014年9月12日		Golden Huang		Initial.
 * 
 * </pre>
 */
public interface TableService
{

	void getTableData(String webSite, String server, String log, String startDate, String endDate,
			boolean tableTypeCount, boolean tableTypeDetails, boolean tableLevelError, boolean tableLevelWarn,
			TableContext tableContext);

}

/*
 * $Log: $
 */