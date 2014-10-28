package com.accela.loganalyzer.mail.model;


/**
 * <pre>
 * 
 *  N/A Automation
 *  File: MailHost.java
 * 
 *  N/A, Inc.
 *  Copyright (C): 2014
 * 
 *  Description:
 *  TODO
 * 
 *  Revision History
 *  Date,		Who,		What;
 *  		pc		Initial.
 *  
 * </pre>
 */
public class Server
{
	/**
	 * @return the serverName
	 */
	
	public String getServerName()
	{
		return serverName;
	}

	/**
	 * @param serverName the serverName to set
	 */
	public void setServerName(String serverName)
	{
		this.serverName = serverName;
	}

	private String host;

	private Integer id;
	
	private String serverName;

	/**
	 * @return the host
	 */
	
	public String getHost()
	{
		return host;
	}

	/**
	 * @return the id
	 */
	
	public Integer getId()
	{
		return id;
	}

	/**
	 * @param host the host to set
	 */
	public void setHost(String host)
	{
		this.host = host;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id)
	{
		this.id = id;
	}

	

}

/*
*$Log: $
*/