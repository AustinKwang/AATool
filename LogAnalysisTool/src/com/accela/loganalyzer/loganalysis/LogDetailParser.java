package com.accela.loganalyzer.loganalysis;

import com.accela.loganalyzer.model.LogModel;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: LogParser.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2014
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: LogParser.java 72642 2009-01-01 20:01:57Z ACHIEVO\Austin.Wang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Aug 29, 2014		Austin.Wang		Initial.
 *  
 * </pre>
 */
public interface LogDetailParser<T>
{
	/**
	 * Parser the specify logType.
	 * 
	 */
	public  T parseLog(StringBuilder logInfo);
	
	/**
	 * initial the log type for current logParser to Parse,like server.log, access.log, profile.log.
	 *
	 * @param logType 
	 */
	public void setLogType(String logType);
	
	/**
	 * initial the log category for current log Parser to parse.like: Web, biz, classic
	 *
	 * @param logCategory 
	 */
	public void setLogCategory(String logCategory);
	
	
	/**
	 * save the log info model to database.
	 *
	 * @param obj 
	 */
	public  void saveLog2DB(T obj);
	
	/**
	 * 
	 * get the context key to get the map(map key) like LogInfoCapture getLogName method
	 *
	 * @return
	 */
	public String getContextKey();

}

/*
*$Log: av-env.bat,v $
*/