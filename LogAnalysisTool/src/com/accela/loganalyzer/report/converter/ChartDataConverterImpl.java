package com.accela.loganalyzer.report.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * <pre>
 * 
 *  N/A
 *  File: ChartDataConverterImpl.java
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
public class ChartDataConverterImpl implements ChartDataConverter
{
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.beyondsoft.chart.utils.ChartDataConverter#convertLineChartData(java.util.List,
	 * com.beyondsoft.chart.utils.LineChartDataListProcessor)
	 */
	@Override
	public <T> LineChartCompleteData convertLineChartData(List<T> dbData,
			LineChartDataListProcessor<T> dataListProcessor, int theme)
	{
		Map<String, List<Long>> data = dataListProcessor.getData(dbData);
		List<LineChartData> datasets = new ArrayList<LineChartData>();
		int i = 0;
		for (String listName : data.keySet())
		{
			LineChartData lineChartData = new LineChartData(getColorByIndex(i), theme);
			lineChartData.setLabel(listName);
			lineChartData.setData(data.get(listName));
			datasets.add(lineChartData);
			i++;
		}
		LineChartCompleteData lineChartCompleteData = new LineChartCompleteData();
		lineChartCompleteData.setLabels(dataListProcessor.getLabels(dbData));
		lineChartCompleteData.setDatasets(datasets);
		return lineChartCompleteData;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.beyondsoft.chart.utils.ChartDataConverter#convertPieChartData(java.util.List,
	 * com.beyondsoft.chart.utils.PieChartDataListProcessor)
	 */
	@Override
	public <T> List<PieChartData> convertPieChartData(List<T> dbData, PieChartDataListProcessor<T> dataListProcessor)
	{
		List<String> labels = dataListProcessor.getLabels(dbData);
		List<Long> values = dataListProcessor.getValues(dbData);
		List<PieChartData> pieBlocks = new ArrayList<PieChartData>();
		for (int i = 0; i < labels.size(); i++)
		{
			PieChartData pieChartData = new PieChartData(getColorByIndex(i));
			pieChartData.setLabel(labels.get(i));
			pieChartData.setValue(values.get(i));
			pieBlocks.add(pieChartData);
		}
		return pieBlocks;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.beyondsoft.chart.utils.ChartDataConverter#getColorByIndex(int)
	 */
	@Override
	public String getColorByIndex(int index)
	{
		int rgb1;
		int rgb2;
		int rgb3;
		Random random = new Random(index * 255 + 255);
		do
		{
			rgb1 = random.nextInt(255);
			rgb2 = random.nextInt(255);
			rgb3 = 450 - rgb1 - rgb2;
		} while (rgb3 > 255 || rgb3 < 0);
		return rgb3 + "," + rgb2 + "," + rgb1;
	}
}

/*
 * $Log: $
 */