package com.accela.loganalyzer.mail.model;

/**
 * <pre>
 * 
 *  N/A Automation
 *  File: MailSender.java
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
public class Receiver
{
	private Integer id;

	private String mailBox;

	/**
	 * @return the id
	 */

	public Integer getId()
	{
		return id;
	}

	/**
	 * @return the mailBox
	 */

	public String getMailBox()
	{
		return mailBox;
	}
	

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id)
	{
		this.id = id;
	}

	/**
	 * @param mailBox the mailBox to set
	 */
	public void setMailBox(String mailBox)
	{
		this.mailBox = mailBox;
	}

	

}

/*
 * $Log: $
 */