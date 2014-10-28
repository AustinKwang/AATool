package com.accela.loganalyzer.readfile;

import java.util.List;

import com.accela.loganalyzer.loganalysis.LogAnalyzeConstants;

/**
 * <pre>
 * 
 *  N/A Automation
 *  File: MemoryCapture.java
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
public class MemoryCapture implements LogInfoCapture
{

	@Override
	public String getLogInfoName()
	{
		return LogAnalyzeConstants.MEMORYCAPTURE_TYPE;
	}

	@Override
	public boolean capture(String line, Context capturesMap)
	{

		if (this.isMenoryFirstLine(line))
		{
			StringBuilder simpleLog = new StringBuilder();
			simpleLog.append(line);
			capturesMap.setValue(this.getLogInfoName(),simpleLog);
			return true;
		}
		if (this.isMenoryBodyLine(line))
		{
			List<StringBuilder> commonLogInfos = capturesMap.getValue(this.getLogInfoName());
			if(commonLogInfos != null)
			{
				int lastIndex = commonLogInfos.size();
				commonLogInfos.get(lastIndex-1).append("\n"+line);
			}
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	private boolean isMenoryBodyLine(String line)
	{
		String[] regexs = new String[6];
		regexs[0] = ".*\\[com.accela.diagnostics.DiagnosticThread\\] Max Memory.*";
		regexs[1] = ".*\\[com.accela.diagnostics.DiagnosticThread\\] Free Memory\\(Total\\).*";
		regexs[2] = ".*\\[com.accela.diagnostics.DiagnosticThread\\] Free Memory\\(Max\\).*";
		regexs[3] = ".*\\[com.accela.diagnostics.DiagnosticThread\\] % Memory Used \\(Total\\).*";
		regexs[4] = ".*\\[com.accela.diagnostics.DiagnosticThread\\] % Memory Used \\(Max\\).*";
		regexs[5] = ".*\\[com.accela.diagnostics.DiagnosticThread\\] Available Processors.*";
		for (int i = 0; i < 6; i++)
		{
			if (line.matches(regexs[i]))
			{
				return true;
			}
		}
		return false;
	}

	private boolean isMenoryFirstLine(String line)
	{
		String regex = ".*\\[com.accela.diagnostics.DiagnosticThread\\] Total Memory.*";
		if (line.matches(regex))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}

/*
*$Log: $
*/