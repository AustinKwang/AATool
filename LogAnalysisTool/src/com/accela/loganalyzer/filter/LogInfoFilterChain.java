package com.accela.loganalyzer.filter;

import java.util.List;

import com.accela.loganalyzer.readfile.Context;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: LogInfoFilter.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2014
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: LogInfoFilter.java 72642 2009-01-01 20:01:57Z ACHIEVO\Austin.Wang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  2014-9-11		Austin.Wang		Initial.
 *  
 * </pre>
 */
public class LogInfoFilterChain
{
	
	/**
	 * the filters to filter which logInfo didn't need capture.
	 */
	private List<LogInfoFilter> logInfoFilters;

	/**
	 * get current filters list.
	 *
	 * @return 
	 */
	public List<LogInfoFilter> getLogInfoFilters()
	{
		return logInfoFilters;
	}

	/**
	 * define which filters, should be used
	 *
	 * @param logInfoFilters 
	 */
	public void setLogInfoFilters(List<LogInfoFilter> logInfoFilters)
	{
		this.logInfoFilters = logInfoFilters;
	}
	
	/**
	 * filter each log line, decide current log if current log info need save
	 *
	 * @param line
	 * @param context 
	 */
	public void performFilters(String line, Context context)
	{
		for (LogInfoFilter filter : logInfoFilters)
		{
			filter.doFilter(line, context);
		}
	}
}

/*
*$Log: av-env.bat,v $
*/