package com.accela.loganalyzer.loganalysis;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.accela.loganalyzer.model.LogModel;


/**
 * <pre>
 * 
 *  Accela Automation
 *  File: LogDetailSpliter.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2014
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: LogDetailSpliter.java 72642 2009-01-01 20:01:57Z ACHIEVO\Austin.Wang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Aug 31, 2014		Austin.Wang		Initial.
 * 
 * </pre>
 */
public class LogDetailSpliter
{

	/**
	 * To split the log information example:2014-08-12 10:56:41,333 ERROR [com.accela.aa.exception.AASystemException]
	 * GetConnectionException
	 * 
	 * @param tempString
	 * @throws ParseException
	 */
	public LogModel splitLogToModel(String tempString) throws ParseException
	{
		LogModel logInfo = new LogModel();
		// split by "(&nbsp)"
		String[] info = tempString.split(" ");
		// combination date time
		String date = info[0] + " " + info[1];
		// in order to match the database the datetime format(2014-01-01 13:12:14.369)
		date = date.replace(",", ".");
		// log level
		String level = info[2];
		String exception = null;

		StringBuilder sb = new StringBuilder();
		for (int i = 3; i < info.length; i++)
		{
			if (i != 3 && i != 4)
			{
				sb.append(info[i]).append(" ");
			}
			else if (i == 3)
			{
				if (info[i].trim() == null || "".equals(info[3].trim()))
				{
					continue;
				}
				else
				{
					exception = info[i].replace("[", "").replace("]", "");
				}
			}
			else if (i == 4)
			{
				if (exception == null)
				{
					exception = info[i].replace("[", "").replace("]", "");
				}
				else
				{
					sb.append(info[i]).append(" ");
				}
			}
		}
		sb.append("\n");
		Date logDate = new SimpleDateFormat(LogAnalyzeConstants.TIME_FORMAT).parse(date);
		logInfo.setLogDate(logDate);
		logInfo.setLogType(level);
		logInfo.setLogDescription(exception);
		logInfo.setLogDetail(sb.toString());

		return logInfo;
	}

	/**
	 * Normal log information to determine whether the rows of data
	 * 
	 * @param tempString
	 * @return true is exception false is normal
	 */
	public boolean isExceptionInfo(String tempString)
	{
		if (tempString.contains(LogAnalyzeConstants.LOG_LEVEL_DEBUG) || tempString.contains(LogAnalyzeConstants.LOG_LEVEL_INFO)
				|| tempString.contains(LogAnalyzeConstants.LOG_LEVEL_WARN) || tempString.contains(LogAnalyzeConstants.LOG_LEVEL_ALL)
				|| tempString.contains(LogAnalyzeConstants.LOG_LEVEL_OFF))
		{
			return false;
		}
		return true;
	}

}

/*
 * $Log: av-env.bat,v $
 */