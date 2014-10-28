package com.accela.loganalyzer.report.model;

/**
 * <pre>
 * 
 *  N/A
 *  File: ServerLogInfoWarnClassName.java
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
public class ServerLogChartModel
{
	private String ClassName;

	private Long count;

	/**
	 * @return the className
	 */

	public String getClassName()
	{
		return ClassName;
	}

	/**
	 * @param className the className to set
	 */
	public void setClassName(String className)
	{
		ClassName = className;
	}

	/**
	 * @return the count
	 */

	public Long getCount()
	{
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(Long count)
	{
		this.count = count;
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
		result = prime * result + ((ClassName == null) ? 0 : ClassName.hashCode());
		result = prime * result + ((count == null) ? 0 : count.hashCode());
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
		ServerLogChartModel other = (ServerLogChartModel) obj;
		if (ClassName == null)
		{
			if (other.ClassName != null)
				return false;
		}
		else if (!ClassName.equals(other.ClassName))
			return false;
		if (count == null)
		{
			if (other.count != null)
				return false;
		}
		else if (!count.equals(other.count))
			return false;
		return true;
	}

}

/*
 * $Log: $
 */