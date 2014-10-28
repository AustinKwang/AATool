package com.accela.loganalyzer.report.action;

import java.util.List;

import com.accela.loganalyzer.report.converter.ChartDataContext;
import com.accela.loganalyzer.report.converter.LineChartCompleteData;
import com.accela.loganalyzer.report.converter.PieChartData;
import com.accela.loganalyzer.report.service.ChartService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * <pre>
 * 
 *  N/A Automation
 *  File: ChartDataAction.java
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
public class ChartAction extends ActionSupport
{
	/**
	 * Comment for &lt;code&gt;serialVersionUID&lt;/code&gt;
	 */
	private static final long serialVersionUID = 1L;

	private String webSite;

	private String server;

	private String log;

	private String startDate;

	private String endDate;

	private String reportType;

	private String level;

	private ChartService chartService;

	private LineChartCompleteData lineChartCompleteData;

	private List<PieChartData> pieBlocks;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception
	{
		lineChartCompleteData = null;
		pieBlocks = null;
		ChartDataContext ChartDataContext = new ChartDataContext();
		chartService.getChartData(webSite, server, log, startDate, endDate, reportType, level, ChartDataContext);
		lineChartCompleteData = ChartDataContext.getLineChartCompleteData();
		pieBlocks = ChartDataContext.getPieBlocks();
		return SUCCESS;
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

	/**
	 * @param webSite the webSite to set
	 */
	public void setWebSite(String webSite)
	{
		this.webSite = webSite;
	}

	/**
	 * @param server the server to set
	 */
	public void setServer(String server)
	{
		this.server = server;
	}

	/**
	 * @param log the log to set
	 */
	public void setLog(String log)
	{
		this.log = log;
	}

	/**
	 * @param reportType the reportType to set
	 */
	public void setReportType(String reportType)
	{
		this.reportType = reportType;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(String level)
	{
		this.level = level;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate)
	{
		this.startDate = startDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate)
	{
		this.endDate = endDate;
	}

	/**
	 * @param chartService the chartService to set
	 */
	public void setChartService(ChartService chartService)
	{
		this.chartService = chartService;
	}

}

/*
 * $Log: $
 */