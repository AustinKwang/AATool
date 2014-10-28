package com.accela.loganalyzer.report.action;

import java.util.List;

import com.accela.loganalyzer.report.converter.ChartDataContext;
import com.accela.loganalyzer.report.converter.LineChartCompleteData;
import com.accela.loganalyzer.report.converter.PieChartData;
import com.accela.loganalyzer.report.service.ChartService;
import com.accela.loganalyzer.report.service.TableService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * <pre>
 * 
 *  N/A Automation
 *  File: ReportAction.java
 * 
 *  N/A, Inc.
 *  Copyright (C): 2014
 * 
 *  Description:
 *  TODO
 * 
 *  Revision History
 *  Date,		Who,		What;
 *  2014年9月16日		Golden Huang		Initial.
 * 
 * </pre>
 */
public class ReportAction extends ActionSupport
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

	private String infoType;

	private String level;

	private boolean tableTypeCount;

	private boolean tableTypeDetails;

	private ChartService chartService;

	private TableService tableService;

	private LineChartCompleteData lineChartCompleteData;

	private List<PieChartData> pieBlocks;

	private List<List<String>> count;

	private List<List<String>> details;

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
		count = null;
		details = null;

		ChartDataContext ChartDataContext = new ChartDataContext();
		TableContext tableContext = new TableContext();

		chartService.getChartData(webSite, server, log, startDate, endDate, infoType, level, ChartDataContext);

		if (null != ChartDataContext.getLineChartCompleteData()
				&& ChartDataContext.getLineChartCompleteData().getLabels().size() > 0)
		{
			lineChartCompleteData = ChartDataContext.getLineChartCompleteData();
		}
		if (null != ChartDataContext.getPieBlocks() && ChartDataContext.getPieBlocks().size() > 0)
		{
			pieBlocks = ChartDataContext.getPieBlocks();
			tableService.getTableData(webSite, server, log, startDate, endDate, tableTypeCount, tableTypeDetails, true,
				false, tableContext);
			if (null != tableContext.getCount() && tableContext.getCount().size() > 0)
			{
				count = tableContext.getCount();
			}
			if (null != tableContext.getDetails() && tableContext.getDetails().size() > 0)
			{
				details = tableContext.getDetails();
			}
		}
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
	 * @return the pieBlocks
	 */

	public List<PieChartData> getPieBlocks()
	{
		return pieBlocks;
	}

	/**
	 * @return the count
	 */

	public List<List<String>> getCount()
	{
		return count;
	}

	/**
	 * @return the details
	 */

	public List<List<String>> getDetails()
	{
		return details;
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
	 * @param infoType the infoType to set
	 */
	public void setInfoType(String infoType)
	{
		this.infoType = infoType;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(String level)
	{
		this.level = level;
	}

	/**
	 * @param tableTypeCount the tableTypeCount to set
	 */
	public void setTableTypeCount(boolean tableTypeCount)
	{
		this.tableTypeCount = tableTypeCount;
	}

	/**
	 * @param tableTypeDetails the tableTypeDetails to set
	 */
	public void setTableTypeDetails(boolean tableTypeDetails)
	{
		this.tableTypeDetails = tableTypeDetails;
	}

	/**
	 * @param chartService the chartService to set
	 */
	public void setChartService(ChartService chartService)
	{
		this.chartService = chartService;
	}

	/**
	 * @param tableService the tableService to set
	 */
	public void setTableService(TableService tableService)
	{
		this.tableService = tableService;
	}
}

/*
 * $Log: $
 */