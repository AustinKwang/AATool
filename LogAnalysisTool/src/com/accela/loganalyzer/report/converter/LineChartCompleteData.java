package com.accela.loganalyzer.report.converter;

import java.util.List;

/**
 * <pre>
 * 
 *  N/A
 *  File: LineChartCompleteData.java
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
public class LineChartCompleteData
{
	private List<String> labels;

	private List<LineChartData> datasets;

	/**
	 * @return the labels
	 */

	public List<String> getLabels()
	{
		return labels;
	}

	/**
	 * @param labels the labels to set
	 */
	public void setLabels(List<String> labels)
	{
		this.labels = labels;
	}

	/**
	 * @return the datasets
	 */

	public List<LineChartData> getDatasets()
	{
		return datasets;
	}

	/**
	 * @param datasets the datasets to set
	 */
	public void setDatasets(List<LineChartData> datasets)
	{
		this.datasets = datasets;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datasets == null) ? 0 : datasets.hashCode());
		result = prime * result + ((labels == null) ? 0 : labels.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LineChartCompleteData other = (LineChartCompleteData) obj;
		if (datasets == null)
		{
			if (other.datasets != null)
				return false;
		}
		else if (!datasets.equals(other.datasets))
			return false;
		if (labels == null)
		{
			if (other.labels != null)
				return false;
		}
		else if (!labels.equals(other.labels))
			return false;
		return true;
	}

}

/*
 * $Log: $
 */