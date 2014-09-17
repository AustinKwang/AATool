package com.accela.loganalyzer.loganalysis;

import java.util.List;

import org.apache.log4j.Logger;

import com.accela.loganalyzer.readfile.Context;


/**
 * <pre>
 * 
 *  Accela Automation
 *  File: LogAnalysisChain.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2014
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: LogAnalysisChain.java 72642 2009-01-01 20:01:57Z ACHIEVO\Austin.Wang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  2014-9-10		Austin.Wang		Initial.
 *  
 * </pre>
 */
public class LogAnalysisChain
{
	private List<LogDetailParser> detailParsers;

//	private static Logger logger = Logger.getLogger(LogAnalysisChain.class);
	/**
	 * 
	 * parse context to become model
	 *
	 * @param context
	 */
	public void parseContext(Context context)
	{
		for (LogDetailParser detailParser : detailParsers)
		{
			List<StringBuilder> logStrings = context.getValue(detailParser.getContextKey());
			if(logStrings != null)
			{
				for (int i = 0; i < logStrings.size(); i++)
				{
					try
					{
					//convert to model and save to database
					detailParser.saveLog2DB(detailParser.parseLog(logStrings.get(i)));
					}
					catch(Exception ex)
					{
//						logger.error("logg info is:" + logStrings.get(i));
					}
							
				}
			}
			
		}
	}
	
	/**
	 * @param detailParsers the detailParsers to set
	 */
	public void setDetailParsers(List<LogDetailParser> detailParsers)
	{
		this.detailParsers = detailParsers;
	}
}

/*
*$Log: av-env.bat,v $
*/