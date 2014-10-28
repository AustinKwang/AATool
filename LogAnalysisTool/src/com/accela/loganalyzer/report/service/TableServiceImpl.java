package com.accela.loganalyzer.report.service;

import java.util.ArrayList;
import java.util.List;

import com.accela.loganalyzer.report.action.TableContext;
import com.accela.loganalyzer.report.dao.TableDao;

/**
 * <pre>
 * 
 *  N/A Automation
 *  File: TableServiceImpl.java
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
public class TableServiceImpl implements TableService
{

	TableDao tableDao;

	/**
	 * @param tableDao the tableDao to set
	 */
	public void setTableDao(TableDao tableDao)
	{
		this.tableDao = tableDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.accela.loganalyzer.report.service.TableService#getChartData(java.lang.String, java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String, boolean, boolean, boolean, boolean)
	 */
	@Override
	public void getTableData(String webSite, String server, String log, String startDate, String endDate,
			boolean tableTypeCount, boolean tableTypeDetails, boolean tableLevelError, boolean tableLevelWarn,
			TableContext tableContext)
	{
		String level = "";
		if ((tableLevelError == true) && (tableLevelWarn == true))
		{
			level = "ERROR' or level='WARN";
		}
		else
		{
			if (tableLevelError == true)
			{
				level = "ERROR";
			}
			if (tableLevelWarn == true)
			{
				level = "WARN";
			}
		}
		if (tableTypeCount == true)
		{
			List<List<String>> count = new ArrayList<List<String>>();
			count = tableDao.count(level, startDate, endDate);
			tableContext.setCount(count);
		}
		if (tableTypeDetails == true)
		{
			List<List<String>> details = new ArrayList<List<String>>();
			details = tableDao.details(level, startDate, endDate);
			tableContext.setDetails(details);
		}
	}

}

/*
 * $Log: $
 */