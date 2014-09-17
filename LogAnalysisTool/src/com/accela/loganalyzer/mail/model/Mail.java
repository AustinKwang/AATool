package com.accela.loganalyzer.mail.model;
/**
 * <pre>
 * 
 *  N/A Automation
 *  File: Mail.java
 * 
 *  N/A, Inc.
 *  Copyright (C): 2014
 * 
 *  Description:
 *  TODO
 * 
 *  Revision History
 *  Date,		Who,		What;
 *  		dell		Initial.
 *  
 * </pre>
 */
public class Mail
{
	private String content;

	private String subject;

	/**
	 * @return the content
	 */
	
	public String getContent()
	{
		return content;
	}

	/**
	 * @return the subject
	 */
	
	public String getSubject()
	{
		return subject;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content)
	{
		this.content = content;
	}
	
	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject)
	{
		this.subject = subject;
	}
	
	
}

/*
*$Log: $
*/