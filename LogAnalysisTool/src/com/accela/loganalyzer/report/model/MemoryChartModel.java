package com.accela.loganalyzer.report.model;

import java.util.Date;

/**
 * <pre>
 * 
 *  N/A
 *  File: SystemMemory.java
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
public class MemoryChartModel
{
	private int ID;

	private Date logDate;

	private long totalMemory;

	private long maxMemory;

	private long totalFreeMemory;

	private long maxFreeMemory;

	private String totalMemoryUsed;

	private String maxMemoryUsed;

	private String type;

	/**
	 * @return the iD
	 */

	public int getID()
	{
		return ID;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD)
	{
		ID = iD;
	}

	/**
	 * @return the logDate
	 */

	public Date getLogDate()
	{
		return logDate;
	}

	/**
	 * @param logDate the logDate to set
	 */
	public void setLogDate(Date logDate)
	{
		this.logDate = logDate;
	}

	/**
	 * @return the totalMemory
	 */

	public long getTotalMemory()
	{
		return totalMemory;
	}

	/**
	 * @param totalMemory the totalMemory to set
	 */
	public void setTotalMemory(long totalMemory)
	{
		this.totalMemory = totalMemory;
	}

	/**
	 * @return the maxMemory
	 */

	public long getMaxMemory()
	{
		return maxMemory;
	}

	/**
	 * @param maxMemory the maxMemory to set
	 */
	public void setMaxMemory(long maxMemory)
	{
		this.maxMemory = maxMemory;
	}

	/**
	 * @return the totalFreeMemory
	 */

	public long getTotalFreeMemory()
	{
		return totalFreeMemory;
	}

	/**
	 * @param totalFreeMemory the totalFreeMemory to set
	 */
	public void setTotalFreeMemory(long totalFreeMemory)
	{
		this.totalFreeMemory = totalFreeMemory;
	}

	/**
	 * @return the maxFreeMemory
	 */

	public long getMaxFreeMemory()
	{
		return maxFreeMemory;
	}

	/**
	 * @param maxFreeMemory the maxFreeMemory to set
	 */
	public void setMaxFreeMemory(long maxFreeMemory)
	{
		this.maxFreeMemory = maxFreeMemory;
	}

	/**
	 * @return the totalMemoryUsed
	 */

	public String getTotalMemoryUsed()
	{
		return totalMemoryUsed;
	}

	/**
	 * @param totalMemoryUsed the totalMemoryUsed to set
	 */
	public void setTotalMemoryUsed(String totalMemoryUsed)
	{
		this.totalMemoryUsed = totalMemoryUsed;
	}

	/**
	 * @return the maxMemoryUsed
	 */

	public String getMaxMemoryUsed()
	{
		return maxMemoryUsed;
	}

	/**
	 * @param maxMemoryUsed the maxMemoryUsed to set
	 */
	public void setMaxMemoryUsed(String maxMemoryUsed)
	{
		this.maxMemoryUsed = maxMemoryUsed;
	}

	/**
	 * @return the type
	 */

	public String getType()
	{
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type)
	{
		this.type = type;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + ((logDate == null) ? 0 : logDate.hashCode());
		result = prime * result + (int) (maxFreeMemory ^ (maxFreeMemory >>> 32));
		result = prime * result + (int) (maxMemory ^ (maxMemory >>> 32));
		result = prime * result + ((maxMemoryUsed == null) ? 0 : maxMemoryUsed.hashCode());
		result = prime * result + (int) (totalFreeMemory ^ (totalFreeMemory >>> 32));
		result = prime * result + (int) (totalMemory ^ (totalMemory >>> 32));
		result = prime * result + ((totalMemoryUsed == null) ? 0 : totalMemoryUsed.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemoryChartModel other = (MemoryChartModel) obj;
		if (ID != other.ID)
			return false;
		if (logDate == null)
		{
			if (other.logDate != null)
				return false;
		}
		else if (!logDate.equals(other.logDate))
			return false;
		if (maxFreeMemory != other.maxFreeMemory)
			return false;
		if (maxMemory != other.maxMemory)
			return false;
		if (maxMemoryUsed == null)
		{
			if (other.maxMemoryUsed != null)
				return false;
		}
		else if (!maxMemoryUsed.equals(other.maxMemoryUsed))
			return false;
		if (totalFreeMemory != other.totalFreeMemory)
			return false;
		if (totalMemory != other.totalMemory)
			return false;
		if (totalMemoryUsed == null)
		{
			if (other.totalMemoryUsed != null)
				return false;
		}
		else if (!totalMemoryUsed.equals(other.totalMemoryUsed))
			return false;
		if (type == null)
		{
			if (other.type != null)
				return false;
		}
		else if (!type.equals(other.type))
			return false;
		return true;
	}

}

/*
 * $Log: $
 */