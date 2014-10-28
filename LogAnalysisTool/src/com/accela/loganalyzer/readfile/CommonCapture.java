package com.accela.loganalyzer.readfile;

import java.util.List;

import com.accela.loganalyzer.loganalysis.LogAnalyzeConstants;

/**
 * <pre>
 * 
 *  N/A Automation
 *  File: CommonCapture.java
 * 
 *  N/A, Inc.
 *  Copyright (C): 2014
 * 
 *  Description:
 *  TODO
 * 
 *  Revision History
 *  Date,		Who,		What;
 *  2014年9月11日		pc		Initial.
 *  
 * </pre>
 */
public class CommonCapture implements LogInfoCapture
{

	@Override
	public String getLogInfoName()
	{
		return LogAnalyzeConstants.COMMONCAPUTRE_TYPE;
	}

	@Override
	public boolean capture(String line, Context capturesMap)
	{
		if (line.matches("\\d{4}-\\d{2}-\\d{2}.*"))
		{
			StringBuilder simpleLog = new StringBuilder();
			simpleLog.append(line);
			capturesMap.setValue(this.getLogInfoName(),simpleLog);
		}
		else
		{
			List<StringBuilder> commonLogInfos = capturesMap.getValue(this.getLogInfoName());
			if(commonLogInfos != null)
			{
				int lastIndex = commonLogInfos.size();
				commonLogInfos.get(lastIndex-1).append("\n"+line);
			}
		}
		return true;
	}
	
}

/*
*$Log: $
*/