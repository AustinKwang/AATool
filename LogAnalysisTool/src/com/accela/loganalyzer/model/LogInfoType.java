package com.accela.loganalyzer.model;
/**
 * <pre>
 * 
 *  Accela Automation
 *  File: LogType.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2014
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: LogType.java 72642 2009-01-01 20:01:57Z ACHIEVO\Austin.Wang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  2014-9-11		Austin.Wang		Initial.
 *  
 * </pre>
 */
public class LogInfoType
{

	public String agency;
	
	//server host like: 192.168.1.12 or www.accela.com
	public String serverHost;
	
	//Log category, like Classic, Web, Biz..
	public String logCategory;
	
	/*log Type: like server.log. access.log, profile.log..*/
	public String logType;
}

/*
*$Log: av-env.bat,v $
*/