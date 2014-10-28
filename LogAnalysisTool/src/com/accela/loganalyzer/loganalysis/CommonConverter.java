package com.accela.loganalyzer.loganalysis;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.accela.loganalyzer.model.LogModel;

/**
 * <pre>
 * 
 *  N/A Automation
 *  File: CommonParserToModel.java
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
public class CommonConverter
{

	private StringBuilder logInfo;

	private LogModel logModel;

	/**
	 * 
	 * CommonParserToModel Constructor. 
	 *
	 */
	public CommonConverter()
	{
		super();
	}

	/**
	 * 
	 * CommonParserToModel Constructor. 
	 *
	 * @param logModel
	 * @param logInfo
	 */
	public CommonConverter(LogModel logModel,StringBuilder logInfo)
	{
		super();
		this.logInfo = logInfo;
		this.logModel = logModel;
	}

	/**
	 * @return the logModel
	 */
	
	public LogModel getLogModel()
	{
		return logModel;
	}

	/**
	 * 
	 * parse className and save in model
	 *
	 * @return
	 */
	public CommonConverter parserClassName()
	{
		int beginIndex = logInfo.indexOf("[");
		String[] splitString = this.logInfo.substring(beginIndex).split(" ");
		String className=splitString[0].trim();
		this.logModel.setClassName(className.substring(1,className.length()-1));
		return this;
	}

	
	/**
	 * 
	 * parse createDate and save in model
	 *
	 * @return
	 */
	public CommonConverter parserCreateDate()
	{
		this.logModel.setCreateDate(new Date(System.currentTimeMillis()));
		return this;
	}

	/**
	 * 
	 * parse level and save in model
	 *
	 * @return
	 */
	public CommonConverter parserLevel()
	{
		String level = this.logInfo.substring(24, 29).trim();
		this.logModel.setLogLevel(level);
		return this;
	}

	/**
	 * 
	 * parse log date and save in model
	 *
	 * @return
	 */
	public CommonConverter parserLogDate()
	{
		String dateString = this.logInfo.substring(0, 22);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
		Date date = null;
		try
		{
			date = dateFormat.parse(dateString);
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		this.logModel.setLogDate(date);
		return this;
	}

	/**
	 * @param logInfo the logInfo to set
	 */
	public void setLogInfo(StringBuilder logInfo)
	{
		this.logInfo = logInfo;
	}

	/**
	 * @param logModel the logModel to set
	 */
	public void setLogModel(LogModel logModel)
	{
		this.logModel = logModel;
	}
	
	/**
	 * 
	 * parse detail and stack and save in model
	 *
	 * @param splitSimpleLog
	 */
	private void pareserDetialAndStack(String[] splitSimpleLog)
	{
		String detial = "";
		String stack = "";
		//wipe off the first line
		for (int i = 1; i < splitSimpleLog.length; i++)
		{
			detial += splitSimpleLog[i] + "\n";
			if (splitSimpleLog[i].contains(LogAnalyzeConstants.COMMONPARSE_STACK_TAG))
			{
				stack += splitSimpleLog[i] + "\n";
			}
		}
		this.logModel.setLogDetail(detial.trim());
		this.logModel.setSimpleStack(stack.trim());
		
	}
	
	
	/**
	 * 
	 * parse description by first line
	 * 
	 * @param firstLine
	 * @return description
	 */
	private String parserDescript(String firstLine)
	{
		int beginIndex = firstLine.indexOf("[");
		String[] splitString = firstLine.substring(beginIndex).split(" ");
		String descirption = "";
		// combine the description again
		for (int i = 1; i < splitString.length; i++)
		{
			descirption += splitString[i] + " ";
		}
		return descirption.trim();
	}
	
	
	/**
	 * 
	 * parse description,stack,detail
	 *
	 * @return
	 */
	public CommonConverter parserOther()
	{
		String level = this.logInfo.substring(24, 29).trim();
		// level is info or warn
		if (LogAnalyzeConstants.LOG_LEVEL_INFO.equals(level) || LogAnalyzeConstants.LOG_LEVEL_WARN.equals(level))
		{
			this.logModel.setLogDescription(this.parserDescript(this.logInfo.toString()));
		}
		// level is error
		else
		{
			String[] spitString=this.logInfo.toString().split("\n");
			//parse description 
			this.logModel.setLogDescription(this.parserDescript(spitString[0]));
			//parse detial and stack
			this.pareserDetialAndStack(spitString);
		}

		return this;
	}
	
	/**
	 * 
	 * parse clientType and clientSequence
	 *
	 * @return
	 */
	public CommonConverter parserClient()
	{
		String description = this.parserDescript(this.logInfo.toString());
		String clientType = "";
		String clientSequence = "";
		// judge client without GovXml
		String[] splitString = description.split("-");
		String prefixString = splitString[0].trim();
		if (prefixString.matches("ACA\\d*") || prefixString.matches("web\\d*") || prefixString.matches("CFM\\d*"))
		{
			clientType = prefixString.substring(0, 3);
			clientSequence = prefixString.substring(3);
		}
		else if (prefixString.matches("httpProxy") || prefixString.contains("rest") || prefixString.matches("ws0.9"))
		{
			clientType = prefixString;
			clientSequence = splitString[1];
		}
		else if (prefixString.matches("PlanReviewJob\\d*"))
		{
			clientType = prefixString.substring(0, 13);
			clientSequence = prefixString.substring(13);
		}
		else if (prefixString.matches("JobManager\\d*") || prefixString.matches("HostSignon"))
		{
			clientType = prefixString.substring(0, 10);
			clientSequence = prefixString.substring(10);
		}
		else if (prefixString.matches("BatchJob\\d*"))
		{
			clientType = prefixString.substring(0, 8);
			clientSequence = prefixString.substring(8);
		}
		else if (prefixString.matches("RandomAudit\\d*"))
		{
			clientType = prefixString.substring(0, 11);
			clientSequence = prefixString.substring(11);

		}
		else if (prefixString.matches("preLoadPages\\d*"))
		{
			clientType = prefixString.substring(0, 12);
			clientSequence = prefixString.substring(12);
		}
		else if (prefixString.matches("BatchJobServlet\\d*"))
		{
			clientType = prefixString.substring(0, 15);
			clientSequence = prefixString.substring(15);
		}

		// judge is or not GovXml client
		String[] splitStringBySpace = description.split(" ");
		if ("GovXML".equals(splitStringBySpace[0].trim()))
		{
			clientType = "GovXML";
		}

		// set clientType and clientSequence to model
		this.logModel.setClientType(clientType);
		this.logModel.setClientSequence(clientSequence);
		return this;
	}
	
}

/*
 * $Log: $
 */