package com.accela.loganalyzer.frame.database;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: DBResultSetProcessor.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2014
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 *  $Id: DBResultSetProcessor.java 72642 2009-01-01 20:01:57Z ACHIEVO\Austin.Wang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Aug 28, 2014		Austin.Wang		Initial.
 *
 * </pre>
 */
public interface DBResultSetProcessor<T>
{

	/**
	 * convert db resultSet processor to model
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	public T processResultSetRow(ResultSet rs) throws SQLException;
}
