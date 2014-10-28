package com.accela.loganalyzer.loganalysis;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.accela.loganalyzer.frame.database.DBAccessor;
import com.accela.loganalyzer.model.MemoryInfoModel;

/**
 * <pre>
 * 
 *  N/A Automation
 *  File: MemoryParse.java
 * 
 *  N/A, Inc.
 *  Copyright (C): 2014
 * 
 *  Description:
 *  TODO
 * 
 *  Revision History
 *  Date,		Who,		What;
 *  2014年9月12日		pc		Initial.
 *  
 * </pre>
 */
public class MemoryParse implements LogDetailParser<MemoryInfoModel>
{

	private DBAccessor dbAccessor;

	@Override
	public String getContextKey()
	{
		return LogAnalyzeConstants.MEMORYCAPTURE_TYPE;
	}
	
	@Override
	public MemoryInfoModel parseLog(StringBuilder logInfo)
	{
		//instance model
		MemoryInfoModel memoryModel=new MemoryInfoModel();
		//split logInfo
		String[] splitStrings =logInfo.toString().split("\n");
		//loop splitString to parse String to model
		for (int i = 0; i < splitStrings.length; i++)
		{
			// set memory data
			int beginIndex = splitStrings[i].indexOf("=") + 1;
			String target = splitStrings[i].substring(beginIndex).trim();
			if (splitStrings[i].contains("Total Memory"))
			{
				memoryModel.setTotalMemory(Long.parseLong(target));
			}
			else if (splitStrings[i].contains("Max Memory"))
			{
				memoryModel.setMaxMemory(Long.parseLong(target));
			}
			else if (splitStrings[i].contains("Free Memory(Total)"))
			{
				memoryModel.setTotalFreeMemory(Long.parseLong(target));
			}
			else if (splitStrings[i].contains("Free Memory(Max)"))
			{
				memoryModel.setMaxFreeMemory(Long.parseLong(target));
			}
			else if (splitStrings[i].contains("% Memory Used (Total)"))
			{
				memoryModel.setTotalMemoryUsed(target);
			}
			else if (splitStrings[i].contains("% Memory Used (Max)"))
			{
				memoryModel.setMaxMemoryUsed(target);
			}
			// set log Date
			if (i == 1)
			{
				memoryModel.setLogDate(this.parserLogDate(splitStrings[i]));
			}
		}
		return memoryModel;
	}

	@Override
	public void saveLog2DB(MemoryInfoModel obj)
	{
		String sql = "INSERT INTO systemmemory(logDate,maxFreeMemory,maxMemory,maxMemoryUsed,totalFreeMemory,totalMemory,totalMemoryUsed) VALUES(?,?,?,?,?,?,?)";
		Object[] parameters = new Object[] {obj.getLogDate(), obj.getMaxFreeMemory(), obj.getMaxMemory(),
				obj.getMaxMemoryUsed(), obj.getTotalFreeMemory(), obj.getTotalMemory(), obj.getTotalMemoryUsed()};
		this.dbAccessor.save(sql, parameters);
	}

	/**
	 * @param dbAccessor the dbAccessor to set
	 */
	public void setDbAccessor(DBAccessor dbAccessor)
	{
		this.dbAccessor = dbAccessor;
	}

	@Override
	public void setLogCategory(String logCategory)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLogType(String logType)
	{
		// TODO Auto-generated method stub
		
	}
	
	private Date parserLogDate(String splitString)
	{
		String dateString = splitString.substring(0, 22);
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
		return date;
	}

}

/*
*$Log: $
*/