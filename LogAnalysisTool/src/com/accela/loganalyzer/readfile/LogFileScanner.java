package com.accela.loganalyzer.readfile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.accela.loganalyzer.loganalysis.LogAnalysisChain;

/**
 * <pre>
 * 
 *  N/A Automation
 *  File: LogFileReader.java
 * 
 *  N/A, Inc.
 *  Copyright (C): 2014
 * 
 *  Description:
 *  Scanner for Server log file
 * 
 *  Revision History
 *  Date,		Who,		What;
 *  2014年9月10日		Golden Huang		Initial.
 * 
 * </pre>
 */
public class LogFileScanner
{

	private LogInfoCaptureChain logInfoCapterChain;

	private LogAnalysisChain analysischain;
	
	public void parseFile(String fullPath)
	{
		System.out.println("=======>>" + fullPath);
		Context context = new Context();
		BufferedReader reader = null;
		try
		{
			reader = new BufferedReader(new FileReader(new File(fullPath)));
			String line = null;

			//1. scanner file
			while ((line = reader.readLine()) != null)
			{
				logInfoCapterChain.doCapture(line, context);
			}
			
			//2. parse context to model and save to database
			this.analysischain.parseContext(context);
			
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				reader.close();
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param logInforCapterChain the logInforCapterChain to set
	 */
	public void setLogInfoCapterChain(LogInfoCaptureChain logInfoCapterChain)
	{
		this.logInfoCapterChain = logInfoCapterChain;
	}
	
	/**
	 * @param analysischain the analysischain to set
	 */
	public void setAnalysischain(LogAnalysisChain analysischain)
	{
		this.analysischain = analysischain;
	}
	
}

/*
 * $Log: $
 */