package com.accela.loganalyzer.frame.database;
/**
 * <pre>
 * 
 *  Accela Automation
 *  File: SqlCommand.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2014
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: SqlCommand.java 72642 2009-01-01 20:01:57Z ACHIEVO\Austin.Wang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Sep 3, 2014		Austin.Wang		Initial.
 *  
 * </pre>
 */
public class SqlCommand
{

	private String sqlString;
	
	private Object[] parameters;

	/**
	 * @return the sqlString
	 */
	
	public String getSqlString()
	{
		return sqlString;
	}

	/**
	 * @param sqlString the sqlString to set
	 */
	public void setSqlString(String sqlString)
	{
		this.sqlString = sqlString;
	}

	/**
	 * @return the parameters
	 */
	
	public Object[] getParameters()
	{
		return parameters;
	}

	/**
	 * @param parameters the parameters to set
	 */
	public void setParameters(Object[] parameters)
	{
		this.parameters = parameters;
	}
	
	
}

/*
*$Log: av-env.bat,v $
*/