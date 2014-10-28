package com.accela.loganalyzer.report.converter;

import java.util.List;

/**
 * <pre>
 * 
 *  N/A
 *  File: LineChartData.java
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
public class LineChartData
{
	private String label;

	private String fillColor;

	private String strokeColor;

	private String highlightFill;

	private String highlightStroke;

	private String pointColor;

	private String pointStrokeColor;

	private String pointHighlightFill;

	private String pointHighlightStroke;

	private List<Long> data;

	/**
	 * LineChartData Constructor.
	 * 
	 */
	public LineChartData()
	{
	}

	/**
	 * LineChartData Constructor.
	 * 
	 * @param rgb format: XXX,XXX,XXX (number 0~255,0~255,0~255)
	 * @param theme format: X (light: 1, dark: 2,default:0 or else number)
	 * 
	 *            theme light looks better in line chart,theme dark looks better in bar chart
	 * 
	 */
	public LineChartData(String rgb, int theme)
	{
		switch (theme)
		{
			case 1:
			{
				this.fillColor = "rgba(" + rgb + ",0)";
				this.strokeColor = "rgba(" + rgb + ",0.7)";
				this.highlightFill = "rgba(" + rgb + ",0.8)";
				this.highlightStroke = "rgba(" + rgb + ",1)";
				this.pointColor = "rgba(" + rgb + ",1)";
				this.pointStrokeColor = "#fff";
				this.pointHighlightFill = "#fff";
				this.pointHighlightStroke = "rgba(" + rgb + ",1)";
				break;
			}
			case 2:
			{
				this.fillColor = "rgba(" + rgb + ",0.5)";
				this.strokeColor = "rgba(" + rgb + ",0.7)";
				this.highlightFill = "rgba(" + rgb + ",0.8)";
				this.highlightStroke = "rgba(" + rgb + ",1)";
				this.pointColor = "rgba(" + rgb + ",1)";
				this.pointStrokeColor = "#fff";
				this.pointHighlightFill = "#fff";
				this.pointHighlightStroke = "rgba(" + rgb + ",1)";
				break;
			}
			default:
			{
				this.fillColor = "rgba(" + rgb + ",0.4)";
				this.strokeColor = "rgba(" + rgb + ",0.7)";
				this.highlightFill = "rgba(" + rgb + ",0.8)";
				this.highlightStroke = "rgba(" + rgb + ",1)";
				this.pointColor = "rgba(" + rgb + ",1)";
				this.pointStrokeColor = "#fff";
				this.pointHighlightFill = "#fff";
				this.pointHighlightStroke = "rgba(" + rgb + ",1)";
				break;
			}
		}
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

	/**
	 * @return the fillColor
	 */

	public String getFillColor()
	{
		return fillColor;
	}

	/**
	 * @param fillColor the fillColor to set
	 */
	public void setFillColor(String fillColor)
	{
		this.fillColor = fillColor;
	}

	/**
	 * @return the strokeColor
	 */

	public String getStrokeColor()
	{
		return strokeColor;
	}

	/**
	 * @param strokeColor the strokeColor to set
	 */
	public void setStrokeColor(String strokeColor)
	{
		this.strokeColor = strokeColor;
	}

	/**
	 * @return the highlightFill
	 */

	public String getHighlightFill()
	{
		return highlightFill;
	}

	/**
	 * @param highlightFill the highlightFill to set
	 */
	public void setHighlightFill(String highlightFill)
	{
		this.highlightFill = highlightFill;
	}

	/**
	 * @return the highlightStroke
	 */

	public String getHighlightStroke()
	{
		return highlightStroke;
	}

	/**
	 * @param highlightStroke the highlightStroke to set
	 */
	public void setHighlightStroke(String highlightStroke)
	{
		this.highlightStroke = highlightStroke;
	}

	/**
	 * @return the pointColor
	 */

	public String getPointColor()
	{
		return pointColor;
	}

	/**
	 * @param pointColor the pointColor to set
	 */
	public void setPointColor(String pointColor)
	{
		this.pointColor = pointColor;
	}

	/**
	 * @return the pointStrokeColor
	 */

	public String getPointStrokeColor()
	{
		return pointStrokeColor;
	}

	/**
	 * @param pointStrokeColor the pointStrokeColor to set
	 */
	public void setPointStrokeColor(String pointStrokeColor)
	{
		this.pointStrokeColor = pointStrokeColor;
	}

	/**
	 * @return the pointHighlightFill
	 */

	public String getPointHighlightFill()
	{
		return pointHighlightFill;
	}

	/**
	 * @param pointHighlightFill the pointHighlightFill to set
	 */
	public void setPointHighlightFill(String pointHighlightFill)
	{
		this.pointHighlightFill = pointHighlightFill;
	}

	/**
	 * @return the pointHighlightStroke
	 */

	public String getPointHighlightStroke()
	{
		return pointHighlightStroke;
	}

	/**
	 * @param pointHighlightStroke the pointHighlightStroke to set
	 */
	public void setPointHighlightStroke(String pointHighlightStroke)
	{
		this.pointHighlightStroke = pointHighlightStroke;
	}

	/**
	 * @return the data
	 */

	public List<Long> getData()
	{
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(List<Long> data)
	{
		this.data = data;
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
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((fillColor == null) ? 0 : fillColor.hashCode());
		result = prime * result + ((highlightFill == null) ? 0 : highlightFill.hashCode());
		result = prime * result + ((highlightStroke == null) ? 0 : highlightStroke.hashCode());
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		result = prime * result + ((pointColor == null) ? 0 : pointColor.hashCode());
		result = prime * result + ((pointHighlightFill == null) ? 0 : pointHighlightFill.hashCode());
		result = prime * result + ((pointHighlightStroke == null) ? 0 : pointHighlightStroke.hashCode());
		result = prime * result + ((pointStrokeColor == null) ? 0 : pointStrokeColor.hashCode());
		result = prime * result + ((strokeColor == null) ? 0 : strokeColor.hashCode());
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
		LineChartData other = (LineChartData) obj;
		if (data == null)
		{
			if (other.data != null)
				return false;
		}
		else if (!data.equals(other.data))
			return false;
		if (fillColor == null)
		{
			if (other.fillColor != null)
				return false;
		}
		else if (!fillColor.equals(other.fillColor))
			return false;
		if (highlightFill == null)
		{
			if (other.highlightFill != null)
				return false;
		}
		else if (!highlightFill.equals(other.highlightFill))
			return false;
		if (highlightStroke == null)
		{
			if (other.highlightStroke != null)
				return false;
		}
		else if (!highlightStroke.equals(other.highlightStroke))
			return false;
		if (label == null)
		{
			if (other.label != null)
				return false;
		}
		else if (!label.equals(other.label))
			return false;
		if (pointColor == null)
		{
			if (other.pointColor != null)
				return false;
		}
		else if (!pointColor.equals(other.pointColor))
			return false;
		if (pointHighlightFill == null)
		{
			if (other.pointHighlightFill != null)
				return false;
		}
		else if (!pointHighlightFill.equals(other.pointHighlightFill))
			return false;
		if (pointHighlightStroke == null)
		{
			if (other.pointHighlightStroke != null)
				return false;
		}
		else if (!pointHighlightStroke.equals(other.pointHighlightStroke))
			return false;
		if (pointStrokeColor == null)
		{
			if (other.pointStrokeColor != null)
				return false;
		}
		else if (!pointStrokeColor.equals(other.pointStrokeColor))
			return false;
		if (strokeColor == null)
		{
			if (other.strokeColor != null)
				return false;
		}
		else if (!strokeColor.equals(other.strokeColor))
			return false;
		return true;
	}

}

/*
 * $Log: $
 */