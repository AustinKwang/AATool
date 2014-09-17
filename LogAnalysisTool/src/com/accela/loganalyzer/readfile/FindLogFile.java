package com.accela.loganalyzer.readfile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * <pre>
 * 
 *  N/A Automation
 *  File: FindLogFile.java
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
public class FindLogFile
{
	/**
	 * 
	 * find the log and return log urls, Directory like: d:\\Agency\\\biz\\server.log
	 * 
	 * @param webSite
	 * @param server
	 * @param logType
	 * @param starDate
	 * @param endDate
	 * @return
	 */
	public List<String> findLogFile(String webSite, String server, String logType, String starDate, String endDate)
	{
		List<String> urls = new ArrayList<String>();
		//get root path
		String rootPath=this.getRootPath();
		//loop to judge this file is or not need
		File root=new File(rootPath + "\\" +server);
		if (root.exists())
		{
			File[] files=root.listFiles();
			for (int i=0;i<files.length;i++)
			{
				if (this.isNeedLog(files[i].getName(), starDate, endDate))
				{
					urls.add(files[i].toString());
				}
			}
		}
		return urls;
		
	}
	
	/**
	 * 
	 * get the root path
	 *
	 * @return
	 */
	private String getRootPath()
	{
		Properties properties = new Properties();
		InputStream inputStream = this.getClass().getResourceAsStream("/config.properties");
		String path = null;
		try
		{
			properties.load(inputStream);
			path = properties.getProperty("logPath");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return path;
	}
	
	/**
	 * 
	 * judge the file is needing 
	 *
	 * @param fileName
	 * @return
	 */
	private boolean isNeedLog(String fileName,String starDate,String endDate)
	{
		String[] splitStrings = fileName.split("\\.");
		String dateString = null;
		Date logDate = null;
		Date _starDate=null;
		Date _endDate=null;
		for (String splitString : splitStrings)
		{
			if (splitString.matches("\\d{4}-\\d{2}-\\d{2}"))
			{
				dateString = splitString;
				break;
			}
		}
		if (dateString == null)
		{
			return false;
		}
		SimpleDateFormat dateFormate = new SimpleDateFormat("yyyy-MM-dd");
		try
		{
			logDate = dateFormate.parse(dateString);
			_starDate=dateFormate.parse(starDate);
			_endDate=dateFormate.parse(endDate);
			
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		if (logDate.after(_starDate) && logDate.before(_endDate))
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