package com.accela.loganalyzer.database.test;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.accela.loganalyzer.frame.database.DBAccessor;
import com.accela.loganalyzer.frame.database.DBResultSetProcessor;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: DBAccessorTest.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2014
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: DBAccessorTest.java 72642 2009-01-01 20:01:57Z ACHIEVO\Austin.Wang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  2014-9-11		Austin.Wang		Initial.
 *  
 * </pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class DBAccessorTest
{
	
	private DBAccessor dbAccessor;
	 
	@Test
	public void selectTest()
	{
		String sql = "SELECT COUNT(*) FROM TASK";
		int n = dbAccessor.select(sql, null, new DBResultSetProcessor<Integer>()
		{
			public Integer processResultSetRow(ResultSet rs) throws SQLException
			{
				return rs.getInt(1);
			}
		}).get(0);
		System.out.println(n);
	}

	@Autowired
	public void setDbAccessor(DBAccessor dbAccessor)
	{
		this.dbAccessor = dbAccessor;
	}
}

/*
*$Log: av-env.bat,v $
*/