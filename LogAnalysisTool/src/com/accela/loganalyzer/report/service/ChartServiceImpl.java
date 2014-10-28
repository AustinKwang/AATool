package com.accela.loganalyzer.report.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.accela.loganalyzer.loganalysis.LogAnalyzeConstants;
import com.accela.loganalyzer.report.converter.ChartDataContext;
import com.accela.loganalyzer.report.converter.ChartDataConverter;
import com.accela.loganalyzer.report.converter.LineChartDataListProcessor;
import com.accela.loganalyzer.report.converter.PieChartDataListProcessor;
import com.accela.loganalyzer.report.dao.ChartDao;
import com.accela.loganalyzer.report.model.ServerLogChartModel;
import com.accela.loganalyzer.report.model.MemoryChartModel;

/**
 * <pre>
 * 
 *  N/A
 *  File: ChartServiceImpl.java
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
public class ChartServiceImpl implements ChartService
{
	private ChartDataConverter chartDataConverter;

	private ChartDao chartDao;

	/**
	 * @return the chartDataConverter
	 */

	public ChartDataConverter getChartDataConverter()
	{
		return chartDataConverter;
	}

	/**
	 * @param chartDataConverter the chartDataConverter to set
	 */
	public void setChartDataConverter(ChartDataConverter chartDataConverter)
	{
		this.chartDataConverter = chartDataConverter;
	}

	/**
	 * @return the chartDao
	 */

	public ChartDao getChartDao()
	{
		return chartDao;
	}

	/**
	 * @param chartDao the chartDao to set
	 */
	public void setChartDao(ChartDao chartDao)
	{
		this.chartDao = chartDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.accela.loganalyzer.report.service.ChartService#getChartData(java.lang.String, java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String, java.lang.String,
	 * com.accela.loganalyzer.report.converter.LineChartCompleteData, java.util.List)
	 */
	@Override
	public void getChartData(String webSite, String server, String log, String startDate, String endDate,
			String reportType, String level, ChartDataContext chartDataContext)
	{
		if (reportType.equals(LogAnalyzeConstants.COMMONCAPUTRE_TYPE))
		{
			List<ServerLogChartModel> dbData = chartDao.getCommonLog(startDate, endDate, level);
			chartDataContext.setPieBlocks(chartDataConverter.convertPieChartData(dbData,
				new ServerLogInfoWarnClassNameDataListProcessor()));
		}
		else if (reportType.equals(LogAnalyzeConstants.MEMORYCAPTURE_TYPE))
		{
			List<MemoryChartModel> dbData = chartDao.getSystemMemories(startDate, endDate);
			chartDataContext.setLineChartCompleteData(chartDataConverter.convertLineChartData(dbData,
				new SystemMemoryDataListProcessor(), 1));
		}
	}

	private class ServerLogInfoWarnClassNameDataListProcessor implements PieChartDataListProcessor<ServerLogChartModel>
	{
		/*
		 * (non-Javadoc)
		 * 
		 * @see com.beyondsoft.chart.utils.LineChartDataListProcessor#getLabels(java.util.List)
		 */
		@Override
		public List<String> getLabels(List<ServerLogChartModel> dbData)
		{
			List<String> labels = new ArrayList<String>();
			for (int i = 0; i < dbData.size(); i++)
			{
				labels.add(dbData.get(i).getClassName());
			}
			return labels;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.beyondsoft.chart.utils.PieChartDataListProcessor#getValues(java.util.List)
		 */
		@Override
		public List<Long> getValues(List<ServerLogChartModel> dbData)
		{
			List<Long> count = new ArrayList<Long>();
			for (int i = 0; i < dbData.size(); i++)
			{
				count.add(dbData.get(i).getCount());
			}
			return count;
		}

	}

	private class SystemMemoryDataListProcessor implements LineChartDataListProcessor<MemoryChartModel>
	{
		/*
		 * (non-Javadoc)
		 * 
		 * @see com.beyondsoft.chart.utils.LineChartDataListProcessor#getLabels(java.util.List)
		 */
		@Override
		public List<String> getLabels(List<MemoryChartModel> dbData)
		{
			List<String> labels = new ArrayList<String>();
			for (int i = 0; i < dbData.size(); i++)
			{
				labels.add(dbData.get(i).getLogDate().toString());
			}
			return labels;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.beyondsoft.chart.utils.LineChartDataListProcessor#getDatasets(java.util.List)
		 */
		@Override
		public Map<String, List<Long>> getData(List<MemoryChartModel> dbData)
		{
			List<Long> totalMemories = new ArrayList<Long>();
			List<Long> maxMemories = new ArrayList<Long>();
			List<Long> totalFreeMemories = new ArrayList<Long>();
			List<Long> maxFreeMemories = new ArrayList<Long>();
			for (int i = 0; i < dbData.size(); i++)
			{
				totalMemories.add(dbData.get(i).getTotalMemory());
				maxMemories.add(dbData.get(i).getMaxMemory());
				totalFreeMemories.add(dbData.get(i).getTotalFreeMemory());
				maxFreeMemories.add(dbData.get(i).getMaxFreeMemory());
			}
			Map<String, List<Long>> data = new HashMap<String, List<Long>>();
			data.put("totalMemory", totalMemories);
			data.put("maxMemories", maxMemories);
			data.put("totalFreeMemory", totalFreeMemories);
			data.put("maxFreeMemory", maxFreeMemories);
			return data;
		}
	}

}

/*
 * $Log: $
 */