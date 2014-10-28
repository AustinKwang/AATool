package com.accela.loganalyzer.report.dao;

import java.util.List;

import com.accela.loganalyzer.report.model.HistoryReportModel;

/**
 * <pre>
 * 
 *  N/A Automation
 *  File: ReportDao.java
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
public interface HistoryReportDao
{
	/**
	 * getAllHistoryReport.
	 * 
	 * @return
	 */
	public List<HistoryReportModel> getAllHistoryReport();

	/**
	 * getHistoryReportById.
	 * 
	 * @param id
	 * @return
	 */
	public HistoryReportModel getHistoryReportById(int id);

	/**
	 * deleteHistoryReport.
	 * 
	 * @param id
	 */
	public void deleteHistoryReport(int id);

	/**
	 * addHistoryReport.
	 * 
	 * @param historyReportModel
	 */
	public void addHistoryReport(HistoryReportModel historyReportModel);

	/**
	 * updateHistoryReport.
	 * 
	 * @param historyReportModel
	 */
	public void updateHistoryReport(HistoryReportModel historyReportModel);

}

/*
 * $Log: $
 */