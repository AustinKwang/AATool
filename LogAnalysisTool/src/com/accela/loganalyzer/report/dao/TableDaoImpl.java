package com.accela.loganalyzer.report.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.accela.loganalyzer.frame.database.DBAccessor;
import com.accela.loganalyzer.frame.database.DBResultSetProcessor;

/**
 * <pre>
 * 
 *  N/A Automation
 *  File: TableDaoImpl.java
 * 
 *  N/A, Inc.
 *  Copyright (C): 2014
 * 
 *  Description:
 *  TODO
 * 
 *  Revision History
 *  Date,		Who,		What;
 *  2014年9月12日		Golden Huang		Initial.
 * 
 * </pre>
 */
public class TableDaoImpl implements TableDao
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
	 * @see com.accela.loganalyzer.report.dao.TableDao#count()
	 */
	@Override
	public List<List<String>> count(String level, String startDate, String endDate)
	{
		// TODO Auto-generated method stub
		return DBAccessor
				.select(
					"SELECT t1.DATE,ERROR,WARN FROM (SELECT DATE_FORMAT(LogDate,'%Y-%m-%d') AS DATE,COUNT(Level) AS ERROR FROM serverloginfo WHERE Level='ERROR' AND LogDate BETWEEN '"
							+ startDate
							+ "' AND '"
							+ endDate
							+ "' GROUP BY day(LogDate)) AS t1 JOIN (SELECT DATE_FORMAT(LogDate,'%Y-%m-%d') AS DATE,COUNT(Level) AS WARN FROM serverloginfo WHERE Level='WARN' AND LogDate BETWEEN '"
							+ startDate + "' AND '" + endDate + "' GROUP BY day(LogDate)) AS t2 ON t1.DATE=t2.DATE",
					new Object[] {}, new DBResultSetProcessor<List<String>>()
					{
						@Override
						public List<String> processResultSetRow(ResultSet rs) throws SQLException
						{
							List<String> list = new ArrayList<String>();
							list.add(rs.getString("DATE"));
							list.add(rs.getString("ERROR"));
							list.add(rs.getString("WARN"));
							return list;
						}
					});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.accela.loganalyzer.report.dao.TableDao#details()
	 */
	@Override
	public List<List<String>> details(String level, String startDate, String endDate)
	{
		return DBAccessor.select("select LogDate,Level,ClassName,SimpleDescription from serverloginfo where (Level='"
				+ level + "') and LogDate between '" + startDate + "' and '" + endDate + "'", new Object[] {},
			new DBResultSetProcessor<List<String>>()
			{
				@Override
				public List<String> processResultSetRow(ResultSet rs) throws SQLException
				{
					List<String> list = new ArrayList<String>();
					list.add(rs.getString("LogDate"));
					list.add(rs.getString("Level"));
					list.add(rs.getString("ClassName"));
					list.add(rs.getString("SimpleDescription"));
					return list;
				}
			});
	}
}

/*
 * $Log: $
 */