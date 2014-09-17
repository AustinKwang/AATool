package com.accela.loganalyzer.report.converter;

import java.util.List;
import java.util.Map;

/**
 * <pre>
 * 
 *  N/A
 *  File: LineChartDataListProcessor.java
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
public interface LineChartDataListProcessor<T>
{
	public List<String> getLabels(List<T> dbData);

	public Map<String, List<Long>> getData(List<T> dbData);
}

/*
 * $Log: $
 */