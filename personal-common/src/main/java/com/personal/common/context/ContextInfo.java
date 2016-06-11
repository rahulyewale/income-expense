package com.personal.common.context;


public class ContextInfo
{

	public ContextInfo()
	{
	}
	public ContextInfo(String actionedBy)
	{
		super();
		this.actionedBy = actionedBy;
	}

	private String actionedBy;

	public String getActionedBy()
	{
		return actionedBy;
	}

	public void setActionedBy(String actionedBy)
	{
		this.actionedBy = actionedBy;
	}

}
