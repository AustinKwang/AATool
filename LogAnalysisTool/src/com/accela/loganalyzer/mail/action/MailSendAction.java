package com.accela.loganalyzer.mail.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.accela.loganalyzer.mail.business.MailSendConfigurationService;
import com.accela.loganalyzer.mail.business.MailSendService;
import com.accela.loganalyzer.mail.model.Receiver;
import com.accela.loganalyzer.mail.model.Sender;
import com.accela.loganalyzer.mail.model.Server;
import com.opensymphony.xwork2.ActionSupport;

/**
 * <pre>
 * 
 *  N/A Automation
 *  File: MailSendAction.java
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
public class MailSendAction extends ActionSupport
{
	private Map<String, Object> ajaxResultMap = new HashMap<String, Object>();

	private MailSendConfigurationService mailSendConfigurationService;

	private MailSendService mailSendService;

	private Receiver receiver;

	private Sender sender;

	private Server server;

	/**
	 * 
	 * TODO.
	 * 
	 * @return
	 */
	public String findSenderConfig()
	{
		// get sender
		this.sender = this.mailSendConfigurationService.findSenderConfig();
		this.ajaxResultMap.put("id", this.sender.getId());
		this.ajaxResultMap.put("mailSender", this.sender.getMailSender());
		this.ajaxResultMap.put("userName", this.sender.getUserName());
		this.ajaxResultMap.put("password", this.sender.getPassword());
		this.ajaxResultMap.put("agency", this.sender.getAgency());
		this.ajaxResultMap.put("id", this.sender.getId());
		this.ajaxResultMap.put("serverName", this.sender.getServer().getServerName());
		// get server
		this.server = this.mailSendConfigurationService.findServerConfig();
		this.ajaxResultMap.put("server", this.server);
		return "success";
	}

	public String findServerConfig()
	{
		this.server = this.mailSendConfigurationService.findServerConfig();
		this.ajaxResultMap.put("id", this.server.getId());
		this.ajaxResultMap.put("host", this.server.getHost());
		this.ajaxResultMap.put("serverName", this.server.getServerName());
		return "success";
	}

	public String findReceiver()
	{
		List<Receiver> receivers = this.mailSendConfigurationService.findReceiver();
		this.ajaxResultMap.put("receivers", receivers);
		return "success";
	}

	/**
	 * @return the ajaxResultMap
	 */

	public Map<String, Object> getAjaxResultMap()
	{
		return ajaxResultMap;
	}

	/**
	 * @return the receiver
	 */

	public Receiver getReceiver()
	{
		return receiver;
	}

	/**
	 * @return the sender
	 */

	public Sender getSender()
	{
		return sender;
	}

	/**
	 * @return the server
	 */

	public Server getServer()
	{
		return server;
	}

	/**
	 * @param mailSendConfigurationService the mailSendConfigurationService to set
	 */
	public void setMailSendConfigurationService(MailSendConfigurationService mailSendConfigurationService)
	{
		this.mailSendConfigurationService = mailSendConfigurationService;
	}

	/**
	 * @param mailSendService the mailSendService to set
	 */
	public void setMailSendService(MailSendService mailSendService)
	{
		this.mailSendService = mailSendService;
	}

	/**
	 * @param receiver the receiver to set
	 */
	public void setReceiver(Receiver receiver)
	{
		this.receiver = receiver;
	}

	/**
	 * @param sender the sender to set
	 */
	public void setSender(Sender sender)
	{
		this.sender = sender;
	}

	/**
	 * @param server the server to set
	 */
	public void setServer(Server server)
	{
		this.server = server;
	}

	/**
	 * 
	 * update Sender config
	 * 
	 * @return
	 */
	public String updateSenderConfig()
	{
		if (this.mailSendConfigurationService.updateSenderConfig(this.sender))
		{
			this.ajaxResultMap.put("result", "true");
			this.ajaxResultMap.put("userName", this.sender.getUserName());
			this.ajaxResultMap.put("password", this.sender.getPassword());
			this.ajaxResultMap.put("agency", this.sender.getAgency());
			this.ajaxResultMap.put("mailSender", this.sender.getMailSender());
		}
		return "success";
	}

	/**
	 * 
	 * TODO.
	 * 
	 * @return
	 */
	public String updateServerConfig()
	{
		if (this.mailSendConfigurationService.updateServerConfig(this.server))
		{
			this.ajaxResultMap.put("result", "true");
			this.ajaxResultMap.put("serverHost", this.server.getHost());
			this.ajaxResultMap.put("serverName", this.server.getServerName());
		}
		return "success";
	}

	/**
	 * 
	 * TODO.
	 * 
	 * @return
	 */
	public String addReceiver()
	{
		this.mailSendConfigurationService.addReceiver(this.receiver);
		return "success";
	}

	/**
	 * 
	 * TODO.
	 * 
	 * @return
	 */
	public String updateReceiver()
	{
		if (this.mailSendConfigurationService.updateReceiver(this.receiver))
		{
			this.ajaxResultMap.put("result", "true");
			this.ajaxResultMap.put("mailBox", this.receiver.getMailBox());
		}
		return "success";
	}

	/**
	 * 
	 * TODO.
	 * 
	 * @return
	 */
	public String deleteReceiver()
	{
		if (this.mailSendConfigurationService.deleteReceiver(receiver.getId()))
		{
			this.ajaxResultMap.put("result", "true");
		}
		return "success";
	}

	public String addSender()
	{
		return null;
	}
}

/*
 * $Log: $
 */