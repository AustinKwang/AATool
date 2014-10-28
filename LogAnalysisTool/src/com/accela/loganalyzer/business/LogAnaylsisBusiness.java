package com.accela.loganalyzer.business;

import java.util.Date;
import java.util.List;

import com.accela.loganalyzer.loganalysis.LogAnalysisChain;
import com.accela.loganalyzer.readfile.Context;
import com.accela.loganalyzer.readfile.FindLogFile;
import com.accela.loganalyzer.readfile.LogFileScanner;

/**
 * <pre>
 * 
 *  N/A Automation
 *  File: LogAnaylsisBusiness.java
 * 
 *  N/A, Inc.
 *  Copyright (C): 2014
 * 
 *  Description:
 *  TODO
 * 
 *  Revision History
 *  Date,		Who,		What;
 *  2014年9月11日		pc		Initial.
 *  
 * </pre>
 */
public class LogAnaylsisBusiness implements LogAnaylsisService
{

	private LogFileScanner logFileScanner;
	

	@Override
	public void analysisLogFile(String webSite, String server, String logType, String starDate, String endDate)
	{
		//loop to get log file
		FindLogFile logFileFinder=new FindLogFile();
		List<String> logFiles = logFileFinder.findLogFile(null,server , logType, starDate, endDate);
		//loop to scanner log file and analysis them
		for (int i = 0; i < logFiles.size(); i++)
		{
			this.logFileScanner.parseFile(logFiles.get(i));
		}
		
		
		
	}

	@Override
	public void generateReport(String reportName)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void generateSummary()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void runTask()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void sendSummary()
	{
		// TODO Auto-generated method stub
	}

	/**
	 * @param logFileScanner the logFileScanner to set
	 */
	public void setLogFileScanner(LogFileScanner logFileScanner)
	{
		this.logFileScanner = logFileScanner;
	}

}

/*
*$Log: $
*/