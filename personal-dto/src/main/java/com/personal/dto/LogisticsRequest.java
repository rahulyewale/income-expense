package com.personal.dto;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonIgnoreType;

@JsonIgnoreType
@JsonIgnoreProperties
public class LogisticsRequest implements Serializable
{
	private static final long serialVersionUID = 1L;

	private String startDate;

	private String endDate;
	
	private Integer applicationUserId;

	public String getStartDate()
	{
		return startDate;
	}

	public void setStartDate(String startDate)
	{
		this.startDate = startDate;
	}

	public String getEndDate()
	{
		return endDate;
	}

	public void setEndDate(String endDate)
	{
		this.endDate = endDate;
	}

	public Integer getApplicationUserId()
	{
		return applicationUserId;
	}

	public void setApplicationUserId(Integer applicationUserId)
	{
		this.applicationUserId = applicationUserId;
	}

}