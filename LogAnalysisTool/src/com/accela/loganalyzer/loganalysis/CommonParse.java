package com.accela.loganalyzer.loganalysis;

import java.util.ArrayList;
import java.util.List;

import com.accela.loganalyzer.frame.database.DBAccessor;
import com.accela.loganalyzer.frame.exception.DataBaseException;
import com.accela.loganalyzer.model.LogModel;

/**
 * <pre>
 * 
 *  N/A Automation
 *  File: CommonParser.java
 * 
 *  N/A, Inc.
 *  Copyright (C): 2014
 * 
 *  Description:
 *  TODO
 * 
 *  Revision History
 *  Date,		Who,		What;
 *  2014骞�鏈�1鏃�	pc		Initial.
 * 
 * </pre>
 */
public class CommonParse implements LogDetailParser<LogModel>
{

	private DBAccessor dbAccessor;

	@Override
	public String getContextKey()
	{
		return LogAnalyzeConstants.COMMONCAPUTRE_TYPE;
	}

	@Override
	public LogModel parseLog(StringBuilder logInfo)
	{
		LogModel logModel = new LogModel();
		// create Converter to parser to model
		CommonConverter parserToModel = new CommonConverter(logModel, logInfo);
		// Convert to model
		parserToModel.parserLogDate().parserLevel().parserClassName().parserCreateDate().parserOther().parserClient();
		return logModel;
	}

	@Override
	public void saveLog2DB(LogModel obj) throws DataBaseException
	{
		List<Object> parameters =new ArrayList<Object>();
		String sql = "INSERT INTO serverloginfo(className,createDate,logDate,simpleDescription,level,detailDescription,stackInfo,clientType,clientSequence) VALUES(?,?,?,?,?,?,?,?,?)";
		parameters.add(obj.getClassName());
		parameters.add(obj.getCreateDate());
		parameters.add(obj.getLogDate());
		parameters.add(obj.getLogDescription());
		parameters.add(obj.getLogLevel());
		if (obj.getLogDetail() != null)
		{
			parameters.add(obj.getLogDetail());
		}
		else
		{
			parameters.add("");
		}
		if (obj.getSimpleStack() != null)
		{
			parameters.add(obj.getSimpleStack());
		}
		else
		{
			parameters.add("");
		}
		parameters.add(obj.getClientType());
		parameters.add(obj.getClientSequence());
		this.dbAccessor.save(sql, parameters.toArray());
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

}

/*
 * $Log: $
 */