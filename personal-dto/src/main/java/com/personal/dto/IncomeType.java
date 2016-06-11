package com.personal.dto;

import java.io.Serializable;

public class IncomeType implements Serializable
{
	private static final long serialVersionUID = 1L;

	private long incomeTypeId;

	private String incomeTypeName;

	public IncomeType()
	{
	}

	public long getIncomeTypeId()
	{
		return this.incomeTypeId;
	}

	public void setIncomeTypeId(long incomeTypeId)
	{
		this.incomeTypeId = incomeTypeId;
	}


	public String getIncomeTypeName()
	{
		return this.incomeTypeName;
	}

	public void setIncomeTypeName(String incomeTypeName)
	{
		this.incomeTypeName = incomeTypeName;
	}

}