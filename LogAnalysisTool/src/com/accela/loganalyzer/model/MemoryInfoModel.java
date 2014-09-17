package com.accela.loganalyzer.model;

import java.util.Date;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: MemotyInfoModel.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2014
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: MemotyInfoModel.java 72642 2009-01-01 20:01:57Z ACHIEVO\Austin.Wang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  2014-9-10		Austin.Wang		Initial.
 *  
 * </pre>
 */
public class MemoryInfoModel
{
	private int id;

	private Date logDate;

	private long totalMemory;

	private long maxMemory;

	private long totalFreeMemory;

	private long maxFreeMemory;

	private String totalMemoryUsed;

	private String maxMemoryUsed;

	private String type;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public Date getLogDate()
	{
		return logDate;
	}

	public void setLogDate(Date logDate)
	{
		this.logDate = logDate;
	}

	public long getTotalMemory()
	{
		return totalMemory;
	}

	public void setTotalMemory(long totalMemory)
	{
		this.totalMemory = totalMemory;
	}

	public long getMaxMemory()
	{
		return maxMemory;
	}

	public void setMaxMemory(long maxMemory)
	{
		this.maxMemory = maxMemory;
	}

	public long getTotalFreeMemory()
	{
		return totalFreeMemory;
	}

	public void setTotalFreeMemory(long totalFreeMemory)
	{
		this.totalFreeMemory = totalFreeMemory;
	}

	public long getMaxFreeMemory()
	{
		return maxFreeMemory;
	}

	public void setMaxFreeMemory(long maxFreeMemory)
	{
		this.maxFreeMemory = maxFreeMemory;
	}

	public String getTotalMemoryUsed()
	{
		return totalMemoryUsed;
	}

	public void setTotalMemoryUsed(String totalMemoryUsed)
	{
		this.totalMemoryUsed = totalMemoryUsed;
	}

	public String getMaxMemoryUsed()
	{
		return maxMemoryUsed;
	}

	public void setMaxMemoryUsed(String maxMemoryUsed)
	{
		this.maxMemoryUsed = maxMemoryUsed;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}
}

/*
*$Log: av-env.bat,v $
*/