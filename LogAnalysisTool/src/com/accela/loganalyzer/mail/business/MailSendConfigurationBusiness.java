package com.accela.loganalyzer.mail.business;

import java.util.List;

import com.accela.loganalyzer.mail.dao.ReceiverDao;
import com.accela.loganalyzer.mail.dao.SenderDao;
import com.accela.loganalyzer.mail.dao.ServerDao;
import com.accela.loganalyzer.mail.model.Receiver;
import com.accela.loganalyzer.mail.model.Sender;
import com.accela.loganalyzer.mail.model.Server;

/**
 * <pre>
 * 
 *  N/A Automation
 *  File: MailSenderConfigurationBusiness.java
 * 
 *  N/A, Inc.
 *  Copyright (C): 2014
 * 
 *  Description:
 *  TODO
 * 
 *  Revision History
 *  Date,		Who,		What;
 *   	pc		Initial.
 *  
 * </pre>
 */
public class MailSendConfigurationBusiness implements MailSendConfigurationService
{
	/**
	 * @param serverDao the serverDao to set
	 */
	public void setServerDao(ServerDao serverDao)
	{
		this.serverDao = serverDao;
	}

	/**
	 * @param receiverDao the receiverDao to set
	 */
	public void setReceiverDao(ReceiverDao receiverDao)
	{
		this.receiverDao = receiverDao;
	}

	/**
	 * @param senderDao the senderDao to set
	 */
	public void setSenderDao(SenderDao senderDao)
	{
		this.senderDao = senderDao;
	}

	private ServerDao serverDao;

	private ReceiverDao receiverDao;
	
	private SenderDao senderDao;

	@Override
	public boolean updateSenderConfig(Sender sender)
	{
		return this.senderDao.update(sender);
	}

	@Override
	public boolean updateServerConfig(Server server)
	{
		return this.serverDao.update(server);
	}

	@Override
	public boolean addReceiver(Receiver receiver)
	{
		return this.receiverDao.save(receiver);
	}

	@Override
	public Sender findSenderConfig()
	{
		List<Sender> senders = this.senderDao.findAll();
		if (senders != null)
		{
			Server server=this.serverDao.findById(senders.get(0).getServer().getId());
			senders.get(0).setServer(server);
			return senders.get(0);
		}
		return null;
	}

	@Override
	public Server findServerConfig()
	{
		List<Server> servers = this.serverDao.findAll();
		if (servers != null)
		{
			return servers.get(0);
		}
		return null;
	}

	@Override
	public List<Receiver> findReceiver()
	{
		return this.receiverDao.findAll();
	}

	@Override
	public boolean updateReceiver(Receiver receiver)
	{
		return this.receiverDao.update(receiver);
	}

	@Override
	public boolean deleteReceiver(Integer receiverId)
	{
		return this.receiverDao.delete(receiverId);
	}

	@Override
	public boolean addSender(Sender sender)
	{
		Server server=this.serverDao.findByServerName(sender.getServer().getServerName());
		return false;
	}

}

/*
*$Log: $
*/