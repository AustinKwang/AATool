package com.accela.loganalyzer.mail.dao;

import java.util.List;

import com.accela.loganalyzer.mail.model.Server;

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
 *  2014幄1�7�1�7旄1�7		pc		Initial.
 *  
 * </pre>
 */
public interface ServerDao
{
	public List<Server> findAll();
	
	public boolean update(Server server);
	
	public Server findById(Integer id);
	
	public Server findByServerName(String serverName);
}

/*
*$Log: $
*/