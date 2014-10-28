package com.accela.loganalyzer.frame.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.accela.loganalyzer.frame.exception.DataBaseException;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: DBAccessor.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2014
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 *  $Id: DBAccessor.java 72642 2009-01-01 20:01:57Z ACHIEVO\Austin.Wang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Aug 28, 2014		Austin.Wang		Initial.
 * 
 * </pre>
 */
public class DBAccessor
{

	private DataSource dataSource;

//	private static Logger logger = Logger.getLogger(DBAccessor.class);
	public DataSource getDataSource()
	{
		return dataSource;
	}

	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}

	/**
	 * select records
	 * 
	 * @param sqlString
	 * @param paramters
	 * @param resultProcessor
	 * @return
	 */
	public <T> List<T> select(String sqlString, Object[] paramters, DBResultSetProcessor<T> resultProcessor)
	{
		List<T> records = new ArrayList<T>();
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			// 1. get connection
			connection = dataSource.getConnection();
			// 2.get prepare Statement
			pstmt = connection.prepareStatement(sqlString);
			// 3.set parameters for prepare statement
			setParameters(pstmt, paramters);
			// 4. execute sql
			rs = pstmt.executeQuery();
			// 5.handle result set
			while (rs.next())
			{

				T obj = resultProcessor.processResultSetRow(rs);
				records.add(obj);
			}
		}
		catch (SQLException ex)
		{
//			logger.error(sqlString);
			throw new DataBaseException("DataBase operater has occured exception", ex);
			// do something handle exception
		}
		finally
		{
			// close all the resource
			DBUtil.close(rs, pstmt, connection);
		}
		return records;
	}

	/**
	 * handle UPDATE/ DELETE/ INSERT SQL
	 * 
	 * @param sqlString
	 * @param parameters
	 * @return the row count for SQL affect
	 */
	public int update(String sqlString, Object[] parameters)
	{
		int result = -1;
		Connection connection = null;
		PreparedStatement pstmt = null;
		try
		{
			// 1. get connection
			connection = dataSource.getConnection();
			// 2.get prepare Statement
			pstmt = connection.prepareStatement(sqlString);
			// 3.set parameters for prepare statement
			setParameters(pstmt, parameters);
			// 4. execute sql
			result = pstmt.executeUpdate();
		}
		catch (SQLException ex)
		{
//			logger.error(sqlString);
			throw new DataBaseException("DataBase operater has occured exception", ex);
			// do something handle exception
		}
		finally
		{
			// close all the resource
			DBUtil.close(null, pstmt, connection);
		}
		return result;
	}

	/**
	 * only for Save data (INSERT SQL)
	 * 
	 * @param sqlString
	 * @param parameters
	 * @return primary key which generate by native database.
	 */
	public int save(String sqlString, Object[] parameters) throws DataBaseException
	{
		int result = -1;
		Connection connection = null;
		PreparedStatement pstmt = null;
		try
		{
			// 1. get connection
			connection = dataSource.getConnection();
			// 2.get prepare Statement
			pstmt = connection.prepareStatement(sqlString, Statement.RETURN_GENERATED_KEYS);
			// 3.set parameters for prepare statement
			setParameters(pstmt, parameters);
			// 4. execute sql
			result = pstmt.executeUpdate();
		}
		catch (SQLException ex)
		{
//			logger.error(sqlString);
			StringBuilder sb = new StringBuilder();
			for(Object str :parameters)
			{
				sb.append(str).append(";");
			}
			System.out.println(sqlString + "||" + sb.toString());
			//throw new DataBaseException("DataBase operater has occured exception", ex);
			// do something handle exception
		}
		finally
		{
			// close all the resource
			DBUtil.close(null, pstmt, connection);
		}
		return result;
	}

	/**
	 * all of the sqlStringsq are whole sql for batch, which like: delete from user where stuId = '0001'
	 * 
	 * @param sqlStrings
	 * @return
	 */
	public boolean updateBatch(List<String> sqlStrings, List<Object[]> prameters) throws DataBaseException
	{
		boolean sucess = true;
		Connection connection = null;
		Statement stmt = null;
		try
		{
			// 1. get connection
			connection = dataSource.getConnection();
			// 2.get statement, because the sqls is not same, use stament
			stmt = connection.createStatement();

			connection.setAutoCommit(false);
			// 3.loop each sql and add to batch
			Iterator<String> it = sqlStrings.iterator();
			while (it.hasNext())
			{
				stmt.addBatch(it.next());
			}
			// 4. execute bath
			int[] results = stmt.executeBatch();

			// 5. commit batch
			connection.commit();
			// 6.handle result
			for (int result : results)
			{
				if (result == 0)
				{
					// if has one is failed, roll back all the SQL
					sucess = false;
					connection.rollback();
					break;
				}
			}
		}
		catch (SQLException ex)
		{
			// if has excption, rollback
			try
			{
				connection.rollback();
			}
			catch (SQLException e)
			{
				throw new DataBaseException(
						"DataBase operater has occured exception when rollback data, So you need rollback database Manually",
						ex);
				// do something handle exception
			}
		}
		finally
		{
			// close all the resource
			DBUtil.close(null, stmt, connection);
		}
		return sucess;
	}

	/**
	 * set parameter for PreparedStatement
	 * 
	 * @param pstmt
	 * @param paramters
	 * @throws SQLException
	 */
	private void setParameters(PreparedStatement pstmt, Object[] paramters) throws SQLException
	{
		if(paramters == null)
		{
			return;
		}
		int index = 0;
		for (Object object : paramters)
		{
			// sample for String type
			index++;
			pstmt.setObject(index, object);
		}
	}

}
