package com.personal.common;

import java.util.Date;

public class DateRange
{
	private Date fromDate;

	private Date toDate;

	public DateRange(Date fromDate, Date toDate)
	{
		this.fromDate = fromDate;
		this.toDate = toDate;
	}

	public Date getFromDate()
	{
		return fromDate;
	}

	public Date getToDate()
	{
		return toDate;
	}

}
