package com.accela.loganalyzer.filter;

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
public interface LogInfoFilter
{

	public void doFilter(String line, Context context);
}

/*
*$Log: av-env.bat,v $
*/