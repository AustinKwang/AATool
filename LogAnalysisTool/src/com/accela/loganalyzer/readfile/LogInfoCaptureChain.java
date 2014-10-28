package com.accela.loganalyzer.readfile;

import java.util.List;
import java.util.Map;

/**
 * <pre>
 * 
 *  N/A Automation
 *  File: LogInfoCaptureChain.java
 * 
 *  N/A, Inc.
 *  Copyright (C): 2014
 * 
 *  Description:
 *  TODO
 * 
 *  Revision History
 *  Date,		Who,		What;
 *  2014年9月10日		Golden Huang		Initial.
 * 
 * </pre>
 */
public class LogInfoCaptureChain
{

	private List<LogInfoCapture> logInfoCaptures;

	/**
	 * TODO.
	 * 
	 * @return
	 */
	public List<LogInfoCapture> getLogInfoCaptures()
	{
		return logInfoCaptures;
	}

	/**
	 * TODO.
	 * 
	 * @param logInfoCaptures
	 */
	public void setLogInfoCaptures(List<LogInfoCapture> logInfoCaptures)
	{
		this.logInfoCaptures = logInfoCaptures;
	}

	/**
	 * TODO.
	 * 
	 * @param line
	 * @param context
	 */
	public void doCapture(String line, Context context)
	{
		for (LogInfoCapture capture : logInfoCaptures)
		{
			if (capture.capture(line, context))
			{
				return;
			}
		}
	}
}

/*
 * $Log: $
 */