package com.accela.loganalyzer.report.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.accela.loganalyzer.frame.database.DBAccessor;
import com.accela.loganalyzer.frame.database.DBResultSetProcessor;
import com.accela.loganalyzer.report.model.ServerLogChartModel;
import com.accela.loganalyzer.report.model.MemoryChartModel;

/**
 * <pre>
 * 
 *  N/A
 *  File: ChartDaoImpl.java
 * 
 *  N/A, Inc.
 *  Copyright (C): 2014
 * 
 *  Description:
 *  TODO
 * 
 *  Revision History
 *  Date,		Who,		What;
 *  2014年9月11日		Golden Huang		Initial.
 * 
 * </pre>
 */
public class ChartDaoImpl implements ChartDao
{

	private DBAccessor DBAccessor;

	/**
	 * @return the dBAccessor
	 */

	public DBAccessor getDBAccessor()
	{
		return DBAccessor;
	}

	/**
	 * @param dBAccessor the dBAccessor to set
	 */
	public void setDBAccessor(DBAccessor dBAccessor)
	{
		DBAccessor = dBAccessor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.beyondsoft.chart.dao.ChartDao#getDataWarnClassName()
	 */
	@Override
	public List<ServerLogChartModel> getCommonLog(String startDate, String endDate, String level)
	{
		return DBAccessor.select("select ClassName,COUNT(ClassName) from serverloginfo where level='" + level
				+ "' and LogDate between '" + startDate + "' and '" + endDate + "' GROUP BY ClassName",
			new Object[] {}, new ServerLogInfoResultSetProcessor());
	}

	private class ServerLogInfoResultSetProcessor implements DBResultSetProcessor<ServerLogChartModel>
	{
		@Override
		public ServerLogChartModel processResultSetRow(ResultSet rs) throws SQLException
		{
			ServerLogChartModel serverLogInfoCountWarnClassName = new ServerLogChartModel();
			serverLogInfoCountWarnClassName.setClassName(rs.getString("ClassName"));
			serverLogInfoCountWarnClassName.setCount(rs.getLong("COUNT(ClassName)"));
			return serverLogInfoCountWarnClassName;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.beyondsoft.chart.dao.ChartDao#getSystemMemories()
	 */
	@Override
	public List<MemoryChartModel> getSystemMemories(String startDate, String endDate)
	{
		return DBAccessor
				.select(
					"SELECT ID,logDate,totalMemory,maxMemory,totalFreeMemory,maxFreeMemory,totalMemoryUsed,maxMemoryUsed,type from systemmemory where logDate between '"
							+ startDate + "' and '" + endDate + "'", new Object[] {},
					new SystemMemoryResultSetProcessor());
	}

	private class SystemMemoryResultSetProcessor implements DBResultSetProcessor<MemoryChartModel>
	{

		@Override
		public MemoryChartModel processResultSetRow(ResultSet rs) throws SQLException
		{
			MemoryChartModel systemMemory = new MemoryChartModel();
			systemMemory.setID(rs.getInt("ID"));
			systemMemory.setLogDate(rs.getTimestamp("logDate"));
			systemMemory.setTotalMemory(rs.getLong("totalMemory"));
			systemMemory.setMaxMemory(rs.getLong("maxMemory"));
			systemMemory.setTotalFreeMemory(rs.getLong("totalFreeMemory"));
			systemMemory.setMaxFreeMemory(rs.getLong("maxFreeMemory"));
			systemMemory.setTotalMemoryUsed(rs.getString("totalMemoryUsed"));
			systemMemory.setMaxMemoryUsed(rs.getString("maxMemoryUsed"));
			systemMemory.setType(rs.getString("type"));
			return systemMemory;
		}
	}
}

/*
 * $Log: $
 */