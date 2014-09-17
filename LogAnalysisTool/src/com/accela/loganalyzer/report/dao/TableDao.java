package com.accela.loganalyzer.report.dao;

import java.util.List;

/**
 * <pre>
 * 
 *  N/A Automation
 *  File: TableDao.java
 * 
 *  N/A, Inc.
 *  Copyright (C): 2014
 * 
 *  Description:
 *  TODO
 * 
 *  Revision History
 *  Date,		Who,		What;
 *  2014年9月12日		Golden Huang		Initial.
 * 
 * </pre>
 */
public interface TableDao
{
	/**
	 * count.
	 * 
	 * @return
	 */
	public List<List<String>> count(String level, String startDate, String endDate);

	/**
	 * details.
	 * 
	 * @return
	 */
	public List<List<String>> details(String level, String startDate, String endDate);
}

/*
 * $Log: $
 */