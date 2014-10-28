package com.accela.loganalyzer.report.model;

import java.util.Date;

/**
 * <pre>
 * 
 *  N/A Automation
 *  File: HistoryReportModel.java
 * 
 *  N/A, Inc.
 *  Copyright (C): 2014
 * 
 *  Description:
 *  TODO
 * 
 *  Revision History
 *  Date,		Who,		What;
 *  2014年9月17日		Golden Huang		Initial.
 * 
 * </pre>
 */
public class HistoryReportModel
{
	private int id;

	private Date addDateTime;

	private String webSite;

	private String server;

	private String log;

	private String startDate;

	private String endDate;

	private String infoType;

	private String level;

	private boolean details;

	private boolean count;

	/**
	 * @return the id
	 */

	public int getId()
	{
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id)
	{
		this.id = id;
	}

	/**
	 * @return the addDateTime
	 */

	public Date getAddDateTime()
	{
		return addDateTime;
	}

	/**
	 * @param addDateTime the addDateTime to set
	 */
	public void setAddDateTime(Date addDateTime)
	{
		this.addDateTime = addDateTime;
	}

	/**
	 * @return the webSite
	 */

	public String getWebSite()
	{
		return webSite;
	}

	/**
	 * @param webSite the webSite to set
	 */
	public void setWebSite(String webSite)
	{
		this.webSite = webSite;
	}

	/**
	 * @return the server
	 */

	public String getServer()
	{
		return server;
	}

	/**
	 * @param server the server to set
	 */
	public void setServer(String server)
	{
		this.server = server;
	}

	/**
	 * @return the log
	 */

	public String getLog()
	{
		return log;
	}

	/**
	 * @param log the log to set
	 */
	public void setLog(String log)
	{
		this.log = log;
	}

	/**
	 * @return the startDate
	 */

	public String getStartDate()
	{
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate)
	{
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */

	public String getEndDate()
	{
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate)
	{
		this.endDate = endDate;
	}

	/**
	 * @return the infoType
	 */

	public String getInfoType()
	{
		return infoType;
	}

	/**
	 * @param infoType the infoType to set
	 */
	public void setInfoType(String infoType)
	{
		this.infoType = infoType;
	}

	/**
	 * @return the level
	 */

	public String getLevel()
	{
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(String level)
	{
		this.level = level;
	}

	/**
	 * @return the details
	 */

	public boolean isDetails()
	{
		return details;
	}

	/**
	 * @param details the details to set
	 */
	public void setDetails(boolean details)
	{
		this.details = details;
	}

	/**
	 * @return the count
	 */

	public boolean isCount()
	{
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(boolean count)
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
		result = prime * result + ((addDateTime == null) ? 0 : addDateTime.hashCode());
		result = prime * result + (count ? 1231 : 1237);
		result = prime * result + (details ? 1231 : 1237);
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + id;
		result = prime * result + ((infoType == null) ? 0 : infoType.hashCode());
		result = prime * result + ((level == null) ? 0 : level.hashCode());
		result = prime * result + ((log == null) ? 0 : log.hashCode());
		result = prime * result + ((server == null) ? 0 : server.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((webSite == null) ? 0 : webSite.hashCode());
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
		HistoryReportModel other = (HistoryReportModel) obj;
		if (addDateTime == null)
		{
			if (other.addDateTime != null)
				return false;
		}
		else if (!addDateTime.equals(other.addDateTime))
			return false;
		if (count != other.count)
			return false;
		if (details != other.details)
			return false;
		if (endDate == null)
		{
			if (other.endDate != null)
				return false;
		}
		else if (!endDate.equals(other.endDate))
			return false;
		if (id != other.id)
			return false;
		if (infoType == null)
		{
			if (other.infoType != null)
				return false;
		}
		else if (!infoType.equals(other.infoType))
			return false;
		if (level == null)
		{
			if (other.level != null)
				return false;
		}
		else if (!level.equals(other.level))
			return false;
		if (log == null)
		{
			if (other.log != null)
				return false;
		}
		else if (!log.equals(other.log))
			return false;
		if (server == null)
		{
			if (other.server != null)
				return false;
		}
		else if (!server.equals(other.server))
			return false;
		if (startDate == null)
		{
			if (other.startDate != null)
				return false;
		}
		else if (!startDate.equals(other.startDate))
			return false;
		if (webSite == null)
		{
			if (other.webSite != null)
				return false;
		}
		else if (!webSite.equals(other.webSite))
			return false;
		return true;
	}

}

/*
 * $Log: $
 */