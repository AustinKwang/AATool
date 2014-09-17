package com.accela.loganalyzer.report.dao.test;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.accela.loganalyzer.report.dao.HistoryReportDao;
import com.accela.loganalyzer.report.model.HistoryReportModel;

/**
 * <pre>
 * 
 *  N/A Automation
 *  File: HistoryReportDaoTest.java
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
public class HistoryReportDaoTest
{
	ApplicationContext ac;

	HistoryReportDao historyReportDao;

	@Before
	public void init()
	{
		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		historyReportDao = (HistoryReportDao) ac.getBean("historyReportDao");
	}

	@Test
	public void queryList()
	{
		List<HistoryReportModel> list = historyReportDao.getAllHistoryReport();
		Assert.assertNotNull(list);
	}

	@Test
	public void queryObject()
	{
		HistoryReportModel historyReportModel = historyReportDao.getHistoryReportById(3);
		Assert.assertNotNull(historyReportModel);
	}

	@Test
	public void add()
	{
		HistoryReportModel historyReportModel = new HistoryReportModel();
		historyReportModel.setAddDateTime(new Date(System.currentTimeMillis()));
		historyReportModel.setStartDate("2014-09-02");
		historyReportModel.setEndDate("2014-09-05");
		historyReportModel.setWebSite("Agency");
		historyReportModel.setServer("biz");
		historyReportModel.setLog("ServerLog");
		historyReportModel.setInfoType("common");
		historyReportModel.setLevel("ERROR");
		historyReportModel.setDetails(false);
		historyReportModel.setCount(false);
		historyReportDao.addHistoryReport(historyReportModel);
	}

	@Test
	public void update()
	{
		HistoryReportModel historyReportModel = new HistoryReportModel();
		historyReportModel.setId(3);
		historyReportModel.setAddDateTime(new Date(System.currentTimeMillis()));
		historyReportModel.setStartDate("2014-09-01");
		historyReportModel.setEndDate("2014-09-06");
		historyReportModel.setWebSite("Agency");
		historyReportModel.setServer("biz");
		historyReportModel.setLog("ServerLog");
		historyReportModel.setInfoType("common");
		historyReportModel.setLevel("WARN");
		historyReportModel.setDetails(true);
		historyReportModel.setCount(true);
		historyReportDao.updateHistoryReport(historyReportModel);
	}

	@Test
	public void delete()
	{
		historyReportDao.deleteHistoryReport(3);
	}
}

/*
 * $Log: $
 */