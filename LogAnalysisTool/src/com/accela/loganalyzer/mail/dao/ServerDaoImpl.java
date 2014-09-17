package com.accela.loganalyzer.mail.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.accela.loganalyzer.frame.database.DBAccessor;
import com.accela.loganalyzer.frame.database.DBResultSetProcessor;
import com.accela.loganalyzer.mail.model.Server;

/**
 * <pre>
 * 
 *  N/A Automation
 *  File: MailHostDaoImpl.java
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
public class ServerDaoImpl implements ServerDao
{

	/**
	 * @return the dbAccessor
	 */
	
	public DBAccessor getDbAccessor()
	{
		return dbAccessor;
	}

	private DBAccessor dbAccessor;

	@Override
	public List<Server> findAll()
	{
		List<Server> servers=null;
		String sql="SELECT id,host,serverName FROM server";
		servers=this.dbAccessor.select(sql, null, new DBResultSetProcessor<Server>()
		{

			@Override
			public Server processResultSetRow(ResultSet rs) throws SQLException
			{
				Server server=new Server();
				server.setId(rs.getInt(1));
				server.setHost(rs.getString(2));
				server.setServerName(rs.getString(3));
				return server;
			}
		});
		return servers;
	}
	
	/**
	 * @param dbAccessor the dbAccessor to set
	 */
	public void setDbAccessor(DBAccessor dbAccessor)
	{
		this.dbAccessor = dbAccessor;
	}

	@Override
	public boolean update(Server server)
	{
		String sql = "UPDATE server SET serverName=?,host=? WHERE id=?";
		int row = this.dbAccessor.update(sql, new Object[] {server.getServerName(),server.getHost(), server.getId()});
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
	public Server findById(Integer id)
	{
		String sql="SELECT id,serverName,host FROM server WHERE id=?";
		List<Server> servers = this.dbAccessor.select(sql, new Object[] {id}, new DBResultSetProcessor<Server>()
		{

			@Override
			public Server processResultSetRow(ResultSet rs) throws SQLException
			{
				Server server = new Server();
				server.setId(rs.getInt(1));
				server.setServerName(rs.getString(2));
				server.setHost(rs.getString(3));
				return server;
			}
		});
		if (servers != null)
		{
			return servers.get(0);
		}
		else
		{
			return null;
		}
	}

	@Override
	public Server findByServerName(String serverName)
	{
		List<Server> servers = null;
		String sql = "SELECT id,host,serverName FROM server WHERE serverName=?";
		servers = this.dbAccessor.select(sql, new Object[] {serverName}, new DBResultSetProcessor<Server>()
		{

			@Override
			public Server processResultSetRow(ResultSet rs) throws SQLException
			{
				Server server = new Server();
				server.setId(rs.getInt(1));
				server.setHost(rs.getString(2));
				server.setServerName(rs.getString(3));
				return server;
			}
		});
		if (servers != null)
		{
			return servers.get(0);
		}
		else
		{
			return null;
		}
	}

	
}

/*
*$Log: $
*/