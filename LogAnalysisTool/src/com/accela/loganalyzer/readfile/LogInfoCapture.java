package com.accela.loganalyzer.readfile;


/**
 * <pre>
 * 
 *  N/A Automation
 *  File: T.java
 * 
 *  N/A, Inc.
 *  Copyright (C): 2014
 * 
 *  Description:
 *  TODO
 * 
 *  Revision History
 *  Date,		Who,		What;
 *  2014骞�鏈�0鏃�	pc		Initial.
 * 
 * </pre>
 */
public interface LogInfoCapture
{
	/**
	 * get log info name.
	 * 
	 * @return
	 */
	public String getLogInfoName();

	/**
	 * capture one whole logInfo which may be take over more than one line.
	 *
	 * @param line one line logInfo in log file.
	 * @param context
	 * @return true/false, if current line logInfo has been captured, will return true, otherwise return false.
	 */
	public boolean capture(String line, Context context);


}

/*
 * $Log: $
 */