package com.accela.loganalyzer.mail.util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * <pre>
 * 
 *  N/A Automation
 *  File: MyAuthenticator.java
 * 
 *  N/A, Inc.
 *  Copyright (C): 2014
 * 
 *  Description:
 *  TODO
 * 
 *  Revision History
 *  Date,		Who,		What;
 *  2014年9月16日		pc		Initial.
 *  
 * </pre>
 */
public class MyAuthenticator extends Authenticator
{
	private String password;

	private String userName;

	public MyAuthenticator()
	{
		super();
	}

	public MyAuthenticator(String userName, String password)
	{
		super();
		this.userName = userName;
		this.password = password;
	}

	/**
	 * @return the password
	 */

	public String getPassword()
	{
		return password;
	}

	/**
	 * @return the userName
	 */

	public String getUserName()
	{
		return userName;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password)
	{
		this.password = password;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	@Override
	protected PasswordAuthentication getPasswordAuthentication()
	{
		return new PasswordAuthentication(this.userName, this.password);
	}

}


/*
*$Log: $
*/