package com.accela.loganalyzer.report.converter;

import java.util.List;

/**
 * <pre>
 * 
 *  N/A
 *  File: PieChartDataListProcessor.java
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
public interface PieChartDataListProcessor<T>
{
	public List<String> getLabels(List<T> dbData);

	public List<Long> getValues(List<T> dbData);
}

/*
 * $Log: $
 */