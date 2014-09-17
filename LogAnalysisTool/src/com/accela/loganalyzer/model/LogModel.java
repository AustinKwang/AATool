package com.accela.loganalyzer.model;

import java.io.Serializable;
import java.util.Date;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: LogModel.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2014
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: LogModel.java 72642 2009-01-01 20:01:57Z ACHIEVO\Austin.Wang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Aug 28, 2014		Austin.Wang		Initial.
 *  
 * </pre>
 */
public class LogModel implements Serializable
{

	/**
	 * Comment for &lt;code&gt;serialVersionUID&lt;/code&gt;
	 */
	private static final long serialVersionUID = 1L;

	private String className;

	//client type,like: Web, ACA, HttpProxy, GovXML, rest
	private String clientType;
	
	private String clientSequence;

	//create date for this record.
	private Date createDate;

	private int id;

	private Date logDate;

	//log Name like: NullPointException
	private String logDescription;

	//all the exception/error information 
	private String logDetail;

	//log Type: Info, debug. Error, Warn fatal..
	private String logLevel;

	//log Type: like Classic, Web, Biz..
	private String logType;
	
	//stack to accela class stack information.
	private String simpleStack;
	
	/**
	 * @return the className
	 */
	
	public String getClassName()
	{
		return className;
	}
	
	/**
	 * @return the clientType
	 */
	
	public String getClientType()
	{
		return clientType;
	}
	
	/**
	 * @return the createDate
	 */
	
	public Date getCreateDate()
	{
		return createDate;
	}
	
	/**
	 * @return the id
	 */
	public int getId()
	{
		return id;
	}
	
	/**
	 * @return the logDate
	 */
	
	public Date getLogDate()
	{
		return logDate;
	}
	
	/**
	 * @return the logDescription
	 */
	
	public String getLogDescription()
	{
		return logDescription;
	}

	/**
	 * @return the logDetail
	 */
	
	public String getLogDetail()
	{
		return logDetail;
	}
	
	/**
	 * @return the logLevel
	 */
	
	public String getLogLevel()
	{
		return logLevel;
	}
	
	
	
	/**
	 * @return the logType
	 */
	
	public String getLogType()
	{
		return logType;
	}

	/**
	 * @return the simpleStack
	 */
	
	public String getSimpleStack()
	{
		return simpleStack;
	}

	/**
	 * @param className the className to set
	 */
	public void setClassName(String className)
	{
		this.className = className;
	}

	/**
	 * @param clientType the clientType to set
	 */
	public void setClientType(String clientType)
	{
		this.clientType = clientType;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate)
	{
		this.createDate = createDate;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id)
	{
		this.id = id;
	}

	/**
	 * @param logDate the logDate to set
	 */
	public void setLogDate(Date logDate)
	{
		this.logDate = logDate;
	}

	/**
	 * @param logDescription the logDescription to set
	 */
	public void setLogDescription(String logDescription)
	{
		this.logDescription = logDescription;
	}

	/**
	 * @param logDetail the logDetail to set
	 */
	public void setLogDetail(String logDetail)
	{
		this.logDetail = logDetail;
	}

	/**
	 * @param logLevel the logLevel to set
	 */
	public void setLogLevel(String logLevel)
	{
		this.logLevel = logLevel;
	}

	/**
	 * @param logType the logType to set
	 */
	public void setLogType(String logType)
	{
		this.logType = logType;
	}

	/**
	 * @param simpleStack the simpleStack to set
	 */
	public void setSimpleStack(String simpleStack)
	{
		this.simpleStack = simpleStack;
	}
	
	/**
	 * @return the clientSequence
	 */
	
	public String getClientSequence()
	{
		return clientSequence;
	}

	/**
	 * @param clientSequence the clientSequence to set
	 */
	public void setClientSequence(String clientSequence)
	{
		this.clientSequence = clientSequence;
	}
	
	
}

/*
*$Log: av-env.bat,v $
*/