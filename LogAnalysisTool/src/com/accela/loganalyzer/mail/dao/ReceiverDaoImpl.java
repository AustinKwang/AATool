package com.accela.loganalyzer.mail.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.accela.loganalyzer.frame.database.DBAccessor;
import com.accela.loganalyzer.frame.database.DBResultSetProcessor;
import com.accela.loganalyzer.mail.model.Receiver;

/**
 * <pre>
 * 
 *  N/A Automation
 *  File: MailConfigDaoImpl.java
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
public class ReceiverDaoImpl implements ReceiverDao
{
	private DBAccessor dbAccessor;

	@Override
	public List<Receiver> findAll()
	{
		List<Receiver> receivers = null;
		String sql = "SELECT id,mailBox FROM receiver";
		receivers = this.dbAccessor.select(sql, null, new DBResultSetProcessor<Receiver>()
		{

			@Override
			public Receiver processResultSetRow(ResultSet rs) throws SQLException
			{
				Receiver receiver = new Receiver();
				receiver.setId(rs.getInt(1));
				receiver.setMailBox(rs.getString(2));
				return receiver;
			}
		});
		return receivers;
	}

	/**
	 * @param dbAccessor the dbAccessor to set
	 */
	public void setDbAccessor(DBAccessor dbAccessor)
	{
		this.dbAccessor = dbAccessor;
	}

	@Override
	public boolean save(Receiver receiver)
	{
		String sql = "INSERT INTO receiver(mailBox) VALUES(?)";
		int key = this.dbAccessor.save(sql, new Object[] {receiver.getMailBox()});
		if (key > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean update(Receiver receiver)
	{
		String sql = "UPDATE receiver SET mailBox=? WHERE id=?";
		int row = this.dbAccessor.update(sql, new Object[] {receiver.getMailBox(), receiver.getId()});
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
	public boolean delete(Integer receiverId)
	{
		String sql = "DELETE FROM receiver WHERE id=?";
		int row = this.dbAccessor.update(sql, new Object[] {receiverId});
		if (row > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}

/*
 * $Log: $
 */