package com.accela.loganalyzer.mail.dao;

import java.util.List;

import com.accela.loganalyzer.mail.model.Receiver;


/**
 * <pre>
 * 
 *  N/A Automation
 *  File: MailSendDao.java
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
public interface ReceiverDao
{
	public List<Receiver> findAll();
	
	public boolean save(Receiver receiver);
	
	public boolean update(Receiver receiver);
	
	public boolean delete(Integer receiverId);
}

/*
*$Log: $
*/