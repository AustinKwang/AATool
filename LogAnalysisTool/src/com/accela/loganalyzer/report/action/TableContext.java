package com.accela.loganalyzer.report.action;

import java.util.List;

/**
 * <pre>
 * 
 *  N/A Automation
 *  File: TableContext.java
 * 
 *  N/A, Inc.
 *  Copyright (C): 2014
 * 
 *  Description:
 *  TODO
 * 
 *  Revision History
 *  Date,		Who,		What;
 *  2014年9月15日		Golden Huang		Initial.
 * 
 * </pre>
 */
public class TableContext
{
	private List<List<String>> count;

	private List<List<String>> details;

	public TableContext()
	{
		this.count = null;
		this.details = null;
	}

	/**
	 * @return the count
	 */

	public List<List<String>> getCount()
	{
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(List<List<String>> count)
	{
		this.count = count;
	}

	/**
	 * @return the details
	 */

	public List<List<String>> getDetails()
	{
		return details;
	}

	/**
	 * @param details the details to set
	 */
	public void setDetails(List<List<String>> details)
	{
		this.details = details;
	}

}

/*
 * $Log: $
 */