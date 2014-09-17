package com.accela.loganalyzer.report.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.accela.loganalyzer.frame.database.DBAccessor;
import com.accela.loganalyzer.frame.database.DBResultSetProcessor;
import com.accela.loganalyzer.report.model.HistoryReportModel;

/**
 * <pre>
 * 
 *  N/A Automation
 *  File: HistoryReportDaoImpl.java
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
public class HistoryReportDaoImpl implements HistoryReportDao
{
	private DBAccessor DBAccessor;

	/**
	 * @param dBAccessor the dBAccessor to set
	 */
	public void setDBAccessor(DBAccessor dBAccessor)
	{
		DBAccessor = dBAccessor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.accela.loganalyzer.report.dao.HistoryReportDao#getAllHistoryReport()
	 */
	@Override
	public List<HistoryReportModel> getAllHistoryReport()
	{
		return DBAccessor
				.select(
					"SELECT id,addDateTime,webSite,server,log,startDate,endDate,infoType,level,details,count FROM history_report",
					new Object[] {}, new HistoryReportModelResultSetProcessor());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.accela.loganalyzer.report.dao.HistoryReportDao#getHistoryReportById(int)
	 */
	@Override
	public HistoryReportModel getHistoryReportById(int id)
	{
		return DBAccessor
				.select(
					"SELECT id,addDateTime,webSite,server,log,startDate,endDate,infoType,level,details,count FROM history_report WHERE id=?",
					new Object[] {id}, new HistoryReportModelResultSetProcessor()).get(0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.accela.loganalyzer.report.dao.HistoryReportDao#deleteHistoryReport(int)
	 */
	@Override
	public void deleteHistoryReport(int id)
	{
		DBAccessor.update("DELETE FROM history_report WHERE id=?", new Object[] {id});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.accela.loganalyzer.report.dao.HistoryReportDao#addHistoryReport(com.accela.loganalyzer.report.model.
	 * HistoryReportModel)
	 */
	@Override
	public void addHistoryReport(HistoryReportModel historyReportModel)
	{
		DBAccessor
				.save(
					"INSERT INTO history_report(addDateTime,webSite,server,log,startDate,endDate,infoType,level,details,count) value(?,?,?,?,?,?,?,?,?,?)",
					new Object[] {historyReportModel.getAddDateTime(), historyReportModel.getWebSite(),
							historyReportModel.getServer(), historyReportModel.getLog(),
							historyReportModel.getStartDate(), historyReportModel.getEndDate(),
							historyReportModel.getInfoType(), historyReportModel.getLevel(),
							historyReportModel.isDetails(), historyReportModel.isCount()});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.accela.loganalyzer.report.dao.HistoryReportDao#updateHistoryReport(com.accela.loganalyzer.report.model.
	 * HistoryReportModel)
	 */
	@Override
	public void updateHistoryReport(HistoryReportModel historyReportModel)
	{
		DBAccessor
				.update(
					"UPDATE history_report SET addDateTime=?,webSite=?,server=?,log=?,startDate=?,endDate=?,infoType=?,level=?,details=?,count=? WHERE id=?",
					new Object[] {historyReportModel.getAddDateTime(), historyReportModel.getWebSite(),
							historyReportModel.getServer(), historyReportModel.getLog(),
							historyReportModel.getStartDate(), historyReportModel.getEndDate(),
							historyReportModel.getInfoType(), historyReportModel.getLevel(),
							historyReportModel.isDetails(), historyReportModel.isCount(), historyReportModel.getId()});
	}

	private class HistoryReportModelResultSetProcessor implements DBResultSetProcessor<HistoryReportModel>
	{

		@Override
		public HistoryReportModel processResultSetRow(ResultSet rs) throws SQLException
		{
			HistoryReportModel historyReportModel = new HistoryReportModel();
			historyReportModel.setId(rs.getInt("id"));
			historyReportModel.setAddDateTime(rs.getDate("addDateTime"));
			historyReportModel.setWebSite(rs.getString("webSite"));
			historyReportModel.setServer(rs.getString("server"));
			historyReportModel.setLog(rs.getString("log"));
			historyReportModel.setStartDate(rs.getString("startDate"));
			historyReportModel.setEndDate(rs.getString("endDate"));
			historyReportModel.setInfoType(rs.getString("infoType"));
			historyReportModel.setLevel(rs.getString("level"));
			historyReportModel.setDetails(rs.getBoolean("details"));
			historyReportModel.setCount(rs.getBoolean("count"));
			return historyReportModel;
		}
	}
}

/*
 * $Log: $
 */