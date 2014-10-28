package com.accela.loganalyzer.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.accela.loganalyzer.business.LogAnaylsisService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * <pre>
 * 
 *  N/A Automation
 *  File: LogAnalysisAction.java
 * 
 *  N/A, Inc.
 *  Copyright (C): 2014
 * 
 *  Description:
 *  TODO
 * 
 *  Revision History
 *  Date,		Who,		What;
 *  2014年9月12日		pc		Initial.
 *  
 * </pre>
 */
public class LogAnalysisAction extends ActionSupport
{


	private String endDate;


	private String log;


	private LogAnaylsisService logAnaylsisService;

	private String server;

	private String startDate;

	private String webSite;

	public String analysisLog()
	{
		this.logAnaylsisService.analysisLogFile(webSite, server, log, startDate, endDate);
		return "success";
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate)
	{
		this.endDate = endDate;
	}

	/**
	 * @param log the log to set
	 */
	public void setLog(String log)
	{
		this.log = log;
	}

	
	/**
	 * @param logAnaylsisService the logAnaylsisService to set
	 */
	public void setLogAnaylsisService(LogAnaylsisService logAnaylsisService)
	{
		this.logAnaylsisService = logAnaylsisService;
	}
	
	/**
	 * @param server the server to set
	 */
	public void setServer(String server)
	{
		this.server = server;
	}
	
	/**
	 * @param starDate the starDate to set
	 */
	public void setStartDate(String startDate)
	{
		this.startDate = startDate;
	}
	

	
	/**
	 * @param webSite the webSite to set
	 */
	public void setWebSite(String webSite)
	{
		this.webSite = webSite;
	}
	
}

/*
*$Log: $
*/