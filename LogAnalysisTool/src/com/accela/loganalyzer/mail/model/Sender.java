package com.accela.loganalyzer.mail.model;
/**
 * <pre>
 * 
 *  N/A Automation
 *  File: Sender.java
 * 
 *  N/A, Inc.
 *  Copyright (C): 2014
 * 
 *  Description:
 *  TODO
 * 
 *  Revision History
 *  Date,		Who,		What;
 *  	pc		Initial.
 *  
 * </pre>
 */
public class Sender
{
	private String agency;

	private Integer id;

	private String mailSender;

	private String password;

	private Server server;

	private String userName;

	/**
	 * @return the agency
	 */
	
	public String getAgency()
	{
		return agency;
	}
	
	/**
	 * @return the id
	 */
	
	public Integer getId()
	{
		return id;
	}

	/**
	 * @return the mailSender
	 */
	
	public String getMailSender()
	{
		return mailSender;
	}

	/**
	 * @return the password
	 */
	
	public String getPassword()
	{
		return password;
	}

	/**
	 * @return the server
	 */
	
	public Server getServer()
	{
		return server;
	}
	
	/**
	 * @return the userName
	 */
	
	public String getUserName()
	{
		return userName;
	}
	/**
	 * @param agency the agency to set
	 */
	public void setAgency(String agency)
	{
		this.agency = agency;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id)
	{
		this.id = id;
	}

	/**
	 * @param mailSender the mailSender to set
	 */
	public void setMailSender(String mailSender)
	{
		this.mailSender = mailSender;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password)
	{
		this.password = password;
	}

	/**
	 * @param server the server to set
	 */
	public void setServer(Server server)
	{
		this.server = server;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	
	
}

/*
*$Log: $
*/