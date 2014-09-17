package com.accela.loganalyzer.report.converter;

import java.util.List;

/**
 * <pre>
 * 
 *  N/A Automation
 *  File: ChartDataContext.java
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
public class ChartDataContext
{
	private LineChartCompleteData lineChartCompleteData;

	private List<PieChartData> pieBlocks;

	public ChartDataContext()
	{
		this.lineChartCompleteData = null;
		this.pieBlocks = null;
	}

	/**
	 * @return the lineChartCompleteData
	 */

	public LineChartCompleteData getLineChartCompleteData()
	{
		return lineChartCompleteData;
	}

	/**
	 * @param lineChartCompleteData the lineChartCompleteData to set
	 */
	public void setLineChartCompleteData(LineChartCompleteData lineChartCompleteData)
	{
		this.lineChartCompleteData = lineChartCompleteData;
	}

	/**
	 * @return the pieBlocks
	 */

	public List<PieChartData> getPieBlocks()
	{
		return pieBlocks;
	}

	/**
	 * @param pieBlocks the pieBlocks to set
	 */
	public void setPieBlocks(List<PieChartData> pieBlocks)
	{
		this.pieBlocks = pieBlocks;
	}

}

/*
 * $Log: $
 */