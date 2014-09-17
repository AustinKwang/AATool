package com.accela.loganalyzer.frame.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: DBUtil.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2014
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 *  $Id: DBUtil.java 72642 2009-01-01 20:01:57Z ACHIEVO\Austin.Wang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Aug 28, 2014		Austin.Wang		Initial.
 * 
 * </pre>
 */
public class DBUtil
{

	private static final String USER_NAME = "root";

	private static final String PASSWORD = "root";

	private static final String JDBC_URL = "jdbc:mysql://192.168.1.51:3306/accelatools";

	private static final String JDBC_MYSQL_DRIVER = "com.mysql.jdbc.Driver";

	/**
	 * 
	 * register database class driver to JVM., and only need run 1 time,
	 * 
	 * */
	static
	{
		// register database class driver to JVM.
		try
		{
			Class.forName(JDBC_MYSQL_DRIVER);
		}
		catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Get Connection
	 * 
	 * @return connection instance
	 */
	public static Connection getConnection()
	{
		Connection con = null;
		try
		{
			con = DriverManager.getConnection(JDBC_URL, USER_NAME, PASSWORD);

		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return con;
	}

	/**
	 * Close the connection and statement and reustSet and based on below steps: 
	 * 1. RestutSet; 
	 * 2. PreparedStatement or Statement; 
	 * 3. Connection
	 * @param con
	 * @param stmt
	 */
	public static void close(ResultSet rs, Statement stmt, Connection con)
	{
		try
		{
			if (rs != null)
			{
				rs.close();
			}
			if (stmt != null)
			{
				stmt.close();
			}
			if (con != null)
			{
				con.close();
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
