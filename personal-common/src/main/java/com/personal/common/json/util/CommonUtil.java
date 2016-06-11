package com.personal.common.json.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.personal.common.CommonConstants;
import com.personal.common.DateRange;
import com.personal.common.ServiceRequest;

public class CommonUtil
{
	
	 private static final SimpleDateFormat dayMonthYearformatter = new SimpleDateFormat(
		      "dd-MMM-yyyy");
	 
	public static DateRange getMonthBoundariesForGivenDate(Date referenceDate)
	{

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(referenceDate);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DATE));
		Date startDate = calendar.getTime();

		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DATE));
		Date endDate = calendar.getTime();
		return new DateRange(startDate, endDate);
	}

	public static Date constructDateFromString(String stringDate) 
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat(CommonConstants.NUMERIC_DATE_FORMAT);
		try
		{
			return dateFormat.parse(stringDate);
		}
		catch (ParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// TEST PURPOSE
	public static void main(String[] args) throws ParseException
	{
		CommonUtil.getMonthBoundariesForGivenDate(new Date());

		System.out.println(CommonUtil.constructDateFromString("31/03/2013"));

	}
	
	public static boolean isInvalidString(String inputString)
	{
		if (inputString == null || inputString.trim().isEmpty())
		{
			return true;
		}
		return false;
	}
	
	public static String getDateStringFromTimestamp(Timestamp timestamp)
	{
		return dayMonthYearformatter.format((java.util.Date) timestamp);
	}
	
	public static Object getDTOFromRequest(ServiceRequest serviceRequest,String key, Class clazz)
	{
		Object object = null;
		if (null != serviceRequest)
		{
			try
			{
				String incomeExpenseRequestString = JsonUtil.convertObjectToJson(serviceRequest.get(key));
				object = JsonUtil.convertJsonToObject(incomeExpenseRequestString, clazz);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		return object;
	}
	
}
