package com.accela.loganalyzer.mail.business;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.accela.loganalyzer.mail.dao.ReceiverDao;
import com.accela.loganalyzer.mail.dao.SenderDao;
import com.accela.loganalyzer.mail.dao.ServerDao;
import com.accela.loganalyzer.mail.model.Mail;
import com.accela.loganalyzer.mail.model.Receiver;
import com.accela.loganalyzer.mail.model.Sender;
import com.accela.loganalyzer.mail.model.Server;
import com.accela.loganalyzer.mail.util.MyAuthenticator;

/**
 * <pre>
 * 
 *  N/A Automation
 *  File: MailSendBusiness.java
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
public class MailSendBusiness implements MailSendService
{


	private ReceiverDao receiverDao;

	private SenderDao senderDao;

	private ServerDao serverDao;
	
	/**
	 * 
	 * create a mail
	 *
	 * @param session
	 * @param mail
	 * @param server
	 * @param receivers
	 * @return
	 */
	private Message createMessage(Session session,Mail mail,Server server,List<Receiver> receivers,Sender sender)
	{
		Message message=new MimeMessage(session);
		MimeMultipart multiPart=new MimeMultipart();
		//1.get and set file and add to mail
		File[] files=this.getFiles();
		if (files != null)
		{
			for (int i = 0; i < files.length; i++)
			{
				BodyPart bodyPart = new MimeBodyPart();
				FileDataSource datasource = new FileDataSource(files[i]);
				try
				{
					bodyPart.setDataHandler(new DataHandler(datasource));
					bodyPart.setFileName(files[i].getName());
					multiPart.addBodyPart(bodyPart);
				}
				catch (MessagingException e)
				{
					e.printStackTrace();
				}
			}
		}
		//2.set mail content
		MimeBodyPart bodyPart = new MimeBodyPart();
		try
		{
			message.setText(mail.getContent());
			bodyPart.setText(mail.getContent());
			multiPart.addBodyPart(bodyPart);
		}
		catch (MessagingException e)
		{
			e.printStackTrace();
		}
		//3.set mail configuration
		try
		{
			//3.1 set mail detail
			message.setSubject(mail.getSubject());
			message.setSentDate(new Date());
			//3.2 set sender address
			Address fromAddress = new InternetAddress(sender.getMailSender());
			message.setFrom(fromAddress);
			//3.3 set receiver address
			InternetAddress[] toAddress=new InternetAddress[receivers.size()];
			for (int i = 0; i < receivers.size(); i++)
			{
				toAddress[i] = new InternetAddress(receivers.get(i).getMailBox());
			}
			message.setRecipients(Message.RecipientType.TO, toAddress);
			message.setContent(multiPart);
		}
		catch (MessagingException e)
		{
			e.printStackTrace();
		}
		return message;
	}

	/**
	 * 
	 * get file
	 *
	 * @return
	 */
	private File[] getFiles()
	{
		//get root path
		Properties properties = new Properties();
		InputStream inputStream = this.getClass().getResourceAsStream("/config.properties");
		String path = null;
		try
		{
			properties.load(inputStream);
			path = properties.getProperty("mailPath");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		//get file
		File root = new File(path);
		File[] files=null;
		if (root.exists())
		{
			files = root.listFiles();
		}
		return files;
	}
	
	@Override
	public void onSendMail()
	{
		//get configuration from database
		List<Server> servers=this.serverDao.findAll();
		List<Receiver> receivers=this.receiverDao.findAll();
		List<Sender> senders=this.senderDao.findAll();
		//set mail content
		Mail mail=new Mail();
		//-------------------------------------
		mail.setContent("The report of today!");
		mail.setSubject("Report");
		//-------------------------------------
		this.sendMail(receivers, servers.get(0),mail,senders.get(0));
		
	}
	
	/**
	 * 
	 * real to send mail
	 *
	 * @param receivers
	 * @param server
	 */
	private void sendMail(List<Receiver> receivers,Server server,Mail mail,Sender sender)
	{
		Authenticator auth=new MyAuthenticator(sender.getUserName(),sender.getPassword());
		Properties props=System.getProperties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", server.getHost());
		Session session=Session.getDefaultInstance(props,auth);
		Message message=this.createMessage(session, mail, server, receivers,sender);
		try
		{
			Transport.send(message);
		}
		catch (MessagingException e)
		{
			e.printStackTrace();
		}
		
	
		
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

	/**
	 * @param serverDao the serverDao to set
	 */
	public void setServerDao(ServerDao serverDao)
	{
		this.serverDao = serverDao;
	}


	
}

/*
*$Log: $
*/