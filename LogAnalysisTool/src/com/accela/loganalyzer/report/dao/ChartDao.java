package com.accela.loganalyzer.report.dao;

import java.util.List;

import com.accela.loganalyzer.report.model.ServerLogChartModel;
import com.accela.loganalyzer.report.model.MemoryChartModel;

/**
 * <pre>
 * 
 *  N/A
 *  File: ChartDao.java
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
public interface ChartDao
{
	/**
	 * getDataWarnClassName.
	 * 
	 * @return
	 */
	public List<ServerLogChartModel> getCommonLog(String startDate, String endDate, String level);

	/**
	 * getSystemMemories.
	 * 
	 * @return
	 */
	List<MemoryChartModel> getSystemMemories(String startDate, String endDate);

}

/*
 * $Log: $
 */