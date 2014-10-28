package com.accela.loganalyzer.readfile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * 
 *  N/A Automation
 *  File: Context.java
 * 
 *  N/A, Inc.
 *  Copyright (C): 2014
 * 
 *  Description:
 *  TODO
 * 
 *  Revision History
 *  Date,		Who,		What;
 *  2014年9月10日		Golden Huang		Initial.
 *  
 * </pre>
 */
public class Context
{
	private Map<String, List<StringBuilder>> capturesMap;
	
	/**
	 * TODO.
	 *
	 * @param type
	 * @param value 
	 */
	public void setValue(String type, StringBuilder value)
	{
		if (this.capturesMap==null)
		{
			this.capturesMap = new HashMap<String, List<StringBuilder>>();
		}
		if (!this.capturesMap.containsKey(type))
		{
			this.capturesMap.put(type, new ArrayList<StringBuilder>());
		}
		this.capturesMap.get(type).add(value);
	}

	/**
	 * TODO.
	 *
	 * @param type
	 * @return 
	 */
	public List<StringBuilder> getValue(String type)
	{
		if(this.capturesMap != null)
		{
			return this.capturesMap.get(type);
		}
		return null;
	}
	
}

/*
*$Log: $
*/