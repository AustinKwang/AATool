package com.accela.loganalyzer.frame.exception;
/**
 * <pre>
 * 
 *  Accela Automation
 *  File: DataBaseException.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2014
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: DataBaseException.java 72642 2009-01-01 20:01:57Z ACHIEVO\Austin.Wang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Aug 28, 2014		Austin.Wang		Initial.
 *  
 * </pre>
 */
public class DataBaseException extends RuntimeException
{
	/**
	 * Comment for &lt;code&gt;serialVersionUID&lt;/code&gt;
	 */
	private static final long serialVersionUID = 1L;
	
	public DataBaseException()
	{
		super();
	}
	
	public DataBaseException(String message)
	{
		super(message);
	}


	public DataBaseException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public DataBaseException(Throwable cause)
	{
		super(cause);
	}

	public DataBaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
	{
//		super(message, cause, enableSuppression, writableStackTrace);
	}

	/* (non-Javadoc)
	 * @see java.lang.Throwable#getCause()
	 */
	@Override
	public synchronized Throwable getCause()
	{
		// TODO Auto-generated method stub
		return super.getCause();
	}
}

/*
*$Log: av-env.bat,v $
*/