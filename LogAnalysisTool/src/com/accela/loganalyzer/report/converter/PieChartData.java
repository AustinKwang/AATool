package com.accela.loganalyzer.report.converter;

/**
 * <pre>
 * 
 *  N/A
 *  File: PieChartData.java
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
public class PieChartData
{
	private long value;

	private String color;

	private String highlight;

	private String label;

	public PieChartData()
	{
	}

	public PieChartData(String rgb)
	{
		this.color = "rgba(" + rgb + ",1)";
		this.highlight = "rgba(" + rgb + ",0.8)";
	}

	/**
	 * @return the value
	 */

	public long getValue()
	{
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(long value)
	{
		this.value = value;
	}

	/**
	 * @return the color
	 */

	public String getColor()
	{
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color)
	{
		this.color = color;
	}

	/**
	 * @return the highlight
	 */

	public String getHighlight()
	{
		return highlight;
	}

	/**
	 * @param highlight the highlight to set
	 */
	public void setHighlight(String highlight)
	{
		this.highlight = highlight;
	}

	/**
	 * @return the label
	 */

	public String getLabel()
	{
		return label;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(String label)
	{
		this.label = label;
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
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((highlight == null) ? 0 : highlight.hashCode());
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		result = prime * result + (int) (value ^ (value >>> 32));
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
		PieChartData other = (PieChartData) obj;
		if (color == null)
		{
			if (other.color != null)
				return false;
		}
		else if (!color.equals(other.color))
			return false;
		if (highlight == null)
		{
			if (other.highlight != null)
				return false;
		}
		else if (!highlight.equals(other.highlight))
			return false;
		if (label == null)
		{
			if (other.label != null)
				return false;
		}
		else if (!label.equals(other.label))
			return false;
		if (value != other.value)
			return false;
		return true;
	}

}

/*
 * $Log: $
 */