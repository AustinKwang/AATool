package com.accela.loganalyzer.mail.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.accela.loganalyzer.frame.database.DBAccessor;
import com.accela.loganalyzer.frame.database.DBResultSetProcessor;
import com.accela.loganalyzer.mail.model.Sender;
import com.accela.loganalyzer.mail.model.Server;

/**
 * <pre>
 * 
 *  N/A Automation
 *  File: SenderDaoImpl.java
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
public class SenderDaoImpl implements SenderDao
{
	private DBAccessor dbAccessor;

	@Override
	public List<Sender> findAll()
	{
		String sql = "SELECT id,userName,password,mailSender,agency,serverId FROM sender";
		List<Sender> senders = null;
		senders = this.dbAccessor.select(sql, null, new DBResultSetProcessor<Sender>()
		{

			@Override
			public Sender processResultSetRow(ResultSet rs) throws SQLException
			{
				Sender sender = new Sender();
				sender.setId(rs.getInt(1));
				sender.setUserName(rs.getString(2));
				sender.setPassword(rs.getString(3));
				sender.setMailSender(rs.getString(4));
				sender.setAgency(rs.getString(5));
				//instance server
				Server server=new Server();
				server.setId(rs.getInt(6));
				sender.setServer(server);
				return sender;
			}
		});
		return senders;
	}

	/**
	 * @param dbAccessor the dbAccessor to set
	 */
	public void setDbAccessor(DBAccessor dbAccessor)
	{
		this.dbAccessor = dbAccessor;
	}

	@Override
	public boolean update(Sender sender)
	{
		String sql = "UPDATE sender SET userName=?,password=?,mailSender=?,agency=? WHERE id=?";
		int row = this.dbAccessor.update(sql,
			new Object[] {sender.getUserName(), sender.getPassword(), sender.getMailSender(),sender.getAgency(), sender.getId()});
		if (row > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public Sender findById(Integer id)
	{
		List<Sender> senders=null;
		String sql="SELECT id,userNaem,password,mailSender,agency,serverId FROM sender WHERE id=?";
		senders=this.dbAccessor.select(sql, new Object[]{id}, new DBResultSetProcessor<Sender>()
		{

			@Override
			public Sender processResultSetRow(ResultSet rs) throws SQLException
			{
				Sender sender =new Sender();
				sender.setId(rs.getInt(1));
				sender.setUserName(rs.getString(2));
				sender.setPassword(rs.getString(3));
				sender.setMailSender(rs.getString(4));
				sender.setAgency(rs.getString(5));
				//instance server
				Server server=new Server();
				server.setId(rs.getInt(6));
				sender.setServer(server);
				return sender;
			}
		});
		if (senders != null)
		{
			return senders.get(0);
		}
		else
		{
			return null;
		}
	}

	@Override
	public boolean save(Sender sender)
	{
		String sql = "INSERT INTO sender(userName,password,mailSender,agency,serverId) VALUES(?,?,?,?,?)";
		this.dbAccessor.save(sql, new Object[] {sender.getUserName(), sender.getPassword(), sender.getMailSender(),
				sender.getAgency(), sender.getServer().getId()});

		return false;
	}

}

/*
 * $Log: $
 */