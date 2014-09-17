package com.accela.loganalyzer.report.converter;

import java.util.List;

/**
 * <pre>
 * 
 *  N/A
 *  File: ChartDataConverter.java
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
public interface ChartDataConverter
{
	/**
	 * convert line/bar/radar chart data.
	 * 
	 * @param dbData
	 * @param dataListProcessor
	 * @param theme format: X (light: 1, dark: 2,default:0 or else number)
	 * @return
	 */
	public <T> LineChartCompleteData convertLineChartData(List<T> dbData,
			LineChartDataListProcessor<T> dataListProcessor, int theme);

	/**
	 * convert pie/doughnut/polar chart data..
	 * 
	 * @param dbData
	 * @param dataListProcessor
	 * @return
	 */
	public <T> List<PieChartData> convertPieChartData(List<T> dbData, PieChartDataListProcessor<T> dataListProcessor);

	/**
	 * get color by index.
	 * 
	 * @param index
	 * @return RGB color, format: XXX,XXX,XXX (0~255,0~255,0~255)
	 */
	public String getColorByIndex(int index);
}

/*
 * $Log: $
 */