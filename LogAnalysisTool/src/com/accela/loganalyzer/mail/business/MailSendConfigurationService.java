package com.accela.loganalyzer.mail.business;

import java.util.List;

import com.accela.loganalyzer.mail.model.Receiver;
import com.accela.loganalyzer.mail.model.Sender;
import com.accela.loganalyzer.mail.model.Server;

/**
 * <pre>
 * 
 *  N/A Automation
 *  File: MailSenderConfiguration.java
 * 
 *  N/A, Inc.
 *  Copyright (C): 2014
 * 
 *  Description:
 *  TODO
 * 
 *  Revision History
 *  Date,		Who,		What;
 *   		pc		Initial.
 *  
 * </pre>
 */
public interface MailSendConfigurationService
{
	/**
	 * 
	 * update sender config
	 *
	 */
	public boolean updateSenderConfig(Sender sender);
	
	/**
	 * 
	 * update server config
	 *
	 */
	public boolean updateServerConfig(Server server);
	
	/**
	 * 
	 * update receiver config
	 *
	 */
	public boolean addReceiver(Receiver receiver);
	
	/**
	 * 
	 * TODO.
	 *
	 * @return
	 */
	public Sender findSenderConfig();
	
	/**
	 * 
	 * TODO.
	 *
	 * @return
	 */
	public Server findServerConfig();
	
	/**
	 * 
	 * TODO.
	 *
	 * @return
	 */
	public List<Receiver> findReceiver();
	
	/**
	 * 
	 * TODO.
	 *
	 * @return
	 */
	public boolean updateReceiver(Receiver receiver);
	
	/**
	 * 
	 * TODO.
	 *
	 * @param receiverId
	 * @return
	 */
	public boolean deleteReceiver(Integer receiverId);
	
	/**
	 * 
	 * TODO.
	 *
	 * @param sender
	 * @return
	 */
	public boolean addSender(Sender sender);
}

/*
*$Log: $
*/