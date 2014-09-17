package com.accela.loganalyzer.mail.dao;

import java.util.List;

import com.accela.loganalyzer.mail.model.Sender;

/**
 * <pre>
 * 
 *  N/A Automation
 *  File: SenderDao.java
 * 
 *  N/A, Inc.
 *  Copyright (C): 2014
 * 
 *  Description:
 *  TODO
 * 
 *  Revision History
 *  Date,		Who,		What;
 *  2014骞�鏈�6鏃�	pc		Initial.
 *  
 * </pre>
 */
public interface SenderDao
{
	public List<Sender> findAll();
	
	public boolean update(Sender sender);
	
	public Sender findById(Integer id);
	
	public boolean save(Sender sender);
}

/*
*$Log: $
*/