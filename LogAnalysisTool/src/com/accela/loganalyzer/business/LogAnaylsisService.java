package com.accela.loganalyzer.business;

import java.util.Date;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: LogAnaylsisService.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2014
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: LogAnaylsisService.java 72642 2009-01-01 20:01:57Z ACHIEVO\Austin.Wang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  2014-9-10		Austin.Wang		Initial.
 *  
 * </pre>
 */
public interface LogAnaylsisService
{

	/**
	 * only analysis file and save to DB
	 *
	 * @param logCategory, mark the log file is what category, serverlog, accesslog, profilelog..
	 * @param fileName 
	 */
	public void analysisLogFile(String webSite, String server, String logType, String starDate, String endDate);
	
	/**
	 * generate report
	 *
	 * @param reportName 
	 */
	public void generateReport(String reportName);
	
	/**
	 * send summary to user
	 * 
	 */
	public void sendSummary();
	
	/**
	 * generate summary
	 * 
	 */
	public void generateSummary();
	
	/**
	 * run task, which contains analysis log file, generate report, send summary
	 * 
	 */
	public void runTask();
	
}

/*
*$Log: av-env.bat,v $
*/